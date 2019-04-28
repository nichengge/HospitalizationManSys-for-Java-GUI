/*
Navicat MySQL Data Transfer

Source Server         : con_MySQL_5.7.x
Source Server Version : 50722
Source Host           : 127.0.0.1:3306
Source Database       : hosmansys

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-04-08 22:09:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for illinf
-- ----------------------------
DROP TABLE IF EXISTS `illinf`;
CREATE TABLE `illinf` (
  `iName` varchar(25) DEFAULT NULL,
  `iNum` varchar(20) DEFAULT NULL,
  `iSex` varchar(2) DEFAULT NULL,
  `iTime` datetime DEFAULT NULL,
  `RoomNum` varchar(5) DEFAULT NULL,
  `iDoc` varchar(25) DEFAULT NULL,
  `iText` varchar(255) DEFAULT NULL,
  `iSta` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of illinf
-- ----------------------------
INSERT INTO `illinf` VALUES ('张三', '2019148', '男', '2019-04-08 00:00:00', '#204', '王二小', '感冒', '1');

-- ----------------------------
-- Table structure for roominf
-- ----------------------------
DROP TABLE IF EXISTS `roominf`;
CREATE TABLE `roominf` (
  `RoomNum` varchar(5) DEFAULT NULL,
  `RoomMan` varchar(25) DEFAULT NULL,
  `RoomSpa` int(2) DEFAULT NULL,
  `RoomType` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of roominf
-- ----------------------------
INSERT INTO `roominf` VALUES ('#201', '李四', '1', 'ICU病房');
INSERT INTO `roominf` VALUES ('#202', '王二小', '2', '专属病房');
INSERT INTO `roominf` VALUES ('#203', '王五', '4', '普通病房');
INSERT INTO `roominf` VALUES ('#204', '赵六', '1', 'ICU病房');

-- ----------------------------
-- Table structure for userinf
-- ----------------------------
DROP TABLE IF EXISTS `userinf`;
CREATE TABLE `userinf` (
  `id` varchar(25) NOT NULL,
  `pwd` varchar(32) NOT NULL,
  `type` varchar(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of userinf
-- ----------------------------
INSERT INTO `userinf` VALUES ('admin', 'admin', 'A');
INSERT INTO `userinf` VALUES ('user', 'user', 'U');
