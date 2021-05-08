create database shuttle;

use shuttle;

create table user(
	id bigint not null auto_increment,
	password varchar(255) not null comment '加密密码',
	phone varchar(255) comment '手机',
	address varchar(255) comment '地址',
	score int(255) unsigned default 0 comment '点数',
	admin tinyint(1) default 0 comment '管理员',
	name varchar(255) not null comment '昵称',
	email varchar(255) not null default 'null' comment '邮箱',
	primary key(id),
	unique(phone),
	unique(name),
	unique(email)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` VALUES (1,'084e0343a0486ff05530df6c705c8bb4','18800000000','Earth',0,1,'guest');