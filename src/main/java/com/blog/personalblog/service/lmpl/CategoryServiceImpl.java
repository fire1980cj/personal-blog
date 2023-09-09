package com.blog.personalblog.service.lmpl;

import com.blog.personalblog.entity.Category;
import com.blog.personalblog.mapper.CategoryMapper;
import com.blog.personalblog.service.CategoryService;
import com.blog.personalblog.util.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategoryPage(@Valid PageRequest pageRequest) {
        return categoryMapper.getCategoryPage();
    }

    @Override
    public int saveCategory(Category category) {
       return categoryMapper.create(category);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryMapper.update(category);
    }

    @Override
    public int deleteCategory(Integer categoryId) {
        return categoryMapper.delete(categoryId);
    }

    @Override
    public Category findById(Integer categoryId) {
        return categoryMapper.getById(categoryId);
    }
}
