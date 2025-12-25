package com.sikaiverse.backend.shared.mapper.privileged;

import com.sikaiverse.backend.shared.dto.response.privileged.CourseData;
import com.sikaiverse.backend.shared.dto.response.privileged.LessonData;
import com.sikaiverse.backend.shared.dto.response.privileged.ModuleData;
import com.sikaiverse.backend.shared.entity.privileged.EditCourseInfoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class PrivilegedEntityToDto {

    public CourseData editCourseMapper(List<EditCourseInfoEntity> entities) {

        if (entities == null || entities.isEmpty()) {
            return null;
        }

        CourseData response = new CourseData();
        Map<Integer, ModuleData> moduleMap = new LinkedHashMap<>();

        for (EditCourseInfoEntity entity : entities) {
            Integer moduleId = entity.getModuleId();

            ModuleData moduleData;

            // Check if module already exists in map
            if (moduleMap.containsKey(moduleId)) {
                moduleData = moduleMap.get(moduleId);
            } else {
                // Create new module and add to map
                moduleData = new ModuleData();
                moduleData.setModuleId(entity.getModuleId());
                moduleData.setModuleTitle(entity.getModuleTitle());
                moduleData.setNoOfLessons(entity.getNoOfLessons());
                moduleData.setLesson(new ArrayList<>());
                moduleMap.put(moduleId, moduleData);
            }

            // Add lesson to the module
            LessonData lessonDto = new LessonData();
            lessonDto.setLessonId(entity.getLessonId());
            lessonDto.setLessonTitle(entity.getLessonTitle());
            lessonDto.setDuration(entity.getDuration());
            moduleData.getLesson().add(lessonDto);
        }

        // Set course-level information
        EditCourseInfoEntity firstEntity = entities.get(0);
        response.setCourseId(firstEntity.getCourseId());
        response.setCourseTitle(firstEntity.getCourseTitle());
        response.setDescription(firstEntity.getDescription());
        response.setInstructorName(firstEntity.getInstructorName());
        response.setCategory(firstEntity.getCategory());
        response.setLevel(firstEntity.getLevel());
        response.setModules(new ArrayList<>(moduleMap.values()));

        return response;
    }
}