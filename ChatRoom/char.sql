/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : char

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-11-01 12:20:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `prichat`
-- ----------------------------
DROP TABLE IF EXISTS `prichat`;
CREATE TABLE `prichat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sender` varchar(20) NOT NULL,
  `receiver` varchar(20) NOT NULL,
  `senderNick` varchar(20) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `time` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prichat
-- ----------------------------
INSERT INTO `prichat` VALUES ('1', '1', '1', '1', '1', '1');
INSERT INTO `prichat` VALUES ('2', 's1', 's2', 'ss1', '1', '2');
INSERT INTO `prichat` VALUES ('3', 's2', 's1', 'ss2', '1', '2');
INSERT INTO `prichat` VALUES ('4', 's1', 's3', 'ss1', '1', '2');
INSERT INTO `prichat` VALUES ('5', 's4', 's1', 'ss4', '1', '2');
INSERT INTO `prichat` VALUES ('6', 's1', 's4', 'ss1', '1', '1');
INSERT INTO `prichat` VALUES ('7', 's1', 's4', 'ss1', '1', '1');
INSERT INTO `prichat` VALUES ('8', 'sender', 'receiver', 'senderNick', 'content', '2018-10-31 09:51:59');
INSERT INTO `prichat` VALUES ('9', 's1', 's2', 'ss1', '你好 世界', '2018-10-31 11:13:42');
INSERT INTO `prichat` VALUES ('10', 's1', 's3', 'ss1', ' 我晕', '2018-10-31 11:14:59');
INSERT INTO `prichat` VALUES ('11', 's1', 's2', 'ss1', '...', '2018-10-31 11:16:15');
INSERT INTO `prichat` VALUES ('12', 's1', 's2', 'ss1', ' 1', '2018-10-31 11:18:23');
INSERT INTO `prichat` VALUES ('13', 's1', 's2', 'ss1', ' ?', '2018-10-31 11:18:34');
INSERT INTO `prichat` VALUES ('14', 's1', 's2', 'ss1', ' 123', '2018-10-31 11:26:19');
INSERT INTO `prichat` VALUES ('15', 's1', 's2', 'ss1', ' 123 sss ', '2018-10-31 11:26:35');
INSERT INTO `prichat` VALUES ('16', 's1', 's4', 'ss1', ' 123', '2018-10-31 11:31:00');
INSERT INTO `prichat` VALUES ('17', 's1', 's4', 'ss1', ' 123123', '2018-10-31 11:31:20');
INSERT INTO `prichat` VALUES ('18', 's1', 's3', 'ss1', ' 123', '2018-10-31 02:36:50');
INSERT INTO `prichat` VALUES ('19', 's1', 's4', 'ss1', ' 123', '2018-10-31 02:37:03');
INSERT INTO `prichat` VALUES ('20', 's1', 's3', 'ss1', ' 123', '2018-10-31 02:37:19');
INSERT INTO `prichat` VALUES ('21', 's1', 's3', 'ss1', ' 123', '2018-10-31 02:39:53');
INSERT INTO `prichat` VALUES ('22', 's1', '', 'ss1', ' ', '2018-10-31 04:08:13');
INSERT INTO `prichat` VALUES ('23', 's1', '', 'ss1', ' ', '2018-10-31 04:08:45');
INSERT INTO `prichat` VALUES ('24', 's1', 's2', 'ss1', ' ', '2018-10-31 04:11:00');
INSERT INTO `prichat` VALUES ('25', 's1', 's2', 'ss1', ' ', '2018-10-31 05:02:19');
INSERT INTO `prichat` VALUES ('26', 's1', 's3', 'ss1', ' 123', '2018-10-31 05:28:58');
INSERT INTO `prichat` VALUES ('27', 's1', 's3', 'ss1', ' 12323', '2018-10-31 05:29:01');
INSERT INTO `prichat` VALUES ('28', 's2', 's4', 'ss2', ' 123', '2018-10-31 06:27:24');
INSERT INTO `prichat` VALUES ('29', 's2', 's3', 'ss2', ' 123333', '2018-10-31 06:27:31');
INSERT INTO `prichat` VALUES ('30', 's2', 's2', 'ss2', ' 1222', '2018-10-31 06:27:36');
INSERT INTO `prichat` VALUES ('31', 's1', 's2', 'ss1', ' sss', '2018-10-31 06:55:54');
INSERT INTO `prichat` VALUES ('32', 's1', 's3', 'ss1', ' ssdd得到是是', '2018-10-31 06:57:35');
INSERT INTO `prichat` VALUES ('33', 's1', 's3', 'ss1', '神丹', '2018-10-31 06:57:43');
INSERT INTO `prichat` VALUES ('34', 's1', 's3', 'ss1', '', '2018-10-31 06:57:45');
INSERT INTO `prichat` VALUES ('35', 's1', 's3', 'ss1', '得到', '2018-10-31 06:57:53');
INSERT INTO `prichat` VALUES ('36', 's1', 's3', 'ss1', '生生世世', '2018-10-31 06:58:00');
INSERT INTO `prichat` VALUES ('37', 's1', 's4', 'ss1', ' 13', '2018-10-31 06:58:54');
INSERT INTO `prichat` VALUES ('38', 's1', 's2', 'ss1', ' ss', '2018-10-31 06:59:47');
INSERT INTO `prichat` VALUES ('39', 's1', 's4', 'ss1', 'dd', '2018-10-31 06:59:53');
INSERT INTO `prichat` VALUES ('40', 's1', 's4', 'ss1', 's', '2018-10-31 06:59:58');
INSERT INTO `prichat` VALUES ('41', 's1', 's3', 'ss1', ' 12 ', '2018-10-31 07:00:44');
INSERT INTO `prichat` VALUES ('42', 's1', 's4', 'ss1', '3', '2018-10-31 07:00:49');
INSERT INTO `prichat` VALUES ('43', 's1', 's2', 'ss1', ' 123', '2018-10-31 07:06:50');
INSERT INTO `prichat` VALUES ('44', 's1', 's2', 'ss1', '1231', '2018-10-31 07:06:52');
INSERT INTO `prichat` VALUES ('45', 's1', 's2', 'ss1', ' ', '2018-10-31 07:19:16');
INSERT INTO `prichat` VALUES ('46', 's1', 's2', 'ss1', ' 1', '2018-10-31 07:47:25');
INSERT INTO `prichat` VALUES ('47', 's1', 's2', 'ss1', '2', '2018-10-31 07:47:26');
INSERT INTO `prichat` VALUES ('48', 's1', 's2', 'ss1', '3', '2018-10-31 09:26:37');
INSERT INTO `prichat` VALUES ('49', 's1', 's2', 'ss1', ' 444', '2018-11-01 11:10:52');

