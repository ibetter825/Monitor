/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50715
Source Host           : 127.0.0.1:3306
Source Database       : monitor

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-07-19 15:04:04
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
  `org_id` varchar(50) NOT NULL COMMENT '机构编号',
  `org_pid` varchar(50) DEFAULT '' COMMENT '机构父编号',
  `org_name` varchar(100) NOT NULL DEFAULT '' COMMENT '机构名称',
  `org_desc` varchar(200) DEFAULT '',
  `org_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态: 0 失效，1 正常，-1 删除',
  `org_seq` int(11) DEFAULT '0' COMMENT '排序',
  `org_level` tinyint(4) DEFAULT '0' COMMENT '机构级别',
  `org_pids` varchar(500) DEFAULT '' COMMENT '所有父级机构编号/隔开',
  PRIMARY KEY (`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_organ
-- ----------------------------
INSERT INTO `c_organ` VALUES ('1', '', '总', null, '1', '0', '0', '/1/');
INSERT INTO `c_organ` VALUES ('1001', '1', '二级1', null, '1', '0', '1', '/1/1001/');
INSERT INTO `c_organ` VALUES ('1001001', '1001', '三级1', null, '1', '0', '2', '/1/1001/1001001/');
INSERT INTO `c_organ` VALUES ('1002', '1', '二级2', null, '1', '1', '1', '/1/1002/');

