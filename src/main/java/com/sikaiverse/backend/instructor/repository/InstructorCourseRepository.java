package com.sikaiverse.backend.instructor.repository;

import com.sikaiverse.backend.instructor.entity.InstructorCourseInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InstructorCourseRepository extends JpaRepository<InstructorCourseInfoEntity,Integer> {

    @Query(value = " SELECT * FROM get_instructor_course_info( :userId );",nativeQuery = true)
    List<InstructorCourseInfoEntity> getCourseInfo(@Param("userId") int userId );


    @Query(value = "SELECT privileged_insert_course(:title, :description, :instructorId, :category, :level, :duration, :image, CAST(:rating AS NUMERIC), :totalStudents)",nativeQuery = true)
    Boolean insertCourse(
            @Param("title") String title,
            @Param("description") String description,
            @Param("instructorId") Integer instructorId,
            @Param("category") String category,
            @Param("level") String level,
            @Param("duration") Integer duration,
            @Param("image") String image,
            @Param("rating") Double rating,
            @Param("totalStudents") Integer totalStudents
    );

}
