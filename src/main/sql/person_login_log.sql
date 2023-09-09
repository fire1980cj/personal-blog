DROP TABLE IF EXISTS `person_login_log`;
CREATE TABLE `person_login_log` (
                                    `info_id`           BIGINT(20)         NOT NULL 	PRIMARY KEY AUTO_INCREMENT    		COMMENT '登录访问id',
                                    `login_name`     	  VARCHAR(50)    	     NULL	DEFAULT ''                				COMMENT '登录账号',
                                    `ip_address`        VARCHAR(128)   		 NULL	DEFAULT ''                			  COMMENT '登录IP地址',
                                    `login_location`    VARCHAR(255)  		 NULL   DEFAULT ''                				COMMENT '登录地点',
                                    `browser_type`      VARCHAR(50)   		 NULL   DEFAULT ''                				COMMENT '浏览器类型',
                                    `os`             	  VARCHAR(50)   		 NULL 	DEFAULT ''                				COMMENT '操作系统',
                                    `status`         	  TINYINT       		 NULL 	DEFAULT 0               				  COMMENT '登录状态，默认0, 0-成功, 1-失败',
                                    `msg`            	  VARCHAR(255)  	     NULL 	DEFAULT ''                				COMMENT '提示消息',
                                    `create_time`       DATETIME            	 NULL 	DEFAULT CURRENT_TIMESTAMP       	COMMENT '创建时间'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Dynamic
  COMMENT '登录日志表';
