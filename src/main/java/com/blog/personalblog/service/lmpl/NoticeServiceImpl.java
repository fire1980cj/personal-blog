package com.blog.personalblog.service.lmpl;

import com.blog.personalblog.entity.Notice;
import com.blog.personalblog.mapper.NoticeMapper;
import com.blog.personalblog.service.NoticeService;
import com.blog.personalblog.util.PageRequest;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public List<Notice> getNoticePage(PageRequest pageRequest) {
        int pageNum=pageRequest.getPageNum();
        int pageSize=pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<Notice> noticeList=noticeMapper.getNoticePage();
        return noticeList;
    }

    @Override
    public int saveNotice(Notice notice) {
        return noticeMapper.createNotice(notice);
    }

    @Override
    public int updateNotice(Notice notice) {
        return noticeMapper.updateNotice(notice);
    }

    @Override
    public int deleteNotice(Integer noticeId) {
        return noticeMapper.deleteNotice(noticeId);
    }
}
