/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : localhost:3306
 Source Schema         : car

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 24/04/2019 13:32:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_car
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `car_name` varchar(32) DEFAULT '' COMMENT '名字',
  `car_type` varchar(32) DEFAULT '' COMMENT '类型',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '金额',
  `car_brand` varchar(32) DEFAULT '' COMMENT '品牌',
  `remaining` int(11) NOT NULL DEFAULT '0' COMMENT '剩余',
  `car_image` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `car_ride` varchar(12) DEFAULT '2-3' COMMENT '可乘坐人数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10006 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_car
-- ----------------------------
BEGIN;
INSERT INTO `t_car` VALUES (10002, '911', '跑车', 300.00, '保时捷', 10, '/images/portfolio-3.jpg', '1', '2-3');
INSERT INTO `t_car` VALUES (10003, 'ES', '轿车', 2000.00, '雷克萨斯', 12, '/images/portfolio-4.jpg', '1', '2-3');
INSERT INTO `t_car` VALUES (10004, 'MKC', '轿车', 723.00, '林肯', 20, '/images/portfolio-2.jpg', '1', '2-3');
INSERT INTO `t_car` VALUES (10005, 'GTR', '跑车', 3000.00, '本田', 32, '/images/portfolio-5.jpg', '1', '2-3');
COMMIT;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `order_number` varchar(32) DEFAULT '' COMMENT '订单编号',
  `order_detail` varchar(300) DEFAULT NULL COMMENT '订单详情',
  `user_id` varchar(32) DEFAULT '' COMMENT '用户id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `pay_status` varchar(12) DEFAULT '' COMMENT '支付状态(0=未支付,1=已支付)',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `payable_number` decimal(10,0) DEFAULT NULL COMMENT '应付金额',
  `pay_number` decimal(10,0) DEFAULT NULL COMMENT '实际支付金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_order
-- ----------------------------
BEGIN;
INSERT INTO `t_order` VALUES (6, '1556083031743', '10003:3,10002:2', '689b94319954a09d8cb6c0f3ac2692f7', '2019-04-24 13:17:12', '0', NULL, 6600, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_shop_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_shop_cart`;
CREATE TABLE `t_shop_cart` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户id',
  `car_id` int(12) DEFAULT NULL COMMENT '商品id',
  `car_count` int(12) DEFAULT NULL COMMENT '数量',
  `creat_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_shop_cart
-- ----------------------------
BEGIN;
INSERT INTO `t_shop_cart` VALUES ('2da32f5ab74c4102b834da24956a1d71', '689b94319954a09d8cb6c0f3ac2692f7', 10003, 1, '2019-04-24 13:29:38');
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(32) NOT NULL,
  `user_name` varchar(32) DEFAULT NULL COMMENT '登录姓名',
  `password` varchar(32) DEFAULT NULL COMMENT '登录密码',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `name` varchar(32) DEFAULT NULL COMMENT '用户姓名',
  `pay_password` varchar(12) DEFAULT NULL COMMENT '支付密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES ('66e67e5417c174564dd474f5e2c8a422', 'zhangsan', '123456', '13916456974', '张三', '123456');
INSERT INTO `t_user` VALUES ('689b94319954a09d8cb6c0f3ac2692f7', 'test', '123456', '139164569741', '测试', '123456');
INSERT INTO `t_user` VALUES ('8526c3e329aef991bdc96057a36ebe04', 'lisi', '123456', '13916456974', '李', '123456');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
