package com.blog.personalblog.service;

import com.blog.personalblog.entity.Category;
import com.blog.personalblog.util.PageRequest;

import javax.validation.Valid;
import java.util.List;

public interface CategoryService {

    List<Category> getCategoryPage(@Valid PageRequest pageRequest);
    int saveCategory(Category category);
    int updateCategory(Category category);
    int deleteCategory(Integer categoryId);
    Category findById(Integer categoryId);
}
