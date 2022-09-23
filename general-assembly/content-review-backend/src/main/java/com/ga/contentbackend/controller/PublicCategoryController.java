package com.ga.contentbackend.controller;

import com.ga.contentbackend.model.Category;
import com.ga.contentbackend.model.Comment;
import com.ga.contentbackend.model.Review;
import com.ga.contentbackend.service.PublicCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "/")
public class PublicCategoryController {
    private final PublicCategoryService publicCategoryService;

    @Autowired
    public PublicCategoryController(PublicCategoryService publicCategoryService) {
        this.publicCategoryService = publicCategoryService;
    }

    /**********CATEGORIES*************/

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return publicCategoryService.getCategories();
    }

    @GetMapping("/categories/{categoryId}")
    public Category getCategory(@PathVariable Long categoryId) {
        return publicCategoryService.getCategory(categoryId);
    }


    /***************Review**************/

    @GetMapping("/categories/{categoryId}/reviews")
    public List<Review> getCategoryReviews(@PathVariable Long categoryId) {
        return publicCategoryService.getCategoryReviews(categoryId);
    }

    @GetMapping("/categories/{categoryId}/reviews/{reviewId}")
    public Review getCategoryReview(@PathVariable Long categoryId,
                                    @PathVariable Long reviewId) {
        return publicCategoryService.getCategoryReview(categoryId, reviewId);
    }

    /***************Comments**************/
    @GetMapping("/categories/{categoryId}/reviews/{reviewId}/comments")
    public List<Comment> getCategoryReviewComments(@PathVariable Long categoryId, @PathVariable Long reviewId) {
        return publicCategoryService.getCategoryReviewComments(categoryId, reviewId);
    }

    @GetMapping("/categories/{categoryId}/reviews/{reviewId}/comments/{commentId}")
    public Comment getCategoryReviewComment(@PathVariable Long reviewId, @PathVariable Long commentId) {
        return publicCategoryService.getCategoryReviewComment(reviewId, commentId);
    }


}
