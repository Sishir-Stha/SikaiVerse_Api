package com.sikaiverse.backend.course.repository;

import com.sikaiverse.backend.course.entity.CourseListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseListRepository extends JpaRepository<CourseListEntity,Long> {

    @Query(value = "SELECT * FROM get_courses_filters(:courseId,:level, :category, :title, CAST(:rating AS NUMERIC))",nativeQuery = true)

    public List<CourseListEntity> listFilteredCourse(@Param("courseId") int courseId,
                                                     @Param("level") String level,
                                                     @Param("category") String category,
                                                     @Param("title") String title,
                                                     @Param("rating") double rating);

    @Query(value = "SELECT insert_course(:title, :description, :instructorId, :category, :level, :duration, :image, CAST(:rating AS NUMERIC), :totalStudents)",nativeQuery = true)
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

