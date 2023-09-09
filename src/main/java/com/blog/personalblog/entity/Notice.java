package com.blog.personalblog.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Notice {

    private int noticeId;
    private String noticeTitle;
    private int noticeType;
    private int status;
    private String noticeContent;
    private String createby;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
