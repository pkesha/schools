package com.ga.contentbackend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ga.contentbackend.model.Category;
import com.ga.contentbackend.repository.CategoryRepository;
import com.ga.contentbackend.security.WithCustomUser;
import com.ga.contentbackend.service.CategoryService;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
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
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(mvcResult.getResponse());

        //the -> using a utility method to map the Json to the cateogoryList
        String expected = mapToJson(categoryList);

        assertEquals(expected, mvcResult.getResponse()
                .getContentAsString());
    }

    @Test
    void createCategory() {
    }

    @Test
    void updateCategory() {
    }

    @Test
    void deleteCategory() {
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
