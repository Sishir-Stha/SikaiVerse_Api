package com.sikaiverse.backend.landing.repository;

import com.sikaiverse.backend.landing.entity.CourseListEntity;
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

}

