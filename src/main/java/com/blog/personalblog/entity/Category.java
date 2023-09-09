package com.blog.personalblog.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Category {

    private Integer categoryId;
    private String categoryName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
