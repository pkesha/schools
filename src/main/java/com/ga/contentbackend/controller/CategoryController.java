package com.ga.contentbackend.controller;

import com.ga.contentbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class CategoryController {
    /***************Categories**************/


    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    public void getCategories(){
        categoryService.getCategories();
    }

    public void getCategory(){
        categoryService.getCategory();
    }

    public void createCategory(){
        categoryService.createCategory();
    }

    public void updateCategory(){
        categoryService.updateCategory();
    }

    public void deleteCategory(){
        categoryService.deleteCategory();
    }

    /***************Review**************/

    public void getCategoryReviews(){
        categoryService.getCategoryReviews();
    }

    public void getCategoryReview(){
        categoryService.getCategoryReview();
    }

    public void createCategoryReview(){
        categoryService.createCategoryReview();
    }

    public void updateCategoryReview(){
    categoryService.updateCategoryReview();
    }

    public void deleteCategoryReview(){
        categoryService.deleteCategoryReview();
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
