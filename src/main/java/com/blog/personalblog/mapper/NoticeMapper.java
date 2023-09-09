package com.blog.personalblog.mapper;

import com.blog.personalblog.entity.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeMapper {

    /**
     * 创建
     * @param notice
     * @return
     */
    int createNotice(Notice notice);

    /**
     * 修改
     * @param notice
     * @return
     */
    int updateNotice(Notice notice);

    /**
     * 分类列表（分页）
     * @return
     */
    List<Notice> getNoticePage();

    /**
     * 删除
     * @param id
     */
    int deleteNotice(Integer id);
}

