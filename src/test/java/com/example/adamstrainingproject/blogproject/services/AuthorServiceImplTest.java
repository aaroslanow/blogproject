package com.example.adamstrainingproject.blogproject.services;

import com.example.adamstrainingproject.blogproject.models.Author;
import com.example.adamstrainingproject.blogproject.repositories.AuthorRepository;
import com.example.adamstrainingproject.blogproject.repositories.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Created by Adam on 05.03.2018.
 */
public class AuthorServiceImplTest {


    AuthorServiceImpl authorService;

    @Mock
    AuthorRepository authorRepository;

    @Mock
    PostRepository postRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        authorService = new AuthorServiceImpl(authorRepository,postRepository);
    }

    @Test
    public void findByIdTest() throws Exception {
        Author author= new Author("author1");
        author.setId(1L);

        Optional<Author> authorOptional = Optional.of(author);

        when(authorRepository.findById(anyLong())).thenReturn(authorOptional);
        Author authorReturned = authorService.findById(1L);
        assertNotNull("Author not found",authorReturned);
        verify(authorRepository,times(1)).findById(anyLong());
        verify(authorRepository,never()).findAll();
        verify(authorRepository,never()).findByNickName(anyString());

    }
    @Test
    public void findByNicknameTest() throws Exception {
        Author author= new Author("author1");
        ;

        Optional<Author> authorOptional = Optional.of(author);
        when(authorRepository.findByNickName(anyString())).thenReturn(authorOptional);
        Author authorReturned = authorService.findByNickName("author1");
        assertNotNull("Author not found",authorReturned);
        verify(authorRepository,times(1)).findByNickName(anyString());
        verify(authorRepository,never()).findAll();
        verify(authorRepository,never()).findById(anyLong());


    }

}
