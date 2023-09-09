package com.blog.personalblog.mapper;

import com.blog.personalblog.entity.ArticleTag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : fox
 * @create: 2023-08-09
 */
@Repository
public interface ArticleTagMapper {

    /**
     * 批量插入
     * @param articleTagList
     * @return
     */
    int inserBatch(@Param("articleTagList")List<ArticleTag> articleTagList);

    /**
     * 根据文章id删除关联表的数据
     * @param articleId
     */
    void deleteByArticleId(Integer articleId);

    /**
     * 根据文章id查找出所有关联的标签数据
     * @param articleId
     * @return
     */
    List<ArticleTag> getArticleTagById(@Param("articleId") Integer articleId);
}
