package com.example.adamstrainingproject.blogproject.repositories;

import com.example.adamstrainingproject.blogproject.models.Author;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;

/**
 * Created by Adam on 27.02.2018.
 */

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Optional<Author> findById(Long id);
    Optional<Author> findByNickName(String nickName);
}
