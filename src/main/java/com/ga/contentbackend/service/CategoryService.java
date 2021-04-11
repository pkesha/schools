package com.ga.contentbackend.service;

import com.ga.contentbackend.model.Category;
import com.ga.contentbackend.repository.CategoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /***************Categories**************/

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategory(Long categoryId){
        return categoryRepository.findById(categoryId).get();
    }

    public void createCategory(){

    }

    public void updateCategory(){

    }

    public void deleteCategory(){

    }

    /***************Review**************/

    public void getCategoryReviews(){

    }

    public void getCategoryReview(){

    }

    public void createCategoryReview(){

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
