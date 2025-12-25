package com.sikaiverse.backend.instructor.repository;

import com.sikaiverse.backend.instructor.entity.InstructorDashboardInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InstructorDashboardRepository extends JpaRepository<InstructorDashboardInfoEntity,Integer> {

    @Query(value = " select * from get_instructor_dashboard_info( :userId );",nativeQuery = true)
    InstructorDashboardInfoEntity getDashboardInfo(@Param("userId") int userId );
}
