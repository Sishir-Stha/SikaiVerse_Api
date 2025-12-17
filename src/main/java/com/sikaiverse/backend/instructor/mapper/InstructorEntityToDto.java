package com.sikaiverse.backend.instructor.mapper;

import com.sikaiverse.backend.instructor.dto.response.dashboard.InstructorDashboardData;
import com.sikaiverse.backend.instructor.entity.InstructorDashboardInfoEntity;
import org.apache.catalina.mbeans.SparseUserDatabaseMBean;
import org.springframework.stereotype.Component;

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
}
