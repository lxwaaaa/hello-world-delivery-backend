create table temp
(
    `temp_id`   VARCHAR(32) COMMENT 'id',
    `user_name` VARCHAR(32) COMMENT '用户名',
    `phone_num` VARCHAR(32) COMMENT '联系方式',

    PRIMARY KEY (`temp_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='测试临时表';
