package com.sikaiverse.backend.shared.service.privileged;

import com.sikaiverse.backend.shared.dto.request.all.CourseIdRequest;
import com.sikaiverse.backend.shared.dto.request.privileged.CourseInsertRequest;
import com.sikaiverse.backend.shared.dto.response.privileged.CourseData;
import com.sikaiverse.backend.shared.entity.privileged.EditCourseInfoEntity;
import com.sikaiverse.backend.shared.mapper.privileged.PrivilegedEntityToDto;
import com.sikaiverse.backend.shared.repository.privileged.PrivilegedCourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class PrivilegedCourseService {
    private final PrivilegedCourseRepository privilegedCourseRepository;
    private final PrivilegedEntityToDto mapper;

    @Autowired
    public PrivilegedCourseService(PrivilegedCourseRepository privilegedCourseRepository, PrivilegedEntityToDto mapper){
        this.privilegedCourseRepository = privilegedCourseRepository;
        this.mapper = mapper;
    }

    public CourseData getEditCourseInfo(CourseIdRequest request){

        List<EditCourseInfoEntity> entities = privilegedCourseRepository.getEditCourseInfo(request.getCourseId());
        log.info("Entity : " + entities);
        if(entities != null || !entities.isEmpty()){
            CourseData response = mapper.editCourseMapper(entities);
            log.info("Mapped :  "+response);
            return response;
        }else{
            return null;
        }
    }



    public Boolean addCourse(CourseInsertRequest req) {
        return privilegedCourseRepository.insertCourse(
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



