package com.sikaiverse.backend.admin.repository;

import com.sikaiverse.backend.admin.entity.AdminUserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminUserRepository extends JpaRepository<AdminUserInfoEntity,Integer> {

    @Query(value = " SELECT * FROM public.get_admin_all_users(); ",nativeQuery = true)
    List<AdminUserInfoEntity> getUserInfo();

}
