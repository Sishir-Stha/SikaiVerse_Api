package com.sikaiverse.backend.admin.repository;

import com.sikaiverse.backend.admin.entity.AdminCourseInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminCourseRespository extends JpaRepository<AdminCourseInfoEntity,Integer> {

    @Query(value = " SELECT * FROM get_admin_course_info(); ",nativeQuery = true)
    List<AdminCourseInfoEntity> getCourseInfo();

}
