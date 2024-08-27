package com.rein.Blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rein.Blog.Entities.BlogPost;

import java.util.Optional;

public interface BlogPostRepository extends JpaRepository<BlogPost, Integer>{
    @Query("SELECT r FROM BlogPost WHERE r.id = :id")
    Optional<BlogPost> FindBlogPostById(@Param("id")Integer id);
    
}
