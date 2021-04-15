package com.ga.contentbackend.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ga.contentbackend.model.Category;
import com.ga.contentbackend.model.User;
import org.checkerframework.checker.units.qual.A;
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

    @Autowired
    private UserRepository userRepository;

    private Category category;
    private User user;

    @BeforeEach
    public void setUp() {
        category = new Category(1L,"Movie","Movies and More");
        user = new User(1L, "pk@gmail.com", "123456");
        userRepository.save(user);
        this.category.setUser(user);
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
        Category fetchedCategory = categoryRepository.findById(category.getId()).get();
        assertEquals(mapToJson(category), mapToJson(fetchedCategory));
    }

    @Test
    void givenSavedCategoryShouldReturnCategoryWithSameId() {
        categoryRepository.save(category);
        Category fetchedCategory = categoryRepository.findByIdAndUserId(category.getId(), this.user.getId());
        assertEquals(category.getId(), fetchedCategory.getId());
        assertEquals(category.getUser().getId(), fetchedCategory.getUser().getId());
    }

    @Test
    void findAllByUserId() {
    }


}
