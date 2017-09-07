-- 账户自然属性表 --
CREATE TABLE IF NOT EXISTS `account` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account_id`   varchar(64)  DEFAULT NULL COMMENT '账户id',

  `account_name` varchar(64) DEFAULT NULL COMMENT '',
  `password` varchar(128) DEFAULT 0 COMMENT '',
  `mobile` varchar(12) DEFAULT NULL COMMENT '',
  `email` varchar(64) DEFAULT NULL COMMENT '',

  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) COMMENT='账户表' DEFAULT CHARSET=utf8;