/*
Navicat MySQL Data Transfer

Source Server         : 本地Mysql
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : ssmdemo

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2016-01-05 19:17:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) NOT NULL,
  `fid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES ('1', '1', '3');
INSERT INTO `friend` VALUES ('2', '1', '5');
INSERT INTO `friend` VALUES ('3', '1', '6');
INSERT INTO `friend` VALUES ('4', '2', '1');
INSERT INTO `friend` VALUES ('5', '3', '7');
INSERT INTO `friend` VALUES ('6', '4', '8');
INSERT INTO `friend` VALUES ('7', '2', '4');
INSERT INTO `friend` VALUES ('8', '5', '7');
INSERT INTO `friend` VALUES ('9', '6', '8');
INSERT INTO `friend` VALUES ('10', '7', '8');
INSERT INTO `friend` VALUES ('11', '8', '4');
INSERT INTO `friend` VALUES ('12', '9', '7');
INSERT INTO `friend` VALUES ('13', '10', '1');

-- ----------------------------
-- Table structure for idiosyncrasy
-- ----------------------------
DROP TABLE IF EXISTS `idiosyncrasy`;
CREATE TABLE `idiosyncrasy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of idiosyncrasy
-- ----------------------------
INSERT INTO `idiosyncrasy` VALUES ('1', '独孤九贱');
INSERT INTO `idiosyncrasy` VALUES ('2', '交际花');
INSERT INTO `idiosyncrasy` VALUES ('3', '屌丝');
INSERT INTO `idiosyncrasy` VALUES ('4', '白富美');
INSERT INTO `idiosyncrasy` VALUES ('5', '高富帅');
INSERT INTO `idiosyncrasy` VALUES ('6', '多愁善感');
INSERT INTO `idiosyncrasy` VALUES ('7', '忧郁');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nickname` varchar(50) NOT NULL,
  `gender` int(2) NOT NULL,
  `age` int(3) NOT NULL,
  `birthday` datetime NOT NULL,
  `roles` varchar(50) NOT NULL,
  `idiosyncrasy` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'peter', 'peter', 'peter', '1', '26', '1990-08-14 00:00:00', 'admin', '1');
INSERT INTO `user` VALUES ('2', 'lucy', 'lucy', 'lucy', '0', '15', '1995-07-12 00:00:00', 'user', '2');
INSERT INTO `user` VALUES ('3', 'leo', 'leo', 'leo', '1', '13', '2002-12-10 00:00:00', 'user', '3');
INSERT INTO `user` VALUES ('4', 'rose', 'rose', 'rose', '0', '17', '1997-10-18 00:00:00', 'manager', '6');
INSERT INTO `user` VALUES ('5', 'jack', 'jack', 'jack', '1', '19', '1995-03-11 00:00:00', 'user', '5');
INSERT INTO `user` VALUES ('6', 'Mark', 'Mark', 'Mark', '1', '25', '1991-01-08 00:00:00', 'user', '3');
INSERT INTO `user` VALUES ('7', 'jimmy', 'jimmy', 'jimmy', '1', '12', '2003-10-19 00:00:00', 'user', '6');
INSERT INTO `user` VALUES ('8', 'jerry', 'jerry', 'jerry', '0', '22', '1994-12-02 00:00:00', 'user', '4');
INSERT INTO `user` VALUES ('9', 'jimmy', 'jimmy', 'jimmy', '1', '19', '1995-06-16 00:00:00', 'user', '2');
INSERT INTO `user` VALUES ('10', 'Julian', 'Julian', 'Julian', '0', '17', '1997-07-07 00:00:00', 'user', '3');
INSERT INTO `user` VALUES ('11', 'joker', 'joker', 'joker', '1', '18', '1996-03-01 00:00:00', 'manager', '7');
