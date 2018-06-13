/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50715
Source Host           : 127.0.0.1:3306
Source Database       : monitor

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-06-13 16:31:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for c_dep
-- ----------------------------
DROP TABLE IF EXISTS `c_dep`;
CREATE TABLE `c_dep` (
  `dep_no` varchar(50) NOT NULL COMMENT '部门编号',
  `dep_name` varchar(100) DEFAULT '' COMMENT '部门名称',
  `dep_pno` varchar(50) DEFAULT '' COMMENT '部门父级编号',
  `org_no` varchar(20) DEFAULT '' COMMENT '机构编号',
  `dep_seq` int(11) DEFAULT '0' COMMENT '部门排序',
  PRIMARY KEY (`dep_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_dep
-- ----------------------------

-- ----------------------------
-- Table structure for c_dict
-- ----------------------------
DROP TABLE IF EXISTS `c_dict`;
CREATE TABLE `c_dict` (
  `dict_no` varchar(50) NOT NULL DEFAULT '' COMMENT '编号',
  `dict_pno` varchar(50) DEFAULT '' COMMENT '父级编号',
  `dict_name` varchar(100) NOT NULL DEFAULT '' COMMENT '字典名',
  `dict_desc` varchar(200) DEFAULT '' COMMENT '描述',
  `dict_pnos` varchar(200) DEFAULT '' COMMENT '所有父级编号，逗号隔开',
  `dict_status` tinyint(4) DEFAULT '1' COMMENT '状态: 1 正常，0 无效，-1 删除不存在',
  `dict_seq` int(11) DEFAULT '0' COMMENT '排序',
  `dict_level` tinyint(4) DEFAULT '0' COMMENT '字典级别',
  `dict_icon` varchar(50) DEFAULT '' COMMENT '字典图标',
  `dict_img` varchar(200) DEFAULT '' COMMENT '字典图形',
  PRIMARY KEY (`dict_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_dict
-- ----------------------------
INSERT INTO `c_dict` VALUES ('D001', '', '指标频度', '指标频度', '', '1', '0', '0', '', '');
INSERT INTO `c_dict` VALUES ('D00101', 'D001', '月度', '', '', '1', '0', '1', '', '');
INSERT INTO `c_dict` VALUES ('D00102', 'D001', '季度', '', '', '1', '1', '1', '', '');
INSERT INTO `c_dict` VALUES ('D00103', 'D001', '半年', '', '', '1', '2', '1', '', '');
INSERT INTO `c_dict` VALUES ('D00104', 'D001', '年', '', '', '1', '3', '1', '', '');
INSERT INTO `c_dict` VALUES ('D002', '', '指标币种', '', '', '1', '0', '0', '', '');
INSERT INTO `c_dict` VALUES ('D00201', 'D002', '人名币', 'CNY', '', '1', '0', '1', '', '');
INSERT INTO `c_dict` VALUES ('D00202', 'D002', '美元', 'USD', '', '1', '1', '1', '', '');

-- ----------------------------
-- Table structure for c_organ
-- ----------------------------
DROP TABLE IF EXISTS `c_organ`;
CREATE TABLE `c_organ` (
  `org_no` varchar(50) NOT NULL COMMENT '机构编号',
  `org_pno` varchar(50) DEFAULT '' COMMENT '机构父编号',
  `org_name` varchar(100) NOT NULL DEFAULT '' COMMENT '机构名称',
  `org_desc` varchar(200) DEFAULT NULL,
  `org_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态: 0 失效，1 正常，-1 删除',
  `org_seq` int(11) DEFAULT '0' COMMENT '排序',
  `org_level` tinyint(4) DEFAULT '0' COMMENT '机构级别',
  `org_pnos` varchar(255) DEFAULT '' COMMENT '所有父级机构编号，逗号隔开',
  PRIMARY KEY (`org_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_organ
-- ----------------------------

-- ----------------------------
-- Table structure for c_user
-- ----------------------------
DROP TABLE IF EXISTS `c_user`;
CREATE TABLE `c_user` (
  `user_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号自增',
  `user_name` varchar(100) DEFAULT '' COMMENT '用户登录名',
  `user_phone` int(11) DEFAULT '0' COMMENT '用户手机号码',
  `user_email` varchar(200) DEFAULT '' COMMENT '用户邮箱',
  `user_status` tinyint(4) DEFAULT '1' COMMENT '状态 1正常 0 失效 ，禁用-1软删除',
  `user_pwd` varchar(100) NOT NULL DEFAULT '' COMMENT '加密后的密码',
  `user_salt` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`user_no`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_user
-- ----------------------------
INSERT INTO `c_user` VALUES ('10000', 'admin', '1340888888', '', '1', '', '');

-- ----------------------------
-- Table structure for c_user_info
-- ----------------------------
DROP TABLE IF EXISTS `c_user_info`;
CREATE TABLE `c_user_info` (
  `user_no` int(11) NOT NULL,
  `user_avatar` varchar(1000) DEFAULT NULL,
  `add_time` bigint(20) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `nick_name` varchar(200) DEFAULT '',
  `user_email` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_phone` varchar(255) DEFAULT NULL,
  `user_pwd` varchar(255) DEFAULT NULL,
  `user_salt` varchar(255) DEFAULT NULL,
  `user_status` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`user_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_user_info
-- ----------------------------
INSERT INTO `c_user_info` VALUES ('10000', null, null, null, '系统管理员', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for d_grid
-- ----------------------------
DROP TABLE IF EXISTS `d_grid`;
CREATE TABLE `d_grid` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT '' COMMENT '二维表表名',
  `width` varchar(20) DEFAULT '' COMMENT '表宽度，默认100%',
  `height` varchar(20) DEFAULT '' COMMENT '二维表高度，默认100%',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='二维表设置';

-- ----------------------------
-- Records of d_grid
-- ----------------------------
INSERT INTO `d_grid` VALUES ('1', '测试表格', '100%', '100%');

-- ----------------------------
-- Table structure for d_grid_cell
-- ----------------------------
DROP TABLE IF EXISTS `d_grid_cell`;
CREATE TABLE `d_grid_cell` (
  `grid_id` int(11) NOT NULL DEFAULT '0',
  `row_no` int(11) NOT NULL DEFAULT '0' COMMENT '行号',
  `col_no` int(11) NOT NULL DEFAULT '0' COMMENT '列号',
  `kpi_code` varchar(50) DEFAULT '' COMMENT '指标编号',
  `cell_value` varchar(200) DEFAULT '' COMMENT '单元格固定值，当code为空时可用',
  PRIMARY KEY (`grid_id`,`row_no`,`col_no`),
  KEY `FK_krimoddplrl3dmh9cila72944` (`grid_id`),
  CONSTRAINT `FK_krimoddplrl3dmh9cila72944` FOREIGN KEY (`grid_id`) REFERENCES `d_grid` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='二维表单元格配置，用于取数';

-- ----------------------------
-- Records of d_grid_cell
-- ----------------------------
INSERT INTO `d_grid_cell` VALUES ('1', '0', '0', '', '第一列0');
INSERT INTO `d_grid_cell` VALUES ('1', '0', '1', 'AR0001', '');
INSERT INTO `d_grid_cell` VALUES ('1', '0', '2', 'AR0002', '');
INSERT INTO `d_grid_cell` VALUES ('1', '0', '3', 'AR0003', '');
INSERT INTO `d_grid_cell` VALUES ('1', '0', '4', 'AR0004', '');
INSERT INTO `d_grid_cell` VALUES ('1', '1', '0', '', '第一列1');
INSERT INTO `d_grid_cell` VALUES ('1', '2', '0', '', '第一列2');
INSERT INTO `d_grid_cell` VALUES ('1', '3', '0', '', '第一列3');

-- ----------------------------
-- Table structure for d_grid_field
-- ----------------------------
DROP TABLE IF EXISTS `d_grid_field`;
CREATE TABLE `d_grid_field` (
  `grid_id` int(11) NOT NULL COMMENT '外键关联grid_config主键',
  `title` varchar(200) DEFAULT '' COMMENT '表头展示名',
  `field` varchar(100) DEFAULT '' COMMENT '列取值字段',
  `width` varchar(200) DEFAULT '' COMMENT '列宽',
  `rowspan` int(11) DEFAULT NULL COMMENT '跨行',
  `colspan` int(11) DEFAULT NULL COMMENT '跨列',
  `halign` varchar(10) DEFAULT '' COMMENT '标题对其方式，left，right，center',
  `align` varchar(10) DEFAULT '' COMMENT '数据单元格对其',
  PRIMARY KEY (`grid_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_grid_field
-- ----------------------------

-- ----------------------------
-- Table structure for d_kpi
-- ----------------------------
DROP TABLE IF EXISTS `d_kpi`;
CREATE TABLE `d_kpi` (
  `kpi_code` varchar(50) NOT NULL COMMENT '指标编号',
  `kpi_name` varchar(100) NOT NULL DEFAULT '' COMMENT '指标名称',
  `kpi_desc` varchar(200) DEFAULT '' COMMENT '指标描述',
  `kpi_freq` varchar(50) NOT NULL DEFAULT '' COMMENT '指标频度',
  `kpi_curr` varchar(50) NOT NULL DEFAULT '' COMMENT '指标币种',
  `kpi_status` tinyint(4) DEFAULT '1' COMMENT '状态 1 正常，0 失效，-1 不存在删除',
  `add_user` varchar(50) DEFAULT '' COMMENT '新建指标的用户',
  `add_time` varchar(20) DEFAULT '' COMMENT '添加日期 2016-12-31 12:30:31',
  `expire_dt` varchar(10) DEFAULT '' COMMENT '过期日期，如 2018-12-31',
  PRIMARY KEY (`kpi_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_kpi
-- ----------------------------
INSERT INTO `d_kpi` VALUES ('AR0001', '指标1', '', 'M', 'CNY', '1', '', '', '');
INSERT INTO `d_kpi` VALUES ('AR0002', '指标2', '', 'M', 'CNY', '1', '', '', '');
INSERT INTO `d_kpi` VALUES ('AR0003', '指标3', '', 'M', 'CNY', '1', '', '', '');
INSERT INTO `d_kpi` VALUES ('AR0004', '指标4', '', 'M', 'CNY', '1', '', '', '');

-- ----------------------------
-- Table structure for d_kpi_data
-- ----------------------------
DROP TABLE IF EXISTS `d_kpi_data`;
CREATE TABLE `d_kpi_data` (
  `kpi_code` varchar(20) NOT NULL COMMENT '指标编号',
  `data_dt` varchar(10) NOT NULL COMMENT '数据日期，如2018-12-31',
  `kpi_value` decimal(10,0) NOT NULL COMMENT '指标值',
  `kpi_freq` varchar(2) NOT NULL COMMENT '指标频度外键',
  `org_no` varchar(50) NOT NULL COMMENT '机构编号',
  `kpi_curr` varchar(10) NOT NULL COMMENT '币种，外键',
  `insert_time` varchar(20) DEFAULT NULL COMMENT '添加日期',
  `update_time` varchar(20) DEFAULT NULL COMMENT '修改日期',
  `insert_user` varchar(20) DEFAULT NULL COMMENT '插入数据的用户',
  PRIMARY KEY (`kpi_code`,`data_dt`,`kpi_freq`,`org_no`,`kpi_curr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_kpi_data
-- ----------------------------
