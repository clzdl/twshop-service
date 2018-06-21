/* tw_shop */

DROP TABLE IF EXISTS `base_user`;
/*微信用户信息*/
CREATE TABLE `base_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '微信用户信息',
  `wechat_account_id` bigint(20) DEFAULT NULL COMMENT 'wechat_account表的id',
  `merchant_id` bigint(20) DEFAULT NULL COMMENT '商户id',
  `open_id` varchar(40) NOT NULL DEFAULT '' COMMENT '微信openid',
  `nick_name` varchar(40) NOT NULL DEFAULT '' COMMENT '昵称',
  `country` varchar(40) DEFAULT NULL COMMENT '国家(从微信获取)',
  `province` varchar(40) DEFAULT NULL COMMENT '省份(从微信获取)',
  `city` varchar(40) DEFAULT NULL COMMENT '城市(从微信获取)',
  `unionId` varchar(40) DEFAULT NULL  COMMENT '微信unionid',
  `avator` varchar(256) DEFAULT NULL  COMMENT '微信头像',
  `grant_distribute_tag` tinyint NOT NULL DEFAULT '0' COMMENT '是否具有分销权限;0-否，1-是',
  
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_openid` (`wechat_account_id`,`open_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `base_merchant`;
/*商户信息*/
CREATE TABLE `base_merchant` (
    `id` bigint(20) NOT NULL  AUTO_INCREMENT COMMENT '商户信息',
    `name` varchar(50) NOT NULL DEFAULT '' COMMENT '商户名',
    `logo_url` varchar(50) NOT NULL DEFAULT '' COMMENT 'logo存放路径',
    `contact_man` varchar(10) NOT NULL DEFAULT '' COMMENT '联系人',
    `contact_phone` varchar(20) NOT NULL DEFAULT '' COMMENT '联系电话',
    `description` varchar(256) NOT NULL DEFAULT '' COMMENT '描述',
    `city_code` varchar(6) NOT NULL DEFAULT '' COMMENT '地市代码',
    `address` varchar(128) NOT NULL DEFAULT '' COMMENT '地址',
    `longitude` varchar(20) NOT NULL DEFAULT '' COMMENT '经度',
    `latitude` varchar(20) NOT NULL DEFAULT '' COMMENT '纬度',

    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `base_mall_collect`;
/*商品收藏*/
CREATE TABLE `base_mall_collect` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品收藏',
    `user_id` bigint(20) NOT NULL COMMENT '用户ID',
    `item_id` bigint(20) NOT NULL COMMENT '商品ID',
  
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    INDEX `idx_mall_collect_userid` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `base_area`;
/*行政区域信息*/
CREATE TABLE `base_area` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '行政区域信息',
    `parent_id` bigint(20) NOT NULL COMMENT '父ID',
    `parent_code` varchar(16) NOT NULL COMMENT '父区域编码',
    `area_code` varchar(16) NOT NULL COMMENT '区域编码',
    `area_name` varchar(64) NOT NULL COMMENT '区域名称',
    `area_type` tinyint(1) NOT NULL COMMENT '1省2市3区县',
    `sort_no` int(11) NOT NULL DEFAULT '0' COMMENT '排序号',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    index `idx_area_parentid` (`parent_id`),
    index `idx_area_code` (`area_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



DROP TABLE IF EXISTS `mall_item`;
/*商品*/
CREATE TABLE `mall_item` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品',
    `merchant_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '商户id',
    `name` varchar(40) NOT NULL DEFAULT '' COMMENT '产品名称',
    `category_id` int(11) NOT NULL DEFAULT '0' COMMENT '所属产品分类id',
    `img_url` varchar(128) NOT NULL DEFAULT '' COMMENT '正方形图片',
    `key_word` varchar(100) NOT NULL DEFAULT '' COMMENT '关键字',
    `price` int(11) NOT NULL DEFAULT '0' COMMENT '价格(单位分)',
    `market_price` int(11) NOT NULL DEFAULT '0' COMMENT '市场价格',
    `sale_count` int(11) NOT NULL DEFAULT '0' COMMENT '销售数量',
    `sort_no` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
    `free_postfee` tinyint NOT NULL DEFAULT '0' COMMENT '是否免运费,0-否,1-是',
    `post_fee` int(11) NOT NULL DEFAULT '0' COMMENT '运费',
    `recomend_tag` tinyint NOT NULL DEFAULT '0' COMMENT '是否推荐;0-否；1-是',
    `soul_tag` tinyint NOT NULL DEFAULT '0' COMMENT '是否精品;0-否；1-是',
    `distribute_tag` tinyint DEFAULT '0' COMMENT '是否参与分销;0-否；1-是',
    `status` tinyint DEFAULT '0' COMMENT '状态;0-待上架，1-已上架；2-已下架',

    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `mall_item_sku`;
/* 库存参数*/
CREATE TABLE `mall_item_sku` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品库存',
    `item_id` bigint(20) NOT NULL COMMENT '产品id',
    `quantity` int(11) NOT NULL DEFAULT '0' COMMENT '库存数量',
    `title` varchar(200) NOT NULL DEFAULT '' COMMENT '标题',
    `img_url` varchar(128) NOT NULL DEFAULT '' COMMENT '图片URL',
    `detail` LONGTEXT DEFAULT NULL COMMENT '详情',
    `price` int(11) NOT NULL DEFAULT '0' COMMENT '价格(单位分)',
    `market_price` int(11) NOT NULL DEFAULT '0' COMMENT '市场价格(单位分)',
    `size` varchar(40) NOT NULL DEFAULT '' COMMENT '尺寸',
    `color` varchar(10) NOT NULL  DEFAULT '' COMMENT '颜色',
    `volume` varchar(10) NOT NULL  DEFAULT '' COMMENT '体积',
    `weight` varchar(10) NOT NULL  DEFAULT '' COMMENT '重量',
    `version` int(11) NOT NULL  DEFAULT '0' COMMENT '数据版本,乐观锁',

    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    index `idx_sku_itemid` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



DROP TABLE IF EXISTS `mall_sku_img`;
/* 库存产品参数图片 */
CREATE TABLE `mall_sku_img` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '库存产品参数图片',
    `sku_id` bigint(20) NOT NULL COMMENT '所述skuId',
    `img_url` varchar(128) NOT NULL DEFAULT '' COMMENT '图片地址',
    `img_type` tinyint DEFAULT '0' COMMENT '图片类型;0-BANNER,1-详情',
    `sort_no` int(11) NOT NULL DEFAULT '0' COMMENT '排序号',

    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    index `idx_skuimg_skuid` (`sku_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



DROP TABLE IF EXISTS `mall_cart`;
/*购物车*/
CREATE TABLE `mall_cart` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车',
    `user_id` int(11) NOT NULL COMMENT '用户ID',
    `item_id` bigint(20) NOT NULL COMMENT '产品id',
    `sku_id` bigint(20) NOT NULL COMMENT '产品参数id',
    `merchant_id` bigint(20) NOT NULL COMMENT '商户ID',
    `quantity` int(11) NOT NULL COMMENT '数量',

    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    index `idx_cart_userid` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



DROP TABLE IF EXISTS `mall_order`;
/*商品订单*/
CREATE TABLE `mall_order` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品订单',
    `user_id` bigint(20) NOT NULL COMMENT '用户Id',
    `merchant_id` bigint(20) NOT NULL COMMENT '商户ID',
    `amount` int(11) DEFAULT NULL COMMENT '总数量',
    `pay_status` tinyint DEFAULT '0' COMMENT '支付状态；0-未支付；1-已支付；2-已退款',
    `pay_time` datetime DEFAULT NULL COMMENT '支付时间',


    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    index `idx_mallorder_userid` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `mall_order_item`;
/*商品订单项*/
CREATE TABLE `mall_order_item` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品订单项',
    `mall_order_id` bigint(20) NOT NULL COMMENT '商品订单Id',
    `item_id` bigint(20) NOT NULL COMMENT '产品ID',
    `sku_id` bigint(20) NOT NULL COMMENT 'sku_id',
    `title` varchar(100) NOT NULL COMMENT '产品名称',
    `quantity` int(11) NOT NULL COMMENT '数量',
    `price` int(11) NOT NULL COMMENT '价格(单位分)',

    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    index `idx_mallorderitem_orderid` (`mall_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `mall_category`;
/*商品分类*/
CREATE TABLE `mall_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品分类',
  `name` varchar(40) NOT NULL DEFAULT '' COMMENT '分类名称',
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父类Id',
  `img_url` varchar(128) NOT NULL DEFAULT '' COMMENT '图片URL',
  `path_ids` varchar(16) NOT NULL DEFAULT '' COMMENT '节点路径id串;如: 0,1,2',
  `sort_no` int(11) NOT NULL DEFAULT '0' COMMENT '排序号',
  `merchant_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '商户ID',

  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `web_order`;
/*费用支付订单*/
CREATE TABLE `web_order` (
    `id` bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '费用支付订单',
    `user_id` bigint(20) NOT NULL COMMENT '用户Id',
    `merchant_id` bigint(20) NOT NULL COMMENT '商户ID',
    `obj_type` tinyint DEFAULT '0' COMMENT '对象类型:0-普通商品',
    `obj_id` bigint(20) DEFAULT '0' COMMENT '对象ID',
    `total_fee` int(11) NOT NULL COMMENT '总金额(单位分)',
    `discount_fee` int(11) NOT NULL COMMENT '总优惠金额',
    `pay_fee` int(11) NOT NULL COMMENT '实际支付金额',
    `pay_method` tinyint DEFAULT '0' COMMENT '支付方式；0-微信；1-支付宝',
    `pay_status` tinyint DEFAULT '0' COMMENT '支付状态；0-未支付；1-已支付；2-已退款',
    `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
    `deliver_addr` varchar(256) NOT NULL DEFAULT '' COMMENT '用户邮寄地址',
    `express_type` tinyint NOT NULL DEFAULT '0' COMMENT '快递类型',
    `express_no` varchar(64) NOT NULL DEFAULT '' COMMENT '快递单号',
    `remark` varchar(50) NOT NULL DEFAULT '' COMMENT '备忘录',
    `ip` varchar(16) DEFAULT NULL COMMENT 'ip',
    `status` tinyint DEFAULT '0' COMMENT '订单状态:0-待支付,1-待发货,2-待收货,3-已收货,4-申请退货,5-已退货,6-订单结束',

    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    INDEX `idx_weborder_userid` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



DROP TABLE IF EXISTS `weborder_paycache`;
/*订单缓存，则回退占用资源*/
CREATE TABLE `weborder_paycache` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单详情Id',
    `rec_type` tinyint DEFAULT '0' COMMENT '状态;0-待支付订单;',
    `obj_id` bigint(20) DEFAULT NULL COMMENT '订单ID',
    `expire_time` CHAR(14) NOT NULL DEFAULT '00000000000000' COMMENT '订单过期时间',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    index idx_weborder_paycache_objid(`obj_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `distribute_relation`;
/* 分销关系 */
CREATE TABLE `distribute_relation` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '分销关系',
    `user_id` bigint(20) NOT NULL COMMENT '分享人',
    `lower_user_id` bigint(20) NOT NULL  COMMENT '被分享人',
    `merchant_id` bigint(20) NOT NULL COMMENT '商户ID',
    
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    INDEX `idx_relation_userId` (`user_id`),
    INDEX `idx_relation_lower_userId` (`lower_user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `distribute_reward`;
/*分销奖励记录*/
CREATE TABLE `distribute_reward` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '分销奖励',
    `user_id` bigint(20) NOT NULL COMMENT '用户id',
    `lower_user_id` bigint(20) NOT NULL COMMENT '被提成的用户id',
    `merchant_id` bigint(20) NOT NULL COMMENT '商户ID',
    `web_order_id` bigint(20) NOT NULL COMMENT '支付订单id',
    `ratio` decimal(10,2) NOT NULL DEFAULT '0' COMMENT '提成比例',
    `money` int(11) NOT NULL DEFAULT '0' COMMENT '提成金额',
    `extract_money` decimal(10,2) NOT NULL DEFAULT '0' COMMENT '提取金额',
    `extract_id` bigint(20) NOT NULL  COMMENT '提取记录id',
    `status` tinyint  NOT NULL DEFAULT '0' COMMENT '状态;0-未提取,1-部分提取,2-已提取,3-已退款',
    
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    INDEX `idx_reward_userid` (`user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `distribute_reward_extract`;
/*分销奖励提取记录*/
CREATE TABLE `distribute_reward_extract` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '分销奖励提取记录',
    `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户id',
    `merchant_id` bigint(20) NOT NULL COMMENT '商户ID',
    `money` int(11) NOT NULL COMMENT '提取金额',

    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    INDEX `idx_extract_userid` (`user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `distribute_ratio`;
/*商户应用分销比例参数*/
CREATE TABLE `distribute_ratio` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '商户应用分销比例参数',
    `merchant_id` bigint(20) NOT NULL  COMMENT '商户ID',
    `grade` tinyint NOT NULL DEFAULT '0' COMMENT '等级;0-一级，1-二级',
    `ratio` decimal(10,2) NOT NULL DEFAULT '0.0' COMMENT '比例值',
    
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    INDEX `idx_distribute_ratio` (`merchant_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



/*微信公众号配置*/
DROP TABLE IF EXISTS `wechat_account`;

CREATE TABLE `wechat_account` (
    `id` bigint(20) NOT NULL  AUTO_INCREMENT COMMENT '微信公众号配置',
    `merchant_id` bigint(20) NOT NULL  COMMENT '商户ID',
    `app_type` tinyint NOT NULL DEFAULT '0'  COMMENT '类型;0-公众号,1-小程序',
    `app_id` varchar(40) NOT NULL DEFAULT '' COMMENT '微信公众号',
    `app_name` varchar(20) NOT NULL DEFAULT '' COMMENT 'APP名称',
    `app_secret` varchar(40) NOT NULL DEFAULT '' COMMENT '微信app秘钥',
    `merchant_pay_no` varchar(40) DEFAULT '' COMMENT '微信商户支付号',
    `merchant_pay_key` varchar(40) DEFAULT '' COMMENT '微信商户支付key',
    `notify_url` varchar(256) DEFAULT '' COMMENT '回调地址',
    `token` varchar(40) DEFAULT '' COMMENT '微信接入token',
    `access_token` varchar(512) NOT NULL DEFAULT '' COMMENT '微信基本token',
    `expires_in` CHAR(14) NOT NULL DEFAULT '00000000000000' COMMENT '微信基本token过期时间',
  
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    INDEX `idx_wechat_account_merchantid` (`merchant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



DROP TABLE IF EXISTS `wechat_token_cache`;
/*微信token缓存*/
CREATE TABLE `wechat_token_cache` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '微信token缓存',
    `account_id` bigint(20) DEFAULT NULL COMMENT 'wechat_account表的id',
    `token` varchar(256) DEFAULT NULL COMMENT '拉取的token串',
    `token_type` TINYINT DEFAULT NULL COMMENT '类型；0-jsapi',
    `expires_in` CHAR(14) NOT NULL DEFAULT '00000000000000' COMMENT '票据过期时间',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    INDEX `idx_wechat_tokencache_accountid` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



