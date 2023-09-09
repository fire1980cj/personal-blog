package com.blog.personalblog.mapper;

import com.blog.personalblog.bo.ArticleBO;
import com.blog.personalblog.entity.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper {

    /**
     * 文章列表（分页）
     * @param articleBO
     * @return
     */
    List<Article> getArticlePage(@Param("articleBO") ArticleBO articleBO);

    /**
     * 新建文章
     * @param article
     */
    void createArticle(Article article);

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
    Article getById(Integer articleId);

    /**
     * 获取全部文章信息
     * @return
     */
    List<Article> findAll();


}
