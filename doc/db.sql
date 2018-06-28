DROP TABLE IF EXISTS t_user;
create table t_user (
  id int primary key auto_increment comment '主键id',
  headId varchar(500) comment '头像',
  balance INT COMMENT '余额，单位：分',
  openId varchar(100) comment 'openid',
  unionId varchar(100) comment 'unionId',
  points int comment '积分数',
  version int  DEFAULT  1 comment '数据库版本号',
  insertTime bigint comment '写入时间'
) CHARSET = utf8mb4 COMMENT '用户表';
DROP TABLE IF EXISTS t_point_log;
CREATE table t_point_log(
id int PRIMARY KEY auto_increment comment '主键id',
userId int not null comment '用户id',
beforePoint int comment '变动前积分',
afterPoint int comment '变动后积分',
reason varchar(500) comment '变动原因',
insertTime bigint comment '写入时间',
lastUpdateTime bigint comment '最后修改时间',
index idx_userId(userId)
)CHARSET = utf8mb4 COMMENT '积分变动表';
DROP TABLE IF EXISTS t_category;
CREATE table if t_category(
id int PRIMARY  KEY auto_incrment '主键id',
name varchar(100) comment '类目名称',
icon varchar(200) comment '类目图标',
parentId int comment '上级类目',
insertTime bigint comment '写入时间',
lastUpdatetTime bigint comment '最后修改时间'
)CHARSET = utf8mb4 COMMENT '类目表';

DROP TABLE IF EXISTS t_news;
CREATE table if t_news(
id int PRIMARY  KEY auto_incrment '主键id',
title varchar(100) comment '新闻标题',
content varchar(5000) comment '新闻内容',
img varchar(1024) comment '图片',
isTop tinyint comment '是否置顶',
insertTime bigint comment '写入时间',
lastUpdatetTime bigint comment '最后修改时间'
)CHARSET = utf8mb4 COMMENT '类目表';


