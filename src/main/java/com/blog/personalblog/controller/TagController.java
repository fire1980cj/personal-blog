package com.blog.personalblog.controller;

import com.blog.personalblog.config.page.PageResult;
import com.blog.personalblog.entity.Tag;
import com.blog.personalblog.service.TagService;
import com.blog.personalblog.util.JsonResult;
import com.blog.personalblog.util.PageRequest;
import com.blog.personalblog.util.PageUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "标签管理")
@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    TagService tagService;

    /**
     * 分页查询列表
     *
     * @return
     * @Param pageRequest
     */
    @ApiOperation(value = "标签列表")
    @PostMapping("list")
    public JsonResult<Object> listPage(@RequestBody @Valid PageRequest pageRequest) {
        List<Tag> tagList = tagService.getTagPage(pageRequest);
        PageInfo pageInfo = new PageInfo(tagList);
        PageResult pageResult = PageUtil.getPageResult(pageRequest, pageInfo);
        return JsonResult.success(pageResult);
    }

    /**
     * 添加标签
     * @param tag
     * @return
     */
    @ApiOperation(value = "添加标签")
    @PostMapping("/create")
    public JsonResult<Object> tagCreate(@RequestBody @Valid Tag tag) {
        int isStatus = tagService.saveTag(tag);
        if (isStatus == 0) {
            return JsonResult.error("标签添加失败！");
        }
        return JsonResult.success();
    }

    /**
     * 批量添加标签，最多添加10个
     * @param tags 义字符串的方式，以英文逗号隔开。例如：JAVA,C语言,Python
     * @return
     */
    @ApiOperation(value = "批量添加标签")
    @PostMapping("/batchCreate")
    public JsonResult<Object> batchCreate(@RequestBody @Valid Tag tags){
        try{
            boolean isStatus=tagService.batchAddTag(tags.getTagName());
            if(!isStatus){
                return JsonResult.error("批量添加标签！");
            }
        }catch (Exception e){
            return JsonResult.error(e.getMessage());
        }
        return JsonResult.success();
    }

    /**
     * 批量删除标签
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除标签")
    @PostMapping("/batchDelete")
    public JsonResult<Object> batchDelete(@RequestBody @Valid String ids){
        try{
            boolean isStatus=tagService.batchDelete(ids);
            if(!isStatus){
                return JsonResult.error("批量删除失败！");
            }
        }catch (Exception e){
            return JsonResult.error(e.getMessage());
        }
        return JsonResult.success();
    }

    /**
     * 删除标签
     * @param id
     * @return
     */
    @ApiOperation(value = "删除标签")
    @PostMapping("/tagDelete/{id}")
    public JsonResult<Object> tagDelete(@PathVariable(value = "id") int id){
        tagService.deleteTag(id);
        return JsonResult.success();
    }
}
