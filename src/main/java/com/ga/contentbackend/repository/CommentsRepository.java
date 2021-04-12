package com.ga.contentbackend.repository;

import com.ga.contentbackend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
    Comment findByReviewId()
}
