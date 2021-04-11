package com.ga.contentbackend.controller;

import com.ga.contentbackend.model.Category;
import com.ga.contentbackend.model.Review;
import com.ga.contentbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path="/api")
public class CategoryController {
    /***************Categories**************/


    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> getCategories(){
       return categoryService.getCategories();
    }

    @GetMapping("/categories/{categoryId}")
    public Category getCategory(@PathVariable Long categoryId){
        return categoryService.getCategory(categoryId);
    }

    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @PutMapping("/categories/{categoryId}")
    public Category updateCategory(@PathVariable Long categoryId,
                                   @RequestBody Category category){
        return categoryService.updateCategory(category, categoryId);
    }

    @DeleteMapping("/categories/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId){
        categoryService.deleteCategory(categoryId);
//        HashMap message = new HashMap();
//        message.put("status", status)
    }

    /***************Review**************/

    @GetMapping("/categories/{categoryId}/reviews")
    public List<Review> getCategoryReviews(@PathVariable Long categoryId){
        return categoryService.getCategoryReviews(categoryId);
    }

    @GetMapping("/categories/{categoryId}/reviews/{reviewId}")
    public Review getCategoryReview(@PathVariable Long categoryId,
                                    @PathVariable Long reviewId){
        return categoryService.getCategoryReview(categoryId, reviewId);
    }

    @PostMapping("/categories/{categoryId}/reviews")
    public Review createCategoryReview(@PathVariable Long categoryId,
                                     @RequestBody Review review){
        return categoryService.createCategoryReview(categoryId, review);
    }

    @PutMapping("/categories/{categoryId}/reviews/{reviewId}")
    public Review updateCategoryReview(@PathVariable Long categoryId,
                                     @PathVariable Long reviewId,
                                     @RequestBody Review updateReview){
    return categoryService.updateCategoryReview(categoryId, reviewId,
            updateReview);
    }

    @DeleteMapping("/categories/{categoryId}/reviews/{reviewId}")
    public void deleteCategoryReview(@PathVariable Long categoryId,
                                     @PathVariable Long reviewId){
        categoryService.deleteCategoryReview(categoryId, reviewId);
    }


    /***************Comments**************/

    public void getCategoryReviewComments(){
    categoryService.getCategoryReviewComments();
    }

    public void getCategoryReviewComment(){
    categoryService.getCategoryReviewComment();
    }

    public void createCategoryReviewComment(){
        categoryService.createCategoryReviewComment();
    }

    public void updateCategoryReviewComment(){
    categoryService.updateCategoryReviewComment();

    }

    public void deleteCategoryReviewComment(){
    categoryService.deleteCategoryReviewComment();
    }


}
