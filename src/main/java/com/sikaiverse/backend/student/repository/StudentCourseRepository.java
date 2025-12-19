package com.sikaiverse.backend.student.repository;

import com.sikaiverse.backend.student.entity.StudentCourseInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourseInfoEntity,Integer> {

    @Query(value = " SELECT * FROM get_student_course_info( :userId );",nativeQuery = true)
    List<StudentCourseInfoEntity> getCourseInfo(@Param("userId") int userId );
}
