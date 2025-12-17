package com.sikaiverse.backend.student.service;

import com.sikaiverse.backend.student.dto.request.StudentIdRequest;
import com.sikaiverse.backend.student.dto.response.course.StudentCourseInfoData;
import com.sikaiverse.backend.student.entity.StudentCourseInfoEntity;
import com.sikaiverse.backend.student.mapper.StudentEntityToDto;
import com.sikaiverse.backend.student.repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseService {
    private final StudentCourseRepository studentCourseRepository;
    private final StudentEntityToDto mapper;

    @Autowired
    public StudentCourseService(StudentCourseRepository studentCourseRepository, StudentEntityToDto mapper){
        this.studentCourseRepository = studentCourseRepository;
        this.mapper = mapper;
    }

    public List<StudentCourseInfoData> getCourseInfo (StudentIdRequest request){
        List<StudentCourseInfoEntity> entity = studentCourseRepository.getCourseInfo(request.getUserId());
       if(entity != null && !entity.isEmpty()) {
           List<StudentCourseInfoData> response = mapper.courseMapper(entity);
           return response;
       }else {
           return null;
       }
    }
}
