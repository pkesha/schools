package com.ga.contentbackend.repository;

import com.ga.contentbackend.model.Comment;
import com.ga.contentbackend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment findByCategoryIdAndReviewId(Long categoryId, Long reviewId, Long commentId);

    Comment findByCategoryIdAndReviewIdAndIdAndUserId(Long categoryId, Long reviewId, Long commentId, Long userId);

}
