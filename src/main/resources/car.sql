/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : car

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 28/04/2019 00:27:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_car
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `car_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '名字',
  `car_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '类型',
  `price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '金额',
  `car_brand` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '品牌',
  `remaining` int(11) NOT NULL DEFAULT 0 COMMENT '剩余',
  `car_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `status` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `car_ride` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '2-3' COMMENT '可乘坐人数',
  `car_leval` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'C1' COMMENT '驾驶证等级(C1)',
  `city` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '所在城市',
  `car_number` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '车牌号',
  `car_reldate` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出厂日期',
  `car_driver_id` int(10) NULL DEFAULT 0 COMMENT '司机id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10006 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '汽车表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_car
-- ----------------------------
INSERT INTO `t_car` VALUES (10002, '911', '跑车', 300.00, '保时捷', 10, '/images/portfolio-3.jpg', '1', '2-3', 'C1', '保定', '冀FH3X02', '2015-04-18', 0);
INSERT INTO `t_car` VALUES (10003, 'ES', '轿车', 2000.00, '雷克萨斯', 12, '/images/portfolio-4.jpg', '1', '2-3', 'C1', '石家庄', '冀FH3X03', '2018-02-09', 0);
INSERT INTO `t_car` VALUES (10004, 'MKC', '轿车', 723.00, '林肯', 20, '/images/portfolio-2.jpg', '1', '2-3', 'C1', '安阳', '冀FH3X04', '2018-06-05', 0);
INSERT INTO `t_car` VALUES (10005, 'GTR', '跑车', 3000.00, '本田', 32, '/images/portfolio-5.jpg', '1', '2-3', 'C1', '北京', '冀FH3X01', '2018-09-09', 0);

-- ----------------------------
-- Table structure for t_driver
-- ----------------------------
DROP TABLE IF EXISTS `t_driver`;
CREATE TABLE `t_driver`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `driver_phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '13111732234' COMMENT '司机手机号',
  `driver_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '司机名称',
  `driver_gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '男' COMMENT '司机性别',
  `drver_age` int(10) NOT NULL DEFAULT 30 COMMENT '司机年龄',
  `driver_year` int(12) NOT NULL DEFAULT 5 COMMENT '司机驾龄',
  `driver_card` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '130633********5474' COMMENT '司机驾驶证',
  `driver_level` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'C1' COMMENT '司机驾驶证级别',
  `driver_city` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '保定' COMMENT '司机所在城市',
  `driver_count` int(10) NOT NULL DEFAULT 4 COMMENT '司机接单次数',
  `status` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '状态(0=可用,1=不可用)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '司机表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_driver
-- ----------------------------
INSERT INTO `t_driver` VALUES (1, '13111732234', '张三', '男', 30, 5, '130633********5474', 'A2', '保定', 3, '0');
INSERT INTO `t_driver` VALUES (2, '13111732234', '李四', '男', 30, 5, '130633********5474', 'C1', '保定', 12, '0');
INSERT INTO `t_driver` VALUES (3, '13111732234', '蔡根花', '女', 30, 5, '130633********5474', 'C1', '保定', 4, '0');
INSERT INTO `t_driver` VALUES (4, '13111732234', '苏大强', '男', 30, 5, '130633********5474', 'A1', '保定', 20, '0');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `order_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '订单编号',
  `order_detail` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单详情',
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `pay_status` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '支付状态(0=未支付,1=已支付)',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `payable_number` decimal(10, 0) NULL DEFAULT NULL COMMENT '应付金额',
  `pay_number` decimal(10, 0) NULL DEFAULT NULL COMMENT '实际支付金额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (6, '1556083031743', '10003:3,10002:2', '689b94319954a09d8cb6c0f3ac2692f7', '2019-04-24 13:17:12', '0', NULL, 6600, 0);

-- ----------------------------
-- Table structure for t_shop_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_shop_cart`;
CREATE TABLE `t_shop_cart`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `car_id` int(12) NULL DEFAULT NULL COMMENT '商品id',
  `car_count` int(12) NULL DEFAULT NULL COMMENT '数量',
  `creat_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '购物车表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_shop_cart
-- ----------------------------
INSERT INTO `t_shop_cart` VALUES ('1c0e92abb4f643b582bda72edf2a9baa', '689b94319954a09d8cb6c0f3ac2692f7', 10002, 2, '2019-04-27 13:20:22');
INSERT INTO `t_shop_cart` VALUES ('2da32f5ab74c4102b834da24956a1d71', '689b94319954a09d8cb6c0f3ac2692f7', 10003, 3, '2019-04-24 13:29:38');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录姓名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录密码',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `pay_password` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付密码',
  `is_admin` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '是否为管理员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('66e67e5417c174564dd474f5e2c8a422', 'zhangsan', '123456', '13916456974', '张三', '123456', '0');
INSERT INTO `t_user` VALUES ('689b94319954a09d8cb6c0f3ac2692f7', 'test', '123456', '139164569741', '测试', '123456', '0');
INSERT INTO `t_user` VALUES ('8526c3e329aef991bdc96057a36ebe01', 'admin', '123456', '132131242312', '管理员', '123456', '1');
INSERT INTO `t_user` VALUES ('8526c3e329aef991bdc96057a36ebe04', 'lisi', '123456', '13916456974', '李', '123456', '0');

SET FOREIGN_KEY_CHECKS = 1;
