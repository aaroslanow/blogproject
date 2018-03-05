package com.example.adamstrainingproject.blogproject.services;

import com.example.adamstrainingproject.blogproject.models.Author;
import com.example.adamstrainingproject.blogproject.models.Post;

import java.util.Set;

/**
 * Created by Adam on 27.02.2018.
 */
public interface PostService {
    Post findById(Long id);
    Set<Post> findAllPosts();
    Set<Post> findPostsFromAuthor(Author author);

}
