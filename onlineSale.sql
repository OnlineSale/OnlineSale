/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50545
Source Host           : localhost:3306
Source Database       : onlineSale

Target Server Type    : MYSQL
Target Server Version : 50545
File Encoding         : 65001

Date: 2016-05-04 17:04:35
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
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------

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
  `subCategoryId` int(11) DEFAULT NULL,
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
  PRIMARY KEY (`goodId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of good
-- ----------------------------

-- ----------------------------
-- Table structure for logistics
-- ----------------------------
DROP TABLE IF EXISTS `logistics`;
CREATE TABLE `logistics` (
  `logisticsId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `orderId` int(11) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `receiver` varchar(45) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `fixPhone` varchar(45) DEFAULT NULL,
  `postcode` int(11) DEFAULT NULL,
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
  `remark` varchar(45) DEFAULT NULL,
  `shopTime` varchar(45) DEFAULT NULL,
  `logisticsId` int(11) DEFAULT NULL,
  `orderState` int(11) DEFAULT NULL,
  `payWay` int(11) DEFAULT NULL,
  `carriageId` int(11) DEFAULT NULL,
  `payTime` varchar(45) DEFAULT NULL,
  `sendGoodTime` varchar(45) DEFAULT NULL,
  `completeTime` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for orderDetail
-- ----------------------------
DROP TABLE IF EXISTS `orderDetail`;
CREATE TABLE `orderDetail` (
  `orderId` int(11) NOT NULL,
  `goodId` int(11) DEFAULT NULL,
  `goodNumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderDetail
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
-- Table structure for subCategory
-- ----------------------------
DROP TABLE IF EXISTS `subCategory`;
CREATE TABLE `subCategory` (
  `subCategoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryId` int(11) DEFAULT NULL,
  `subCategoryName` varchar(45) DEFAULT NULL,
  `subCategoryDesc` varchar(45) DEFAULT NULL,
  `createTime` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`subCategoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subCategory
-- ----------------------------

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
  `phone` int(11) DEFAULT NULL,
  `integralId` int(11) DEFAULT NULL,
  `memberLevel` int(11) DEFAULT NULL,
  `userImage` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for userAuthority
-- ----------------------------
DROP TABLE IF EXISTS `userAuthority`;
CREATE TABLE `userAuthority` (
  `userGroup` int(11) NOT NULL AUTO_INCREMENT,
  `userAuthority` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userGroup`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userAuthority
-- ----------------------------

-- ----------------------------
-- Table structure for userGroup
-- ----------------------------
DROP TABLE IF EXISTS `userGroup`;
CREATE TABLE `userGroup` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userGroup` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userGroup
-- ----------------------------
