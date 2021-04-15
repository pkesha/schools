package com.ga.contentbackend.service;

import com.ga.contentbackend.model.Category;
import com.ga.contentbackend.model.User;
import com.ga.contentbackend.repository.CategoryRepository;
import com.ga.contentbackend.repository.CommentRepository;
import com.ga.contentbackend.repository.ReviewRepository;
import com.ga.contentbackend.repository.UserRepository;
import com.ga.contentbackend.security.CustomSecurityContextFactory;
import com.ga.contentbackend.security.WithCustomUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private UserRepository userRepository;


    @Autowired
    @InjectMocks
     private CategoryService categoryService;

    List<Category> categoryList;
    private Category category1;
    private Category category2;
    private User user;

    @BeforeEach
    public void setUp() {
        categoryList = new ArrayList<>();
        category1 = new Category(1L, "Movies","Things about movies");
        category2 = new Category(2L, "Lunch","Things about lunch");
        categoryList.add(category1);
        categoryList.add(category2);
        User user = new User(1L,"al","a.email.com");
        category1.setUser(user);
        category2.setUser(user);
    }

    @AfterEach
    public void tearDown(){
        category1 = category2 = null;
        categoryList = null;
    }

    @Autowired
    @InjectMocks
    private CategoryService serviceUnderTest;

    @Test
    void getCategories(){


        when(categoryRepository.findByTitleAndUserId(any(),any())).thenReturn(category1);
        when(categoryRepository.save(any())).thenReturn(category1);
        categoryService.createCategory(category1);
        verify(categoryRepository,times(1)).findByTitleAndUserId(any(),
                any());
        verify(categoryRepository,times(1)).save(any());
    }

    @Test
    void getCategory() {
    }

    @Test
    void createCategory() {
    }

    @Test
    void updateCategory() {
    }

    @Test
    void deleteCategory() {
    }

    @Test
    void getCategoryReviews() {
    }

    @Test
    void getCategoryReview() {
    }

    @Test
    void createCategoryReview() {
    }

    @Test
    void updateCategoryReview() {
    }

    @Test
    void deleteCategoryReview() {
    }

    @Test
    void getCategoryReviewComments() {
    }

    @Test
    void getCategoryReviewComment() {
    }

    @Test
    void createCategoryReviewComment() {
    }

    @Test
    void updateCategoryReviewComment() {
    }

    @Test
    void deleteCategoryReviewComment() {
    }
}
