package com.blog.personalblog.mapper;

import com.blog.personalblog.entity.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagMapper {

    /**
     * 创建
     * @param tag
     * @return
     */
    int createTag(Tag tag);

    /**
     * 修改
     * @param tag
     * @return
     */
    int updateTag(Tag tag);

    /**
     * 分类列表（分页）
     * @return
     */
    List<Tag> getTagPage();

    /**
     * 删除
     * @param id
     * @return
     */
    void deleteTag(Integer id);

    /**
     * 批量添加标签
     * @param strings
     * @return
     */
    boolean batchAddTag(List<Tag> strings);

    /**
     * 批量删除标签
     * @param ids
     * @return
     */
    boolean deleteBatch(List<Tag> ids);

    /**
     * 根据标签查找对象
     * @param tag
     * @return
     */
    Tag getByTagName(Tag tag);

    /**
     * 根据id查找标签
     * @param tagId
     * @return
     */
    Tag getByTagId(Integer tagId);
}
