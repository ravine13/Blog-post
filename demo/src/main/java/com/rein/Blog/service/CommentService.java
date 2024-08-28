package com.rein.Blog.service;

import com.rein.Blog.repository.CommentRepository;
import com.rein.Blog.Entities.Comment;

public class CommentService {
    
    private CommentRepository CommentRepository;

    public CommentService(CommentRepository commentRepository){
        this.CommentRepository = commentRepository;
    }
    //create
    public Comment saveComment(Comment comment){
        return CommentRepository.save(comment);
    }
    //get
    public Iterable<Comment>getAllComments(){
        return CommentRepository.findAll();
    }
    //getById
    public Comment getCommentById(Integer Id){
        return CommentRepository.findById(Id).orElse(null);
    }
    //update
    public Comment updateComment(Comment comment){
        return CommentRepository.save(comment);
    }
    //delete
    public void deleteComment(Integer Id){
        CommentRepository.deleteById(Id);
    }
}
