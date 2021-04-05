create database shuttle;

use shuttle;

create table orders(
	id bigint not null auto_increment,
	cid bigint not null comment '消费者用户id',
	sid bigint comment '生产者用户id',
	pid bigint not null comment '产品id',
	date datetime not null comment '创建时间',
	address varchar(255) not null comment '地址',
	note varchar(255) comment '备注',
	file varchar(255) comment '附件',
	status int(10) not null default -1 comment '订单状态',
	primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;