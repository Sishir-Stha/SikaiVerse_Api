package com.sikaiverse.backend.shared.repository.all;

import com.sikaiverse.backend.shared.entity.all.DiscussionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiscussionRepository extends JpaRepository<DiscussionEntity,Long> {


    @Query(value = "SELECT * FROM public.get_all_course_discussions( :courseId );",nativeQuery = true)
    List<DiscussionEntity> getDiscussionInfo(@Param("courseId") int courseId );

    @Query(value = "SELECT public.all_increment_discussion_post_likes( :postId );",nativeQuery = true)
    Boolean likeDiscussionPost(@Param("postId") int postId );

    @Query(value = "SELECT public.all_increment_discussion_reply_likes( :replyId ); ",nativeQuery = true)
    Boolean likeReplyPost(@Param("replyId") int replyId );

    @Query(value = "SELECT insert_discussion_post( :courseId,:userId, :title, :content );",nativeQuery = true)
    Boolean addPostReply (@Param("courseId") int courseId,
                          @Param("userId") int userId,
                          @Param("title") String title,
                          @Param("content") String content);

    @Query(value = "SELECT insert_discussion_reply( :postId, :userId, :content)",nativeQuery = true)
    Boolean addReplies (@Param("postId") int postId,
                        @Param("userId") int userId,
                        @Param("content") String content);
}
