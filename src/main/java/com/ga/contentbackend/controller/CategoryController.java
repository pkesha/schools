package com.ga.contentbackend.controller;

import com.ga.contentbackend.model.Category;
import com.ga.contentbackend.model.Comment;
import com.ga.contentbackend.model.Review;
import com.ga.contentbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CategoryController {
    /***************Categories**************/


    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/categories/{categoryId}")
    public Category getCategory(@PathVariable Long categoryId) {
        return categoryService.getCategory(categoryId);
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.createCategory(category),
                HttpStatus.CREATED);
    }

    @PutMapping("/categories/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long categoryId,
                                                   @RequestBody Category category) {
        return new ResponseEntity<>(categoryService.updateCategory(category,
                categoryId), HttpStatus.OK);

    }

    @DeleteMapping("/categories/{categoryId}")
    public HttpStatus deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return HttpStatus.OK;

    }

    /***************Review**************/

    @GetMapping("/categories/{categoryId}/reviews")
    public List<Review> getCategoryReviews(@PathVariable Long categoryId) {
        return categoryService.getCategoryReviews(categoryId);
    }

    @GetMapping("/categories/{categoryId}/reviews/{reviewId}")
    public ResponseEntity<Review> getCategoryReview(@PathVariable Long categoryId,
                                    @PathVariable Long reviewId) {
        return new ResponseEntity<>(categoryService.getCategoryReview(categoryId,
                reviewId),HttpStatus.OK);
    }

    @PostMapping("/categories/{categoryId}/reviews")
    public ResponseEntity<Review> createCategoryReview(@PathVariable Long categoryId,
                                       @RequestBody Review review) {
        return new ResponseEntity<>(categoryService.createCategoryReview(categoryId
                , review),HttpStatus.CREATED);
    }

    @PutMapping("/categories/{categoryId}/reviews/{reviewId}")
    public ResponseEntity<Review> updateCategoryReview(@PathVariable Long categoryId,
                                       @PathVariable Long reviewId,
                                       @RequestBody Review updateReview) {
        return new ResponseEntity<>(categoryService.updateCategoryReview(categoryId, reviewId,
                updateReview),HttpStatus.OK);
    }

    @DeleteMapping("/categories/{categoryId}/reviews/{reviewId}")
    public void deleteCategoryReview(@PathVariable Long categoryId,
                                     @PathVariable Long reviewId) {
        categoryService.deleteCategoryReview(categoryId, reviewId);
    }


    /***************Comments**************/
    @GetMapping("/categories/{categoryId}/reviews/{reviewId}/comments")
    public List<Comment> getCategoryReviewComments(@PathVariable Long categoryId, @PathVariable Long reviewId) {
        return categoryService.getCategoryReviewComments(categoryId, reviewId);
    }

    @GetMapping("/categories/{categoryId}/reviews/{reviewId}/comments/{commentId}")
    public Comment getCategoryReviewComment(@PathVariable Long reviewId, @PathVariable Long commentId) {
        return categoryService.getCategoryReviewComment(reviewId, commentId);
    }

    @PostMapping("/categories/{categoryId}/reviews/{reviewId}/comments")
    public ResponseEntity<Comment> createCategoryReviewComment(@PathVariable Long categoryId,
                                               @PathVariable Long reviewId,
                                               @RequestBody Comment comment) {
        return new ResponseEntity<>(categoryService.createCategoryReviewComment(categoryId,
                reviewId,
                comment),HttpStatus.CREATED);
    }

    @PutMapping("/categories/{categoryId}/reviews/{reviewId}/comments/{commentId}")
    public void updateCategoryReviewComment(@PathVariable Long reviewId,
                                            @RequestBody Comment comment,
                                            @PathVariable Long commentId) {
        categoryService.updateCategoryReviewComment(reviewId, comment, commentId);
    }

    @DeleteMapping("/categories/{categoryId}/reviews/{reviewId}/comments/{commentId}")
    public void deleteCategoryReviewComment(@PathVariable Long reviewId, @PathVariable Long commentId) {
        categoryService.deleteCategoryReviewComment(reviewId, commentId);
    }

}
