package com.sikaiverse.backend.instructor.service;

import com.sikaiverse.backend.instructor.dto.request.InstructorIdRequest;
import com.sikaiverse.backend.instructor.dto.response.course.InstructorCourseInfoData;
import com.sikaiverse.backend.instructor.entity.InstructorCourseInfoEntity;
import com.sikaiverse.backend.instructor.entity.InstructorCourseListEntity;
import com.sikaiverse.backend.instructor.mapper.InstructorEntityToDto;
import com.sikaiverse.backend.instructor.repository.InstructorCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorCourseService {
    private final InstructorCourseRepository instructorCourseRepository;
    private final InstructorEntityToDto mapper;

    @Autowired
    public InstructorCourseService(InstructorCourseRepository instructorCourseRepository, InstructorEntityToDto mapper) {
        this.instructorCourseRepository = instructorCourseRepository;
        this.mapper = mapper;
    }

    public List<InstructorCourseInfoData> getCourseInfo(InstructorIdRequest request) {
        List<InstructorCourseInfoEntity> entity = instructorCourseRepository.getCourseInfo(request.getUserId());
        if (entity != null && !entity.isEmpty()) {
            List<InstructorCourseInfoData> response = mapper.courseDataMapper(entity);
            return response;
        } else {
            return null;
        }
    }

    public List<InstructorCourseListEntity> getCourseList(InstructorIdRequest request){
        List<InstructorCourseListEntity> entity = instructorCourseRepository.getCourseList(request.getUserId());
        if(entity != null && !entity.isEmpty()){

        }
    }
}