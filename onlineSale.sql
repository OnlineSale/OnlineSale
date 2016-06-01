/*
Navicat MySQL Data Transfer

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2016-06-01 16:49:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for aactivity
-- ----------------------------
DROP TABLE IF EXISTS `aactivity`;
CREATE TABLE `aactivity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `accumulated_integral` int(11) DEFAULT '0',
  `ranking_integral` int(11) DEFAULT '0',
  `share_integral` int(11) DEFAULT '0',
  `withdraw_integral` int(11) DEFAULT '0',
  `in_rank` int(11) DEFAULT NULL,
  `total_integral` int(11) DEFAULT '0',
  `date` datetime DEFAULT NULL,
  `status` varchar(64) DEFAULT 'IN',
  PRIMARY KEY (`id`),
  KEY `in_rank` (`in_rank`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aactivity
-- ----------------------------
INSERT INTO `aactivity` VALUES ('1', '1', '0', '0', '0', '0', '1', '0', '2016-05-27 22:42:58', 'IN');
INSERT INTO `aactivity` VALUES ('2', '1', '0', '0', '0', '0', '2', '0', '2016-05-27 22:45:28', 'IN');

-- ----------------------------
-- Table structure for carriage
-- ----------------------------
DROP TABLE IF EXISTS `carriage`;
CREATE TABLE `carriage` (
  `carriageId` int(11) NOT NULL AUTO_INCREMENT,
  `carriageName` varchar(45) DEFAULT NULL,
  `firstPrice` double DEFAULT NULL,
  `destination` varchar(200) DEFAULT NULL,
  `firstNumber` int(11) DEFAULT NULL,
  `nextNumber` int(11) DEFAULT NULL,
  `nextPrice` double DEFAULT NULL,
  `userId` int(11) DEFAULT NULL COMMENT '外键',
  PRIMARY KEY (`carriageId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

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
  `managerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('2', 'test1', '2016-07-06 12:07:51', null);
INSERT INTO `category` VALUES ('3', 'test2', '2016-07-06 12:07:57', null);
INSERT INTO `category` VALUES ('4', 'test3', '2016-08-06 12:08:02', null);
INSERT INTO `category` VALUES ('5', 'haha1', '2016-39-06 08:39:42', null);
INSERT INTO `category` VALUES ('6', 'haha2', '2016-39-06 08:39:59', null);
INSERT INTO `category` VALUES ('7', 'haha3', '2016-50-06 08:50:32', null);
INSERT INTO `category` VALUES ('8', 'test', '2016-55-10 09:55:31', null);
INSERT INTO `category` VALUES ('9', '日用百货', '2016-03-12 10:03:44', null);
INSERT INTO `category` VALUES ('10', '珠宝玉石', '2016-12-12 10:12:04', null);
INSERT INTO `category` VALUES ('11', '保健养生', '2016-06-12 10:06:30', null);
INSERT INTO `category` VALUES ('12', '家电家具', '2016-34-12 10:34:16', null);
INSERT INTO `category` VALUES ('13', '服装鞋帽', '2016-13-12 08:13:29', null);

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
-- Table structure for default_address
-- ----------------------------
DROP TABLE IF EXISTS `default_address`;
CREATE TABLE `default_address` (
  `default_address_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `rough_address` varchar(45) NOT NULL,
  `detail_address` varchar(45) NOT NULL,
  `receiver` varchar(45) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `is_default` int(11) NOT NULL,
  `fix_phone` varchar(45) DEFAULT NULL,
  `postcode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`default_address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of default_address
-- ----------------------------
INSERT INTO `default_address` VALUES ('1', '2', '天津', '新华路18号', '李华', '110', '0', null, null);

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
  `userId` int(11) DEFAULT NULL,
  `saleType` int(11) DEFAULT NULL COMMENT '0 表示立即开售，\n1，表示准点开售',
  `saleTime` varchar(45) DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL COMMENT '0 表示未删，1表示删除',
  PRIMARY KEY (`goodId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of good
-- ----------------------------

-- ----------------------------
-- Table structure for integral
-- ----------------------------
DROP TABLE IF EXISTS `integral`;
CREATE TABLE `integral` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) DEFAULT NULL,
  `balance_integral` int(20) DEFAULT '0',
  `accumulated_integral` int(20) DEFAULT NULL,
  `ranking_integral` int(20) DEFAULT NULL,
  `share_integral` int(20) DEFAULT NULL,
  `withdraw_integral` int(20) DEFAULT NULL,
  `share_uuid` varchar(255) DEFAULT NULL,
  `point_token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of integral
-- ----------------------------
INSERT INTO `integral` VALUES ('3', '1', '9302', null, null, null, null, 'u_T9AmT5j6Cy6Jb1zX_zp2', 'Fruvrvvdgi6PsBYe9VMNY3');
INSERT INTO `integral` VALUES ('4', '6', '6150', null, null, null, null, 'WEdFsIQsi2iB2_3tPP8V70', 'PAS4orTHiCiWVbjakrd2s3');

-- ----------------------------
-- Table structure for listening_range
-- ----------------------------
DROP TABLE IF EXISTS `listening_range`;
CREATE TABLE `listening_range` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rank_id` int(11) DEFAULT NULL,
  `range_low` int(11) DEFAULT NULL,
  `range_high` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `range_low` (`range_low`) USING BTREE,
  KEY `range_high` (`range_high`) USING BTREE,
  KEY `range_low_2` (`range_low`,`range_high`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of listening_range
-- ----------------------------

-- ----------------------------
-- Table structure for logistics
-- ----------------------------
DROP TABLE IF EXISTS `logistics`;
CREATE TABLE `logistics` (
  `logisticsId` varchar(20) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `orderId` varchar(20) DEFAULT NULL,
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
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `managerId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `createTime` varchar(45) DEFAULT NULL,
  `role` int(11) DEFAULT NULL COMMENT '0 表示系统管理员，1表示超级管理员',
  PRIMARY KEY (`managerId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `orderId` int(11) NOT NULL,
  `goodId` int(11) DEFAULT NULL,
  `goodNumber` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `image` varchar(45) DEFAULT NULL,
  `totalPrice` double DEFAULT NULL,
  `specificationId` int(11) DEFAULT NULL,
  `standardId` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------

-- ----------------------------
-- Table structure for pass_match
-- ----------------------------
DROP TABLE IF EXISTS `pass_match`;
CREATE TABLE `pass_match` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `match_time` int(11) DEFAULT '0',
  `date` datetime DEFAULT NULL,
  `locked` varchar(64) DEFAULT 'UNLOCKED',
  PRIMARY KEY (`id`),
  KEY `date` (`date`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pass_match
-- ----------------------------
INSERT INTO `pass_match` VALUES ('7', '1', '2', '2016-05-24 18:45:59', 'UNLOCKED');
INSERT INTO `pass_match` VALUES ('8', '6', '1', '2016-05-24 18:48:52', 'UNLOCKED');

-- ----------------------------
-- Table structure for share
-- ----------------------------
DROP TABLE IF EXISTS `share`;
CREATE TABLE `share` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `shared_user_id` int(11) DEFAULT NULL,
  `share_uuid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of share
-- ----------------------------

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `shopId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `positionId` int(11) DEFAULT NULL,
  `positionName` varchar(45) DEFAULT NULL,
  `createTime` varchar(45) DEFAULT NULL,
  `updateTime` varchar(45) DEFAULT NULL,
  `managerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`shopId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of specification
-- ----------------------------
INSERT INTO `specification` VALUES ('1', '1', 'test1', null, '12.34', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of standard
-- ----------------------------
INSERT INTO `standard` VALUES ('1', '1', 'test', '12.34', '2');

-- ----------------------------
-- Table structure for subcategory
-- ----------------------------
DROP TABLE IF EXISTS `subcategory`;
CREATE TABLE `subcategory` (
  `subCategoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryId` int(11) DEFAULT NULL,
  `subCategoryName` varchar(45) DEFAULT NULL,
  `subCategoryDesc` varchar(45) DEFAULT NULL,
  `createTime` varchar(45) DEFAULT NULL,
  `managerId` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`subCategoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subcategory
-- ----------------------------
INSERT INTO `subcategory` VALUES ('1', null, 'test', '', '2016-08-06 04:08:52', null);
INSERT INTO `subcategory` VALUES ('2', '1', null, '', '2016-42-12 12:42:12', null);
INSERT INTO `subcategory` VALUES ('3', '1', null, '', '2016-00-12 01:00:23', null);
INSERT INTO `subcategory` VALUES ('4', '1', '牙膏', '', '2016-04-12 01:04:11', null);

-- ----------------------------
-- Table structure for torder
-- ----------------------------
DROP TABLE IF EXISTS `torder`;
CREATE TABLE `torder` (
  `orderId` varchar(20) NOT NULL,
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
  `commentState` int(4) DEFAULT NULL,
  `isDelete` int(4) DEFAULT '0',
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of torder
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `payPassword` varchar(128) DEFAULT NULL,
  `registTime` varchar(45) DEFAULT NULL,
  `idcard` varchar(45) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `integralId` int(11) DEFAULT NULL,
  `memberLevel` int(11) DEFAULT NULL,
  `userImage` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', null, '123456', '8PIFwYK7/5lz/bPrE8RHd6HZDkPEbZ6CcL3LKrvZajFV8C/t7jjCyQ==', '2016-05-11 16:50:36', null, null, null, '3', null);
INSERT INTO `user` VALUES ('2', null, null, 'VEeE7V722bHUxCmP1fAEfV//S9dcOCWCkmd2ldsSRdqIMb0zKk4RQQ==', '2016-05-11 16:50:51', null, null, null, null, null);
INSERT INTO `user` VALUES ('3', null, null, null, '2016-05-11 17:02:04', null, null, null, null, null);
INSERT INTO `user` VALUES ('4', 'hzy', '123', null, '2016-05-13 15:16:58', null, null, null, null, null);
INSERT INTO `user` VALUES ('5', '你好', '123', null, '2016-05-13 15:17:44', null, null, null, null, null);
INSERT INTO `user` VALUES ('6', 'faker', '123456', 'vDPhOFILlDZEOPs6hMgyq2qvRzfX0wSrWndS4FrX1gKH89sFCJicVQ==', '2016-05-13 15:19:59', null, null, null, '1', null);

-- ----------------------------
-- Table structure for userauthority
-- ----------------------------
DROP TABLE IF EXISTS `userauthority`;
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
DROP TABLE IF EXISTS `usergroup`;
CREATE TABLE `usergroup` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userGroup` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usergroup
-- ----------------------------
