package com.ga.contentbackend.service;

import com.ga.contentbackend.exception.InformationExistsException;
import com.ga.contentbackend.exception.InformationNotFoundException;
import com.ga.contentbackend.model.Category;
import com.ga.contentbackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
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
