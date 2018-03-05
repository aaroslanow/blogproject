package com.example.adamstrainingproject.blogproject.services;

import com.example.adamstrainingproject.blogproject.models.Author;
import com.example.adamstrainingproject.blogproject.models.Post;
import com.example.adamstrainingproject.blogproject.repositories.AuthorRepository;
import com.example.adamstrainingproject.blogproject.repositories.PostRepository;
import javafx.geometry.Pos;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Created by Adam on 05.03.2018.
 */
public class PostsRepositoryTest {

    PostServiceImpl postService;

    @Mock
    PostRepository postRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        postService = new PostServiceImpl(postRepository);
    }

    @Test
    public void findByIdTest() throws Exception {
        Post post= new Post();
        post.setId(1L);

        Optional<Post> postOptional = Optional.of(post);
        when(postRepository.findById(anyLong())).thenReturn(postOptional);
        Post postReturned = postService.findById(1L);
        assertNotNull("Post doesnt exist",post);
        verify(postRepository,times(1)).findById(anyLong());
        verify(postRepository,never()).deleteAll();
        verify(postRepository,never()).findByAuthor(any());

    }

    @Test
    public void findAllPostsTest() throws Exception {
        Post post = new Post();
        HashSet postsData = new HashSet();
        postsData.add(post);

        when(postService.findAllPosts()).thenReturn(postsData);

        Set<Post> posts = postService.findAllPosts();

        assertEquals(1, posts.size());
        verify(postRepository, times(1)).findAll();
        verify(postRepository, never()).findById(anyLong());
    }

    @Test
    public void findPostsFromAuthor() throws Exception {
        Author author1 = new Author("author1");
        Author author2 = new Author("author2");
        LocalDate date = LocalDate.now();
        Post post1 = new Post(author1,"content1",date);
        Post post2 = new Post(author1,"content2",date);
        Post post3 = new Post(author2,"content3",date);
        HashSet postData = new HashSet();
        postData.add(post1);
        postData.add(post2);


        HashSet postData2 = new HashSet();
        postData2.add(post3);

        when(postService.findPostsFromAuthor(author1)).thenReturn(postData);
        when(postService.findPostsFromAuthor(author2)).thenReturn(postData2);

        Set<Post> postsFromAuthor1 = postService.findPostsFromAuthor(author1);
        Set<Post> postsFromAuthor2 = postService.findPostsFromAuthor(author2);
        assertEquals(2,postsFromAuthor1.size());
        assertEquals(1,postsFromAuthor2.size());
        verify(postRepository,times(2)).findAllByAuthor(any());


    }

}

