package com.ga.contentbackend.service;

import com.ga.contentbackend.exception.InformationNotFoundException;
import com.ga.contentbackend.model.Category;
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

}
