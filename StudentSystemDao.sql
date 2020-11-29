/*
 Navicat Premium Data Transfer

 Source Server         : vm_CentOS_MySQL8.0
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 192.168.21.22:3306
 Source Schema         : StudentSystemDao

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 29/11/2020 14:52:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_Student
-- ----------------------------
DROP TABLE IF EXISTS `tb_Student`;
CREATE TABLE `tb_Student`  (
  `Student_Id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Student_Name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Student_Sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '男',
  `Grade` int NOT NULL,
  `Classe` int NOT NULL,
  `Major_Name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Department_Name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Student_Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_Student
-- ----------------------------
INSERT INTO `tb_Student` VALUES ('20200001', '测试名字', '男', 1, 6, '软件工程', '电子科技大学');

-- ----------------------------
-- Table structure for tb_User
-- ----------------------------
DROP TABLE IF EXISTS `tb_User`;
CREATE TABLE `tb_User`  (
  `User_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`User_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_User
-- ----------------------------
INSERT INTO `tb_User` VALUES ('admin', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
