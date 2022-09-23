package com.ga.contentbackend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ga.contentbackend.model.Category;
import com.ga.contentbackend.model.Comment;
import com.ga.contentbackend.model.Review;
import com.ga.contentbackend.security.WithCustomUser;
import com.ga.contentbackend.service.CategoryService;
import com.ga.contentbackend.service.PublicCategoryService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithCustomUser(username = "amuniz@gmail.com")
class PublicCategoryControllerTest {

    private final String BASE_URL = "/categories";
    private final String REVIEW_MODEL = "/reviews";
    private final String COMMENT_MODEL = "/comments";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PublicCategoryService publicCategoryService;

    //Utility Methods for parsing Json
    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    //Object from Json
    protected <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }

    @Test
    void getCategories() throws Exception {
        //Given
        List<Category> categoryList = new ArrayList<Category>();
        Category category = new Category(1L,"Course","Description");
        Category category1 = new Category(2L,"Course","Description");
        categoryList.add(category);
        categoryList.add(category1);

        //when -> what we expect to happen
        Mockito.when(
                publicCategoryService.getCategories()).thenReturn(categoryList);

        //Then here we are specifying the end point under test
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                BASE_URL).accept(
                MediaType.APPLICATION_JSON);

        //Returns a JSON response
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(mapToJson(categoryList)))
                .andReturn();

        //the -> using a utility method to map the Json to the cateogoryList
        String expected = mapToJson(categoryList);

        assertEquals(expected, mvcResult.getResponse()
                .getContentAsString());
    }

    @Test
    void getCategory() throws Exception{
        //Given
        Category category = new Category(1L,"Course","Description");
        //when -> what we expect to happen
        Mockito.when(
                publicCategoryService.getCategory(1L)).thenReturn(category);

        //Then here we are specifying the end point under test
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                BASE_URL + "/1").accept(
                MediaType.APPLICATION_JSON);

        //Returns a JSON response
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(mapToJson(category)))
                .andReturn();

        //the -> using a utility method to map the Json to the cateogoryList
        String expected = mapToJson(category);

        assertEquals(expected, mvcResult.getResponse()
                .getContentAsString());
    }

    @Test
    void getCategoryReviews() throws Exception {
        //Given
        List<Category> categoryList = new ArrayList<Category>();
        Category category = new Category(1L,"Course","Description");
        LocalDate date = LocalDate.of(2020, 1, 8);
        Review review = new Review(1L,"review","reviewTest",
                null, category);
        List<Review> reviewList = new ArrayList<Review>();
        reviewList.add(review);

        //When
        Mockito.when(
                publicCategoryService.getCategoryReviews(1L)).thenReturn(reviewList);

        //Then here we are specifying the end point under test
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                BASE_URL+"/1"+REVIEW_MODEL).accept(
                MediaType.APPLICATION_JSON);

        //Returns a JSON response
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(mapToJson(reviewList)))
                .andReturn();

        //the -> using a utility method to map the object to json
        String expected = mapToJson(reviewList);

        assertEquals(expected, mvcResult.getResponse()
                .getContentAsString());
    }

    @Test
    void getCategoryReview() throws Exception {
        //Given
        List<Category> categoryList = new ArrayList<Category>();
        Category category = new Category(1L,"Course","Description");
        LocalDate date = LocalDate.of(2020, 1, 8);
        Review review = new Review(1L,"review","reviewTest",
                null, category);

        //when -> what we expect to happen
        Mockito.when(
                publicCategoryService.getCategoryReview(1L, 1L)).thenReturn(review);

        //Then here we are specifying the end point under test
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                BASE_URL + "/1" + REVIEW_MODEL + "/1").accept(
                MediaType.APPLICATION_JSON);

        //Returns a JSON response
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(mapToJson(review)))
                .andReturn();

        //the -> using a utility method to map the object to json
        String expected = mapToJson(review);

        assertEquals(expected, mvcResult.getResponse()
                .getContentAsString());
    }

    @Test
    void getCategoryReviewComments() throws Exception {
        List<Category> categoryList = new ArrayList<Category>();
        Category category = new Category(1L,"Course","Description");
        LocalDate date = LocalDate.of(2020, 1, 8);
        Review review = new Review(1L,"review","reviewTest",
                null, category);
        Comment comment = new Comment(1L,"Comment One");
        comment.setReview(review);
        List<Comment> commentList = new ArrayList<>();

        //when
        Mockito.when(
                publicCategoryService.getCategoryReviewComments(1L, 1L)).thenReturn(commentList);

        //Then
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                BASE_URL + "/1" + REVIEW_MODEL + "/1" + COMMENT_MODEL).accept(
                MediaType.APPLICATION_JSON);

        //Returns a JSON response
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(mapToJson(commentList)))
                .andReturn();

        //the
        String expected = mapToJson(commentList);

        assertEquals(expected, mvcResult.getResponse()
                .getContentAsString());
    }

    @Test
    void getCategoryReviewComment() throws Exception {
        List<Category> categoryList = new ArrayList<Category>();
        Category category = new Category(1L,"Course","Description");
        LocalDate date = LocalDate.of(2020, 1, 8);
        Review review = new Review(1L,"review","reviewTest",
                null, category);
        Comment comment = new Comment(1L,"Comment One");
        comment.setReview(review);

        //when -> what we expect to happen
        Mockito.when(
                publicCategoryService.getCategoryReviewComment(1L, 1L)).thenReturn(comment);

        //Then here we are specifying the end point under test
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                BASE_URL + "/1" + REVIEW_MODEL + "/1" + COMMENT_MODEL + "/1").accept(
                MediaType.APPLICATION_JSON);

        //Returns a JSON response
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(mapToJson(comment)))
                .andReturn();

        String expected = mapToJson(comment);

        assertEquals(expected, mvcResult.getResponse()
                .getContentAsString());
    }
}
