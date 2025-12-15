package com.sikaiverse.backend.student.repository;

import com.sikaiverse.backend.authentication.entity.AuthUserEntity;
import com.sikaiverse.backend.student.entity.DashboardInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DashboardRespository extends JpaRepository<DashboardInfoEntity,Integer> {

    @Query(value = " SELECT * FROM get_student_dashboard_info( :userId );",nativeQuery = true)
    List<DashboardInfoEntity> getDashboardInfo(@Param("userId") int userId );

}
