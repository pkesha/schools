package com.ga.contentbackend.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ga.contentbackend.model.Category;
import com.ga.contentbackend.model.Review;
import com.ga.contentbackend.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@DataJpaTest
class ReviewRepositoryTest {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    private Category testCategory;
    private User testUser;
    private Review testReview;

    @BeforeEach
    public void setUp() {
        LocalDate date = LocalDate.of(2020, 1, 8);

        testCategory = new Category(1L,"Movie","Movies and More");
        testUser = new User(1L, "pk@gmail.com", "123456");
        testReview = new Review(1L, "cat", "dog", date, testCategory);

        this.testCategory.setUser(testUser);
        this.testReview.setCategory(this.testCategory);
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
    void givenSavedReviewShouldReturnReview() throws Exception {
        userRepository.save(testUser);
        categoryRepository.save(testCategory);
        reviewRepository.save(testReview);
        Review fetchedReview = reviewRepository.findByCategoryIdAndId(testCategory.getId(), testReview.getId());
        assertEquals(mapToJson(testReview), mapToJson(fetchedReview));
    }

    @Test
    void givenSavedCategoryShouldReturnCategoryWithSameId() {
        userRepository.save(testUser);
        categoryRepository.save(testCategory);
        reviewRepository.save(testReview);

        Review fetchedReview = reviewRepository.findByCategoryIdAndIdAndUserId(testCategory.getId(),
                testReview.getId(),
                testUser.getId());
        System.out.println(fetchedReview);
        assertEquals(testReview.getId(), fetchedReview.getId());
        assertEquals(testReview.getUser().getId(), fetchedReview.getUser().getId());
    }

    @Test
    void findAllCategoriesByUserId() throws JsonProcessingException {
        categoryRepository.save(this.testCategory);
        List<Category> fetchedCategoryList = categoryRepository.findAllByUserId(this.testUser.getId());
        assertEquals(mapToJson(fetchedCategoryList.get(0)), mapToJson(this.testCategory));
    }

    @Test
    void findByCategoryIdAndUserIdCreateRepository() {
        categoryRepository.save(this.testCategory);
    }

    @Test
    void checkForDeletedCategory() {
        categoryRepository.delete(this.testCategory);
        assertEquals(null, categoryRepository.findByIdAndUserId(testCategory.getId(),
                testUser.getId()));
    }
}
