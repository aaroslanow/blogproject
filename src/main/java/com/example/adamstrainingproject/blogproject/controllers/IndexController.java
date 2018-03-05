package com.example.adamstrainingproject.blogproject.controllers;

import com.example.adamstrainingproject.blogproject.models.Author;
import com.example.adamstrainingproject.blogproject.services.AuthorService;
import com.example.adamstrainingproject.blogproject.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Adam on 27.02.2018.
 */
@Controller
public class IndexController {
    private PostService postService;
    private AuthorService authorService;
    public IndexController(PostService postService) {
        this.postService=postService ;
    }

    @RequestMapping(value = {"index","/"},method = RequestMethod.GET)
    public String getIndex(Model model) {
        model.addAttribute("posts",postService.findAllPosts());
        return "index";
    }

}
