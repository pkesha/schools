package com.ga.contentbackend.repository;

import com.ga.contentbackend.model.Comment;
import com.ga.contentbackend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment findByCategoryIdAAndReviewIdAndIdAndUserId(Long categoryId, Long reviewId, Long commentId, Long userId);

}
