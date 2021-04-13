package com.ga.contentbackend.repository;

import com.ga.contentbackend.model.Comment;
import com.ga.contentbackend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findByReviewIdAndId(Long reviewId, Long commentId);

    Comment findByReviewIdAndIdAndUserId(Long reviewId, Long commentId, Long userId);
}
