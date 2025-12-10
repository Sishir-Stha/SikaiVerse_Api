package com.sikaiverse.backend.common.security;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtil {

    private static final String SECRET_KEY = System.getenv("JWT_SECRET_KEY") != null ? System.getenv("JWT_SECRET_KEY") : "d77a6591df8e6ba4f079c0a8f63b21bbc107c51e056e3e3d421efba488ed6015b29867788716f4e63b0f524f3f49c249";

    private static final long EXPIRATION_TIME = System.getenv("JWT_EXPIRATION_TIME") != null
            ? Long.parseLong(System.getenv("JWT_EXPIRATION_TIME")) : 1000 * 60 * 30;    // 30 minute of expiration it is good enough

    public static String generateToken(String email) {  // using email to generate the token
        if (SECRET_KEY == null || SECRET_KEY.isEmpty()) {
            throw new IllegalStateException("JWT_SECRET_KEY environment variable not set.");
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", email);

        try {
            return Jwts.builder()
                    .setClaims(claims)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                    .compact();
        } catch (Exception e) {
            System.err.println("Error during token generation: " + e.getMessage());
            throw new IllegalStateException("Error generating token", e);
        }
    }

    public static String extractUserID(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public static Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public static boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private static <T> T extractClaim(String token, ClaimsExtractor<T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.extract(claims);
    }

    private static Claims extractAllClaims(String token) {
        try {
            JwtParser parser = Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build();

            Jws<Claims> jws = parser.parseClaimsJws(token);
            return jws.getBody();
        } catch (Exception e) {
            System.err.println("Error parsing JWT: " + e.getMessage());
            throw new IllegalArgumentException("Invalid or expired JWT token.", e);
        }
    }

    public static boolean validateToken(String token, String userID) {
        return (userID.equals(extractUserID(token)) && !isTokenExpired(token));
    }

    @FunctionalInterface
    public interface ClaimsExtractor<T> {
        T extract(Claims claims);
    }
    public static void main(String[] args) {
        String userId = "2";
        String token = generateToken(userId);
        System.out.println("Generated Token: " + token);
        System.out.println("Extracted UserID: " + extractUserID(token));
        System.out.println("Is Token Expired: " + isTokenExpired(token));
    }
}
