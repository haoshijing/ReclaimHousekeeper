
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(100) DEFAULT NULL COMMENT '类目名称',
  `icon` varchar(200) DEFAULT NULL COMMENT '类目图标',
  `parentId` int(11) DEFAULT NULL COMMENT '上级类目',
  `insertTime` bigint(20) DEFAULT NULL COMMENT '写入时间',
  `lastUpdatetTime` bigint(20) DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='类目表';

-- ----------------------------
-- Records of t_category
-- ----------------------------

-- ----------------------------
-- Table structure for t_news
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` varchar(100) DEFAULT NULL COMMENT '新闻标题',
  `content` varchar(5000) DEFAULT NULL COMMENT '新闻内容',
  `isTop` tinyint(4) DEFAULT NULL COMMENT '是否置顶',
  `insertTime` bigint(20) DEFAULT NULL COMMENT '写入时间',
  `lastUpdatetTime` bigint(20) DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='类目表';

-- ----------------------------
-- Records of t_news
-- ----------------------------

-- ----------------------------
-- Table structure for t_point_log
-- ----------------------------
DROP TABLE IF EXISTS `t_point_log`;
CREATE TABLE `t_point_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `userId` int(11) NOT NULL COMMENT '用户id',
  `beforePoint` int(11) DEFAULT NULL COMMENT '变动前积分',
  `afterPoint` int(11) DEFAULT NULL COMMENT '变动后积分',
  `reason` varchar(500) DEFAULT NULL COMMENT '变动原因',
  `insertTime` bigint(20) DEFAULT NULL COMMENT '写入时间',
  `lastUpdateTime` bigint(20) DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='积分变动表';

-- ----------------------------
-- Records of t_point_log
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `headId` varchar(500) DEFAULT NULL COMMENT '头像',
  `balance` int(11) DEFAULT NULL COMMENT '余额，单位：分',
  `openId` varchar(100) DEFAULT NULL COMMENT 'openid',
  `unionId` varchar(100) DEFAULT NULL COMMENT 'unionId',
  `points` int(11) DEFAULT NULL COMMENT '积分数',
  `version` int(11) DEFAULT '1' COMMENT '数据库版本号',
  `insertTime` bigint(20) DEFAULT NULL COMMENT '写入时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
