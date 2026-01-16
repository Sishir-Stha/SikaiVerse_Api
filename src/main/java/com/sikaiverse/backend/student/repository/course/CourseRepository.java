package com.sikaiverse.backend.student.repository.course;

import com.sikaiverse.backend.student.entity.course.SideBarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<SideBarEntity,String> {

    @Query(value = "SELECT * FROM get_course_page_sidebar(:courseId);",nativeQuery = true)
    SideBarEntity getSideBar (@Param("courseId") int courseId);

}
