package com.example.adamstrainingproject.blogproject.models;

import com.example.adamstrainingproject.blogproject.models.Author;
import com.example.adamstrainingproject.blogproject.models.Post;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Adam on 01.03.2018.
 */
public class AuthorTest {
    Author author;

    @Before
    public void setUp() throws Exception {
        author = new Author();
    }


    @Test
    public void getNickName() throws Exception {
        author.setNickName("test nickname");
        String nickName = author.getNickName();
        assertEquals("test nickname",nickName);

    }
    @Test
    public void getPosts() throws Exception {
        Post post1 = new Post();
        Post post2 = new Post();
        post1.setContent("zyx");
        post2.setContent("abc");
        author.addPost(post1);
        author.addPost(post2);

        assertEquals(2,author.getPosts().size());



    }
}
