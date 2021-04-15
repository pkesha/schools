package com.ga.contentbackend.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ga.contentbackend.model.Category;
import com.ga.contentbackend.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    private Category testCategory;
    private User testUser;

    @BeforeEach
    public void setUp() {
        testCategory = new Category(1L,"Movie","Movies and More");
        testUser = new User(1L, "pk@gmail.com", "123456");

        userRepository.save(testUser);


        this.testCategory.setUser(testUser);
    }
    @AfterEach
    public void tearDown() {
        categoryRepository.deleteAll();
        testCategory = null;
    }

    //TODO repository methods updated
    //Utility Methods for parsing Json
    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    @Test
    void givenSavedCategoryShouldReturnCategory() throws Exception {
        Category fetchedCategory = categoryRepository.findById(testCategory.getId()).get();
        assertEquals(mapToJson(testCategory), mapToJson(fetchedCategory));
    }

    @Test
    void givenSavedCategoryShouldReturnCategoryWithSameId() {
        categoryRepository.save(this.testCategory);
        Category fetchedCategory = categoryRepository.findByIdAndUserId(testCategory.getId(), this.testUser.getId());
        System.out.println(fetchedCategory);
        assertEquals(testCategory.getId(), fetchedCategory.getId());
        assertEquals(testCategory.getUser().getId(), fetchedCategory.getUser().getId());
    }

    @Test
    void findAllCategoriesByUserId() throws JsonProcessingException {
        categoryRepository.save(this.testCategory);
        List<Category> fetchedCategoryList = categoryRepository.findAllByUserId(this.testUser.getId());
        assertEquals(mapToJson(fetchedCategoryList.get(0)), mapToJson(this.testCategory));
    }
}
