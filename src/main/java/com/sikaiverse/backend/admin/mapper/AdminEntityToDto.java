package com.sikaiverse.backend.admin.mapper;


import com.sikaiverse.backend.admin.dto.response.course.AdminCourseData;
import com.sikaiverse.backend.admin.dto.response.course.AdminCourseListData;
import com.sikaiverse.backend.admin.dto.response.dashboard.AdminDashboardData;
import com.sikaiverse.backend.admin.dto.response.user.AdminUserData;
import com.sikaiverse.backend.admin.entity.AdminCourseInfoEntity;
import com.sikaiverse.backend.admin.entity.AdminCourseListEntity;
import com.sikaiverse.backend.admin.entity.AdminDashboardInfoEntity;
import com.sikaiverse.backend.admin.entity.AdminUserInfoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminEntityToDto {

    public List<AdminCourseData> courseDataMapper(List<AdminCourseInfoEntity> entites) {
        List<AdminCourseData> response = new ArrayList<>();
        for (AdminCourseInfoEntity entity : entites){
            AdminCourseData dto = new AdminCourseData();
            dto.setCourseId(entity.getCourseId());
            dto.setCourseTitle(entity.getCourseTitle());
            dto.setDescription(entity.getDescription());
            dto.setLevel(entity.getLevel());
            dto.setInstructorName(entity.getInstructorName());
            dto.setTotalModules(entity.getTotalModule());
            dto.setTotalLessons(entity.getTotalLesson());
            dto.setTotalDuration(entity.getTotalDuration());
            dto.setRating(entity.getRating());
            response.add(dto);
        }
        return response;
    }

    public AdminDashboardData dashboardDataMapper(AdminDashboardInfoEntity entity){
       AdminDashboardData data = new AdminDashboardData();
        data.setTotalCourse(entity.getTotalCourse());
        data.setTotalModule(entity.getTotalModule());
        data.setTotalLesson(entity.getTotalLesson());
        data.setTotalStudents(entity.getTotalStudents());
        return data;
    }

    public List<AdminUserData> userDataMapper(List<AdminUserInfoEntity> entities){
        List<AdminUserData> responses = new ArrayList<>();

        for (AdminUserInfoEntity entity : entities) {
            AdminUserData dto = new AdminUserData();
            dto.setUserId(entity.getUserId());
            dto.setFullName(entity.getFullName());
            dto.setEmail(entity.getEmail());
            dto.setRole(entity.getRole());
            dto.setStatus(entity.getStatus());
            dto.setPhoneNumber(entity.getPhoneNumber());
            dto.setAddress(entity.getAddress());
            dto.setJoinedDate(entity.getJoinedDate());
            responses.add(dto);
        }
        return responses;
    }


    public List<AdminCourseListData> courseListDataMapper(List<AdminCourseListEntity> entities){
        List<AdminCourseListData> response = new ArrayList<>();
        for (AdminCourseListEntity entity : entities){
            AdminCourseListData dto = new AdminCourseListData();
            dto.setCourseId(entity.getCourseId());
            dto.setCourseTitle(entity.getCourseTitle());
            dto.setNoOfLessons(entity.getNoOfLessons());
            response.add(dto);
        }
        return response;
    }
}


