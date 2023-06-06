CREATE TABLE `x_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) DEFAULT NULL,
  `role_desc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;


insert into `x_role` (`role_id`, `role_name`, `role_desc`) values('1','admin','超级管理员');
insert into `x_role` (`role_id`, `role_name`, `role_desc`) values('2','hr','人事专员');
insert into `x_role` (`role_id`, `role_name`, `role_desc`) values('3','normal','普通员工');
