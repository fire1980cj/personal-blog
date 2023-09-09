package com.blog.personalblog.service;

import com.blog.personalblog.entity.Tag;
import com.blog.personalblog.util.PageRequest;

import java.util.List;

public interface TagService {

    /**
     * 获取所有的标签（分页）
     * @param pageRequest
     * @return
     */
    List<Tag> getTagPage(PageRequest pageRequest);

    /**
     * 新建标签
     * @param tag
     * @return
     */
    int saveTag(Tag tag);

    /**
     * 修改标签
     * @param tag
     * @return
     */
    int updateTag(Tag tag);

    /**
     * 删除标签
     * @param id
     * @return
     */
    void deleteTag(Integer id);

    /**
     * 批量添加
     * @param tags
     * @return
     * @throws Exception
     */
    boolean batchAddTag(String tags) throws Exception;

    /**
     * 批量删除标签
     * @param tagname
     * @return
     */
    boolean batchDelete(String tagname);

    /**
     * 根据标签查找
     * @param tagName
     * @return
     */
    Tag findByTagName(String tagName);

    /**
     * 根据id查找标签
     * @param tagId
     * @return
     */
    Tag findByTagId(Integer tagId);
}
