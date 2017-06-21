
CREATE TABLE `student` (
  `student_id` varchar(36) NOT NULL COMMENT '主键',
  `name` varchar(64) NOT NULL COMMENT '姓名',
  `address` VARCHAR(200) DEFAULT NULL ,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '学生';
