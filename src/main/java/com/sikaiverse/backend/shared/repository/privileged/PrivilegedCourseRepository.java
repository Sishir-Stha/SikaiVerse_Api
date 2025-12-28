package com.sikaiverse.backend.shared.repository.privileged;

import com.sikaiverse.backend.shared.entity.privileged.EditCourseInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrivilegedCourseRepository extends JpaRepository<EditCourseInfoEntity,Integer> {

    @Query(value = "SELECT * FROM public.get_privileged_edit_course_info( :courseId );",nativeQuery = true)
    List<EditCourseInfoEntity> getEditCourseInfo(@Param("courseId") Integer courseId );



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
