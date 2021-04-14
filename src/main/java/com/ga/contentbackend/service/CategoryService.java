package com.ga.contentbackend.service;

import com.ga.contentbackend.exception.InformationExistsException;
import com.ga.contentbackend.exception.InformationNotFoundException;
import com.ga.contentbackend.model.Category;
import com.ga.contentbackend.model.Comment;
import com.ga.contentbackend.model.Review;
import com.ga.contentbackend.model.User;
import com.ga.contentbackend.repository.CategoryRepository;
import com.ga.contentbackend.repository.CommentRepository;
import com.ga.contentbackend.repository.ReviewRepository;
import com.ga.contentbackend.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ReviewRepository reviewRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, ReviewRepository reviewRepository,
                           CommentRepository commentRepository) {
        this.categoryRepository = categoryRepository;
        this.reviewRepository = reviewRepository;
        this.commentRepository = commentRepository;
    }

    /***************Categories**************/

    public List<Category> getCategories(){
        return categoryRepository.findAllByUserId(getUser().getId());
    }

    public Category getCategory(Long categoryId){
        try{
            return categoryRepository.findByIdAndUserId(categoryId, getUser().getId()) ;
        } catch (Exception e){
                throw  new InformationNotFoundException("Category with id " + categoryId + " not found");
        }
    }

    public Category createCategory(Category userCategory){
        String inputTitle = userCategory.getTitle();
        Category databaseCategory = categoryRepository.findByTitleAndUserId(inputTitle, getUser().getId());

        if(databaseCategory == null) {
            userCategory.setUser(getUser());
            return categoryRepository.save(userCategory);
        } else {
            throw new InformationExistsException("Category " + inputTitle + " exists");
        }
    }

    public Category updateCategory(Category userCategory, Long categoryId){
        Category databaseCategory = this.getCategory(categoryId);

        databaseCategory.setTitle(userCategory.getTitle());
        databaseCategory.setDescription(userCategory.getDescription());

        return categoryRepository.save(databaseCategory);

    }

    public void deleteCategory(Long categoryId){
        //Checking for exceptions
        this.getCategory(categoryId);
        categoryRepository.deleteById(categoryId);
    }

    /***************Review**************/
    public List<Review> getCategoryReviews(Long categoryId){
        //checks if the category exists in the DB
        Category databaseCategory = this.getCategory(categoryId);
        //check if foundCategory is null
        return databaseCategory.getReviewList();
    }

    public Review getCategoryReview(Long categoryId, Long reviewId){
        //checks if the category exists in the DB
        Review databaseReview = reviewRepository
                .findByCategoryIdAndIdAndUserId(categoryId, reviewId, getUser().getId());
        if(databaseReview == null){
            throw new InformationNotFoundException("Review with ID " + reviewId + "not found");
        } else{
            return databaseReview;
        }

    }

    public Review createCategoryReview(Long categoryId, Review userReview){
        Category databaseCategory = getCategory(categoryId);
        userReview.setCategory(databaseCategory);

        if(!databaseCategory.getReviewList().isEmpty()){
            for(Review reviewObject : databaseCategory.getReviewList()){
                if(userReview.getTitle().equals(reviewObject.getTitle()))
                {
                    throw new InformationExistsException("This task exists");
                }
            }
        } else{
            System.out.println("This task is saved");
        }
        userReview.setUser(getUser());
        reviewRepository.save(userReview);
        return userReview;
    }

    public Review updateCategoryReview(Long categoryId, Long reviewId,
                                     Review userReview){
        //checks if category exists
        Category databaseCategory = getCategory(categoryId);

        Review databaseReview = this.getCategoryReview(databaseCategory.getId(), reviewId);
        if(databaseReview != null){
                if(databaseReview.getTitle().equals(userReview.getTitle()))
                    throw new InformationExistsException("This review already" +
                            " exists with title " + databaseReview.getTitle());
                else{
                    databaseReview.setCategory(databaseCategory);
                    databaseReview.setDate(userReview.getDate());
                    databaseReview.setTitle(userReview.getTitle());
                    databaseReview.setText(userReview.getText());
                    databaseReview.setUser(getUser());
                    return reviewRepository.save(databaseReview);
                }
        }else{
            throw new InformationNotFoundException("This review does not " +
                    "exist");
        }
    }

    public void deleteCategoryReview(Long categoryId, Long reviewId){
        //check if exists
        Review databaseReview = this.getCategoryReview(categoryId, reviewId);
        if(databaseReview == null){
            throw new InformationNotFoundException("This review cannot be " +
                    "deleted as the ID does not exists ID: " + reviewId);
        }else{
            reviewRepository.deleteById(reviewId);
        }

    }


    /***************Comments**************/

    public List<Comment> getCategoryReviewComments(Long categoryId, Long reviewId) {
        Review databaseReview = this.getCategoryReview(categoryId, reviewId);
        return databaseReview.getCommentList();
    }

    public Comment getCategoryReviewComment(Long categoryId, Long reviewId, Long commentId) {
        Review databaseReview = this.getCategoryReview(categoryId, reviewId);

        for(Comment comment : databaseReview.getCommentList()) {
            if(comment.getId().equals(commentId)){
                return comment;
            }
        }

        throw new InformationNotFoundException("Comment " + commentId + " was not found");
    }

    public Comment createCategoryReviewComment(Long categoryId, Long reviewId,
                                         Comment userComment) {
       Review databaseReview = this.getCategoryReview(categoryId, reviewId);
       userComment.setReview(databaseReview);
       userComment.setUser(getUser());
       return commentRepository.save(userComment);
    }

    public void updateCategoryReviewComment(Long categoryId, Long reviewId, Comment userObject, Long commentId) {
        Comment databaseComment = this.getCategoryReviewComment(categoryId, reviewId, commentId);
        databaseComment.setDate(userObject.getDate());
        databaseComment.setText(userObject.getText());
        databaseComment.setUser(getUser());
        commentRepository.save(databaseComment);
    }

    public void deleteCategoryReviewComment(Long categoryId, Long reviewId, Long commentId) {
        Comment databaseComment = this.getCategoryReviewComment(categoryId, reviewId, commentId);
        commentRepository.delete(databaseComment);
    }

    private User getUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        return userDetails.getUser();
    }

}
