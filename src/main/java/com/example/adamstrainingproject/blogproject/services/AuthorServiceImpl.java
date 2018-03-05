package com.example.adamstrainingproject.blogproject.services;

import com.example.adamstrainingproject.blogproject.models.Author;
import com.example.adamstrainingproject.blogproject.repositories.AuthorRepository;
import com.example.adamstrainingproject.blogproject.repositories.PostRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;


/**
 * Created by Adam on 27.02.2018.
 */
@Service
public class AuthorServiceImpl implements  AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepo,PostRepository postRepo ) {
        this.authorRepository=authorRepo;
    }
    @Override
    public Author findById(Long id) {
        Optional<Author> author= authorRepository.findById(id);
        if (!author.isPresent()) {
            throw new RuntimeException("Post Not Found!");
        }
        return author.get();
    }



}
