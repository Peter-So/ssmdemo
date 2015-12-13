-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.25 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  8.2.0.4675
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 ssmdemo 的数据库结构
CREATE DATABASE IF NOT EXISTS `ssmdemo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ssmdemo`;


-- 导出  表 ssmdemo.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nickname` varchar(50) NOT NULL,
  `gender` int(2) NOT NULL,
  `age` int(3) NOT NULL,
  `birthday` datetime NOT NULL,
  `roles` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- 正在导出表  ssmdemo.user 的数据：~11 rows (大约)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `nickname`, `gender`, `age`, `birthday`, `roles`) VALUES
	(1, 'peter', 'peter', 'peter', 1, 26, '1990-08-14 00:00:00', 'admin'),
	(2, 'lucy', 'lucy', 'lucy', 0, 15, '1995-07-12 00:00:00', 'user'),
	(3, 'leo', 'leo', 'leo', 1, 13, '2002-12-10 00:00:00', 'user'),
	(4, 'rose', 'rose', 'rose', 0, 17, '1997-10-18 00:00:00', 'manager'),
	(5, 'jack', 'jack', 'jack', 1, 19, '1995-03-11 00:00:00', 'user'),
	(6, 'Mark', 'Mark', 'Mark', 1, 25, '1991-01-08 00:00:00', 'user'),
	(7, 'jimmy', 'jimmy', 'jimmy', 1, 12, '2003-10-19 00:00:00', 'user'),
	(8, 'jerry', 'jerry', 'jerry', 0, 22, '1994-12-02 00:00:00', 'user'),
	(9, 'jimmy', 'jimmy', 'jimmy', 1, 19, '1995-06-16 00:00:00', 'user'),
	(10, 'Julian', 'Julian', 'Julian', 0, 17, '1997-07-07 00:00:00', 'user'),
	(11, 'joker', 'joker', 'joker', 1, 18, '1996-03-01 00:00:00', 'manager');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
