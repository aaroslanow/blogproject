package com.example.adamstrainingproject.blogproject.controllers;

import com.example.adamstrainingproject.blogproject.models.Post;
import com.example.adamstrainingproject.blogproject.services.PostService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


/**
 * Created by Adam on 01.03.2018.
 */
public class IndexControllerTest {
    @Mock
    Model model;

    @Mock
    PostService postService;
    IndexController indexController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(postService);
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void getIndexPageTest() throws Exception {

        //given
        Set<Post> posts = new HashSet<>();
        Post post1 = new Post();
        post1.setContent("xyz");
        posts.add(post1);
        when(postService.findAllPosts()).thenReturn(posts);

        //when
        String viewName = indexController.getIndex(model);
        //then
        assertEquals("index", viewName);

        verify(postService, times(1)).findAllPosts();
    }
}


