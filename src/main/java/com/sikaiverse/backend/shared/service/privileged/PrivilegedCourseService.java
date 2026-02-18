package com.sikaiverse.backend.shared.service.privileged;

import com.sikaiverse.backend.admin.dto.request.AdminUserIdRequest;
import com.sikaiverse.backend.shared.dto.request.all.CourseIdRequest;
import com.sikaiverse.backend.shared.dto.request.privileged.*;
import com.sikaiverse.backend.shared.dto.response.privileged.CourseData;
import com.sikaiverse.backend.shared.dto.response.privileged.InstructorListData;
import com.sikaiverse.backend.shared.entity.privileged.EditCourseInfoEntity;
import com.sikaiverse.backend.shared.entity.privileged.InstructorListEntity;
import com.sikaiverse.backend.shared.mapper.privileged.PrivilegedEntityToDto;
import com.sikaiverse.backend.shared.repository.privileged.PrivilegedCourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PrivilegedCourseService {
    private final PrivilegedCourseRepository privilegedCourseRepository;
    private final PrivilegedEntityToDto mapper;
    private static final long MAX_FILE_SIZE = 500L * 1024 * 1024;


    @Autowired
    public PrivilegedCourseService(PrivilegedCourseRepository privilegedCourseRepository, PrivilegedEntityToDto mapper){
        this.privilegedCourseRepository = privilegedCourseRepository;
        this.mapper = mapper;
    }

    public boolean deleteCourse(PrivilegedCourseId request){
        return privilegedCourseRepository.deleteCourse(request.getCourseId());
    }

    public CourseData getEditCourseInfo(CourseIdRequest request){
        List<EditCourseInfoEntity> entities = privilegedCourseRepository.getEditCourseInfo(request.getCourseId());
        if(entities != null || !entities.isEmpty()){
            CourseData response = mapper.editCourseMapper(entities);
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

    public boolean updateCourseInfo(UpdateCourseInfoRequest request){
         return privilegedCourseRepository.updateCourseInfo( request.getCourseId(),request.getUserId(), request.getCourseTitle(),request.getDescription(), request.getLevel().toLowerCase(), request.getCategory());
    }

    public Boolean addModule(ModuleInsertRequest req) {
        return privilegedCourseRepository.insertModule(req.getCourseId(), req.getModuleTitle(), req.getDescription());
    }

    public boolean addLesson(LessonInsertRequest requestDto) throws IOException {

        byte[] fileData = null;
        String contentType = requestDto.getContentType() != null
                ? requestDto.getContentType()
                : "link";

        MultipartFile file = requestDto.getFileData();

        if (file != null && !file.isEmpty()) {

            // Validate file type
            if (!isValidFileType(file.getContentType())) {
                log.warn("Invalid file type: {}", file.getContentType());
                return false;
            }

            // Validate file size (500MB)
            if (file.getSize() > MAX_FILE_SIZE) {
                log.warn("File size too large: {}", file.getSize());
                return false;
            }

            // Auto-detect content type from file
            contentType = getFileCategory(file.getContentType());

            // ⚠ Loads entire file into memory
            fileData = file.getBytes();

            log.info("Uploaded file: name={}, type={}, size={}",
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getSize());
        }


        log.info("Adding lesson: moduleId={}, title={}, contentType={}, hasFile={}, duration={}",
                requestDto.getModuleId(),
                requestDto.getLessonTitle(),
                contentType,
                fileData != null,
                requestDto.getDuration());

        return privilegedCourseRepository.insertLesson(
                requestDto.getModuleId(),
                requestDto.getLessonTitle(),
                requestDto.getLessonContent(),
                requestDto.getDescription(),
                contentType,
                requestDto.getContentData(),
                fileData,
                requestDto.getDuration()
        );
    }

    /**
     * Validates if file type is allowed
     */
    private boolean isValidFileType(String contentType) {
        if (contentType == null) return false;

        return contentType.equals("image/jpeg") ||
                contentType.equals("image/png") ||
                contentType.equals("image/gif") ||
                contentType.equals("image/webp") ||
                contentType.equals("video/mp4") ||
                contentType.equals("video/mpeg") ||
                contentType.equals("video/quicktime") ||
                contentType.equals("video/webm") ||
                contentType.equals("video/x-matroska") ||
                contentType.equals("application/pdf");
    }

    /**
     * Gets file category from mime type
     */
    private String getFileCategory(String mimeType) {
        if (mimeType == null) return "link";

        if (mimeType.startsWith("image/")) return "image";
        if (mimeType.startsWith("video/")) return "video";
        if (mimeType.equals("application/pdf")) return "pdf";

        return "file";
    }

    public List<InstructorListData> getInstructorList(){
        List<InstructorListEntity> entity = privilegedCourseRepository.getInstructorList();
        if(entity != null){
            List<InstructorListData> data = mapper.instructorDataMapper(entity);
            return data;
        }else{
            return null;
        }
    }

}



