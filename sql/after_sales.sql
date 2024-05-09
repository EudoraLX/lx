/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50744 (5.7.44)
 Source Host           : localhost:3306
 Source Schema         : business

 Target Server Type    : MySQL
 Target Server Version : 50744 (5.7.44)
 File Encoding         : 65001

 Date: 07/05/2024 14:56:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for after_sales
-- ----------------------------
DROP TABLE IF EXISTS `after_sales`;
CREATE TABLE `after_sales`  (
  `after_sales_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '售后ID',
  `opportunity_id` bigint(20) NOT NULL COMMENT '商机ID，关联到Opportunity表的OpportunityID',
  `after_sales_description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '售后描述',
  `after_sales_result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '售后结果',
  `creation_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`after_sales_id`) USING BTREE,
  INDEX `opportunity_id`(`opportunity_id`) USING BTREE,
  CONSTRAINT `after_sales_ibfk_1` FOREIGN KEY (`opportunity_id`) REFERENCES `opportunity` (`opportunity_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '售后记录' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
