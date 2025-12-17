package com.sikaiverse.backend.authentication.repository;

import com.sikaiverse.backend.authentication.entity.AuthUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthRepository extends JpaRepository<AuthUserEntity,Long> {

    @Query(value = "select u.userid,u.fullname,u.email,u.password,u.role,u,status from public.users u  where u.email = :email and u.password = :password;",nativeQuery = true)
    AuthUserEntity login(@Param("email") String email,
                            @Param("password") String password);

    @Query (value = "select * from public.insert_user(:fullName,:email,:password,:role);",nativeQuery = true)
    Boolean insertuser(@Param("fullName") String fullName,
                       @Param("email") String email,
                       @Param("password") String password,
                       @Param("role") String role);
}
