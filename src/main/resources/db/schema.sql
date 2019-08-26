


DROP TABLE IF EXISTS `jd_user`;
CREATE TABLE `jd_user` (
  `user_id` varchar(60) NOT NULL COMMENT '主键id',
  `user_name` varchar(60) DEFAULT NULL COMMENT '用户姓名',
  `password` varchar(60)  DEFAULT NULL COMMENT '密码',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `sex` varchar(1) DEFAULT NULL COMMENT '性别 1：男 2：女',
  `department_id` varchar(60) NOT NULL COMMENT '所属部门编号',
  `status` varchar(1) NOT NULL COMMENT '1:有效 2：删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`user_id`)
);

DROP TABLE IF EXISTS `jd_department`;


CREATE TABLE `jd_department` (
  `department_id` varchar(60) NOT NULL COMMENT '主键id',
  `department_name` varchar(60) DEFAULT NULL COMMENT '部门名称',
  `department_count` integer  DEFAULT 0 COMMENT '部门人数',
  `status` varchar(1) DEFAULT NULL COMMENT '1:有效 2：删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`department_id`)
);

