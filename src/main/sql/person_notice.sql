DROP TABLE IF EXISTS `person_notice`;
CREATE TABLE `person_notice` (
                                 `notice_id`        INT             NOT NULL PRIMARY KEY AUTO_INCREMENT     COMMENT '主键',
                                 `notice_title`		VARCHAR(255)      NOT NULL                                COMMENT '公告标题',
                                 `notice_type`		TINYINT    		  NOT NULL DEFAULT 0                      COMMENT '公告类型，默认0, 0-公告, 1-通知, 2-提醒',
                                 `status`           TINYINT           NOT NULL DEFAULT 0                      COMMENT '状态，默认0, 0-正常, 1-关闭',
                                 `noticeContent`    text                  NULL                                COMMENT '公告内容',
                                 `createBy`   		VARCHAR(128)      NOT NULL                                COMMENT '创建者',
                                 `create_time`      DATETIME              NULL DEFAULT CURRENT_TIMESTAMP      COMMENT '创建时间',
                                 `update_time`      DATETIME              NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Dynamic
  COMMENT '通知公告表';
