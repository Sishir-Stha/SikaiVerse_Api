package com.sikaiverse.backend.student.mapper;

import com.sikaiverse.backend.student.dto.response.course.StudentCourseInfoData;
import com.sikaiverse.backend.student.dto.response.dashboard.StudentDashboardCourseData;
import com.sikaiverse.backend.student.dto.response.dashboard.StudentDashboardInfoData;
import com.sikaiverse.backend.student.entity.StudentCourseInfoEntity;
import com.sikaiverse.backend.student.entity.StudentDashboardInfoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentEntityToDto {

    public StudentDashboardInfoData dashboardMapper(List<StudentDashboardInfoEntity> entites){
        StudentDashboardInfoEntity firstEntity = entites.getFirst();
        List<StudentDashboardCourseData> courseData = new ArrayList<>();

        for (StudentDashboardInfoEntity entity : entites){
            StudentDashboardCourseData dto = new StudentDashboardCourseData();
            dto.setCourseId(entity.getCourseId());
            dto.setCourseTitle(entity.getCourseTitle());
            dto.setCourseDescription(entity.getCourseDescription());
            dto.setProgressPercentage(entity.getProgressPercentage());
            dto.setTotalModules(entity.getTotalModules());
            courseData.add(dto);
        }
        StudentDashboardInfoData response = new StudentDashboardInfoData();
        response.setTotalCourse(firstEntity.getTotalCourse());
        response.setCompleted(firstEntity.getCompleted());
        response.setInProgress(firstEntity.getInProgress());
        response.setStudyTime(firstEntity.getStudyTime());
        response.setCourseData(courseData);
        return response;
    }

    public List<StudentCourseInfoData> courseMapper(List<StudentCourseInfoEntity> entities){
        List<StudentCourseInfoData> responses = new ArrayList<>();

        for(StudentCourseInfoEntity entity : entities){
            StudentCourseInfoData dto = new StudentCourseInfoData();
            dto.setCourseId(entity.getCourseId());
            dto.setCourseTitle(entity.getCourseTitle());
            dto.setLevel(entity.getLevel());
            dto.setInstructorName(entity.getInstructorName());
            dto.setTotalModules(entity.getTotalModule());
            dto.setTotalLessons(entity.getTotalLesson());
            dto.setTotalDuration(entity.getTotalDuration());
            dto.setRating(entity.getRating());
            responses.add(dto);
        }
        return responses;
    }

}
