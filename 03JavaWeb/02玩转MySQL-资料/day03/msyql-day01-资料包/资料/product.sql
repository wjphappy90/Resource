--
-- 表的结构 `product`
--
CREATE TABLE IF NOT EXISTS `product` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_name` varchar(100) NOT NULL,
  `protype_id` int(11) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `pinpai` varchar(25) NOT NULL,
  `chandi` varchar(25) NOT NULL,
  PRIMARY KEY (`pro_id`),
  KEY `pro_name` (`pro_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='商品信息表' AUTO_INCREMENT=16 ;

--
-- 转存表中的数据 `product`
--

INSERT INTO `product` (`pro_id`, `pro_name`, `protype_id`, `price`, `pinpai`, `chandi`) VALUES
(1, '康佳（KONKA）42英寸全高清液晶电视', 1, '1999.00', '康佳', '深圳'),
(2, '索尼（SONY）4G手机（黑色）', 2, '3238.00', '索尼', '深圳'),
(3, '海信（Hisense）55英寸智能电视', 1, '4199.00', '海信', '青岛'),
(4, '联想（Lenovo）14.0英寸笔记本电脑', 3, '5499.00', '联想', '北京'),
(5, '索尼（SONY）13.3英寸触控超极本', 3, '11499.00', '索尼', '天津'),
(11, '索尼（SONY）60英寸全高清液晶电视', 1, '6999.00', '索尼', '北京'),
(12, '联想（Lenovo）14.0英寸笔记本电脑', 3, '2999.00', '联想', '北京'),
(13, '联想 双卡双待3G手机', 2, '988.00', '联想', '北京'),
(15, '惠普（HP）黑白激光打印机', 3, '1169.00', '惠普', '天津');
