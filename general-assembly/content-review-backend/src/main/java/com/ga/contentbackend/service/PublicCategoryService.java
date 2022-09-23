package com.ga.contentbackend.service;

import com.ga.contentbackend.exception.InformationNotFoundException;
import com.ga.contentbackend.model.Category;
import com.ga.contentbackend.model.Comment;
import com.ga.contentbackend.model.Review;
import com.ga.contentbackend.repository.CategoryRepository;
import com.ga.contentbackend.repository.CommentRepository;
import com.ga.contentbackend.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicCategoryService {
    private final CategoryRepository categoryRepository;
    private final ReviewRepository reviewRepository;
    private final CommentRepository commentRepository;

    public PublicCategoryService(CategoryRepository categoryRepository,
                                 ReviewRepository reviewRepository,
                                 CommentRepository commentRepository) {
        this.categoryRepository = categoryRepository;
        this.reviewRepository = reviewRepository;
        this.commentRepository = commentRepository;
    }

    /***************Categories**************/

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategory(Long categoryId) {
        try {
            return categoryRepository.findById(categoryId).get();
        } catch (Exception e) {
            throw new InformationNotFoundException("Category with id " +
                    categoryId + " not found");
        }

    }

    /***************Review**************/

    public List<Review> getCategoryReviews(Long categoryId) {
        //checks if the category exists in the DB
        Category databaseCategory = this.getCategory(categoryId);

        //check if databaseCategory is null
        return databaseCategory.getReviewList();
    }

    public Review getCategoryReview(Long categoryId, Long reviewId) {
        //checks if the category exists in the DB

        Review databaseReview = reviewRepository.findByCategoryIdAndId(categoryId, reviewId);
        if (databaseReview == null) {
            throw new InformationNotFoundException("Review with ID " + reviewId + "not found");
        } else {
            return databaseReview;
        }

    }

    /***************Comments**************/
    public List<Comment> getCategoryReviewComments(Long categoryId, Long reviewId) {
        Review databaseReview = this.getCategoryReview(categoryId, reviewId);
        return databaseReview.getCommentList();
    }

    public Comment getCategoryReviewComment(Long reviewId, Long commentId) {
        Comment databaseComment = commentRepository.findByReviewIdAndId(reviewId, commentId);
        if (databaseComment == null) {
            throw new InformationNotFoundException("Comment with id " + commentId + " not found");
        } else {
            return databaseComment;
        }
    }

}
