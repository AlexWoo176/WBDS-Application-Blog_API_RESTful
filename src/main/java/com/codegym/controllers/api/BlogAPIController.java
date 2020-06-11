package com.codegym.controllers.api;

import com.codegym.models.Blog;
import com.codegym.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogAPIController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public ResponseEntity<Iterable<Blog>> listBlog() {
        Iterable<Blog> blogs = blogService.findAllBlog();
        return new ResponseEntity<Iterable<Blog>>(blogs, HttpStatus.OK);
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable("id") Long id) {
        Blog blogs = blogService.findBlogById(id);
        return new ResponseEntity<Blog>(blogs, HttpStatus.OK);
    }

    @PostMapping("/blogs")
    public ResponseEntity<Void> createBlog(@RequestBody Blog blog) {
        blogService.saveBlog(blog);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/blogs/{id}")
    public ResponseEntity<Void> editBlog(@PathVariable("id") Long id, @RequestBody Blog blog) {
        Blog blog1 = blogService.findBlogById(id);
        blog1.setTitle(blog.getTitle());
        blog1.setContent(blog.getContent());
        blog1.setCategory(blog.getCategory());
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/blogs/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable("id") Long id) {
        blogService.removeBlog(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
