/*
 Navicat MySQL Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : employee

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 14/06/2023 14:51:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '技术部');
INSERT INTO `department` VALUES (2, '产品部');
INSERT INTO `department` VALUES (3, '市场部');
INSERT INTO `department` VALUES (4, '销售部');
INSERT INTO `department` VALUES (5, '人力资源部');
INSERT INTO `department` VALUES (6, '财务部');
INSERT INTO `department` VALUES (7, '客户服务部');
INSERT INTO `department` VALUES (8, '研发部');
INSERT INTO `department` VALUES (9, '运营部');
INSERT INTO `department` VALUES (10, '行政部');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `id_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `gender` int(11) NULL DEFAULT NULL COMMENT '性别(1表示男性，2表示女性)',
  `position_id` int(11) NULL DEFAULT NULL COMMENT '职位ID(关联职位表)',
  `department_id` int(11) NULL DEFAULT NULL COMMENT '部门ID(关联部门表)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '张三', '110101199001011234', '13800010001', 1, 1, 1);
INSERT INTO `employee` VALUES (2, '李四', '110101199001011235', '13800010002', 0, 2, 1);
INSERT INTO `employee` VALUES (3, '王五', '110101199001011236', '13800010003', 1, 3, 2);
INSERT INTO `employee` VALUES (4, '赵六', '110101199001011237', '13800010004', 0, 4, 2);
INSERT INTO `employee` VALUES (5, '孙七', '110101199001011238', '13800010005', 1, 5, 3);
INSERT INTO `employee` VALUES (6, '周八', '110101199001011239', '13800010006', 0, 6, 3);
INSERT INTO `employee` VALUES (7, '吴九', '110101199001011240', '13800010007', 1, 7, 4);
INSERT INTO `employee` VALUES (8, '郑十', '110101199001011241', '13800010008', 0, 8, 4);
INSERT INTO `employee` VALUES (9, '冯十一', '110101199001011242', '13800010009', 1, 9, 5);
INSERT INTO `employee` VALUES (10, '陈十二', '110101199001011243', '13800010010', 0, 10, 5);

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '职位表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES (1, '软件工程师');
INSERT INTO `position` VALUES (2, '数据分析师');
INSERT INTO `position` VALUES (3, '项目经理');
INSERT INTO `position` VALUES (4, '产品经理');
INSERT INTO `position` VALUES (5, 'UI设计师');
INSERT INTO `position` VALUES (6, '前端开发工程师');
INSERT INTO `position` VALUES (7, '后端开发工程师');
INSERT INTO `position` VALUES (8, '测试工程师');
INSERT INTO `position` VALUES (9, '运维工程师');
INSERT INTO `position` VALUES (10, '网络安全工程师');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `role` int(11) NULL DEFAULT NULL COMMENT '用户角色(1表示管理员，2表示普通用户)',
  `status` int(11) NULL DEFAULT NULL COMMENT '用户状态(1表示启用，2表示禁用)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 1, 1);
INSERT INTO `user` VALUES (3, 'user', 2, 1);
INSERT INTO `user` VALUES (4, 'jack', 2, 0);

SET FOREIGN_KEY_CHECKS = 1;
