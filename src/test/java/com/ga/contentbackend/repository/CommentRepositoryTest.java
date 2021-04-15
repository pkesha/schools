package com.ga.contentbackend.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ga.contentbackend.model.Category;
import com.ga.contentbackend.model.Comment;
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
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@DataJpaTest
class CommentRepositoryTest {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    private Category testCategory;
    private User testUser;
    private Review testReview;
    private Comment testComment;

    @BeforeEach
    public void setUp() {
        LocalDate date = LocalDate.of(2020, 1, 8);

        testCategory = new Category(1L,"Movie","Movies and More");
        testUser = new User(1L, "pk@gmail.com", "123456");
        testReview = new Review(1L, "cat", "dog", date, testCategory);
        testComment = new Comment(1L, "animal", date, testReview, testUser);

        this.testCategory.setUser(testUser);
        this.testReview.setCategory(this.testCategory);
        this.testComment.setReview(this.testReview);
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
    void givenSavedCommentShouldReturnComment() throws Exception {
        userRepository.save(testUser);
        categoryRepository.save(testCategory);
        reviewRepository.save(testReview);
        commentRepository.save(testComment);

        Comment fetchedComment = commentRepository.findByReviewIdAndId(testReview.getId(), testComment.getId());
        assertEquals(mapToJson(testComment), mapToJson(fetchedComment));
    }

    @Test
    void givenSavedReviewShouldReturnReviewWithSameId() {
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
    void findAllReviewsByUserId() throws JsonProcessingException {
        userRepository.save(testUser);
        categoryRepository.save(testCategory);
        this.testReview.setCategory(this.testCategory);
        reviewRepository.save(testReview);

        List<Review> reviewList = new ArrayList<>();
        reviewList.add(testReview);
        this.testCategory.setReviewList(reviewList);

        List<Review> fetchedReviewList = testCategory.getReviewList();
        assertEquals(mapToJson(fetchedReviewList.get(0)), mapToJson(this.testReview));
    }

    @Test
    void findByReviewIdAndUserIdCreateReview() {
        userRepository.save(testUser);
        categoryRepository.save(testCategory);
        this.testReview.setCategory(this.testCategory);
        reviewRepository.save(testReview);
    }

    @Test
    void checkForDeletedReview() {
        reviewRepository.delete(this.testReview);
        assertEquals(null, reviewRepository.findByCategoryIdAndIdAndUserId(testCategory.getId(),
                testReview.getId(),
                testUser.getId()));
    }
}
