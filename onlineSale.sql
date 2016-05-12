﻿/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50545
Source Host           : localhost:3306
Source Database       : onlineSale

Target Server Type    : MYSQL
Target Server Version : 50545
File Encoding         : 65001

Date: 2016-05-12 09:09:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for carriage
-- ----------------------------
DROP TABLE IF EXISTS `carriage`;
CREATE TABLE `carriage` (
  `carriageId` int(11) NOT NULL AUTO_INCREMENT,
  `carriageName` varchar(45) DEFAULT NULL,
  `carriagePrice` double DEFAULT NULL,
  PRIMARY KEY (`carriageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carriage
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(45) DEFAULT NULL,
  `createTime` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'justtest', '2016-52-06 10:52:31');
INSERT INTO `category` VALUES ('2', 'test1', '2016-07-06 12:07:51');
INSERT INTO `category` VALUES ('3', 'test2', '2016-07-06 12:07:57');
INSERT INTO `category` VALUES ('4', 'test3', '2016-08-06 12:08:02');
INSERT INTO `category` VALUES ('5', 'haha1', '2016-39-06 08:39:42');
INSERT INTO `category` VALUES ('6', 'haha2', '2016-39-06 08:39:59');
INSERT INTO `category` VALUES ('7', 'haha3', '2016-50-06 08:50:32');

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `goodId` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collection
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentId` int(11) NOT NULL,
  `goodId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  `commentTime` varchar(45) DEFAULT NULL,
  `goodServer` int(11) DEFAULT NULL,
  `sellerServer` int(11) DEFAULT NULL,
  `logisticsServer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good` (
  `goodId` int(11) NOT NULL AUTO_INCREMENT,
  `classId` int(11) DEFAULT NULL,
  `goodName` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `stoke` int(11) DEFAULT NULL,
  `goodDesc` varchar(45) DEFAULT NULL,
  `brand` varchar(45) DEFAULT NULL,
  `goodLable` varchar(45) DEFAULT NULL,
  `sales` int(11) DEFAULT NULL,
  `clicks` int(11) DEFAULT NULL,
  `goodPoint` double DEFAULT NULL,
  `serverPoint` double DEFAULT NULL,
  `logisticsPoint` double DEFAULT NULL,
  `goodImage` varchar(45) DEFAULT NULL,
  `goodState` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`goodId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of good
-- ----------------------------
INSERT INTO `good` VALUES ('1', '2', 'test', null, '123', '', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for logistics
-- ----------------------------
DROP TABLE IF EXISTS `logistics`;
CREATE TABLE `logistics` (
  `logisticsId` int(10) NOT NULL AUTO_INCREMENT COMMENT '物流id',
  `userId` int(10) DEFAULT NULL COMMENT '用户id',
  `orderId` int(10) DEFAULT NULL COMMENT '订单id',
  `address` varchar(45) DEFAULT NULL COMMENT '送货地址',
  `receiver` varchar(45) DEFAULT NULL COMMENT '收货人',
  `phone` varchar(11) DEFAULT NULL COMMENT '收货电话',
  `fixPhone` varchar(20) DEFAULT NULL COMMENT '座机',
  `postcode` int(11) DEFAULT NULL COMMENT '邮编',
  `logisticsCom` varchar(45) DEFAULT NULL,
  `logisticsNumber` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`logisticsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logistics
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `costDIscount` double DEFAULT NULL,
  `remark` varchar(45) DEFAULT NULL COMMENT '备注',
  `shopTime` varchar(45) DEFAULT NULL,
  `logisticsId` int(11) DEFAULT NULL,
  `orderState` int(11) DEFAULT NULL,
  `payWay` int(11) DEFAULT NULL,
  `carriageId` int(11) DEFAULT NULL,
  `payTime` varchar(45) DEFAULT NULL,
  `sendGoodTime` varchar(45) DEFAULT NULL,
  `completeTime` varchar(45) DEFAULT NULL,
  `commentState` int(4) DEFAULT '0' COMMENT '0：未评价  1：已经评价',
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderDetail` (
  `orderId` int(10) NOT NULL,
  `goodId` int(10) DEFAULT NULL,
  `goodNumber` int(10) DEFAULT NULL,
  `image` varchar(50) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `totalPrice` double DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------

-- ----------------------------
-- Table structure for shopping
-- ----------------------------
DROP TABLE IF EXISTS `shopping`;
CREATE TABLE `shopping` (
  `userId` int(11) DEFAULT NULL,
  `goodId` int(11) DEFAULT NULL,
  `goodNumber` int(11) DEFAULT NULL,
  `shopTime` varchar(45) DEFAULT NULL,
  `shoppingId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`shoppingId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping
-- ----------------------------

-- ----------------------------
-- Table structure for specification
-- ----------------------------
DROP TABLE IF EXISTS `specification`;
CREATE TABLE `specification` (
  `specificationId` int(11) NOT NULL AUTO_INCREMENT,
  `goodId` int(11) DEFAULT NULL,
  `specificationName` varchar(45) DEFAULT NULL,
  `specificationImage` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `stoke` int(11) DEFAULT NULL,
  PRIMARY KEY (`specificationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of specification
-- ----------------------------

-- ----------------------------
-- Table structure for standard
-- ----------------------------
DROP TABLE IF EXISTS `standard`;
CREATE TABLE `standard` (
  `standardId` int(11) NOT NULL AUTO_INCREMENT,
  `specificationId` int(11) DEFAULT NULL,
  `standardName` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `stoke` int(11) DEFAULT NULL,
  PRIMARY KEY (`standardId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of standard
-- ----------------------------

-- ----------------------------
-- Table structure for subcategory
-- ----------------------------
DROP TABLE IF EXISTS `subCategory`;
CREATE TABLE `subcategory` (
  `subCategoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryId` int(11) DEFAULT NULL,
  `subCategoryName` varchar(45) DEFAULT NULL,
  `subCategoryDesc` varchar(45) DEFAULT NULL,
  `createTime` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`subCategoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subcategory
-- ----------------------------
INSERT INTO `subcategory` VALUES ('1', null, 'test', '', '2016-08-06 04:08:52');
INSERT INTO `subcategory` VALUES ('2', '1', 'test1test', 'nihao', '2016-15-06 04:15:58');
INSERT INTO `subcategory` VALUES ('3', '1', 'test2test', 'nihao', '2016-17-06 04:17:21');
INSERT INTO `subcategory` VALUES ('4', '1', 'test3test', 'nihao', '2016-17-06 04:17:24');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `payPassword` int(11) DEFAULT NULL,
  `registTime` varchar(45) DEFAULT NULL,
  `idcard` varchar(45) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `integralId` int(11) DEFAULT NULL,
  `memberLevel` int(11) DEFAULT NULL,
  `userImage` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '1', '1', '1', '1', '12345678911', '12', '1', '1');

-- ----------------------------
-- Table structure for userauthority
-- ----------------------------
DROP TABLE IF EXISTS `userAuthority`;
CREATE TABLE `userauthority` (
  `userGroup` int(11) NOT NULL AUTO_INCREMENT,
  `userAuthority` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userGroup`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userauthority
-- ----------------------------

-- ----------------------------
-- Table structure for usergroup
-- ----------------------------
DROP TABLE IF EXISTS `userGroup`;
CREATE TABLE `usergroup` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userGroup` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usergroup
-- ----------------------------
