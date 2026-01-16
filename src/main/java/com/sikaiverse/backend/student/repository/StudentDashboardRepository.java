package com.sikaiverse.backend.student.repository;

import com.sikaiverse.backend.student.entity.StudentDashboardInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentDashboardRepository extends JpaRepository<StudentDashboardInfoEntity,Integer> {

    @Query(value = " select * from get_student_dashboard_info( :userId ); ",nativeQuery = true)
    List<StudentDashboardInfoEntity> getDashboardInfo(@Param("userId") int userId );

}
