package com.sikaiverse.backend.instructor.repository;

import com.sikaiverse.backend.instructor.entity.InstructorDashboardInfoEntity;
import com.sikaiverse.backend.student.entity.StudentDashboardInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InstructorDashboardRepository extends JpaRepository<InstructorDashboardInfoEntity,Integer> {

    @Query(value = " SELECT * FROM get_student_dashboard_info( :userId );",nativeQuery = true)
    InstructorDashboardInfoEntity getDashboardInfo(@Param("userId") int userId );
}
