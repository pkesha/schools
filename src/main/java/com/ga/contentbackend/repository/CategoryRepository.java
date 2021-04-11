package com.ga.contentbackend.repository;

import com.ga.contentbackend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByTitle(String categoryName);
}
