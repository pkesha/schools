package com.ga.contentbackend.service;

import com.ga.contentbackend.model.Category;
import com.ga.contentbackend.model.User;
import com.ga.contentbackend.repository.CategoryRepository;
import com.ga.contentbackend.repository.CommentRepository;
import com.ga.contentbackend.repository.ReviewRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class CategoryServiceTest {

    @InjectMocks
    private CategoryService serviceUnderTest;

    @Test
    void getCategories(){
       CategoryService categoryService = mock(CategoryService.class);
       CategoryRepository categoryRepository = mock(CategoryRepository.class);

        //given
        List<Category> categoryList = new ArrayList<Category>();
        Category category = new Category(1L,"Course","Description",null);
        Category category1 = new Category(2L,"Course","Description",null);
        User user1 = new User(1L,"Alvin","amuniz@gmail.com");
        category.setUser(user1);
        category1.setUser(user1);
        categoryList.add(category);
        categoryList.add(category1);
        System.out.println(categoryList);
        System.out.println(categoryRepository.save(category));
        System.out.println(categoryRepository.save(category1));

        Mockito.when(categoryRepository.save(any(Category.class))).thenReturn(category);

        Mockito.when(
                categoryRepository.findAllByUserId(any(Long.class))).thenReturn(categoryList);

        System.out.println(categoryRepository);

        List<Category> testList = categoryService.getCategories();

        System.out.println(testList);

        //then
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
