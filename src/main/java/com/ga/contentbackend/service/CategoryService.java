package com.ga.contentbackend.service;

import com.ga.contentbackend.exception.InformationExistsException;
import com.ga.contentbackend.exception.InformationNotFoundException;
import com.ga.contentbackend.model.Category;
import com.ga.contentbackend.model.Comment;
import com.ga.contentbackend.model.Review;
import com.ga.contentbackend.repository.CategoryRepository;
import com.ga.contentbackend.repository.CommentRepository;
import com.ga.contentbackend.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    private ReviewRepository reviewRepository;
    private CommentRepository commentRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository,
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

    public Category createCategory(Category category){
        String inputTitle = category.getTitle();
        Category dbCategory = categoryRepository.findByTitle(inputTitle);

        if(dbCategory == null) {
            return categoryRepository.save(category);
        } else {
            throw new InformationExistsException("Category " + inputTitle + " exists");
        }
    }

    public Category updateCategory(Category category, Long categoryId){
        Category dbCategory = categoryRepository.findById(categoryId).get();

        if(dbCategory == null) {
            throw new InformationNotFoundException("Category id " + categoryId + " does not exist");
        } else {
            dbCategory.setTitle(category.getTitle());
            dbCategory.setDescription(category.getDescription());
            return categoryRepository.save(dbCategory);
        }
    }

    public void deleteCategory(Long categoryId){
        Category dbCategory = categoryRepository.findById(categoryId).get();

        if(dbCategory == null) {
            throw new InformationNotFoundException("Category id " + categoryId +
                    " does not exist");
        } else {
            categoryRepository.deleteById(categoryId);
        }
    }

    /***************Review**************/

    public List<Review> getCategoryReviews(Long categoryId){
        //checks if the category exists in the DB
        Category foundCategory = getCategory(categoryId);

        //check if foundCategory is null
        return foundCategory.getReviewList();
    }

    public Review getCategoryReview(Long categoryId, Long reviewId){
        //checks if the category exists in the DB
        Category foundCategory = getCategory(categoryId);

        Review foundReview =
                reviewRepository.findByCategoryIdAndId(categoryId, reviewId);
        if(foundReview == null){
            throw new InformationNotFoundException("Review with ID " + reviewId + "not found");
        } else{
            return foundReview;
        }

    }


    public Review createCategoryReview(Long categoryId,
                                       Review review){
        Category foundCategory = getCategory(categoryId);
        review.setCategory(foundCategory);

        if(!foundCategory.getReviewList().isEmpty()){
            for(Review reviewObject : foundCategory.getReviewList()){
                if(review.getTitle().equals(reviewObject.getTitle()))
                {
                    throw new InformationExistsException("This task exists");
                }
            }
        } else{
            System.out.println("This task is saved");
        }
        reviewRepository.save(review);
        return review;
    }

    public Review updateCategoryReview(Long categoryId, Long reviewId,
                                     Review reviewObject){
        //checks if category exists
        Category foundCategory = getCategory(categoryId);

        Review foundReview = reviewRepository.findByCategoryIdAndId(
                        foundCategory.getId(), reviewId);
        if(foundReview != null){
                if(foundReview.getTitle().equals(reviewObject.getTitle()))
                    throw new InformationExistsException("This review already" +
                            " exists with title " + foundReview.getTitle());
                else{
                    foundReview.setCategory(foundCategory);
                    foundReview.setDate(reviewObject.getDate());
                    foundReview.setTitle(reviewObject.getTitle());
                    foundReview.setText(reviewObject.getText());
                    return reviewRepository.save(foundReview);
                }
        }else{
            throw new InformationNotFoundException("This review does not " +
                    "exist");
        }
    }

    public void deleteCategoryReview(Long categoryId, Long reviewId){

        //check if exists
        Review foundReview =
                reviewRepository.findByCategoryIdAndId(categoryId, reviewId);
        if(foundReview == null){
            throw new InformationNotFoundException("This review cannot be " +
                    "deleted as the ID does not exists ID: " + reviewId);
        }else{
            reviewRepository.deleteById(reviewId);
        }

    }


    /***************Comments**************/

    public List<Comment> getCategoryReviewComments(Long categoryId, Long reviewId) {
        Review review = this.getCategoryReview(categoryId, reviewId);
        return review.getCommentList();
    }

    public Comment getCategoryReviewComment(Long categoryId, Long reviewId, Long commentId) {
        Review review = this.getCategoryReview(categoryId, reviewId);

        for(Comment comment : review.getCommentList()) {
            if(comment.getId().equals(commentId)){
                return comment;
            }
        }

        throw new InformationNotFoundException("Comment " + commentId + " was not found");
    }

    public void createCategoryReviewComment(Long categoryId, Long reviewId, Comment comment) {
       Review dbReview = this.getCategoryReview(categoryId, reviewId);
       comment.setReview(dbReview);
       commentRepository.save(comment);
    }

    public void updateCategoryReviewComment(Long categoryId, Long reviewId, Comment commentObject) {
        Comment comment = this.getCategoryReviewComment(categoryId, reviewId, commentObject.getId());
        comment.setReview(commentObject.getReview());
        comment.setDate(commentObject.getDate());
        comment.setText(commentObject.getText());
        commentRepository.save(comment);
    }

    public void deleteCategoryReviewComment(Long categoryId, Long reviewId, Comment commentObject) {
        Comment comment = this.getCategoryReviewComment(categoryId, reviewId, commentObject.getId());
        commentRepository.delete(comment);

    }

}
