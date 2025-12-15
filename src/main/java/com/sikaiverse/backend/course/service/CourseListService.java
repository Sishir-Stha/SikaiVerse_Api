package com.sikaiverse.backend.course.service;

import com.sikaiverse.backend.course.dto.request.CourseInsertRequest;
import com.sikaiverse.backend.course.dto.request.CourseListRequest;
import com.sikaiverse.backend.course.dto.response.CourseDataResponse;
import com.sikaiverse.backend.course.dto.response.CourseListResponse;
import com.sikaiverse.backend.course.entity.CourseListEntity;
import com.sikaiverse.backend.course.mapper.CourseListEntityToDto;
import com.sikaiverse.backend.course.repository.CourseListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseListService {


    private final CourseListRepository courseListRepository;
    private final CourseListEntityToDto mapper;

    @Autowired
    public CourseListService(CourseListRepository courseListRepository, CourseListEntityToDto mapper){
        this.courseListRepository = courseListRepository;
        this.mapper = mapper;
    }

    public List<CourseDataResponse> listFilteredCourse(CourseListRequest request){

        List<CourseListEntity> entityList = courseListRepository.listFilteredCourse(request.getCourseId(),request.getLevel(), request.getCategory(), request.getTitle(), request.getRating());
        if(entityList != null && !entityList.isEmpty()){
            return mapper.courseListMapper(entityList);
        }else{
            return null;
        }
    }

    public Boolean addCourse(CourseInsertRequest req) {
        return courseListRepository.insertCourse(
                req.getTitle(),
                req.getDescription(),
                req.getInstructorId(),
                req.getCategory(),
                req.getLevel().toLowerCase(),
                req.getDuration(),
                req.getImage(),
                req.getRating(),
                req.getTotalStudents()
        );
    }

}
