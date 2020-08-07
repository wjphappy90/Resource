/*创建客户表*/
CREATE TABLE `cst_customer` (
  `cust_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
  `cust_name` varchar(32) NOT NULL COMMENT '客户名称(公司名称)',
  `cust_source` varchar(32) DEFAULT NULL COMMENT '客户信息来源',
  `cust_industry` varchar(32) DEFAULT NULL COMMENT '客户所属行业',
  `cust_level` varchar(32) DEFAULT NULL COMMENT '客户级别',
  `cust_address` varchar(128) DEFAULT NULL COMMENT '客户联系地址',
  `cust_phone` varchar(64) DEFAULT NULL COMMENT '客户联系电话',
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

/*创建联系人表*/
CREATE TABLE `cst_linkman` (
  `lkm_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '联系人编号(主键)',
  `lkm_name` varchar(16) DEFAULT NULL COMMENT '联系人姓名',
  `lkm_gender` char(1) DEFAULT NULL COMMENT '联系人性别',
  `lkm_phone` varchar(16) DEFAULT NULL COMMENT '联系人办公电话',
  `lkm_mobile` varchar(16) DEFAULT NULL COMMENT '联系人手机',
  `lkm_email` varchar(64) DEFAULT NULL COMMENT '联系人邮箱',
  `lkm_position` varchar(16) DEFAULT NULL COMMENT '联系人职位',
  `lkm_memo` varchar(512) DEFAULT NULL COMMENT '联系人备注',
  `lkm_cust_id` bigint(32) NOT NULL COMMENT '客户id(外键)',
  PRIMARY KEY (`lkm_id`),
  KEY `FK_cst_linkman_lkm_cust_id` (`lkm_cust_id`),
  CONSTRAINT `FK_cst_linkman_lkm_cust_id` FOREIGN KEY (`lkm_cust_id`) REFERENCES `cst_customer` (`cust_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


/*创建数据字典表*/
CREATE TABLE `base_dict` (
  `dict_id` varchar(32) NOT NULL COMMENT '数据字典id(主键)',
  `dict_type_code` varchar(10) NOT NULL COMMENT '数据字典类别代码',
  `dict_type_name` varchar(64) NOT NULL COMMENT '数据字典类别名称',
  `dict_item_name` varchar(64) NOT NULL COMMENT '数据字典项目名称',
  `dict_item_code` varchar(10) DEFAULT NULL COMMENT '数据字典项目(可为空)',
  `dict_sort` int(10) DEFAULT NULL COMMENT '排序字段',
  `dict_enable` char(1) NOT NULL COMMENT '1:使用 0:停用',
  `dict_memo` varchar(64) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*为字典表插入数据：Data for the table `base_dict` */

LOCK TABLES `base_dict` WRITE;

insert  into `base_dict`(`dict_id`,`dict_type_code`,`dict_type_name`,`dict_item_name`,`dict_item_code`,`dict_sort`,`dict_enable`,`dict_memo`) 
values ('1','001','客户行业','教育培训 ',NULL,1,'1',NULL),
('10','003','公司性质','民企',NULL,3,'1',NULL),
('12','004','年营业额','1-10万',NULL,1,'1',NULL),
('13','004','年营业额','10-20万',NULL,2,'1',NULL),
('14','004','年营业额','20-50万',NULL,3,'1',NULL),
('15','004','年营业额','50-100万',NULL,4,'1',NULL),
('16','004','年营业额','100-500万',NULL,5,'1',NULL),
('17','004','年营业额','500-1000万',NULL,6,'1',NULL),
('18','005','客户状态','基础客户',NULL,1,'1',NULL),
('19','005','客户状态','潜在客户',NULL,2,'1',NULL),
('2','001','客户行业','电子商务',NULL,2,'1',NULL),
('20','005','客户状态','成功客户',NULL,3,'1',NULL),
('21','005','客户状态','无效客户',NULL,4,'1',NULL),
('22','006','客户级别','普通客户',NULL,1,'1',NULL),
('23','006','客户级别','VIP客户',NULL,2,'1',NULL),
('24','007','商机状态','意向客户',NULL,1,'1',NULL),
('25','007','商机状态','初步沟通',NULL,2,'1',NULL),
('26','007','商机状态','深度沟通',NULL,3,'1',NULL),
('27','007','商机状态','签订合同',NULL,4,'1',NULL),
('3','001','客户行业','对外贸易',NULL,3,'1',NULL),
('30','008','商机类型','新业务',NULL,1,'1',NULL),
('31','008','商机类型','现有业务',NULL,2,'1',NULL),
('32','009','商机来源','电话营销',NULL,1,'1',NULL),
('33','009','商机来源','网络营销',NULL,2,'1',NULL),
('34','009','商机来源','推广活动',NULL,3,'1',NULL),
('4','001','客户行业','酒店旅游',NULL,4,'1',NULL),
('5','001','客户行业','房地产',NULL,5,'1',NULL),
('6','002','客户信息来源','电话营销',NULL,1,'1',NULL),
('7','002','客户信息来源','网络营销',NULL,2,'1',NULL),
('8','003','公司性质','合资',NULL,1,'1',NULL),
('9','003','公司性质','国企',NULL,2,'1',NULL);
UNLOCK TABLES;
