package com.ga.contentbackend.repository;

import com.ga.contentbackend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByTitleAndUserId(String categoryName, Long userId);

    Category findByIdAndUserId(Long categoryId, Long userId);

    List<Category> findAllByUserId(Long userId);
}
