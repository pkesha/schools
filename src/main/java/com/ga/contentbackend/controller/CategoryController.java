package com.ga.contentbackend.controller;

import com.ga.contentbackend.model.Category;
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
        categoryService.getCategories();
        return null;
    }

    @GetMapping("/categories/{categoryId}")
    public Category getCategory(@PathVariable Long categoryId){
        categoryService.getCategory(categoryId);
        return null;
    }

    @PostMapping("/categories/")
    public Category createCategory(){
        categoryService.createCategory();
        return null;
    }

    @PutMapping("/categories/{categoryId}")
    public Category updateCategory(@PathVariable Long categoryId,
                                   @RequestBody Category category){
        categoryService.updateCategory();
        return null;
    }

    @DeleteMapping("/categories/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId){
        categoryService.deleteCategory();
//        HashMap message = new HashMap();
//        message.put("status", status)
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
