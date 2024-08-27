package com.rein.Blog.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.Data;


@Data
@Entity
@Table(name="BlogPost")
public class BlogPost {

    @Id
    @Column(name="id")
    private int id;
    @Column(name="title")
    private String title;
    @Column(name="content")
    private String content;
    @Column(name="user")
    private int user;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at", nullable=false, updatable=false)
    private Date createdAt;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at")
    private Date updatedAt;
    
}
