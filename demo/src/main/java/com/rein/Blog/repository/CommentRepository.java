package com.rein.Blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.rein.Blog.Entities.Comment;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
    @Query("SELECT r from Comment r WHERE r.id = :id")
    Optional<Comment> findCommentById(@Param("id")Integer id);
    
}
