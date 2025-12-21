package com.sikaiverse.backend.shared.repository.all;

import com.sikaiverse.backend.shared.entity.all.DiscussionEntity;
import com.sikaiverse.backend.student.entity.StudentCourseInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiscussionRepository extends JpaRepository<DiscussionEntity,Long> {


    @Query(value = "SELECT * FROM public.get_course_discussions_with_authors( :courseId );",nativeQuery = true)
    List<DiscussionEntity> getDiscussionInfo(@Param("courseId") int courseId );

    @Query(value = "SELECT public.increment_discussion_post_likes( :postId );",nativeQuery = true)
    Boolean likeDiscussionPost(@Param("postId") int postId );

    @Query(value = "SELECT public.increment_discussion_reply_likes( :replyId ); ",nativeQuery = true)
    Boolean likeReplyPost(@Param("replyId") int replyId );

}
