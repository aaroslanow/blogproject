package com.example.adamstrainingproject.blogproject.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Adam on 27.02.2018.
 */
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Author author;

    private String content;
    @DateTimeFormat(pattern="dd/MM/yyyy hh:mm:ss")
    private Date date;

    public  Long getId() {
        return id;
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


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
   public Post() {

    }
    public Post( Author author, String content, Date date) {
        this.author=author;
        this.content=content;
        this.date=date;
    }
}
