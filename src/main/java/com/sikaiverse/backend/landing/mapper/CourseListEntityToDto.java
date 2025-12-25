package com.sikaiverse.backend.landing.mapper;

import com.sikaiverse.backend.landing.dto.response.CourseDataResponse;
import com.sikaiverse.backend.landing.entity.CourseListEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseListEntityToDto {

    public List<CourseDataResponse> courseListMapper(List<CourseListEntity> entities){
        List<CourseDataResponse> reponses = new ArrayList<>();

        for(CourseListEntity entity : entities){
            CourseDataResponse dto = new CourseDataResponse();
            dto.setCourseId(entity.getCourseId());
            dto.setTitle(entity.getTitle());
            dto.setDescription(entity.getDescription());
            dto.setInstructor(entity.getInstructor());
            dto.setLevel(entity.getLevel());
            dto.setDuration(entity.getDuration());
            dto.setTotalStudents(entity.getTotalStudents());
            dto.setRating(entity.getRating());
            dto.setImage(entity.getImage());

            reponses.add(dto);
        }
        return reponses;
    }
}
