package com.ga.contentbackend.service;

import com.ga.contentbackend.exception.InformationExistsException;
import com.ga.contentbackend.exception.InformationNotFoundException;
import com.ga.contentbackend.model.Category;
import com.ga.contentbackend.model.Review;
import com.ga.contentbackend.repository.CategoryRepository;
import com.ga.contentbackend.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    private ReviewRepository reviewRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository,
                           ReviewRepository reviewRepository) {
        this.categoryRepository = categoryRepository;
        this.reviewRepository = reviewRepository;
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

        System.out.println(review);
        reviewRepository.save(review);
        System.out.println(reviewRepository.findById(1L));
        return review;
    }

    public void updateCategoryReview(){

    }

    public void deleteCategoryReview(){

    }


    /***************Comments**************/

    public void getCategoryReviewComments(){

    }

    public void getCategoryReviewComment(){

    }

    public void createCategoryReviewComment(){

    }

    public void updateCategoryReviewComment(){


    }

    public void deleteCategoryReviewComment(){

    }

}
