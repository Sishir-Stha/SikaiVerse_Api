package com.sikaiverse.backend.student.mapper;

import com.sikaiverse.backend.student.dto.response.course.SideBarData;
import com.sikaiverse.backend.student.dto.response.course.StudentCourseInfoData;
import com.sikaiverse.backend.student.dto.response.course.StudentEnrolledCourseData;
import com.sikaiverse.backend.student.dto.response.course.StudentEnrolledModuleData;
import com.sikaiverse.backend.student.dto.response.dashboard.StudentDashboardCourseData;
import com.sikaiverse.backend.student.dto.response.dashboard.StudentDashboardInfoData;
import com.sikaiverse.backend.student.entity.StudentCourseInfoEntity;
import com.sikaiverse.backend.student.entity.StudentDashboardInfoEntity;
import com.sikaiverse.backend.student.entity.StudentEnrolledCourseInfoEntity;
import com.sikaiverse.backend.student.entity.course.SideBarEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Data
@Slf4j
@Component
public class StudentEntityToDto {

    private final ObjectMapper mapper;


    //***  DASHBOARD MAPPER  ***//
    public StudentDashboardInfoData dashboardMapper(List<StudentDashboardInfoEntity> entites) {
        StudentDashboardInfoEntity firstEntity = entites.getFirst();
        List<StudentDashboardCourseData> courseData = new ArrayList<>();

        for (StudentDashboardInfoEntity entity : entites) {
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

    //***  COURSE MAPPER  ***//
    public List<StudentCourseInfoData> courseMapper(List<StudentCourseInfoEntity> entities) {
        List<StudentCourseInfoData> responses = new ArrayList<>();

        for (StudentCourseInfoEntity entity : entities) {
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

    //***  ENROLLED COURSE DETAILS MAPPER  ***//
    public StudentEnrolledCourseData enrolledCourseMapper(StudentEnrolledCourseInfoEntity entity) {

        String jsonModules = entity.getModules();
        StudentEnrolledCourseData response = new StudentEnrolledCourseData();
        response.setCourseId(entity.getCourseId());
        response.setCourseTitle(entity.getCourseTitle());
        response.setDescription(entity.getDescription());
        response.setLevel(entity.getLevel());
        response.setCategory(entity.getCategory());
        response.setInstructorName(entity.getInstructorName());
        response.setTotalModules(entity.getTotalModules());
        response.setTotalLessons(entity.getTotalLessons());
        response.setTotalDuration(entity.getTotalDuration());
        response.setRating(entity.getRating());
        response.setTotalStudents(entity.getTotalStudents());
        response.setImage(entity.getImage());
        response.setCompletionPercentage(entity.getCompletionPercentage());
        List<StudentEnrolledModuleData> modules = parseModuleData(jsonModules);
        response.setModules(modules);
        return response;

    }

    public List<StudentEnrolledModuleData> parseModuleData(String jsonModules) {
        if (jsonModules == null || jsonModules.isBlank() || jsonModules.equals("[]")) {
            return new ArrayList<>();
        } else {
            List<StudentEnrolledModuleData> modules = mapper.readValue(jsonModules,
                    new TypeReference<List<StudentEnrolledModuleData>>() {
                    }
            );
            return modules;
        }
    }

}

