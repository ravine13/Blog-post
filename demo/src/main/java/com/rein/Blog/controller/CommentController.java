package com.rein.Blog.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.rein.Blog.Entities.Comment;
import com.rein.Blog.service.CommentService;



@RestController
@RequestMapping("/comment")
public class CommentController{

 
    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }
    @PostMapping(value="/comment", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerComment(@RequestBody Comment comment){
        Comment savedComment = commentService.saveComment(comment);
        return ResponseEntity.ok(savedComment);
    }
    @GetMapping(value = "/{all}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllComments(){
        return ResponseEntity.ok(commentService.getAllComments());
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>getAllComments(@PathVariable Integer id){
        return ResponseEntity.ok(commentService.getCommentById(id));
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>updateComments(@PathVariable Integer id, @RequestBody Comment comment){
        Comment updateComment = commentService.updateComment(comment);
        return ResponseEntity.ok(updateComment);
    }
    @DeleteMapping(value = "path/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteComment(@PathVariable Integer id){
        commentService.deleteComment(id);
        return ResponseEntity.ok().build();
    }

}
