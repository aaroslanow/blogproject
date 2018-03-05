package com.example.adamstrainingproject.blogproject.repositories;

import com.example.adamstrainingproject.blogproject.models.Author;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;


/**
 * Created by Adam on 01.03.2018.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;

    @Before
    public void setUp() throws Exception {

    }


    @Test
    public void findByNickNameTest() throws Exception {
        authorRepository.save(new Author("mishead"));
        Optional<Author> author = authorRepository.findByNickName("mishead");

        assertEquals("mishead",author.get().getNickName());


    }
}
