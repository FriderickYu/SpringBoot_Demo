CREATE TABLE `x_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `avatar` varchar(200) DEFAULT NULL,
   `deleted` INT(1) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

insert into `x_user` (`id`, `username`, `password`, `email`, `phone`, `status`, `avatar`, `deleted`) values('1','admin','123456','super@outlook.com','18677778888','1','https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif','0');
insert into `x_user` (`id`, `username`, `password`, `email`, `phone`, `status`, `avatar`, `deleted`) values('2','zhangsan','123456','zhangsan@outlook.com','13966667777','1','https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif','0');
insert into `x_user` (`id`, `username`, `password`, `email`, `phone`, `status`, `avatar`, `deleted`) values('3','lisi','123456','lisi@outlook.com','13966667778','1','https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif','0');
insert into `x_user` (`id`, `username`, `password`, `email`, `phone`, `status`, `avatar`, `deleted`) values('4','wangwu','123456','wangwu@outlook.com','13966667772','1','https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif','0');
insert into `x_user` (`id`, `username`, `password`, `email`, `phone`, `status`, `avatar`, `deleted`) values('5','zhaoer','123456','zhaoer@outlook.com','13966667776','1','https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif','0');
insert into `x_user` (`id`, `username`, `password`, `email`, `phone`, `status`, `avatar`, `deleted`) values('6','songliu','123456','songliu@outlook.com','13966667771','1','https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif','0');


