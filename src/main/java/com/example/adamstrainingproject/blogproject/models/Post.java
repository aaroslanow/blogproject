package com.example.adamstrainingproject.blogproject.models;

import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


/**
 * Created by Adam on 27.02.2018.
 */
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

    private Author author;

    private String content;
    @DateTimeFormat(pattern="dd/MM/yyyy hh:mm:ss")
    private LocalDate date;

    public  Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
   public Post() {

    }
    public Post( Author author, String content, LocalDate date) {
        this.author=author;
        this.content=content;
        this.date=date;
    }

}
