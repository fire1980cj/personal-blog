package com.blog.personalblog.service;

import com.blog.personalblog.entity.Notice;
import com.blog.personalblog.util.PageRequest;

import java.util.List;

public interface NoticeService {

    /**
     * 获取所有的分类（分页）
     * @return
     */
    List<Notice> getNoticePage(PageRequest pageRequest);

    /**
     * 新建分类
     * @Param notice
     * @return
     */
    int saveNotice(Notice notice);

    /**
     * 修改分类
     * @Param notice
     * @return
     */
    int updateNotice(Notice notice);

    /**
     * 删除分类
     * @Param noticeId
     */
    int deleteNotice(Integer noticeId);
}
