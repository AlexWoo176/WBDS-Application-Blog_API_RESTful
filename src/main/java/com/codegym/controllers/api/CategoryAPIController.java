package com.codegym.controllers.api;

import com.codegym.models.Category;
import com.codegym.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryAPIController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<Iterable<Category>> listCategory() {
        Iterable<Category> categories = categoryService.findAllCategory();
        return new ResponseEntity<Iterable<Category>>(categories,HttpStatus.OK);
    }

    @GetMapping(value = "/categories/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> detail(@PathVariable("id") Long id) {
        Category category = categoryService.findByIdCategories(id);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @PostMapping("/categories")
    public ResponseEntity<Void> createCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Void> updateCategory(@RequestBody Category category, @PathVariable("id") Long id) {
        Category category1 = categoryService.findByIdCategories(id);
        category1.setName(category.getName());
        categoryService.saveCategory(category1);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) {
        if (categoryService.findByIdCategories(id) == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        categoryService.removeCategory(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
