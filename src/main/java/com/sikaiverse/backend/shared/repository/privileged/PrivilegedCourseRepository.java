package com.sikaiverse.backend.shared.repository.privileged;

import com.sikaiverse.backend.shared.entity.privileged.EditCourseInfoEntity;
import com.sikaiverse.backend.shared.entity.privileged.InstructorListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrivilegedCourseRepository extends JpaRepository<EditCourseInfoEntity,Integer> {

    @Query(value = "SELECT * FROM public.get_privileged_edit_course_info( :courseId );",nativeQuery = true)
    List<EditCourseInfoEntity> getEditCourseInfo(@Param("courseId") Integer courseId );

    @Query(value = "SELECT privileged_update_course_info(:courseId,:userId,:courseTitle,:description,:level,:category);",nativeQuery = true)
    boolean updateCourseInfo(@Param("courseId") Integer courseId,
                             @Param("userId") Integer userId,
                             @Param("courseTitle") String courseTitle,
                             @Param("description") String description,
                             @Param("level") String level,
                             @Param("category") String category);


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


    @Query(value = "SELECT privileged_insert_module(:courseId,:moduleTitle, :description);",nativeQuery = true)
    Boolean insertModule(
            @Param("courseId") Integer courseId,
            @Param("moduleTitle") String moduleTitle,
            @Param("description") String description);

    @Query(value = "SELECT privileged_insert_lesson(:moduleId, :lessonTitle, :lessonContent, :description, :contentType, :contentData, :fileData, :duration);", nativeQuery = true)
    Boolean insertLesson(
            @Param("moduleId") Integer moduleId,
            @Param("lessonTitle") String lessonTitle,
            @Param("lessonContent") String lessonContent,
            @Param("description") String description,
            @Param("contentType") String contentType,
            @Param("contentData") String contentData,
            @Param("fileData") byte[] fileData,
            @Param("duration") Integer duration
    );


    @Query(value = "SELECT * FROM get_instructor_list();",nativeQuery = true)
    List<InstructorListEntity> getInstructorList();


    @Query(value = "select privileged_delete_course(:courseId);",nativeQuery = true)
    Boolean deleteCourse(@Param("courseId") Integer courseId);

}
