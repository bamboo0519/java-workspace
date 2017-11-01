DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` varchar(64) DEFAULT NULL COMMENT '账户号',
  `account_name` varchar(64) DEFAULT NULL COMMENT '账户名',
  `password` varchar(128) DEFAULT NULL COMMENT '密码',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',

  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='账户表';