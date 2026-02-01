package com.sikaiverse.backend.student.repository.course;

import com.sikaiverse.backend.student.entity.course.LessonEntity;
import com.sikaiverse.backend.student.entity.course.SideBarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<SideBarEntity,String> {

    @Query(value = "SELECT * FROM get_course_page_sidebar(:courseId);", nativeQuery = true)
    SideBarEntity getSideBar(@Param("courseId") int courseId);

    @Query(value = "SELECT * FROM enrolled_lesson_details(:lessonId);", nativeQuery = true)
    LessonEntity getLessonDetails(@Param("lessonId") int lessonId);

    @Query(value = "SELECT * FROM set_lesson_in_progress(:userId, :lessonId);", nativeQuery = true)
    boolean setInProgress(@Param("lessonId") int lessonId,
                          @Param("userId") int userId);

    @Query(value = "SELECT set_lesson_completed(:userId, :lessonId);", nativeQuery = true)
    boolean setCompleted(@Param("lessonId") int lessonId,
                          @Param("userId") int userId);
}
