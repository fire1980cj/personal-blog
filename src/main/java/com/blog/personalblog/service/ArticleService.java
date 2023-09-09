package com.blog.personalblog.service;

import com.blog.personalblog.bo.ArticleBO;
import com.blog.personalblog.entity.Article;

import java.util.List;

public interface ArticleService {

    /**
     * 初始化数据
     */
    void init();

    /**
     * 获取文章（分页）
     * @param articleBO
     * @return
     */
    List<Article> getArticlePage(ArticleBO articleBO);

    /**
     * 新建文章
     * @param article
     */
    void saveArticle(Article article);

    /**
     * 修改文章
     * @param article
     */
    void updateArticle(Article article);

    /**
     * 删除文章
     * @param articleId
     */
    void deleteArticle(Integer articleId);

    /**
     * 根据id查找文章
     * @param articleId
     * @return
     */
    Article findByid(Integer articleId);
}
