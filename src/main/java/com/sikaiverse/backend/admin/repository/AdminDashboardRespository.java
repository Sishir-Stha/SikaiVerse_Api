package com.sikaiverse.backend.admin.repository;

import com.sikaiverse.backend.admin.entity.AdminDashboardInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminDashboardRespository extends JpaRepository<AdminDashboardInfoEntity, Integer>{

    @Query(value = " SELECT * FROM get_admin_dashboard_info() ; ",nativeQuery = true)
    AdminDashboardInfoEntity getDashboardInfo();

}
