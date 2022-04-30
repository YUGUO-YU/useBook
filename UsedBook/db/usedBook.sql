/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : localhost:3306
 Source Schema         : face

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 30/04/2022 19:55:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `a_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `a_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `a_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `a_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `a_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`a_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (1, '荔湾区花地大道', '13631181504', '小羽子', '8d8294cfbaa44845b1cb5f2e8a61e0ca');
INSERT INTO `address` VALUES (2, '北京市市辖区东城区五道口职业技术学院', '13631181504', '王老吉', 'c0be8e3ed567438897076db6a18ae418');
INSERT INTO `address` VALUES (3, '山西省长治市屯留区芜湖护屋', '123456789', '王师傅', 'c0be8e3ed567438897076db6a18ae418');
INSERT INTO `address` VALUES (4, '北京市市辖区东城区哈哈哈哈哈哈', '12345678', '哈哈哈', 'c0be8e3ed567438897076db6a18ae418');

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college`  (
  `c_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `c_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院名',
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES (1, '全部');
INSERT INTO `college` VALUES (2, '经济管理学院');
INSERT INTO `college` VALUES (3, '机械工程学院');
INSERT INTO `college` VALUES (4, '美术学院');
INSERT INTO `college` VALUES (5, '建筑学院');
INSERT INTO `college` VALUES (6, '土木水利学院');
INSERT INTO `college` VALUES (7, '公共管理学院');
INSERT INTO `college` VALUES (8, '信息工程学院');

-- ----------------------------
-- Table structure for f_code
-- ----------------------------
DROP TABLE IF EXISTS `f_code`;
CREATE TABLE `f_code`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of f_code
-- ----------------------------
INSERT INTO `f_code` VALUES ('2332357244@qq.com', '59939', '2022-04-20 01:47:45');
INSERT INTO `f_code` VALUES ('3172401742@qq.com', '18236', '2022-04-20 01:46:29');
INSERT INTO `f_code` VALUES ('3518648281@qq.com', '45790', '2022-04-30 19:18:26');

-- ----------------------------
-- Table structure for f_favorites
-- ----------------------------
DROP TABLE IF EXISTS `f_favorites`;
CREATE TABLE `f_favorites`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of f_favorites
-- ----------------------------
INSERT INTO `f_favorites` VALUES ('a526ada1f2104c8bb264313aa2b74da5', 'c0be8e3ed567438897076db6a18ae418', 'deb37eadca0843a08d2aaa8edc57e378', '2022-04-24 10:38:01', 1);
INSERT INTO `f_favorites` VALUES ('b1e1dc8847fa414fabd2c2f1c25e8511', 'c0be8e3ed567438897076db6a18ae418', '16f9892eca874e8cb7a9cb53d3e4e7fa', '2022-04-20 03:40:42', 1);
INSERT INTO `f_favorites` VALUES ('b1fc0941654c42c6a9ab330ef67da990', 'd9b0e4247cc8435b86ff31a52ceb88d8', '333cc079eeec455d9a5a7c2e3a99d4ce', '2022-04-16 10:46:44', 1);
INSERT INTO `f_favorites` VALUES ('b386be7c1c0c45958730bc479e5c78a6', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '05b2281215c4408f80172d78acd9d092', '2022-04-20 03:27:23', 1);
INSERT INTO `f_favorites` VALUES ('e73a54bc738d4171bc637c82b6d81a75', 'd9b0e4247cc8435b86ff31a52ceb88d8', '9adecbe5966744a2b2f8f4b1c6b77f72', '2022-04-15 06:15:12', 1);
INSERT INTO `f_favorites` VALUES ('f00caebc9d4e40ea8fec605a425ebf08', 'd9b0e4247cc8435b86ff31a52ceb88d8', '9fc2a5a8bf7545d0b317cd532eba06d5', '2022-04-15 06:14:41', 1);

-- ----------------------------
-- Table structure for f_image
-- ----------------------------
DROP TABLE IF EXISTS `f_image`;
CREATE TABLE `f_image`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `table_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `table_id` int(11) NULL DEFAULT NULL,
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isdetault` int(11) NULL DEFAULT NULL,
  `about` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of f_image
-- ----------------------------
INSERT INTO `f_image` VALUES ('0165f5697350431e95293b3f8ef4b841', NULL, NULL, 'a45994a65ced4eaf8043b2a390607857.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('0d4687543fc94278946848e73ee92c6d', NULL, NULL, 'cfa07cec3ce74b8394cafbaa4d9f9780.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('0f5f51955cea4d23925e1ec50c63ee6d', NULL, NULL, '3a1b43737ee34cf799bb43d1aaf2a4c9.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('11f6614ac3b24e7db8292d4c01403eed', NULL, NULL, '7479b16da1364d1e9841014c14411c6d.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('129ff59963dd4fdd82d75bb15b311325', NULL, NULL, '596f01f6596d4f50885df17afb0e20e1.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('1756edd7545c4304998e046bcafda08d', NULL, NULL, 'cb8766b113ef4e8083efa91b8c46698c.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('189703fd4e454b128d05ce1c8777b160', NULL, NULL, 'f428e0d3f6924a9cb75c874a5f6abdab.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('4f761cc86e3f46e99f038e89380f0e54', NULL, NULL, '0343fd367b7f4afcb69e8107c97d69cf.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('5b2ce7b40fd34f64b1d3f688179c887c', NULL, NULL, '05d0cc0af7714750bee89c9d815602b8.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('5ba720045e064528bb7183e76f77c793', NULL, NULL, 'a25c38414dcf42b790ce634ad0063e9f.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('5bb249157af84516945a764615c544de', NULL, NULL, '53762a44202c4363920dd13cbe532026.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('6583e967131746a2b00db134c2448fcf', NULL, NULL, 'e5b341dac58547f583a257c2a33bed9a.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('6aa6e698fa1948f1af6997422db17817', NULL, NULL, '45bbe6d22546445dae8b7b083f54add2.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('8296cda18ebb40f3ab0a60999aa60eea', NULL, NULL, '58eba0a5e3a54bd894c4e1a4d1cd4bcc.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('89071f788bc04951bd75fc25e072aea8', NULL, NULL, '2906d0c5f3e94e2591fe827fff0fb3fa.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('91ad4fa59b0d485783949f48702c4736', NULL, NULL, '2a693ba5cd1240fe983358b3945e81f5.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('932ead39247a424da8f9f66054962606', NULL, NULL, 'ab84110d6d314b478ab627dc1204abf6.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('a66883deb2a34c5bad4a23b6e5c71609', NULL, NULL, '1f326984bbf44495a8348533e08fd8e0.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('b3addc9d0b9649cba57c4c40ad36661d', NULL, NULL, '75c6b66fb31c4544af6247d36e513ed4.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('c1c51d36346d42a99c784bb490dbe5cb', NULL, NULL, '4f68103e224142f9986fd86ee03478fb.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('c2f7ca33fb704e919b2b45024002aa97', NULL, NULL, '1b8885f7b369463bb5c4fa466823283e.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('d642f5726bb24479b9724cf3aeb30cb8', NULL, NULL, '157ca3de86e24e148d13f6f4378b1d74.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('d760170844ec4bcf8ca2c2da459def04', NULL, NULL, '3bdc5de558bd4c5b974ab2fb94b23382.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('dfd9cff9746745289974018beb2a21b2', NULL, NULL, '8999dc38f35947c686e66aa1296d7464.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('e60e07e4e24b41a0a0d1ad92ef97b799', NULL, NULL, '6107aa440a7841b582f7eb6ec9dbd575.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('ea6793d34e704b0c89731ee7034cd1a3', NULL, NULL, 'e3e3e81ac19740fe899e42d2dde135e2.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('f9e0209eae314cd285f000dcb76ab07d', NULL, NULL, '83b718b9191d45f5bc1ae4cb4ab38b38.jpg', NULL, NULL);
INSERT INTO `f_image` VALUES ('fdb979efd162448aa3ff79dd7811e72a', NULL, NULL, '5eae2a409a8d4145a9a114e4b0dc7184.jpg', NULL, NULL);

-- ----------------------------
-- Table structure for f_message
-- ----------------------------
DROP TABLE IF EXISTS `f_message`;
CREATE TABLE `f_message`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `t_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `f_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of f_message
-- ----------------------------
INSERT INTO `f_message` VALUES ('d9c986ce36f1463eb99d9a6df329f9de', 'd9b0e4247cc8435b86ff31a52ceb88d8', '16f9892eca874e8cb7a9cb53d3e4e7fa', '我要', '2022-04-16 10:45:35');

-- ----------------------------
-- Table structure for f_order
-- ----------------------------
DROP TABLE IF EXISTS `f_order`;
CREATE TABLE `f_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `real_fee` decimal(18, 4) NULL DEFAULT NULL,
  `pay_time` datetime(0) NULL DEFAULT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品Id',
  `address_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of f_order
-- ----------------------------
INSERT INTO `f_order` VALUES (7, '510857ac835c40b0ba1a224a273bf650', 3.0000, '2022-04-22 16:07:13', 'c0be8e3ed567438897076db6a18ae418', '333cc079eeec455d9a5a7c2e3a99d4ce', 2);
INSERT INTO `f_order` VALUES (8, '5d5c91775b434dfb87c8588c814cb8d5', 45.0000, '2022-04-22 16:10:20', 'c0be8e3ed567438897076db6a18ae418', 'ea90569b4ad94752acd02f2d7d9efab0', 2);
INSERT INTO `f_order` VALUES (9, 'c500fe99db0443cc973df7f71166dcda', 45.0000, '2022-04-22 16:11:56', 'c0be8e3ed567438897076db6a18ae418', '634fc063a74b49a28408d791c6a1f458', 2);
INSERT INTO `f_order` VALUES (10, 'a01c9e306ce04973b800611763301486', 12.0000, '2022-04-22 16:14:28', 'c0be8e3ed567438897076db6a18ae418', '05b2281215c4408f80172d78acd9d092', 3);
INSERT INTO `f_order` VALUES (11, 'bef30b6ed9cc434c819dbdc8da853d6b', 8.0000, '2022-04-22 18:49:54', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '66ec6f6b7e694f7299b4d53948bda285', 1);
INSERT INTO `f_order` VALUES (12, 'da5f0270e6fa403eb2a4b65673d28ff3', 23.0000, '2022-04-22 18:53:48', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '16f9892eca874e8cb7a9cb53d3e4e7fa', 1);
INSERT INTO `f_order` VALUES (13, '9acf1f71bc474d94b971cbfa4087666c', 2.0000, '2022-04-22 18:54:35', '8d8294cfbaa44845b1cb5f2e8a61e0ca', 'f7137ae98c8542eeba6ebf542a1515f9', 1);
INSERT INTO `f_order` VALUES (14, '7a515d27d5454fe4915dfe2330cfd2d8', 5.0000, '2022-04-22 18:57:55', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '22486d86ac47403098a5d5d6b2bc3916', 1);
INSERT INTO `f_order` VALUES (15, 'eedbf3dd9d8e4b66b079338223a090b5', 10.0000, '2022-04-22 18:59:16', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '33918d8a45b947419b4695b6e73b10c8', 1);
INSERT INTO `f_order` VALUES (18, 'd20e1a927f3942349388cb307c2a893a', 8.0000, '2022-04-26 21:59:44', '8d8294cfbaa44845b1cb5f2e8a61e0ca', 'a35dea0040084873ae95e8ea923311e8', 1);

-- ----------------------------
-- Table structure for f_product
-- ----------------------------
DROP TABLE IF EXISTS `f_product`;
CREATE TABLE `f_product`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bprice` decimal(18, 4) NULL DEFAULT NULL,
  `price` decimal(18, 4) NULL DEFAULT NULL,
  `times` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_show` int(11) NULL DEFAULT 1,
  `is_del` int(11) UNSIGNED NULL DEFAULT 0,
  `count` int(11) NULL DEFAULT NULL,
  `sc` int(11) NULL DEFAULT NULL,
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布人姓名',
  `college_id` int(11) NULL DEFAULT NULL COMMENT '学院id',
  `major_id` int(11) NULL DEFAULT NULL COMMENT '专业id',
  `grade_id` int(11) NULL DEFAULT NULL COMMENT '年级id',
  `is_not` int(11) NULL DEFAULT 0 COMMENT '0未售出，1已售出',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of f_product
-- ----------------------------
INSERT INTO `f_product` VALUES ('05b2281215c4408f80172d78acd9d092', 'dryrd', 'aeghjg', 123.0000, 12.0000, NULL, '2022-04-20 01:08:34', 'e6ebd297e76d4dc78a5bb9729cb4da60', 1, 0, NULL, NULL, 'images/2906d0c5f3e94e2591fe827fff0fb3fa.jpg', NULL, NULL, NULL, NULL, 1);
INSERT INTO `f_product` VALUES ('16f9892eca874e8cb7a9cb53d3e4e7fa', '哈哈哈', '的法国红酒看来', 1234.0000, 23.0000, NULL, '2022-04-16 09:10:31', 'd9b0e4247cc8435b86ff31a52ceb88d8', 1, 0, NULL, NULL, 'images/4f68103e224142f9986fd86ee03478fb.jpg', '小羽子', NULL, NULL, NULL, 1);
INSERT INTO `f_product` VALUES ('22486d86ac47403098a5d5d6b2bc3916', 'PS技术学习', '学习ps必备', 59.0000, 5.0000, NULL, '2022-04-21 02:09:30', 'c0be8e3ed567438897076db6a18ae418', 1, 0, NULL, NULL, 'images/157ca3de86e24e148d13f6f4378b1d74.jpg', '王五', 4, 14, 2, 1);
INSERT INTO `f_product` VALUES ('333cc079eeec455d9a5a7c2e3a99d4ce', '678', '234234', 23.0000, 3.0000, NULL, '2022-04-16 09:13:45', 'd9b0e4247cc8435b86ff31a52ceb88d8', 1, 0, NULL, NULL, 'images/7479b16da1364d1e9841014c14411c6d.jpg', '小羽子', NULL, NULL, NULL, 1);
INSERT INTO `f_product` VALUES ('33918d8a45b947419b4695b6e73b10c8', '会计学理论', '学习会计必备良品', 45.0000, 10.0000, NULL, '2022-04-21 05:14:37', 'c0be8e3ed567438897076db6a18ae418', 1, 0, NULL, NULL, 'images/3bdc5de558bd4c5b974ab2fb94b23382.jpg', '王五', 2, 5, 3, 1);
INSERT INTO `f_product` VALUES ('4a264e9383d349a99bac669f58f98f1a', '阿斯顿', '色发士大夫山豆根山豆根规范化规范化广泛', 145.0000, 45.0000, NULL, '2022-04-16 08:59:04', 'd9b0e4247cc8435b86ff31a52ceb88d8', 1, 1, NULL, NULL, 'src\\main\\resources\\static\\images\\5eae2a409a8d4145a9a114e4b0dc7184.jpg', '小羽子', NULL, NULL, NULL, 0);
INSERT INTO `f_product` VALUES ('634fc063a74b49a28408d791c6a1f458', 'dfg', 'dfsdgsdgs', 456.0000, 45.0000, NULL, '2022-04-16 08:58:14', 'd9b0e4247cc8435b86ff31a52ceb88d8', 1, 0, NULL, NULL, 'images/6107aa440a7841b582f7eb6ec9dbd575.jpg', '小羽子', NULL, NULL, NULL, 1);
INSERT INTO `f_product` VALUES ('66ec6f6b7e694f7299b4d53948bda285', '精密仪器理论', '学习精密仪器必备', 88.0000, 8.0000, NULL, '2022-04-21 04:59:14', 'c0be8e3ed567438897076db6a18ae418', 1, 0, NULL, NULL, 'images/2a693ba5cd1240fe983358b3945e81f5.jpg', '王五', 3, 10, 2, 1);
INSERT INTO `f_product` VALUES ('81e0b4c355034aaea2883a2fc364663d', 'sfdasdf', 'sdfsdfa', 123.0000, 12.0000, NULL, '2022-04-16 08:59:12', 'd9b0e4247cc8435b86ff31a52ceb88d8', 1, 1, NULL, NULL, 'F:/2022.4.12二手书城项目/imgs/0343fd367b7f4afcb69e8107c97d69cf.jpg', '小羽子', NULL, NULL, NULL, 0);
INSERT INTO `f_product` VALUES ('9668568a89354313abe6e3830703360e', '胜多负少', '案说法打发打发', 123.0000, 12.0000, NULL, '2022-04-16 08:59:22', 'd9b0e4247cc8435b86ff31a52ceb88d8', 1, 1, NULL, NULL, 'F:\\2022.4.12二手书城项目\\imgs\\0343fd367b7f4afcb69e8107c97d69cf.jpg', '小羽子', NULL, NULL, NULL, 0);
INSERT INTO `f_product` VALUES ('9adecbe5966744a2b2f8f4b1c6b77f72', '为公司', '哇发发士大夫是DVD', 123.0000, 12.0000, NULL, '2022-04-16 08:59:28', 'd9b0e4247cc8435b86ff31a52ceb88d8', 1, 1, NULL, NULL, '\\static\\img\\58eba0a5e3a54bd894c4e1a4d1cd4bcc.jpg', '小羽子', NULL, NULL, NULL, 0);
INSERT INTO `f_product` VALUES ('9fc2a5a8bf7545d0b317cd532eba06d5', '软件书记', '哈哈哈哈哈哈哈哈哈', 123.0000, 1.0000, NULL, '2022-04-16 08:59:37', 'd9b0e4247cc8435b86ff31a52ceb88d8', 1, 1, NULL, NULL, '\\static\\img\\1b8885f7b369463bb5c4fa466823283e.jpg', '小羽子', NULL, NULL, NULL, 0);
INSERT INTO `f_product` VALUES ('a35dea0040084873ae95e8ea923311e8', '水利书籍', '水利', 88.0000, 8.0000, NULL, '2022-04-25 09:39:54', 'c0be8e3ed567438897076db6a18ae418', 1, 0, NULL, NULL, 'images/f428e0d3f6924a9cb75c874a5f6abdab.jpg', '王五', 6, 18, 1, 1);
INSERT INTO `f_product` VALUES ('ad8bfe1027294edea30fe2f848aa44a2', '书籍', '好书选我', 200.0000, 20.0000, NULL, '2022-04-20 08:31:03', 'c0be8e3ed567438897076db6a18ae418', 1, 0, NULL, NULL, 'images/e3e3e81ac19740fe899e42d2dde135e2.jpg', '王五', NULL, NULL, NULL, 0);
INSERT INTO `f_product` VALUES ('b8825ef33bc64da3b097411b88ed0c45', 'sdfsfsf', 'afafasfaf', 123.0000, 3.0000, NULL, '2022-04-18 09:04:59', 'd9b0e4247cc8435b86ff31a52ceb88d8', 1, 1, NULL, NULL, '05d0cc0af7714750bee89c9d815602b8.jpg', '小羽子', NULL, NULL, NULL, 0);
INSERT INTO `f_product` VALUES ('be850af20be248b9a8b878f32da0b612', '山豆根山豆根', '啊大苏打实打实打算', 123.0000, 12.0000, NULL, '2022-04-18 09:05:06', 'd9b0e4247cc8435b86ff31a52ceb88d8', 1, 1, NULL, NULL, '\\static\\img\\ab84110d6d314b478ab627dc1204abf6.jpg', '小羽子', NULL, NULL, NULL, 0);
INSERT INTO `f_product` VALUES ('d37d7cec67294306ab3225fd8484de94', '顶顶顶', '阿文啊发射点发射点发', 123.0000, 12.0000, NULL, '2022-04-18 09:05:12', 'd9b0e4247cc8435b86ff31a52ceb88d8', 1, 1, NULL, NULL, '\\static\\img\\45bbe6d22546445dae8b7b083f54add2.jpg', '小羽子', NULL, NULL, NULL, 0);
INSERT INTO `f_product` VALUES ('deb37eadca0843a08d2aaa8edc57e378', 'esdhfnbdz', 'eshfdngmh', 224.0000, 3.0000, NULL, '2022-04-20 01:52:00', '8d8294cfbaa44845b1cb5f2e8a61e0ca', 1, 0, NULL, NULL, 'images/e5b341dac58547f583a257c2a33bed9a.jpg', '小羽子', NULL, NULL, NULL, 0);
INSERT INTO `f_product` VALUES ('df804aea42ae4de3aa72a9e16483c9e4', '建筑学', '建筑学必备', 123.0000, 12.0000, NULL, '2022-04-22 07:12:40', '8d8294cfbaa44845b1cb5f2e8a61e0ca', 1, 0, NULL, NULL, 'images/a25c38414dcf42b790ce634ad0063e9f.jpg', '小羽子', 5, 15, 1, 0);
INSERT INTO `f_product` VALUES ('e47f5a25596048a68bce7f88383455b3', '操作系统概论', '计算机操作系统学习书籍', 88.0000, 10.0000, NULL, '2022-04-21 02:06:16', 'c0be8e3ed567438897076db6a18ae418', 1, 0, NULL, NULL, 'images/8999dc38f35947c686e66aa1296d7464.jpg', '王五', 8, 2, 4, 0);
INSERT INTO `f_product` VALUES ('e7c0c25331e44d6b842718a05a1b0299', '会计学', '哈哈哈哈哈哈哈哈哈', 123.0000, 12.0000, NULL, '2022-04-30 07:19:44', '58142e4ed1a54cd8885ca85ab6a5b2e2', 1, 0, NULL, NULL, 'images/1f326984bbf44495a8348533e08fd8e0.jpg', '大傻子', 2, 6, 1, 0);
INSERT INTO `f_product` VALUES ('ea90569b4ad94752acd02f2d7d9efab0', '再', '是的法国红酒看', 123.0000, 45.0000, NULL, '2022-04-20 01:34:31', 'e6ebd297e76d4dc78a5bb9729cb4da60', 1, 0, NULL, NULL, 'images/3a1b43737ee34cf799bb43d1aaf2a4c9.jpg', '小羽子', NULL, NULL, NULL, 1);
INSERT INTO `f_product` VALUES ('f7137ae98c8542eeba6ebf542a1515f9', '23123', '沙发沙发沙发', 123.0000, 2.0000, NULL, '2022-04-16 10:44:33', 'd9b0e4247cc8435b86ff31a52ceb88d8', 1, 0, NULL, NULL, 'images/53762a44202c4363920dd13cbe532026.jpg', '小羽子', NULL, NULL, NULL, 1);

-- ----------------------------
-- Table structure for f_user
-- ----------------------------
DROP TABLE IF EXISTS `f_user`;
CREATE TABLE `f_user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pass_word` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `credit` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  `wxopenid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qqopenid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `aliopenid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` decimal(18, 4) NULL DEFAULT NULL,
  `room_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of f_user
-- ----------------------------
INSERT INTO `f_user` VALUES ('58142e4ed1a54cd8885ca85ab6a5b2e2', '大傻子', 'e10adc3949ba59abbe56e057f20f883e', '123456789', '3518648281@qq.com', NULL, '2022-04-30 07:18:53', NULL, NULL, '3518648281', NULL, NULL, '13467946');
INSERT INTO `f_user` VALUES ('8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'e10adc3949ba59abbe56e057f20f883e', '5646546588', '3172401742@qq.com', NULL, '2022-04-20 01:47:07', NULL, NULL, '56454664', NULL, NULL, '65478587');
INSERT INTO `f_user` VALUES ('c0be8e3ed567438897076db6a18ae418', '王五', 'e10adc3949ba59abbe56e057f20f883e', '43646264535', '2332357244@qq.com', NULL, '2022-04-20 01:48:20', NULL, NULL, '651891895', NULL, NULL, '27525727');

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `g_id` int(11) NOT NULL COMMENT 'id',
  `g_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年级',
  PRIMARY KEY (`g_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grade
-- ----------------------------

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`  (
  `m_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `m_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业名',
  `m_father_id` int(11) NULL DEFAULT NULL COMMENT '一级id',
  PRIMARY KEY (`m_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES (1, '电子工程', 8);
INSERT INTO `major` VALUES (2, '软件工程', 8);
INSERT INTO `major` VALUES (3, '计算机科学与技术', 8);
INSERT INTO `major` VALUES (4, '自动化系', 8);
INSERT INTO `major` VALUES (5, '会计系', 2);
INSERT INTO `major` VALUES (6, '经济系', 2);
INSERT INTO `major` VALUES (7, '金融系', 2);
INSERT INTO `major` VALUES (8, '市场营销系', 2);
INSERT INTO `major` VALUES (9, '机械工程系', 3);
INSERT INTO `major` VALUES (10, '精密仪器系', 3);
INSERT INTO `major` VALUES (11, '能源与动力工程', 3);
INSERT INTO `major` VALUES (12, '艺术史论系', 4);
INSERT INTO `major` VALUES (13, '绘画系', 4);
INSERT INTO `major` VALUES (14, '工程美术系', 4);
INSERT INTO `major` VALUES (15, '建筑系', 5);
INSERT INTO `major` VALUES (16, '城市规划系', 5);
INSERT INTO `major` VALUES (17, '建筑技术科学系', 5);
INSERT INTO `major` VALUES (18, '土木工程系', 6);
INSERT INTO `major` VALUES (19, '城市规划系', 6);
INSERT INTO `major` VALUES (20, '景观学系', 6);
INSERT INTO `major` VALUES (21, '公共管理系', 7);

-- ----------------------------
-- Table structure for msg_info
-- ----------------------------
DROP TABLE IF EXISTS `msg_info`;
CREATE TABLE `msg_info`  (
  `id` int(6) NOT NULL AUTO_INCREMENT COMMENT '消息id',
  `from_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息发送者id',
  `from_user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息发送者名称',
  `to_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息接收者id',
  `to_user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息接收者名称',
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息内容',
  `create_time` datetime(0) NOT NULL COMMENT '消息发送时间',
  `un_read_flag` int(1) NOT NULL COMMENT '是否已读（1 已读）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 321 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '消息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of msg_info
-- ----------------------------
INSERT INTO `msg_info` VALUES (283, '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'c0be8e3ed567438897076db6a18ae418', '小羽子', 'wasdhfjgkh', '2022-04-20 01:56:37', 1);
INSERT INTO `msg_info` VALUES (284, 'c0be8e3ed567438897076db6a18ae418', '王五', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '王五', 'sagdhg', '2022-04-20 02:21:59', 1);
INSERT INTO `msg_info` VALUES (285, 'c0be8e3ed567438897076db6a18ae418', '王五', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '王五', 'wtesyrdtjky', '2022-04-20 02:22:08', 1);
INSERT INTO `msg_info` VALUES (286, 'c0be8e3ed567438897076db6a18ae418', '王五', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '王五', '你', '2022-04-22 19:12:56', 1);
INSERT INTO `msg_info` VALUES (287, 'c0be8e3ed567438897076db6a18ae418', '王五', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '王五', 'dddd', '2022-04-30 16:33:22', 1);
INSERT INTO `msg_info` VALUES (288, 'c0be8e3ed567438897076db6a18ae418', '王五', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '王五', '哈哈哈哈', '2022-04-30 16:35:05', 1);
INSERT INTO `msg_info` VALUES (289, 'c0be8e3ed567438897076db6a18ae418', '王五', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', '哈哈哈哈哈哈', '2022-04-30 16:44:25', 1);
INSERT INTO `msg_info` VALUES (290, 'c0be8e3ed567438897076db6a18ae418', '王五', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', '2222', '2022-04-30 16:46:09', 1);
INSERT INTO `msg_info` VALUES (291, '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'c0be8e3ed567438897076db6a18ae418', '王五', '你是？', '2022-04-30 17:16:49', 1);
INSERT INTO `msg_info` VALUES (292, '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'c0be8e3ed567438897076db6a18ae418', '王五', '我是', '2022-04-30 17:17:14', 1);
INSERT INTO `msg_info` VALUES (293, '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'c0be8e3ed567438897076db6a18ae418', '王五', '哈哈哈哈', '2022-04-30 17:20:59', 1);
INSERT INTO `msg_info` VALUES (294, 'c0be8e3ed567438897076db6a18ae418', '王五', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', '哈哈哈哈哈哈', '2022-04-30 17:21:24', 1);
INSERT INTO `msg_info` VALUES (295, 'c0be8e3ed567438897076db6a18ae418', '王五', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', '哈哈哈哈', '2022-04-30 17:24:40', 1);
INSERT INTO `msg_info` VALUES (296, 'c0be8e3ed567438897076db6a18ae418', '王五', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', '哈哈哈哈', '2022-04-30 17:28:19', 1);
INSERT INTO `msg_info` VALUES (297, '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'c0be8e3ed567438897076db6a18ae418', '王五', '2222', '2022-04-30 17:41:40', 1);
INSERT INTO `msg_info` VALUES (298, 'c0be8e3ed567438897076db6a18ae418', '王五', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', '2222', '2022-04-30 17:44:02', 1);
INSERT INTO `msg_info` VALUES (299, '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'c0be8e3ed567438897076db6a18ae418', '王五', '2222', '2022-04-30 17:44:18', 1);
INSERT INTO `msg_info` VALUES (300, '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'c0be8e3ed567438897076db6a18ae418', '王五', '哈哈哈哈', '2022-04-30 18:01:28', 1);
INSERT INTO `msg_info` VALUES (301, 'c0be8e3ed567438897076db6a18ae418', '王五', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'nihao', '2022-04-30 18:02:40', 1);
INSERT INTO `msg_info` VALUES (302, 'c0be8e3ed567438897076db6a18ae418', '王五', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'hhhhhh', '2022-04-30 18:07:09', 1);
INSERT INTO `msg_info` VALUES (303, '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'c0be8e3ed567438897076db6a18ae418', '王五', 'hhhhhhh', '2022-04-30 18:08:29', 1);
INSERT INTO `msg_info` VALUES (304, 'c0be8e3ed567438897076db6a18ae418', '王五', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'hhhhh', '2022-04-30 18:10:36', 1);
INSERT INTO `msg_info` VALUES (305, 'c0be8e3ed567438897076db6a18ae418', '王五', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'wwww', '2022-04-30 18:15:41', 1);
INSERT INTO `msg_info` VALUES (306, '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'c0be8e3ed567438897076db6a18ae418', '王五', 'nihao1', '2022-04-30 18:17:11', 1);
INSERT INTO `msg_info` VALUES (307, 'c0be8e3ed567438897076db6a18ae418', '王五', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'nihao1', '2022-04-30 18:18:05', 1);
INSERT INTO `msg_info` VALUES (308, '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'c0be8e3ed567438897076db6a18ae418', '王五', 'nnnnn', '2022-04-30 18:19:29', 1);
INSERT INTO `msg_info` VALUES (309, 'c0be8e3ed567438897076db6a18ae418', '王五', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'hhhhh', '2022-04-30 18:21:04', 1);
INSERT INTO `msg_info` VALUES (310, '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'c0be8e3ed567438897076db6a18ae418', '王五', 'nishi', '2022-04-30 18:25:02', 1);
INSERT INTO `msg_info` VALUES (311, 'c0be8e3ed567438897076db6a18ae418', '王五', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'nihao', '2022-04-30 18:26:46', 1);
INSERT INTO `msg_info` VALUES (312, '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'c0be8e3ed567438897076db6a18ae418', '王五', 'nihao', '2022-04-30 18:27:10', 1);
INSERT INTO `msg_info` VALUES (313, '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'c0be8e3ed567438897076db6a18ae418', '王五', 'nihao', '2022-04-30 18:29:58', 1);
INSERT INTO `msg_info` VALUES (314, 'c0be8e3ed567438897076db6a18ae418', '王五', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'niaho', '2022-04-30 18:30:14', 1);
INSERT INTO `msg_info` VALUES (315, '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'c0be8e3ed567438897076db6a18ae418', '王五', 'nihao', '2022-04-30 18:31:49', 1);
INSERT INTO `msg_info` VALUES (316, 'c0be8e3ed567438897076db6a18ae418', '王五', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'nihao', '2022-04-30 19:16:31', 0);
INSERT INTO `msg_info` VALUES (317, 'c0be8e3ed567438897076db6a18ae418', '王五', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 'hhhh', '2022-04-30 19:16:41', 0);
INSERT INTO `msg_info` VALUES (318, 'c0be8e3ed567438897076db6a18ae418', '王五', '58142e4ed1a54cd8885ca85ab6a5b2e2', '大傻子', '你好', '2022-04-30 19:20:29', 1);
INSERT INTO `msg_info` VALUES (319, 'c0be8e3ed567438897076db6a18ae418', '王五', '58142e4ed1a54cd8885ca85ab6a5b2e2', '大傻子', '嘿嘿嘿', '2022-04-30 19:21:24', 1);
INSERT INTO `msg_info` VALUES (320, '58142e4ed1a54cd8885ca85ab6a5b2e2', '大傻子', 'c0be8e3ed567438897076db6a18ae418', '王五', '你也好', '2022-04-30 19:21:38', 0);

-- ----------------------------
-- Table structure for session_list
-- ----------------------------
DROP TABLE IF EXISTS `session_list`;
CREATE TABLE `session_list`  (
  `id` int(60) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属用户',
  `to_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '到用户',
  `list_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '会话名称',
  `un_read_count` int(60) NOT NULL COMMENT '未读消息数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会话列表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of session_list
-- ----------------------------
INSERT INTO `session_list` VALUES (41, 'c0be8e3ed567438897076db6a18ae418', '8d8294cfbaa44845b1cb5f2e8a61e0ca', '小羽子', 0);
INSERT INTO `session_list` VALUES (42, '8d8294cfbaa44845b1cb5f2e8a61e0ca', 'c0be8e3ed567438897076db6a18ae418', '王五', 0);
INSERT INTO `session_list` VALUES (47, 'c0be8e3ed567438897076db6a18ae418', '58142e4ed1a54cd8885ca85ab6a5b2e2', '大傻子', 0);
INSERT INTO `session_list` VALUES (48, '58142e4ed1a54cd8885ca85ab6a5b2e2', 'c0be8e3ed567438897076db6a18ae418', '王五', 0);

SET FOREIGN_KEY_CHECKS = 1;
