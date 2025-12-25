package com.sikaiverse.backend.instructor.mapper;

import com.sikaiverse.backend.instructor.dto.response.course.InstructorCourseInfoData;
import com.sikaiverse.backend.instructor.dto.response.dashboard.InstructorDashboardData;
import com.sikaiverse.backend.instructor.entity.InstructorCourseInfoEntity;
import com.sikaiverse.backend.instructor.entity.InstructorDashboardInfoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InstructorEntityToDto {

    public InstructorDashboardData dashboardDataMapper(InstructorDashboardInfoEntity entity){
        InstructorDashboardData data = new InstructorDashboardData();
        data.setTotalCourse(entity.getTotalCourse());
        data.setTotalModule(entity.getTotalModule());
        data.setTotalLesson(entity.getTotalLesson());
        data.setTotalStudents(entity.getTotalStudents());
        return data;
    }

    public List<InstructorCourseInfoData> courseDataMapper(List<InstructorCourseInfoEntity> entites) {
        List<InstructorCourseInfoData> response = new ArrayList<>();
        for (InstructorCourseInfoEntity entity : entites){
            InstructorCourseInfoData dto = new InstructorCourseInfoData();
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
}
