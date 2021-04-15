package com.ga.contentbackend.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ga.contentbackend.model.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
    //Utility Methods for parsing Json
    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    @Test
    void givenSavedCategoryShouldReturnCategory() throws Exception {
        categoryRepository.save(category);
        Category fetchedCategory =
                categoryRepository.findById(category.getId()).get();
        assertEquals(mapToJson(category), mapToJson(fetchedCategory));
    }

    @Test
    void findByIdAndUserId() {
    }

    @Test
    void findAllByUserId() {
    }
}
