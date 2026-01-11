package com.sikaiverse.backend.admin.repository;

import com.sikaiverse.backend.admin.entity.AdminCourseInfoEntity;
import com.sikaiverse.backend.admin.entity.AdminCourseListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminCourseRespository extends JpaRepository<AdminCourseInfoEntity,Integer> {

    @Query(value = " SELECT * FROM get_admin_course_info(); ",nativeQuery = true)
    List<AdminCourseInfoEntity> getCourseInfo();

    @Query(value = "select * from get_admin_courses_list()",nativeQuery = true)
    List<AdminCourseListEntity> getCourseList();
}
