/*系统管理-菜单*/
CREATE TABLE `sys_menu` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '系统菜单表',
    `name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '菜单名称',
    `href` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '菜单链接地址',
    `parent_id` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '父节点id',
    `icon` VARCHAR(15) NOT NULL DEFAULT 'fa-navicon' COMMENT '菜单icon',
    `sort_no` INT(11) NOT NULL DEFAULT '0' COMMENT '排序号',
     
    `create_time` INT(11) NOT NULL DEFAULT '0' COMMENT '创建日期',
    `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB;

/*系统管理-系统用户*/
CREATE TABLE `sys_user` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '系统用户表',
    `user_name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '姓名',
    `user_tel` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '手机',
    `user_email` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '邮箱',
    `user_sex` CHAR(1) NOT NULL DEFAULT '1' COMMENT '性别，1男 0女',
    `user_login` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '登陆名',
    `user_pwd` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '密码',
    `user_type` TINYINT NOT NULL DEFAULT '0' COMMENT '用户类型;0-系统，1-商户',
    `org_id` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '所属机构id',
    `merchant_id` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '商户ID',
    
    `create_time` INT(11) NOT NULL DEFAULT '0' COMMENT '创建日期',
    `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB;

/*系统管理-组织机构*/
CREATE TABLE `sys_org` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '组织结构表',
    `org_name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '名称',
    `parent_id` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '父节点id',
    
    `create_time` INT(11) NOT NULL DEFAULT '0' COMMENT '创建日期',
    `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB;

/*系统管理-角色*/
CREATE TABLE `sys_role` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '系统角色表',
    `role_name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '名称',
    `description` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '说明',
    
    `create_time` INT(11) NOT NULL DEFAULT '0' COMMENT '创建日期',
    `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB;

/*系统管理-角色菜单中间表*/
CREATE TABLE `sys_role_menu` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '系统角色菜单关系表',
    `sys_role_id` BIGINT(20) NOT NULL  DEFAULT '0' COMMENT '角色id',
    `sys_menu_id` BIGINT(20) NOT NULL  DEFAULT '0' COMMENT '菜单id',
    
    `create_time` INT(11) NOT NULL DEFAULT '0' COMMENT '创建日期',
    `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB;

/*系统管理-角色用户中间表*/
CREATE TABLE `sys_role_user` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '系统角色用户关系表',
    `sys_role_id` BIGINT(20) NOT NULL  DEFAULT '0' COMMENT '角色id',
    `sys_user_id` BIGINT(20) NOT NULL  DEFAULT '0' COMMENT '用户id',
    
    `create_time` INT(11) NOT NULL DEFAULT '0' COMMENT '创建日期',
    `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB;

/*系统管理-系统操作日志*/
CREATE TABLE `sys_operation_log` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '系统操作日志表',
    `sys_user_id` BIGINT(11) NOT NULL  DEFAULT '0' COMMENT '用户id',
    `contents` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '日志',
    
    `create_time` INT(11) NOT NULL DEFAULT '0' COMMENT '创建日期',
    `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB;



INSERT INTO `sys_menu` (`id`, `name`, `href`, `parent_id`, `sort_no`) VALUES (1, '修改密码', '/sysuser/toeditpwd', 0, 1);
INSERT INTO `sys_menu` (`id`, `name`, `href`, `parent_id`, `sort_no`) VALUES (2, '系统管理', '', 0, 2);
INSERT INTO `sys_menu` (`id`, `name`, `href`, `parent_id`, `sort_no`) VALUES (21, '机构管理', '/sysorg/index', 2, 21);
INSERT INTO `sys_menu` (`id`, `name`, `href`, `parent_id`, `sort_no`) VALUES (22, '人员管理', '/sysuser/list', 2, 22);
INSERT INTO `sys_menu` (`id`, `name`, `href`, `parent_id`, `sort_no`) VALUES (23, '角色管理', '/sysrole/list', 2, 23);
INSERT INTO `sys_menu` (`id`, `name`, `href`, `parent_id`, `sort_no`) VALUES (24, '菜单管理', '/sysmenu/list', 2, 24);

/*初始化组织机构 */
insert into `sys_org` (id, create_time, org_name, parent_id) values (1, unix_timestamp('20170320100000'), '总部', '0');

/*初始化角色菜单*/
INSERT INTO `sys_role` (`id`, `role_name`, `description`) VALUES (1, 'admin', '系统管理员');

INSERT INTO `sys_role_menu` (`sys_role_id`, `sys_menu_id`) VALUES ( 1, 1);
INSERT INTO `sys_role_menu` (`sys_role_id`, `sys_menu_id`) VALUES ( 1, 2);
INSERT INTO `sys_role_menu` (`sys_role_id`, `sys_menu_id`) VALUES ( 1, 21);
INSERT INTO `sys_role_menu` (`sys_role_id`, `sys_menu_id`) VALUES ( 1, 22);
INSERT INTO `sys_role_menu` (`sys_role_id`, `sys_menu_id`) VALUES ( 1, 23);
INSERT INTO `sys_role_menu` (`sys_role_id`, `sys_menu_id`) VALUES ( 1, 24);

/*初始化角色用户*/
INSERT INTO `sys_role_user` (`id`, `sys_role_id`, `sys_user_id`) VALUES (1, 1, 1);
/*password  123456*/
INSERT INTO `sys_user` (`id`, `user_name`, `user_email`, `user_tel`, `user_sex`, `user_login`, `user_pwd`, `org_id`) 
    VALUES (1, '管理员', 'admin@anxun.com', '18645005420', '1', 'admin@anxun.com', 'e10adc3949ba59abbe56e057f20f883e', 1);

