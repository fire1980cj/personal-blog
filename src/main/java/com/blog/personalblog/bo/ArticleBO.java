package com.blog.personalblog.bo;

import lombok.Data;

@Data
public class ArticleBO {

    /**
     * 分类id
     */
    private Integer categoryId;

    /**
     * 发布状态
     */
    private Integer artStatus;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 页码
     */
    private int pageNum;

    /**
     * 每页的数据条数
     */
    private int pageSzie;
}
