/*
Navicat MySQL Data Transfer

Source Server         : MySql_local
Source Server Version : 50527
Source Host           : 127.0.0.1:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2016-01-25 11:56:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL COMMENT 'id',
  `name` varchar(12) DEFAULT NULL COMMENT '姓名',
  `gender` tinyint(1) NOT NULL COMMENT '1-男，2-女',
  `age` tinyint(2) DEFAULT NULL COMMENT '年龄',
  `birthday` bigint(20) DEFAULT NULL COMMENT '生日',
  `address` varchar(128) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
