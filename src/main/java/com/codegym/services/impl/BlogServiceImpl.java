package com.codegym.services.impl;

import com.codegym.models.Blog;
import com.codegym.repositories.BlogRepository;
import com.codegym.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findBlogById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void removeBlog(Long id) {
        blogRepository.delete(id);
    }
}
