package com.example.adamstrainingproject.blogproject.services;

import com.example.adamstrainingproject.blogproject.models.Post;
import com.example.adamstrainingproject.blogproject.repositories.PostRepository;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Adam on 27.02.2018.
 */
@Service
public class PostServiceImpl implements  PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepo) {
        this.postRepository=postRepo;
    }
    @Override
    public Post findById(Long id) {
        Optional<Post> post= postRepository.findById(id);
        if (!post.isPresent()) {
            throw new RuntimeException("Post Not Found!");
        }
        return post.get();
    }

    @Override
    public Set<Post> getPosts() {
         Set<Post> postSet = new HashSet<>();
        postRepository.findAll().iterator().forEachRemaining(postSet::add);
        return postSet;
    }
}
