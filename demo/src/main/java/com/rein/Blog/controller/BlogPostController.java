package com.rein.Blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.rein.Blog.Entities.BlogPost;
import com.rein.Blog.service.BlogPostService;

@RestController
@RequestMapping("/blogposts") 
public class BlogPostController {

    private final BlogPostService blogPostService;

    @Autowired
    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    
    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BlogPost> registerBlogPost(@RequestBody BlogPost blogPost) {
        BlogPost savedBlogPost = blogPostService.saveBlogPost(blogPost);
        return ResponseEntity.ok(savedBlogPost);
    }

   
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<BlogPost>> getAllBlogPost() {
        return ResponseEntity.ok(blogPostService.getAllBlogPost());
    }

   
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BlogPost> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(blogPostService.getBlogPostById(id));
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Integer id, @RequestBody BlogPost blogPost) {
        BlogPost updatedBlogPost = blogPostService.saveBlogPost(blogPost);
        return ResponseEntity.ok(updatedBlogPost);
    }

    
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Integer id) {
        blogPostService.deleteBlogPost(id);
        return ResponseEntity.ok().build();
    }
}
