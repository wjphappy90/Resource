CREATE TABLE `article` (
  `aid` int(11) NOT NULL auto_increment COMMENT '主键',
  `author` varchar(255) default NULL COMMENT '作者',
  `createTime` datetime default NULL COMMENT '创建时间',
  `title` varchar(255) default NULL COMMENT '标题',
  PRIMARY KEY  (`aid`)
);