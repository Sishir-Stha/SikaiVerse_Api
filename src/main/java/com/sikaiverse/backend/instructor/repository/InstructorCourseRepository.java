package com.sikaiverse.backend.instructor.repository;

import com.sikaiverse.backend.instructor.entity.InstructorCourseInfoEntity;
import com.sikaiverse.backend.instructor.entity.InstructorCourseListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InstructorCourseRepository extends JpaRepository<InstructorCourseInfoEntity,Integer> {

    @Query(value = " SELECT * FROM get_instructor_course_info( :userId );",nativeQuery = true)
    List<InstructorCourseInfoEntity> getCourseInfo(@Param("userId") int userId );

    @Query(value = "SELECT * FROM get_instructor_courses_list( :instructorId );",nativeQuery = true)
    List<InstructorCourseListEntity> getCourseList(@Param("instructorId") int instructorId );

}
