package com.example.adamstrainingproject.blogproject.services;

import com.example.adamstrainingproject.blogproject.models.Author;
import com.example.adamstrainingproject.blogproject.models.Post;
import com.example.adamstrainingproject.blogproject.repositories.AuthorRepository;
import com.example.adamstrainingproject.blogproject.repositories.PostRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Set;


/**
 * Created by Adam on 27.02.2018.
 */
@Service
public class AuthorServiceImpl implements  AuthorService {

    private final AuthorRepository authorRepository;
    private final PostRepository postRepository;

    public AuthorServiceImpl(AuthorRepository authorRepo,PostRepository postRepo ) {
        this.authorRepository=authorRepo;
        this.postRepository = postRepo;
    }
    @Override
    public Author findById(Long id) {
        Optional<Author> author= authorRepository.findById(id);
        if (!author.isPresent()) {
            throw new RuntimeException("Post Not Found!");
        }
        return author.get();
    }

    @Override
    public Set<Post> findPostsFromAuthor(Author author) {
        Set<Post> posts = postRepository.findAllByAuthor(author);
        return posts;
    }

}
