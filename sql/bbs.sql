/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : bbs

 Target Server Type    : MySQL
 Target Server Version : 50099
 File Encoding         : 65001

 Date: 28/06/2022 15:24:03
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bbs_answer
-- ----------------------------
DROP TABLE IF EXISTS `bbs_answer`;
CREATE TABLE `bbs_answer`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `question_id` bigint NULL DEFAULT NULL COMMENT '问题主键',
  `create_user` bigint NULL DEFAULT NULL COMMENT '回答者',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '回答内容',
  `create_time` datetime NULL DEFAULT NULL COMMENT '回答时间',
  `status` int NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of bbs_answer
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for bbs_content
-- ----------------------------
DROP TABLE IF EXISTS `bbs_content`;
CREATE TABLE `bbs_content`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of bbs_content
-- ----------------------------
BEGIN;
INSERT INTO `bbs_content` (`id`, `content`, `create_time`) VALUES (1, '# 测试', '2022-06-01 17:32:40');
COMMIT;

-- ----------------------------
-- Table structure for bbs_question
-- ----------------------------
DROP TABLE IF EXISTS `bbs_question`;
CREATE TABLE `bbs_question`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `section_id` bigint NULL DEFAULT NULL COMMENT '标签',
  `create_user` bigint NULL DEFAULT NULL COMMENT '创建者',
  `read_count` int NULL DEFAULT NULL COMMENT '点击量',
  `reply_count` int NULL DEFAULT NULL COMMENT '评论量',
  `answer_count` int NULL DEFAULT NULL COMMENT '回答量',
  `create_time` datetime NULL DEFAULT NULL COMMENT '发布时间',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `status` int NULL DEFAULT NULL COMMENT '有效状态',
  `tags` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签',
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of bbs_question
-- ----------------------------
BEGIN;
INSERT INTO `bbs_question` (`id`, `section_id`, `create_user`, `read_count`, `reply_count`, `answer_count`, `create_time`, `title`, `content`, `status`, `tags`) VALUES (1, 1, 1531211809900998656, 9, 0, 0, '2022-06-01 17:32:40', '测试', '问答模块测试', 1, NULL), (2, 1, 1531211809900998656, 0, 0, 0, '2022-06-01 17:32:40', '测试2', '问答模块测试', 1, NULL);
COMMIT;

-- ----------------------------
-- Table structure for bbs_reply
-- ----------------------------
DROP TABLE IF EXISTS `bbs_reply`;
CREATE TABLE `bbs_reply`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `topic_id` bigint NULL DEFAULT NULL COMMENT '评论的文章ID',
  `create_user` bigint NULL DEFAULT NULL COMMENT '评论人ID',
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '评论内容',
  `create_time` datetime NULL DEFAULT NULL COMMENT '评论时间',
  `parent_comment_id` bigint NULL DEFAULT NULL COMMENT '父级评论ID',
  `comment_level` int NULL DEFAULT NULL COMMENT '评论级别',
  `ip` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip',
  `address` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY USING BTREE (`id`),
  INDEX `reply_user` USING BTREE(`create_user`),
  CONSTRAINT `reply_user` FOREIGN KEY (`create_user`) REFERENCES `bbs_user` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of bbs_reply
-- ----------------------------
BEGIN;
INSERT INTO `bbs_reply` (`id`, `topic_id`, `create_user`, `title`, `content`, `create_time`, `parent_comment_id`, `comment_level`, `ip`, `address`) VALUES (1, 1, 1531211809900998656, '测试', '<p>测试一级评论</p>', '2022-06-08 10:57:55', NULL, 1, '169.254.211.99', ' 本地链路'), (2, 1, 1531211809900998656, '测试', '<p>测试二级评论</p>', '2022-06-08 17:08:10', 1, 2, '169.254.211.99', ' 本地链路'), (3, 1, 1531211809900998656, '测试', '<p>再次测试二级评论</p>', '2022-06-08 17:11:47', 1, 2, '169.254.211.99', ' 本地链路'), (4, 1, 1531211809900998656, '测试', '<p>第三次测试</p>', '2022-06-08 17:14:54', 1, 2, '169.254.211.99', ' 本地链路'), (5, 1, 1531211809900998656, '测试', '<p>测试ip地址显示</p>', '2022-06-08 17:29:20', NULL, 1, '192.168.31.149', ' 局域网'), (6, 1, 1531211809900998656, '测试', '<p>第四个评论</p>', '2022-06-13 15:16:25', 1, 2, '169.254.211.99', ' 本地链路'), (7, 1, 1531211809900998656, '测试', '<p>第五条评论</p>', '2022-06-13 15:17:08', 1, 2, '169.254.211.99', ' 本地链路'), (8, 1, 1531211809900998656, '测试', '<p>测试评论完成后刷新</p>', '2022-06-13 15:52:55', 1, 2, '169.254.211.99', ' 本地链路');
COMMIT;

