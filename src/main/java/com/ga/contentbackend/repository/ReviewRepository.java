package com.ga.contentbackend.repository;

import com.ga.contentbackend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCategoryId(Long categoryId);

    List<Review> findByCategoryIdAndUserId(Long categoryId, Long userId);

    Review findByCategoryIdAndId(Long categoryId, Long reviewId);

    Review findByCategoryIdAndIdAndUserId(Long categoryId, Long reviewId, Long userId);

    List<Review> findAllByUserId(Long userId);
}
