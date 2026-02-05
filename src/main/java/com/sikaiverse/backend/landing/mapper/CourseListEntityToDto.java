package com.sikaiverse.backend.landing.mapper;

import com.sikaiverse.backend.landing.dto.response.CourseDataResponse;
import com.sikaiverse.backend.landing.dto.response.CourseDetailData;
import com.sikaiverse.backend.landing.entity.CourseDetailEntity;
import com.sikaiverse.backend.landing.entity.CourseListEntity;
import com.sikaiverse.backend.student.dto.response.course.StudentEnrolledCourseData;
import com.sikaiverse.backend.student.dto.response.course.StudentEnrolledModuleData;
import com.sikaiverse.backend.student.entity.StudentEnrolledCourseInfoEntity;
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
public class CourseListEntityToDto {
    private final ObjectMapper mapper;

    public List<CourseDataResponse> courseListMapper(List<CourseListEntity> entities){
        List<CourseDataResponse> reponses = new ArrayList<>();

        for(CourseListEntity entity : entities){
            CourseDataResponse dto = new CourseDataResponse();
            dto.setCourseId(entity.getCourseId());
            dto.setTitle(entity.getTitle());
            dto.setDescription(entity.getDescription());
            dto.setInstructor(entity.getInstructor());
            dto.setCategory(entity.getCategory());
            dto.setLevel(entity.getLevel());
            dto.setDuration(entity.getDuration());
            dto.setTotalStudents(entity.getTotalStudents());
            dto.setRating(entity.getRating());
            dto.setImage(entity.getImage());

            reponses.add(dto);
        }
        return reponses;
    }


    public CourseDetailData CourseDetailMapper(CourseDetailEntity entity) {

        String jsonModules = entity.getModules();
        CourseDetailData response = new CourseDetailData();
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
