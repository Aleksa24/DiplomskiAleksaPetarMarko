package com.example.app.controller;

import com.example.app.dto.post.PostDto;
import com.example.app.service.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;


@WebMvcTest(controllers = PostController.class)
@ExtendWith(SpringExtension.class)
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PostService postService;

    @Test
    void findAll() throws Exception {

        PostDto postDto1 = new PostDto();
        postDto1.setId(1L);
        PostDto postDto2 = new PostDto();
        postDto2.setId(2L);

        List<PostDto> expectedUserDtoList = List.of(postDto1, postDto2);

        Mockito.when(postService.findAll()).thenReturn(expectedUserDtoList);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/post/all")
                .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String actualResponse = mvcResult.getResponse().getContentAsString();
        Assertions.assertThat(actualResponse).isEqualToIgnoringWhitespace(
                objectMapper.writeValueAsString(expectedUserDtoList)
        );
    }
}