package com.sikaiverse.backend.landing.service;

import com.sikaiverse.backend.landing.dto.request.CourseListRequest;
import com.sikaiverse.backend.landing.dto.request.IsEnrolledRequest;
import com.sikaiverse.backend.landing.dto.request.LandingCourseIdRequest;
import com.sikaiverse.backend.landing.dto.response.CourseDataResponse;
import com.sikaiverse.backend.landing.dto.response.CourseDetailData;
import com.sikaiverse.backend.landing.entity.CourseDetailEntity;
import com.sikaiverse.backend.landing.entity.CourseListEntity;
import com.sikaiverse.backend.landing.mapper.CourseListEntityToDto;
import com.sikaiverse.backend.landing.repository.CourseListRepository;
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

    public CourseDetailData getCourseDetail(LandingCourseIdRequest request){
        CourseDetailEntity data = courseListRepository.getCourseDetail(request.getCourseId());
        if (data != null){
            CourseDetailData response = mapper.CourseDetailMapper(data);
            return response;
        }else {
            return null;
        }
    }


    public boolean isEnrolled(IsEnrolledRequest request){
        return courseListRepository.isEnrolled(request.getCourseId(),request.getUserId());
    }
}
