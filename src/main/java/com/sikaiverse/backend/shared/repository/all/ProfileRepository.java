package com.sikaiverse.backend.shared.repository.all;

import com.sikaiverse.backend.shared.entity.all.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfileRepository extends JpaRepository<ProfileEntity, String> {

    @Query(value = "select * from public.all_get_user_by_id( :userId ); ",nativeQuery = true)
    ProfileEntity getUserProfile(@Param("userId") int userId );

}
