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
    private CategoryRepository categoryRepository;
    private ReviewRepository reviewRepository;
    private CommentRepository commentRepository;

    public PublicCategoryService(CategoryRepository categoryRepository,
                                 ReviewRepository reviewRepository,
                                 CommentRepository commentRepository) {
        this.categoryRepository = categoryRepository;
        this.reviewRepository = reviewRepository;
        this.commentRepository = commentRepository;
    }

    /***************Categories**************/

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategory(Long categoryId){
        try{
            return categoryRepository.findById(categoryId).get();
        } catch (Exception e){
            throw  new InformationNotFoundException("Category with id " +
                    categoryId + " not found");
        }

    }

    /***************Comments**************/
    public List<Comment> getCategoryReviewComments(Long categoryId, Long reviewId) {
        Review review = this.getCategoryReview(categoryId, reviewId);
        return review.getCommentList();
    }

    public Comment getCategoryReviewComment(Long categoryId, Long reviewId, Long commentId) {
        Review review = this.getCategoryReview(categoryId, reviewId);

        for (Comment comment : review.getCommentList()) {
            if (comment.getId().equals(commentId)) {
                return comment;
            }
        }
        throw new InformationNotFoundException("Comment " + commentId + " was not found");
    }


}
