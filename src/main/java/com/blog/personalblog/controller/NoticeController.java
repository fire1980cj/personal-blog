package com.blog.personalblog.controller;

import com.blog.personalblog.config.page.PageResult;
import com.blog.personalblog.entity.Notice;
import com.blog.personalblog.service.NoticeService;
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

@Api(tags = "公告管理")
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    /**
     * 添加公告
     * @param pageRequest
     * @return
     */
    @ApiOperation(value = "公告列表")
    @PostMapping("/list")
    public JsonResult<Object> listPage(@RequestBody @Valid PageRequest pageRequest){
        List<Notice> noticeList=noticeService.getNoticePage(pageRequest);
        PageInfo pageInfo=new PageInfo(noticeList);
        PageResult pageResult=PageUtil.getPageResult(pageRequest,pageInfo);
        return JsonResult.success(pageResult);
    }

    /**
     * 修改公告
     * @param notice
     * @return
     */
    @ApiOperation(value = "修改公告")
    @PostMapping("/update")
    public JsonResult<Object> categoryUpdate(@RequestBody @Valid Notice notice){
        int isStatus=noticeService.updateNotice(notice);
        if(isStatus==0){
            return JsonResult.error("修改公告失败！");
        }
        return JsonResult.success();
    }

    /**
     * 添加公告
     * @param notice
     * @return
     */
    @ApiOperation(value = "添加公告")
    @PostMapping("/create")
    public JsonResult<Object> categoryCreate(@RequestBody @Valid Notice notice){
        int isStatus=noticeService.saveNotice(notice);
        if(isStatus==0){
            return JsonResult.error("添加公告失败！");
        }
        return JsonResult.success();
    }

    @ApiOperation(value = "删除公告")
    @PostMapping("/delete/{id}")
    public JsonResult<Object> categoryDelege(@PathVariable(value = "id") int id){
        noticeService.deleteNotice(id);
        return JsonResult.success();
    }
}
