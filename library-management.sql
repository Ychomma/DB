/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : library-management

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 23/11/2022 21:15:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系方式',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  `createtime` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` datetime NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `status` tinyint(1) NULL DEFAULT 1 COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username_key`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (28, 'chen', '15880051262', NULL, '2022-11-12 16:24:51', '2022-11-13 12:07:41', '98cba98d5a6f702a6fcfc2b207a22fb8', 1);
INSERT INTO `admin` VALUES (29, 'admin', '15880051226', NULL, '2022-11-13 02:22:20', '2022-11-20 23:06:17', '985b06ddbbeab537238f61182f3350df', 1);

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `publish_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '出版日期',
  `author` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '作者',
  `publisher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '出版社',
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分类',
  `book_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标准码',
  `createtime` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '封面',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (2, 'asda s', NULL, '2022-11-08', NULL, NULL, NULL, NULL, '2022-11-23 19:18:08', NULL, NULL);
INSERT INTO `book` VALUES (3, '123', '1', '2022-11-01', 'cpj', '32', '23', '23', '2022-11-23 19:20:32', '2022-11-23 00:00:00', 'https://bkimg.cdn.bcebos.com/pic/e61190ef76c6a7efce1bf7fef4b7b851f3deb58fc89c?x-bce-process=image/watermark,image_d2F0ZXIvYmFpa2U5Mg==,g_7,xp_5,yp_5');
INSERT INTO `book` VALUES (4, '图形学', '666', '2022-11-30', '陈培杰', '123', NULL, '123', '2022-11-23 20:07:16', NULL, '666');
INSERT INTO `book` VALUES (5, '数据库', '666', '2022-11-18', '陈培杰', '123', NULL, '请问', '2022-11-23 20:08:46', NULL, '请问');
INSERT INTO `book` VALUES (6, '阿松大a', 's的a', '2022-11-08', '阿萨d', '阿萨d', '科技>高新科技>', '阿萨d', '2022-11-23 20:14:56', NULL, ' 阿松大');
INSERT INTO `book` VALUES (7, '阿松大', '啊收到', '2022-10-31', '阿松大', '阿萨d', '现代文化>计算机', '阿松大', '2022-11-23 20:20:45', '2022-11-23 00:00:00', '啊收到');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `pid` int NULL DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (5, '唐朝文化', NULL, 3, '2022-11-22 21:45:23', NULL);
INSERT INTO `category` VALUES (7, '宋朝文化', NULL, 3, '2022-11-22 21:48:11', NULL);
INSERT INTO `category` VALUES (8, '现代文化', '现代文化', NULL, '2022-11-22 22:05:08', NULL);
INSERT INTO `category` VALUES (9, '计算机', '计算机', 8, '2022-11-22 22:08:47', NULL);
INSERT INTO `category` VALUES (10, '科技', '科技', NULL, '2022-11-22 22:59:01', NULL);
INSERT INTO `category` VALUES (11, '生物科技', '生物科技', 10, '2022-11-22 22:59:13', NULL);
INSERT INTO `category` VALUES (12, '高新科技', '高新科技', 10, '2022-11-22 22:59:29', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '姓名',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `sex` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系方式',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地址',
  `createtime` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (20, '李云', NULL, 24, '女', '13922000022', '北京', NULL, NULL);
INSERT INTO `user` VALUES (21, 'chen', '20221111951013535', 22, '男', '18859063781', 'sdfjh', NULL, NULL);
INSERT INTO `user` VALUES (22, 'chen', '20221111299186889', 18, '男', '15880051262', '123', '2022-11-11 11:43:06', NULL);

SET FOREIGN_KEY_CHECKS = 1;
