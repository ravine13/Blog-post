package com.rein.Blog.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Comment")
public class Comment {

    @Id
    @Column(name="id")
    private int id;
    @Column(name="comment")
    private String comment;
    @Column(name="blogPost")
    private int blogPost;
    @Column(name="user")
    private int user;
    
}
