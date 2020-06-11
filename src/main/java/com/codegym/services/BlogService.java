package com.codegym.services;

import com.codegym.models.Blog;

public interface BlogService {
    Iterable<Blog> findAllBlog();

    Blog findBlogById(Long id);

    void saveBlog(Blog blog);

    void removeBlog(Long id);
}
