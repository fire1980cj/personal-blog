DROP TABLE IF EXISTS `person_article`; -- 删除表
CREATE TABLE `person_article` (
                                  `id`                 INT             NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
                                  `author`             VARCHAR(128)    NOT NULL                            COMMENT '作者',
                                  `title`              VARCHAR(255)    NOT NULL                            COMMENT '文章标题',
                                  `tag_id`             INT(11)         NOT NULL                            COMMENT '文章标签id',
                                  `user_id`            INT(11)         NOT NULL                            COMMENT '用户id',
                                  `category_id`        INT(11)         NOT NULL                            COMMENT '分类id',
                                  `content`            LONGTEXT            NULL                            COMMENT '文章内容',
                                  `views`              BIGINT          NOT NULL DEFAULT 0                  COMMENT '文章浏览量',
                                  `total_words`        BIGINT          NOT NULL DEFAULT 0                  COMMENT '文章总字数',
                                  `commentable`        INT    		     NULL                            COMMENT '评论id',
                                  `art_status`         TINYINT         NOT NULL DEFAULT 0                  COMMENT '发布，默认0, 0-发布, 1-草稿',
                                  `description`        VARCHAR(255)    NOT NULL                            COMMENT '描述',
                                  `image_url`          VARCHAR(255)    NOT NULL                            COMMENT '文章logo',
                                  `create_time`        DATETIME            NULL DEFAULT CURRENT_TIMESTAMP      COMMENT '创建时间',
                                  `update_time`        DATETIME            NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Dynamic
  COMMENT '文章管理表';
