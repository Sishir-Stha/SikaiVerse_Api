package com.sikaiverse.backend.admin.repository;

import com.sikaiverse.backend.admin.entity.AdminUserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminUserRepository extends JpaRepository<AdminUserInfoEntity,Integer> {

    @Query(value = " SELECT * FROM public.get_admin_all_users(); ",nativeQuery = true)
    List<AdminUserInfoEntity> getUserInfo();

    @Query(value = "SELECT all_update_user(:userId,:fullName,:email,:role,:status,:phoneNumber,:address);",nativeQuery = true)
    Boolean updateUserProfile(@Param("userId") Long userId,
                              @Param("fullName") String fullName,
                              @Param("email") String email,
                              @Param("role") String role,
                              @Param("status") String status,
                              @Param("phoneNumber") String phoneNumber,
                              @Param("address") String address);

    @Query(value = "select public.admin_insert_user(:fullName, :email,:password,:role,:status,:phoneNumber,:address);",nativeQuery = true)
    Boolean insertUserProfile ( @Param("fullName") String fullName,
                                @Param("email") String email,
                                @Param("password") String password,
                                @Param("role") String role,
                                @Param("status") String status,
                                @Param("phoneNumber") String phoneNumber,
                                @Param("address") String address);

    @Query(value = "select admin_delete_user(:userId);",nativeQuery = true)
    Boolean deleteUser(@Param("userId") Integer userId);


}
