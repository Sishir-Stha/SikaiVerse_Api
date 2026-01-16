package com.sikaiverse.backend.student.mapper;

import com.sikaiverse.backend.student.dto.response.course.SideBarData;
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
}
