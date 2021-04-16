package com.ga.contentbackend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ga.contentbackend.model.Category;
import com.ga.contentbackend.model.Comment;
import com.ga.contentbackend.model.Review;
import com.ga.contentbackend.security.WithCustomUser;
import com.ga.contentbackend.service.CategoryService;
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class CategoryControllerTest {

    private final String BASE_URL = "/api/categories";
    private final String REVIEW_MODEL = "/reviews";
    private final String COMMENT_MODEL = "/comments";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

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
    @WithCustomUser(username="amuniz@gmail.com")
    void getCategories() throws IOException,Exception {
        //Given
        List<Category> categoryList = new ArrayList<Category>();
        Category category = new Category(1L,"Course","Description");
        Category category1 = new Category(2L,"Course","Description");
        categoryList.add(category);
        categoryList.add(category1);

        //when -> what we expect to happen
        Mockito.when(
                categoryService.getCategories()).thenReturn(categoryList);

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
    void shouldReturn403IfAuthWorking() throws IOException,Exception {
        //Then here we are specifying the end point under test
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                BASE_URL).accept(
                MediaType.APPLICATION_JSON);

        //Returns a JSON response
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isForbidden())
                .andReturn();
    }

    @Test
    @WithCustomUser(username="alvin.email.com")
    void createCategory() throws Exception {
        //Given
        Category category = new Category(1L,"Course","Description");

        Mockito.when(
                categoryService.createCategory(category)).thenReturn(category);

        //Returns a JSON response
         mockMvc.perform(post(
                "/api/categories")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .content(mapToJson(category)))
                        .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @WithCustomUser(username="amuniz@gmail.com")
    void updateCategory() throws Exception {
        //Given
        Category category = new Category(1L,"Course","Description");
        //when -> here we call the categoryService method underTest and state
        // the expected output
        Mockito.when(
                categoryService.updateCategory(category, 1L)).thenReturn(category);

        //Returns a JSON response
                mockMvc.perform(MockMvcRequestBuilders.put(BASE_URL+"/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .content(mapToJson(category)))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();
    }

    @Test
    @WithCustomUser(username="custom@amuniz.com")
    void deleteCategory() throws Exception{
        //Given
        Category category = new Category(1L,"Course","Description");

        //when -> here we call the categoryService method underTest and state
        mockMvc.perform(MockMvcRequestBuilders.delete(BASE_URL + "/{id}",1L)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                        .andExpect(status().isOk());
    }

    @Test
    @WithCustomUser(username="alvin@email.com")
    void getCategoryReviews() throws Exception {
        //Given
        List<Category> categoryList = new ArrayList<Category>();
        Category category = new Category(1L,"Course","Description");
        LocalDate date = LocalDate.of(2020, 1, 8);
        Review review = new Review(1L,"review","reviewTest",
             null, category);
        List<Review> reviewList = new ArrayList<Review>();
        reviewList.add(review);

        //when -> what we expect to happen
        Mockito.when(
                categoryService.getCategoryReviews(1L)).thenReturn(reviewList);

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

        //the -> using a utility method to map the Json to the cateogoryList
        String expected = mapToJson(reviewList);

        assertEquals(expected, mvcResult.getResponse()
                .getContentAsString());
    }

    @Test
    @WithCustomUser(username="alvin@email.com")
    void getCategoryReview() throws Exception{
//Given
        List<Category> categoryList = new ArrayList<Category>();
        Category category = new Category(1L,"Course","Description");
        LocalDate date = LocalDate.of(2020, 1, 8);
        Review review = new Review(1L,"review","reviewTest",
                null, category);


        //when -> what we expect to happen
        Mockito.when(
                categoryService.getCategoryReview(1L, 1L)).thenReturn(review);

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

        //the -> using a utility method to map the Json to the cateogoryList
        String expected = mapToJson(review);

        assertEquals(expected, mvcResult.getResponse()
                .getContentAsString());
    }

    @Test
    @WithCustomUser(username="amuniz@gmail.com")
    void createCategoryReview() throws Exception {

        //Given
        List<Category> categoryList = new ArrayList<Category>();
        Category category = new Category(1L,"Course","Description");
        LocalDate date = LocalDate.of(2020, 1, 8);
        Review review = new Review(1L,"review","reviewTest",
                null, category);

        //when -> what we expect to happen
        Mockito.when(
                categoryService.createCategoryReview(1L, review)).thenReturn(review);

        //Returns a JSON response
        mockMvc.perform(post(
                BASE_URL+"/1"+REVIEW_MODEL)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(mapToJson(review)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    @WithCustomUser(username="alvin@gmail.com")
    void updateCategoryReview() throws Exception {
        //Given
        Category category = new Category(1L,"Course","Description");
        Review review = new Review(1L,"review","reviewTest",
                null, category);
        //when -> here we call the categoryService method underTest and state
        // the expected output
        Mockito.when(
                categoryService.updateCategoryReview(1L, 1L,review)).thenReturn(review);

        //Returns a JSON response
        mockMvc.perform(MockMvcRequestBuilders.put(BASE_URL+"/1"+REVIEW_MODEL+"/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(mapToJson(review)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    @WithCustomUser(username="amuniz@gmail.com")
    void deleteCategoryReview() throws Exception {

        //when -> here we call the categoryService method underTest and state
        mockMvc.perform(MockMvcRequestBuilders.delete(BASE_URL +
                "/{categoryId}"+ REVIEW_MODEL+"/{reviewId}",1L,1L)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    @WithCustomUser(username = "alvin@email.com")
    void getCategoryReviewComments() throws Exception{
        List<Category> categoryList = new ArrayList<Category>();
        Category category = new Category(1L,"Course","Description");
        LocalDate date = LocalDate.of(2020, 1, 8);
        Review review = new Review(1L,"review","reviewTest",
                null, category);
        Comment comment = new Comment(1L,"Comment One");
        comment.setReview(review);
        List<Comment> commentList = new ArrayList<>();

        //when -> what we expect to happen
        Mockito.when(
                categoryService.getCategoryReviewComments(1L, 1L)).thenReturn(commentList);

        //Then here we are specifying the end point under test
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                BASE_URL + "/1" + REVIEW_MODEL + "/1" + COMMENT_MODEL).accept(
                MediaType.APPLICATION_JSON);

        //Returns a JSON response
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(mapToJson(commentList)))
                .andReturn();

        //the -> using a utility method to map the Json to the cateogoryList
        String expected = mapToJson(commentList);

        assertEquals(expected, mvcResult.getResponse()
                .getContentAsString());
    }

    @Test
    @WithCustomUser(username="amuniz@gmail.com")
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
                categoryService.getCategoryReviewComment(1L, 1L)).thenReturn(comment);

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

    @Test
    @WithCustomUser(username="alvin@gmail.com")
    void createCategoryReviewComment() throws Exception{
        //Given
        List<Category> categoryList = new ArrayList<Category>();
        Category category = new Category(1L,"Course","Description");
        LocalDate date = LocalDate.of(2020, 1, 8);
        Review review = new Review(1L,"review","reviewTest",
                null, category);
        Comment comment = new Comment(1L,"Comment One");
        comment.setReview(review);

        //when -> what we expect to happen
        Mockito.when(
                categoryService.createCategoryReviewComment(1L,1L,
                        comment)).thenReturn(comment);

        //Returns a JSON response
        mockMvc.perform(post(
                BASE_URL+"/1"+REVIEW_MODEL+"/1"+COMMENT_MODEL)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(mapToJson(comment)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @WithCustomUser(username="alvin@gmail.com")
    void updateCategoryReviewComment() throws Exception{
        //Given
        Category category = new Category(1L,"Course","Description");
        Review review = new Review(1L,"review","reviewTest",
                null, category);
        Comment comment = new Comment(1L,"Comment One");
        comment.setReview(review);
        //when -> here we call the categoryService method underTest and state
        // the expected output
        Mockito.when(
                categoryService.updateCategoryReviewComment( 1L,comment,1L
        )).thenReturn(comment);

        //Returns a JSON response
        mockMvc.perform(MockMvcRequestBuilders.put(BASE_URL+"/1"+REVIEW_MODEL+"/1"+COMMENT_MODEL+"/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(mapToJson(comment)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    @WithCustomUser(username="alvin@gmail.com")
    void deleteCategoryReviewComment() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete(BASE_URL +
                "/{categoryId}"+ REVIEW_MODEL+"/{reviewId}"+COMMENT_MODEL+
                        "/{commentId}",1L
                ,1L, 1L)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

    }
}
