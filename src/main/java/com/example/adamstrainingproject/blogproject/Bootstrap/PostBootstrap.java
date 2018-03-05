package com.example.adamstrainingproject.blogproject.Bootstrap;

import com.example.adamstrainingproject.blogproject.models.Author;
import com.example.adamstrainingproject.blogproject.models.Post;
import com.example.adamstrainingproject.blogproject.repositories.AuthorRepository;
import com.example.adamstrainingproject.blogproject.repositories.PostRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Adam on 28.02.2018.
 */
@Component
public class PostBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private PostRepository postRepository;
    public PostBootstrap (PostRepository postRepository,AuthorRepository authorRepository) {
        this.authorRepository=authorRepository;
        this.postRepository=postRepository;
    }
    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        this.postRepository.saveAll(getPosts());


    }
    private List<Post> getPosts() {
        Post firstPost = new Post();
        Author author=new Author();
        author.setNickName("mishead");
        author.addPost(firstPost);
        firstPost.setAuthor(author);
        firstPost.setContent("gugu");
        List<Post> lit = new ArrayList<>(1);

        lit.add(firstPost);
        return lit;

    }

}
