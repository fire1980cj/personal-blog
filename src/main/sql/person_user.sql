DROP TABLE IF EXISTS `person_user`;
CREATE TABLE `person_user` (
                               `id`                 INT             NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
                               `username`           VARCHAR(255)    NOT NULL                            COMMENT '用户名',
                               `password`           VARCHAR(255)    NOT NULL                            COMMENT '密码',
                               `email`              VARCHAR(64)         NULL                            COMMENT '邮箱',
                               `last_login_time`    datetime            NULL                            COMMENT '上次登录时间',
                               `phone`              BIGINT(11)      NOT NULL DEFAULT 0                  COMMENT '手机号',
                               `nickname`			  VARCHAR(64)         NULL                            COMMENT '昵称',
                               `create_time`        DATETIME            NULL DEFAULT CURRENT_TIMESTAMP      COMMENT '创建时间',
                               `update_time`        DATETIME            NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Dynamic
  COMMENT '用户管理表';
