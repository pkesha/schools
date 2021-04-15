package com.ga.contentbackend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ga.contentbackend.model.Category;
import com.ga.contentbackend.repository.CategoryRepository;
import com.ga.contentbackend.security.WithCustomUser;
import com.ga.contentbackend.service.CategoryService;
import jdk.jfr.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder.*;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class CategoryControllerTest {

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
        Category category = new Category(1L,"Course","Description",null);
        Category category1 = new Category(2L,"Course","Description",null);
        categoryList.add(category);
        categoryList.add(category1);

        String uri = "/api/categories";

        //when -> here we call the categoryService method underTest and state
        // the expected output
        Mockito.when(
                categoryService.getCategories()).thenReturn(categoryList);

        //Then here we are specifying the end point under test
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/categories").accept(
                MediaType.APPLICATION_JSON);

        //Returns a JSON response
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(mapToJson(category)))
                .andReturn();

        System.out.println(mvcResult.getResponse());

        //the -> using a utility method to map the Json to the cateogoryList
        String expected = mapToJson(categoryList);

        assertEquals(expected, mvcResult.getResponse()
                .getContentAsString());
    }

    @Test
    @WithCustomUser(username="amuniz@gmail.com")
    void createCategory() throws Exception {
        //Given
        Category category = new Category(1L,"Course","Description",null);
        String uri = "/api/categories";
        //when -> here we call the categoryService method underTest and state
        // the expected output
        Mockito.when(
                categoryService.createCategory(category)).thenReturn(category);

        //Then here we are specifying the end point under test
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
                "/api/categories").contentType(MediaType.APPLICATION_JSON).content(mapToJson(category));

        //Returns a JSON response
         mockMvc.perform(MockMvcRequestBuilders.post(
                "/api/categories")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .content(mapToJson(category)))
                        .andExpect(MockMvcResultMatchers.status().isCreated())
                        ;

    }

    @Test
    @WithCustomUser(username="amuniz@gmail.com")
    void updateCategory() throws Exception {
        //Given
        Category category = new Category(1L,"Course","Description",null);
        //Then here we are specifying the end point under test
        String uri = "/api/categories/1";
        //when -> here we call the categoryService method underTest and state
        // the expected output
        Mockito.when(
                categoryService.updateCategory(category, 1L)).thenReturn(category);

        //Returns a JSON response
                mockMvc.perform(MockMvcRequestBuilders.put("/api/categories/1")
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
        Category category = new Category(1L,"Course","Description",null);
        //Then here we are specifying the end point under test
        String uri = "/api/categories/1";
        //when -> here we call the categoryService method underTest and state
        // the expected output

        //Returns a JSON response
        mockMvc.perform(MockMvcRequestBuilders.delete("/api" +
                        "/categories/{id}",1L)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                        .andExpect(status().isOk());
    }

    @Test
    void getCategoryReviews() {
    }

    @Test
    void getCategoryReview() {
    }

    @Test
    void createCategoryReview() {
    }

    @Test
    void updateCategoryReview() {
    }

    @Test
    void deleteCategoryReview() {
    }

    @Test
    void getCategoryReviewComments() {
    }

    @Test
    void getCategoryReviewComment() {
    }

    @Test
    void createCategoryReviewComment() {
    }

    @Test
    void updateCategoryReviewComment() {
    }

    @Test
    void deleteCategoryReviewComment() {
    }
}
