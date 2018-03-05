package com.example.adamstrainingproject.blogproject.repositories;

import com.example.adamstrainingproject.blogproject.models.Author;
import com.example.adamstrainingproject.blogproject.models.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;


import static org.junit.Assert.assertEquals;

/**
 * Created by Adam on 05.03.2018.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findAllByAuthorTest() throws Exception {
        LocalDate date;
        date= LocalDate.now();
        Author author = new Author("testAuthor");
        postRepository.save(new Post(author,"content", date));
        postRepository.save(new Post(author,"content2", date));
        postRepository.save(new Post(author,"content3", date));
        assertEquals(3,postRepository.findAllByAuthor(author).size());
        postRepository.deleteAll();
    }

    @Test
    public void findByAuthorTest() throws Exception {
        LocalDate date;
        date= LocalDate.now();
        Author author = new Author("testAuthor");
        Post post = new Post(author,"content",date);
        postRepository.save(post);
        Optional<Post> returnedPost = postRepository.findByAuthor(author);
        assertEquals(post.getAuthor(),returnedPost.get().getAuthor());
    }

    @Test
    public void findByDateTest() throws Exception {
        LocalDate date;
        date= LocalDate.of(2017,12,1);
        Author author = new Author("testAuthor");
        Post post = new Post(author,"content",date);

        LocalDate date2 = LocalDate.now();
        Post post2 = new Post(author,"content",date2);
        postRepository.save(post);
        postRepository.save(post2);
        Optional <Post> returnedPost = postRepository.findByDate(date);
        assertEquals(post,returnedPost.get());
        Optional <Post> returnedPost2 = postRepository.findByDate(date2);
        assertEquals(post2,returnedPost2.get());



    }
}
