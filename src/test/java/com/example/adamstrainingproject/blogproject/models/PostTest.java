package com.example.adamstrainingproject.blogproject.models;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


/**
 * Created by Adam on 01.03.2018.
 */
public class PostTest {

    Post post;
    Post post2;
    LocalDate currentDate;
    Author author;
    @Before
    public void setUp() throws Exception {
        post = new Post();
        currentDate = LocalDate.now();
        author = new Author("testAuthor");
        post2 = new Post(author,"test content",currentDate);
    }

    @Test
    public void getDateTest() throws Exception {
        LocalDate date = post2.getDate();
        assertEquals(currentDate,date);
    }

    @Test
    public void getContentTest() throws Exception {
        assertEquals("test content",post2.getContent());
    }

    @Test
    public void getAuthorTest() throws Exception {
        assertEquals(author,post2.getAuthor());
        assertEquals("testAuthor",post2.getAuthor().getNickName());
    }
}
