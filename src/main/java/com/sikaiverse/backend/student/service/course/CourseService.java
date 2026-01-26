package com.sikaiverse.backend.student.service.course;

import com.sikaiverse.backend.student.dto.request.CourseIdRequest;
import com.sikaiverse.backend.student.dto.request.LessonIdRequest;
import com.sikaiverse.backend.student.dto.response.course.EnrolledLessonData;
import com.sikaiverse.backend.student.dto.response.course.SideBarData;
import com.sikaiverse.backend.student.entity.course.LessonEntity;
import com.sikaiverse.backend.student.entity.course.SideBarEntity;
import com.sikaiverse.backend.student.mapper.CourseEntityToDto;
import com.sikaiverse.backend.student.repository.course.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.metamodel.mapping.ForeignKeyDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseEntityToDto mapper;

    @Autowired
    public CourseService  ( CourseRepository courseRepository,CourseEntityToDto mapper){
        this.courseRepository = courseRepository;
        this.mapper = mapper;
    }

    public List<SideBarData> getSideBar(CourseIdRequest request){

        SideBarEntity entity = courseRepository.getSideBar(request.getCourseId());
        if(entity != null){
            List<SideBarData> response = mapper.sideBarMapper(entity);
            return response;
        }else{
            return null;
        }
    }

    public EnrolledLessonData getLessonDetail(LessonIdRequest request){
        LessonEntity entity = courseRepository.getLessonDetails(request.getLessonId());
        if(entity != null ){
            EnrolledLessonData data = mapper.lessonMapper(entity);
            return data;
        }else{
            return null;
        }
    }
}