-- ----------------------------
-- Table structure for `pubchat`
-- ----------------------------
DROP TABLE IF EXISTS `pubchat`;
CREATE TABLE `pubchat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `groupId` int(11) NOT NULL,
  `acc` varchar(20) NOT NULL,
  `nick` varchar(20) DEFAULT NULL,
  `pic` varchar(100) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `time` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pubchat
-- ----------------------------
INSERT INTO `pubchat` VALUES ('1', '1', '1', '1', '1', '1', '1');
INSERT INTO `pubchat` VALUES ('2', '123456789', 's1', 'ss1', 'sss1', 'Hello World!', 'now!');
INSERT INTO `pubchat` VALUES ('3', '123456789', 's1', 'ss1', 'sss1', '!!!aaaa2', 'now2!');
INSERT INTO `pubchat` VALUES ('4', '123456789', 's998', 'test', 'test', 'test', '2018-10-31 07:35:10');
INSERT INTO `pubchat` VALUES ('5', '123456789', 's2', 'ss2', 'sss2', ' sss', '2018-10-31 07:38:28');
INSERT INTO `pubchat` VALUES ('6', '123456789', 's2', 'ss2', 'sss2', ' ss', '2018-10-31 07:39:16');
INSERT INTO `pubchat` VALUES ('7', '123456789', 's2', 'ss2', 'sss2', ' s', '2018-10-31 07:40:18');
INSERT INTO `pubchat` VALUES ('8', '123456789', 's2', 'ss2', 'sss2', 'ddd队都丢i', '2018-10-31 07:40:25');
INSERT INTO `pubchat` VALUES ('9', '123456789', 's1', 'ss1', 'sss1', '3', '2018-10-31 07:47:30');
INSERT INTO `pubchat` VALUES ('10', '123456789', 's1', 'ss1', 'sss1', ' 2', '2018-10-31 09:26:33');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acc` varchar(20) NOT NULL,
  `pw` varchar(20) NOT NULL,
  `nick` varchar(20) DEFAULT NULL,
  `pic` varchar(100) DEFAULT NULL,
  `time` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '1', '1', '1', '1');
INSERT INTO `user` VALUES ('2', 's1', 's1', 'ss1', 'sss1', 'ssss1');
INSERT INTO `user` VALUES ('3', 's2', 's2', 'ss2', 'sss2', 'ssss2');
INSERT INTO `user` VALUES ('4', 's3', 's3', 'ss3', 'sss3', 'ssss3');
INSERT INTO `user` VALUES ('5', 's4', 's4', 'ss4', 'sss4', 'ssss4');
INSERT INTO `user` VALUES ('6', '123456789', '123456', 'nick', 'pic', '2018-11-01 12:13:10');
