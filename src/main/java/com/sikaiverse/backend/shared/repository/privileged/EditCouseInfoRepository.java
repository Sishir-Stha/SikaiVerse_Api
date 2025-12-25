package com.sikaiverse.backend.shared.repository.privileged;

import com.sikaiverse.backend.shared.entity.privileged.EditCourseInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EditCouseInfoRepository extends JpaRepository<EditCourseInfoEntity,Integer> {

    @Query(value = "SELECT * FROM public.get_privileged_edit_course_info( :courseId );",nativeQuery = true)
    List<EditCourseInfoEntity> getEditCourseInfo(@Param("courseId") Integer courseId );
}
