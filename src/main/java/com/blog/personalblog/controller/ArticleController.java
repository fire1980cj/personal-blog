package com.blog.personalblog.controller;

import com.blog.personalblog.bo.ArticleBO;
import com.blog.personalblog.config.page.PageResult;
import com.blog.personalblog.entity.Article;
import com.blog.personalblog.service.ArticleService;
import com.blog.personalblog.util.JsonResult;
import com.blog.personalblog.util.PageRequest;
import com.blog.personalblog.util.PageUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "文章管理")
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    /**
     * 文章列表
     *
     * @param articleBO
     * @return
     */
    @ApiOperation(value = "文章列表")
    @PostMapping("/list")
    public JsonResult<Object> listPage(@RequestBody @Valid ArticleBO articleBO) {
        List<Article> articleList = articleService.getArticlePage(articleBO);
        PageInfo pageInfo = new PageInfo(articleList);
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageNum(articleBO.getPageNum());
        pageRequest.setPageSize(articleBO.getPageSzie());
        PageResult pageResult = PageUtil.getPageResult(pageRequest, pageInfo);
        return JsonResult.success(pageResult);
    }

    /**
     * 添加文章
     *
     * @param article
     * @return
     */
    @ApiOperation(value = "添加文档")
    @PostMapping("/create")
    public JsonResult<Object> articleCreate(@RequestBody @Valid Article article) {
        articleService.saveArticle(article);
        return JsonResult.success();
    }

    /**
     * 修改文章
     *
     * @param article
     * @return
     */
    @ApiOperation(value = "修改文章")
    @PostMapping("/update")
    public JsonResult<Object> articleUpdate(@RequestBody @Valid Article article) {
        articleService.updateArticle(article);
        return JsonResult.success();
    }

    /**
     * 删除文章
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除文章")
    @PostMapping("/delete/{id}")
    public JsonResult<Object> articleDelete(@PathVariable(value = "id") int id) {
        articleService.deleteArticle(id);
        return JsonResult.success();
    }

    /**
     * 根据id查找文章
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查找文章")
    @PostMapping("/getArticle/{id}")
    public JsonResult<Object> getArticleById(@PathVariable(value = "id") int id) {
        Article article = articleService.findByid(id);
        return JsonResult.success(article);
    }
}
