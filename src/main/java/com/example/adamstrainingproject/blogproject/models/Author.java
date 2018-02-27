package com.example.adamstrainingproject.blogproject.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Adam on 27.02.2018.
 */
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private Set<Post> posts = new HashSet<>();

    public Long getId() {
        return id;
    }


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

}
