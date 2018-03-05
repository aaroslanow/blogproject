package com.example.adamstrainingproject.blogproject.repositories;


import com.example.adamstrainingproject.blogproject.models.Author;
import com.example.adamstrainingproject.blogproject.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

/**
 * Created by Adam on 27.02.2018.
 */
public interface PostRepository extends CrudRepository<Post,Long> {
    Optional<Post> findById(Long id);
    Set<Post> findAllByAuthor(Author author);


}
