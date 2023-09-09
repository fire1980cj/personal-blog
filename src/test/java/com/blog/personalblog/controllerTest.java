package com.blog.personalblog;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.blog.personalblog.entity.Article;
import com.blog.personalblog.service.ArticleService;
import com.blog.personalblog.util.JsonResult;
import io.swagger.annotations.Authorization;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class controllerTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void ArticleTest(){
        Article article=new Article();
        article.setTitle("历史深处的民国");
        article.setId(2);
        article.setAuthor("西北工业大学出版社");
        article.setUserId(2231);
        article.setCategoryId(2);
        article.setArtStatus(1);
        article.setDescription("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");

        articleService.updateArticle(article);
        System.out.println("======================JsonResult.success()============================");
        System.out.println(JsonResult.success());
    }
}