-- ----------------------------
-- Table structure for bbs_section
-- ----------------------------
DROP TABLE IF EXISTS `bbs_section`;
CREATE TABLE `bbs_section`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of bbs_section
-- ----------------------------
BEGIN;
INSERT INTO `bbs_section` (`id`, `name`, `type`, `status`, `create_time`) VALUES (1, '综合', 1, 1, '2022-06-01 17:32:40');
COMMIT;

-- ----------------------------
-- Table structure for bbs_topic
-- ----------------------------
DROP TABLE IF EXISTS `bbs_topic`;
CREATE TABLE `bbs_topic`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `section_id` bigint NULL DEFAULT NULL,
  `create_user` bigint NULL DEFAULT NULL,
  `reply_count` int NULL DEFAULT NULL,
  `read_count` int NULL DEFAULT NULL,
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `status` int NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`),
  INDEX `user_id` USING BTREE(`create_user`),
  CONSTRAINT `user_id` FOREIGN KEY (`create_user`) REFERENCES `bbs_user` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of bbs_topic
-- ----------------------------
BEGIN;
INSERT INTO `bbs_topic` (`id`, `section_id`, `create_user`, `reply_count`, `read_count`, `title`, `content`, `status`, `create_time`, `ip`, `address`) VALUES (1, 1, 1531211809900998656, 0, 8, '测试', '<h1 style=\"text-align: center;\">Welcome to the TinyMCE demo!</h1><p style=\"text-align: center; font-size: 15px;\"><ul>\r\n        <li>Our <a href=\"//www.tinymce.com/docs/\">documentation</a> is a great resource for learning how to configure TinyMCE.</li><li>Have a specific question? Visit the <a href=\"https://community.tinymce.com/forum/\">Community Forum</a>.</li><li>We also offer enterprise grade support as part of <a href=\"https://tinymce.com/pricing\">TinyMCE premium subscriptions</a>.</li>\r\n      </ul>', 1, '2022-06-01 17:32:40', '127.0.0.1', '局域网'), (2, 1, 1531211809900998656, 0, 0, '测2', '1测2', 1, '2022-06-01 17:32:40', '127.0.0.1', '局域网');
COMMIT;

-- ----------------------------
-- Table structure for bbs_user
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user`;
CREATE TABLE `bbs_user`  (
  `id` bigint NOT NULL,
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nick_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `role_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of bbs_user
-- ----------------------------
BEGIN;
INSERT INTO `bbs_user` (`id`, `user_name`, `nick_name`, `password`, `avatar`, `email`, `phone`, `status`, `create_time`, `role_id`) VALUES (1531211809900998656, 'admin', 'user', '$2a$10$xF0qMQyYZR7DimWPg2xiguKAGMVAYkS512IfJ.w2RcLf/KHknG242', 'https://static01.imgkr.com/temp/23cf94d1cb6145298bc169c23c3c84c8.jpg', '1875091912@qq.com', NULL, 1, NULL, 1);
COMMIT;

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip',
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登陆地址',
  `browser` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '浏览器',
  `login_time` datetime NULL DEFAULT NULL COMMENT '登录时间',
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 224 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of login_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限名',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '资源定位符',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `status` int(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '状态(0.有效 1.无效)',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 155 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表';

-- ----------------------------
-- Records of permission
-- ----------------------------
BEGIN;
INSERT INTO `permission` (`id`, `name`, `url`, `description`, `status`, `create_time`) VALUES (1, '管理员', '/api/**', 'de', 1, '2022-01-17 10:27:04');
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` int NULL DEFAULT NULL COMMENT '角色编码(1.学生 2.教师 3.管理员 4.系统管理员)',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色名称',
  `status` int NULL DEFAULT NULL COMMENT '角色状态(0.有效 1.无效)',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `user_count` int NULL DEFAULT NULL COMMENT '后台用户数量',
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` (`id`, `code`, `description`, `name`, `status`, `create_time`, `update_time`, `user_count`) VALUES (1, 1, '系统管理员', 'admin', 1, '2022-01-17 13:46:12', '2022-05-12 14:54:01', 1), (2, 2, '用户', 'user', 1, '2022-01-17 13:46:12', '2022-04-19 15:38:30', 0);
COMMIT;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint NULL DEFAULT NULL,
  `permission_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`),
  INDEX `role` USING BTREE(`role_id`),
  INDEX `permission` USING BTREE(`permission_id`),
  CONSTRAINT `permission` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
BEGIN;
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (1, 1, 1), (2, 2, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
