package com.rein.Blog.service;

import com.rein.Blog.Entities.BlogPost;
import com.rein.Blog.repository.BlogPostRepository;

public class BlogPostService {
    
    private BlogPostRepository blogPostRepository;

    public BlogPostService(BlogPostRepository blogPostRepository){
        this.blogPostRepository = blogPostRepository;
    }
    //create
    public  BlogPost saveBlogPost(BlogPost blogPost){
        return blogPostRepository.save(blogPost);
    }
    //get
    public Iterable<BlogPost>getAllBlogPost(){
        return blogPostRepository.findAll();
    }
    //getById
    public BlogPost getBlogPostById(Integer id){
        return blogPostRepository.findById(id).orElse(null);
    }
    //update
    public BlogPost updateBlogPost(BlogPost blogPost){
        return blogPostRepository.save(blogPost);
    }
    //delete
    public void deleteBlogPost(Integer id){
        blogPostRepository.deleteById(id);
    }


}
