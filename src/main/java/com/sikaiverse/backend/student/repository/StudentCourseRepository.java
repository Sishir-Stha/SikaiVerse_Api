package com.sikaiverse.backend.student.repository;

import com.sikaiverse.backend.student.entity.StudentCourseInfoEntity;
import com.sikaiverse.backend.student.entity.StudentEnrolledCourseInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourseInfoEntity,Integer> {

    @Query(value = " SELECT * FROM get_student_course_list( :userId );",nativeQuery = true)
    List<StudentCourseInfoEntity> getCourseInfo(@Param("userId") int userId );

    @Query(value = "SELECT * FROM get_enrolled_course_detail( :courseId );",nativeQuery = true)
    StudentEnrolledCourseInfoEntity getEnrolledCourseInfo(@Param("courseId") int courseId );

    @Query(value = "SELECT get_enrolled_status(:userId, :lessonId);",nativeQuery = true)
    boolean isEnrolled(@Param("lessonId") int lessonId,
                       @Param("userId") int userId);

}
