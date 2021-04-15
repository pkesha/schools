package com.ga.contentbackend.repository;

import com.ga.contentbackend.model.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;
    private Category category;
    @BeforeEach
    public void setUp() {
        category = new Category(1L,"Movie","Movies and More");
    }
    @AfterEach
    public void tearDown() {
        categoryRepository.deleteAll();
        category = null;
    }

    //TODO repository methods updated

    @Test
    void givenSavedCategoryShouldReturnCategory() {
        categoryRepository.save(category);
        Category fetchedCategory =
                categoryRepository.findById(category.getId()).get();
    }

    @Test
    void findByIdAndUserId() {
    }

    @Test
    void findAllByUserId() {
    }
}
