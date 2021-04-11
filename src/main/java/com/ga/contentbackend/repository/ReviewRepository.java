package com.ga.contentbackend.repository;

import com.ga.contentbackend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByCategoryId(Long categoryId);

    Review findByCategoryIdAndId(Long categoryId, Long reviewId);

}
