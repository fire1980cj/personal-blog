package com.blog.personalblog.controller;

import com.blog.personalblog.config.page.PageResult;
import com.blog.personalblog.entity.Category;
import com.blog.personalblog.service.CategoryService;
import com.blog.personalblog.util.JsonResult;
import com.blog.personalblog.util.PageRequest;
import com.blog.personalblog.util.PageUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "分类管理")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /**
     * 分页查询列表
     * @Param pageRequest
     * @return
     */
    @ApiOperation("分类列表")
    @PostMapping("/list")
    public JsonResult<Object> listPage(@RequestBody @Valid PageRequest pageRequest){
        List<Category> categoryList=categoryService.getCategoryPage(pageRequest);
        PageInfo pageInfo=new PageInfo(categoryList);
        PageResult pageResult= PageUtil.getPageResult(pageRequest,pageInfo);
        return JsonResult.success(pageResult);
    }

    /**
     * 添加分类
     * @param category
     * @return
     */
    @ApiOperation("添加分类")
    @PostMapping("/create")
    public JsonResult<Object> categoryCreate(@RequestBody @Valid Category category){
        int isStatus=categoryService.saveCategory(category);
        if(isStatus==0){
            return JsonResult.error("添加分类失败");
        }
        return JsonResult.success();
    }

    @ApiOperation("修改分类信息")
    @PostMapping("/update")
    public JsonResult<Object> categoryUpdate(@RequestBody @Valid Category category){
        int isStatus=categoryService.updateCategory(category);
        if(isStatus==0){
            return JsonResult.error("修改分类信息失败");
        }
        return JsonResult.success();
    }

    @ApiOperation("删除分类信息")
    @PostMapping("/delete/{id}")
    public JsonResult<Object> categoryDelete(@PathVariable(value = "id") int id){
        categoryService.deleteCategory(id);
        return JsonResult.success();
    }
}
