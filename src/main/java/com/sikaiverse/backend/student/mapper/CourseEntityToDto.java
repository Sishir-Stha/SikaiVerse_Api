package com.sikaiverse.backend.student.mapper;

import com.sikaiverse.backend.student.dto.response.course.EnrolledLessonData;
import com.sikaiverse.backend.student.dto.response.course.SideBarData;
import com.sikaiverse.backend.student.entity.course.LessonEntity;
import com.sikaiverse.backend.student.entity.course.SideBarEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Data
@Slf4j
@Component
public class CourseEntityToDto {

    private final ObjectMapper mapper;

    //***  SIDEBAR LIST MAPPER  ***//

    public List<SideBarData> sideBarMapper(SideBarEntity entity) {
        String jsonSideBarData = entity.getResult();
        if (jsonSideBarData == null || jsonSideBarData.isBlank() || jsonSideBarData.equals("[]")) {
            log.debug("<<No Sidebar Modules found ! >>");
            return new ArrayList<>();
        } else {
            List<SideBarData> data = mapper.readValue(jsonSideBarData,
                    new TypeReference<List<SideBarData>>() {
                    }
            );
            log.info("<< SideBar Module parsed >>");
            return data;
        }
    }

    //***  LESSON ENTITY MAPPER ***//

    public EnrolledLessonData lessonMapper(LessonEntity entity){
        EnrolledLessonData dto = new EnrolledLessonData();
        dto.setLessonTitle(entity.getLessonTitle());
        dto.setDescription(entity.getDescription());
        dto.setDuration(entity.getDuration());
        dto.setStatus(entity.getStatus());
        dto.setContentType(entity.getContentType());
        dto.setLessonData(entity.getLessonData());
        dto.setLessonContent(entity.getLessonContent());
        return dto;
    }
}
