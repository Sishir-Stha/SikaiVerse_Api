package com.sikaiverse.backend.student.mapper;

import com.sikaiverse.backend.student.dto.response.DashboardCourseData;
import com.sikaiverse.backend.student.dto.response.DashboardInfoData;
import com.sikaiverse.backend.student.entity.DashboardInfoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DashboardEntityToDto {

    public DashboardInfoData dashboardMapper(List<DashboardInfoEntity> entites){
        DashboardInfoEntity firstEntity = entites.getFirst();
        List<DashboardCourseData> courseData = new ArrayList<>();

        for (DashboardInfoEntity entity : entites){
            DashboardCourseData dto = new DashboardCourseData();
            dto.setCourseId(entity.getCourseId());
            dto.setCourseTitle(entity.getCourseTitle());
            dto.setCourseDescription(entity.getCourseDescription());
            dto.setProgressPercentage(entity.getProgressPercentage());
            dto.setTotalModules(entity.getTotalModules());
            courseData.add(dto);
        }
        DashboardInfoData response = new DashboardInfoData();
        response.setTotalCourse(firstEntity.getTotalCourse());
        response.setCompleted(firstEntity.getCompleted());
        response.setInProgress(firstEntity.getInProgress());
        response.setStudyTime(firstEntity.getStudyTime());
        response.setCourseData(courseData);
        return response;
    }

}
