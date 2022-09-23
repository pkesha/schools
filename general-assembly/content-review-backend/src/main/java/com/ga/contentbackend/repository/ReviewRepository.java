package com.ga.contentbackend.repository;

import com.ga.contentbackend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findByCategoryIdAndId(Long categoryId, Long reviewId);

    Review findByCategoryIdAndIdAndUserId(Long categoryId, Long reviewId, Long userId);
}
