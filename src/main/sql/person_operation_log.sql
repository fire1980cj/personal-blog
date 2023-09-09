DROP TABLE IF EXISTS `person_operation_log`;
CREATE TABLE `person_operation_log` (
                                        `operation_id`          INT             NOT NULL PRIMARY KEY AUTO_INCREMENT     COMMENT '主键',
                                        `operation_ip`          VARCHAR(128)        NULL DEFAULT 0                      COMMENT '主机地址',
                                        `oper_location`         VARCHAR(255)        NULL DEFAULT ''                     COMMENT '操作地点',
                                        `method`                TEXT                NULL                                COMMENT '方法名',
                                        `args`          		  TEXT                NULL                                COMMENT '参数',
                                        `operation_name`        VARCHAR(50)     NOT NULL DEFAULT ''                     COMMENT '操作人',
                                        `operation_type` 		  VARCHAR(50)     NOT NULL DEFAULT ''                     COMMENT '操作类型',
                                        `return_value`   		  TEXT                NULL                                COMMENT '返回参数',
                                        `create_time`        	  DATETIME            NULL DEFAULT CURRENT_TIMESTAMP      COMMENT '创建时间',
                                        `update_time`        	  DATETIME            NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Dynamic
  COMMENT '操作日志表';
