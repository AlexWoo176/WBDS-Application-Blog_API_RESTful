package com.codegym.services;

import com.codegym.models.Category;

public interface CategoryService {
    Iterable<Category> findAllCategory();

    Category findByIdCategories(Long id);

    void saveCategory(Category category);

    void removeCategory(Long id);
}
