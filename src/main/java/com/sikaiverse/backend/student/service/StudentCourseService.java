package com.sikaiverse.backend.student.service;

import com.sikaiverse.backend.student.dto.request.CourseIdRequest;
import com.sikaiverse.backend.student.dto.request.LearnLessonRequest;
import com.sikaiverse.backend.student.dto.request.StudentIdRequest;
import com.sikaiverse.backend.student.dto.response.course.StudentCourseInfoData;
import com.sikaiverse.backend.student.dto.response.course.StudentEnrolledCourseData;
import com.sikaiverse.backend.student.entity.StudentCourseInfoEntity;
import com.sikaiverse.backend.student.entity.StudentEnrolledCourseInfoEntity;
import com.sikaiverse.backend.student.mapper.StudentEntityToDto;
import com.sikaiverse.backend.student.repository.StudentCourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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

    public StudentEnrolledCourseData getEnrolledCourseInfo(CourseIdRequest request){
        StudentEnrolledCourseInfoEntity data = studentCourseRepository.getEnrolledCourseInfo(request.getCourseId());
        if(data != null ){
            StudentEnrolledCourseData response = mapper.enrolledCourseMapper(data);
            return response;
        }else{
            return null;
        }
    }

    public boolean isEnrolled(LearnLessonRequest request){
        return studentCourseRepository.isEnrolled(request.getLessonId(), request.getUserId());
    }

}
