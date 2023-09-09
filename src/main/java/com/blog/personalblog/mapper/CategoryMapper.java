package com.blog.personalblog.mapper;

import com.blog.personalblog.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {

    int create(Category category);

    int update(Category category);

    List<Category> getCategoryPage();

    int delete(Integer id);

    Category getById(Integer id);
}
