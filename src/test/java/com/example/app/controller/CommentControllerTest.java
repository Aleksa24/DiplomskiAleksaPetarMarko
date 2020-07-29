package com.example.app.controller;

import com.example.app.dto.comment.CommentDto;
import com.example.app.dto.user.UserDto;
import com.example.app.exception.comment.CommentNotFountException;
import com.example.app.exception.user.UserNotFoundException;
import com.example.app.service.CommentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;


@WebMvcTest(CommentController.class)
class CommentControllerTest {

    @Autowired
    protected MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    CommentService commentService;


    @Test
    void findById() throws Exception{

        CommentDto commentDto = new CommentDto();
        commentDto.setId(1L);
        commentDto.setText("Yaya");

        Mockito.when(commentService.findById(Mockito.anyLong())).thenReturn(commentDto);

        RequestBuilder request = MockMvcRequestBuilders
                .get("/comment/1")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String actual = result.getResponse().getContentAsString();
        String expected = objectMapper.writeValueAsString(commentDto);

        assertEquals(actual, expected);
    }


    @Test
    void findByIdException() throws Exception{

    }

}