-- ----------------------------
-- Table structure for c_page_part
-- ----------------------------
DROP TABLE IF EXISTS `c_page_part`;
CREATE TABLE `c_page_part` (
  `part_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `part_no` int(11) NOT NULL DEFAULT '0' COMMENT '页面模块编号',
  `menu_id` varchar(50) NOT NULL DEFAULT '' COMMENT '菜单编号',
  `part_title` varchar(100) DEFAULT '' COMMENT '模块标题',
  `part_seq` int(11) DEFAULT '0' COMMENT '模块排序',
  `part_desc` varchar(200) DEFAULT '' COMMENT '模块描述',
  `part_tip` varchar(100) DEFAULT '' COMMENT '例如: 币种：人民币 单位：万元',
  `part_freq` varchar(20) NOT NULL COMMENT '模块查询数据频度',
  `part_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态 1 正常 0 不可用',
  `part_style` varchar(200) DEFAULT '' COMMENT '样式',
  PRIMARY KEY (`part_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单页面模块配置';

-- ----------------------------
-- Records of c_page_part
-- ----------------------------

-- ----------------------------
-- Table structure for c_page_part_element
-- ----------------------------
DROP TABLE IF EXISTS `c_page_part_element`;
CREATE TABLE `c_page_part_element` (
  `ele_id` int(11) NOT NULL AUTO_INCREMENT,
  `part_id` int(11) DEFAULT NULL,
  `ele_type` varchar(255) DEFAULT NULL,
  `ele_style` varchar(255) DEFAULT NULL,
  `ele_cont` varchar(255) DEFAULT '' COMMENT '内容，包括echarts,grid等',
  `ele_seq` int(11) DEFAULT '0',
  PRIMARY KEY (`ele_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_page_part_element
-- ----------------------------

-- ----------------------------
-- Table structure for c_role
-- ----------------------------
DROP TABLE IF EXISTS `c_role`;
CREATE TABLE `c_role` (
  `role_id` varchar(20) NOT NULL COMMENT '角色主键，自定义',
  `role_name` varchar(100) NOT NULL DEFAULT '' COMMENT '角色名称',
  `role_desc` varchar(200) DEFAULT '' COMMENT '角色描述',
  `org_id` varchar(50) DEFAULT '' COMMENT '机构编号',
  `dep_id` varchar(50) DEFAULT '' COMMENT '部门编号',
  `role_status` tinyint(4) DEFAULT '1' COMMENT '状态 1 正常，0 失效，-1 删除',
  `role_seq` int(11) DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of c_role
-- ----------------------------
INSERT INTO `c_role` VALUES ('super', '超级管理员', '', '', '1', '1', '0');
INSERT INTO `c_role` VALUES ('test', '测试角色', '', '', '1', '1', '1');
INSERT INTO `c_role` VALUES ('test02', '测试角色02', '', '', '1', '1', '2');

-- ----------------------------
-- Table structure for c_user
-- ----------------------------
DROP TABLE IF EXISTS `c_user`;
CREATE TABLE `c_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号自增',
  `user_name` varchar(100) DEFAULT '' COMMENT '用户登录名',
  `user_phone` char(11) DEFAULT '' COMMENT '用户手机号码',
  `user_email` varchar(200) DEFAULT '' COMMENT '用户邮箱',
  `user_status` tinyint(4) DEFAULT '1' COMMENT '状态 1正常 0 失效,禁用 -1软删除',
  `user_pwd` varchar(100) NOT NULL DEFAULT '' COMMENT '加密后的密码',
  `user_salt` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10013 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_user
-- ----------------------------
INSERT INTO `c_user` VALUES ('10000', 'admin', '1340845888', '', '1', '', '');
INSERT INTO `c_user` VALUES ('10004', 'test01', '13408888888', 'test_01@gmail.com', '1', 'A0B08BA9515935411312353D8EA43E58', 'MONITOR');
INSERT INTO `c_user` VALUES ('10005', 'test02', '17676777777', '66s7@qq.com', '-1', 'A0B08BA9515935411312353D8EA43E58', 'MONITOR');
INSERT INTO `c_user` VALUES ('10006', 'tsoft', 'ddd', 'ddd@qq.com', '1', 'A0B08BA9515935411312353D8EA43E58', 'MONITOR');
INSERT INTO `c_user` VALUES ('10008', 'test02', '', '', '1', 'A0B08BA9515935411312353D8EA43E58', 'MONITOR');
INSERT INTO `c_user` VALUES ('10009', 'test03', '', '', '1', 'A0B08BA9515935411312353D8EA43E58', 'MONITOR');
INSERT INTO `c_user` VALUES ('10010', 'test04', '', '', '1', 'A0B08BA9515935411312353D8EA43E58', 'MONITOR');
INSERT INTO `c_user` VALUES ('10011', 'test05', '', '', '1', 'A0B08BA9515935411312353D8EA43E58', 'MONITOR');
INSERT INTO `c_user` VALUES ('10012', 'test06', '', '', '-1', 'A0B08BA9515935411312353D8EA43E58', 'MONITOR');

-- ----------------------------
-- Table structure for c_user_info
-- ----------------------------
DROP TABLE IF EXISTS `c_user_info`;
CREATE TABLE `c_user_info` (
  `info_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `nick_name` varchar(200) DEFAULT '',
  `user_avatar` varchar(1000) DEFAULT NULL,
  `add_time` bigint(20) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`info_id`),
  KEY `FK_86eps06tvhl88fpbqy7jx6hml` (`user_id`),
  KEY `FK_kyk8tri3xh2c4sgcqw4m88cyu` (`user_id`),
  CONSTRAINT `FK_kyk8tri3xh2c4sgcqw4m88cyu` FOREIGN KEY (`user_id`) REFERENCES `c_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10023 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_user_info
-- ----------------------------
INSERT INTO `c_user_info` VALUES ('10005', '10000', '超级管理员', null, null, '1531323719479');
INSERT INTO `c_user_info` VALUES ('10011', '10004', '测试01', null, '1530673803293', '1531451178915');
INSERT INTO `c_user_info` VALUES ('10012', '10005', '测试01', null, '1530674112754', null);
INSERT INTO `c_user_info` VALUES ('10015', '10006', 'dddd', null, '1530771191856', '1531320244143');
INSERT INTO `c_user_info` VALUES ('10018', '10008', '测试02', null, '1531228562226', null);
INSERT INTO `c_user_info` VALUES ('10019', '10009', 'test03', null, '1531228574853', '1531228588361');
INSERT INTO `c_user_info` VALUES ('10020', '10010', 'test04', null, '1531228597748', null);
INSERT INTO `c_user_info` VALUES ('10021', '10011', 'test05', null, '1531228608934', null);
INSERT INTO `c_user_info` VALUES ('10022', '10012', 'test06', null, '1531228619686', null);

-- ----------------------------
-- Table structure for c_user_organ
-- ----------------------------
DROP TABLE IF EXISTS `c_user_organ`;
CREATE TABLE `c_user_organ` (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `org_id` varchar(50) NOT NULL COMMENT '机构id',
  PRIMARY KEY (`user_id`,`org_id`),
  KEY `FK_aoganjnf6bftucyb2ucu4ei4x` (`org_id`),
  KEY `FK_ffibanc50dibw1syn7i8phlj0` (`user_id`),
  CONSTRAINT `FK_aoganjnf6bftucyb2ucu4ei4x` FOREIGN KEY (`org_id`) REFERENCES `c_organ` (`org_id`),
  CONSTRAINT `FK_ffibanc50dibw1syn7i8phlj0` FOREIGN KEY (`user_id`) REFERENCES `c_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户机构关系表';

-- ----------------------------
-- Records of c_user_organ
-- ----------------------------
INSERT INTO `c_user_organ` VALUES ('10000', '1');
INSERT INTO `c_user_organ` VALUES ('10004', '1');
INSERT INTO `c_user_organ` VALUES ('10006', '1001');
INSERT INTO `c_user_organ` VALUES ('10006', '1001001');
INSERT INTO `c_user_organ` VALUES ('10008', '1001001');
INSERT INTO `c_user_organ` VALUES ('10009', '1');
INSERT INTO `c_user_organ` VALUES ('10010', '1001');
INSERT INTO `c_user_organ` VALUES ('10011', '1001001');
INSERT INTO `c_user_organ` VALUES ('10012', '1001');

-- ----------------------------
-- Table structure for c_user_role
-- ----------------------------
DROP TABLE IF EXISTS `c_user_role`;
CREATE TABLE `c_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_ryx81a2lxs8gia9b88uqx16y6` (`role_id`),
  KEY `FK_pnmkqxfhkfoup945qhjst4k4r` (`user_id`),
  CONSTRAINT `FK_pnmkqxfhkfoup945qhjst4k4r` FOREIGN KEY (`user_id`) REFERENCES `c_user` (`user_id`),
  CONSTRAINT `FK_ryx81a2lxs8gia9b88uqx16y6` FOREIGN KEY (`role_id`) REFERENCES `c_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_user_role
-- ----------------------------
INSERT INTO `c_user_role` VALUES ('10000', 'super');
INSERT INTO `c_user_role` VALUES ('10004', 'test');
INSERT INTO `c_user_role` VALUES ('10004', 'test02');
INSERT INTO `c_user_role` VALUES ('10006', 'test02');
INSERT INTO `c_user_role` VALUES ('10010', 'test');
INSERT INTO `c_user_role` VALUES ('10012', 'test02');

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
