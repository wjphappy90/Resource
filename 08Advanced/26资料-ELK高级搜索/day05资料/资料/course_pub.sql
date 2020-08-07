/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : xc_course

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 10/11/2019 02:50:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course_pub
-- ----------------------------
DROP TABLE IF EXISTS `course_pub`;
CREATE TABLE `course_pub`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称',
  `users` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '适用人群',
  `mt` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '大分类',
  `st` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '小分类',
  `grade` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程等级',
  `studymodel` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学习模式',
  `teachmode` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教育模式',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程介绍',
  `timestamp` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '时间戳logstash使用',
  `charge` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收费规则，对应数据字典',
  `valid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '有效性，对应数据字典',
  `qq` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '咨询qq',
  `price` float(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `price_old` float(10, 2) NULL DEFAULT NULL COMMENT '原价格',
  `expires` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '过期时间',
  `start_time` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程有效期-开始时间',
  `end_time` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程有效期-结束时间',
  `pic` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程图片',
  `teachplan` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程计划',
  `pub_time` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_pub
-- ----------------------------
INSERT INTO `course_pub` VALUES ('297e7c7c62b888f00162b8a7dec20000', 'test_java基础33', 'b1', '1-3', '1-3-3', '200002', '201002', NULL, 'java 从入门到删库跑路', '2019-10-28 11:26:25', '203002', '204002', '32432', NULL, NULL, NULL, NULL, NULL, 'group1/M00/00/00/wKgZhV2tIgiAaYVMAAA2T52Dthw246.jpg', '{\"children\":[{\"children\":[],\"id\":\"40288f9b6e0c10d8016e0c37f72a0000\",\"pname\":\"1\"},{\"children\":[{\"id\":\"40288581632b593e01632bd53ff10001\",\"mediaFileoriginalname\":\"solr.avi\",\"mediaId\":\"5fbb79a2016c0eb609ecd0cd3dc48016\",\"pname\":\"Hello World\"},{\"id\":\"40288f9b6e106273016e106485f30000\",\"mediaFileoriginalname\":\"lucene.avi\",\"mediaId\":\"c5c75d70f382e6016d2f506d134eee11\",\"pname\":\"java基础\"}],\"id\":\"40288581632b593e01632bd4ec360000\",\"pname\":\"程序入门\"},{\"children\":[{\"id\":\"40288f9b6dce18e3016dcef16d860001\",\"mediaFileoriginalname\":\"solr.avi\",\"mediaId\":\"5fbb79a2016c0eb609ecd0cd3dc48016\",\"pname\":\"三级节点\"}],\"id\":\"40288f9b6dce18e3016dcef12a1d0000\",\"pname\":\"二级节点\"},{\"children\":[{\"id\":\"40288c9a6ca3968e016ca417fa8d0001\",\"mediaFileoriginalname\":\"lucene.avi\",\"mediaId\":\"c5c75d70f382e6016d2f506d134eee11\",\"pname\":\"test04-01\"}],\"id\":\"40288c9a6ca3968e016ca417b4a50000\",\"pname\":\"test04\"},{\"children\":[{\"id\":\"40288581632b593e01632bd5d31f0003\",\"mediaFileoriginalname\":\"solr.avi\",\"mediaId\":\"5fbb79a2016c0eb609ecd0cd3dc48016\",\"pname\":\"表达式\"},{\"id\":\"40288581632b593e01632bd606480004\",\"pname\":\"逻辑运算\"}],\"id\":\"40288581632b593e01632bd597810002\",\"pname\":\"编程基础\"},{\"children\":[{\"id\":\"402881e764034e4301640351f3d70003\",\"pname\":\"一切皆为对象\"}],\"id\":\"402881e764034e430164035091a00002\",\"pname\":\"面向对象\"},{\"children\":[{\"id\":\"402899816ad8457c016ad9282a330001\",\"pname\":\"test06\"}],\"id\":\"402899816ad8457c016ad927ba540000\",\"pname\":\"test05\"}],\"id\":\"4028858162bec7f30162becad8590000\",\"pname\":\"test_java基础33\"}', '2019-10-28 11:26:24');
INSERT INTO `course_pub` VALUES ('297e7c7c62b888f00162b8a965510001', 'test_java基础node', 'test_java基础', '1-3', '1-3-2', '200001', '201001', NULL, 'test_java基础2test_java基础2test_java基础2test_java基础2test_java基础2test_java基础2test_java基础2test_java基础2test_java基础2test_java基础2', '2019-10-24 16:26:34', '203001', '204001', '443242', NULL, NULL, NULL, NULL, NULL, NULL, '{\"children\":[{\"children\":[{\"id\":\"402881e66417407b01641744fc650001\",\"pname\":\"入门程序\"}],\"id\":\"402881e66417407b01641744afc30000\",\"pname\":\"基础知识\"},{\"children\":[],\"id\":\"4028858162e5d6e00162e5e0727d0001\",\"pname\":\"java基础语法\"},{\"children\":[{\"id\":\"4028d0866b158241016b502433d60002\",\"pname\":\"第二节\"}],\"id\":\"4028d0866b158241016b5023f51e0001\",\"pname\":\"第二章\"}],\"id\":\"4028858162e5d6e00162e5e0227b0000\",\"pname\":\"test_java基础2\"}', '2019-10-24 16:26:33');

SET FOREIGN_KEY_CHECKS = 1;
