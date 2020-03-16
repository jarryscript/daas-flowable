
-- BUILD WITH MODEL TIME 200220T0957
-- Turn off safe mode
SET SQL_SAFE_UPDATES = 0;


drop database  if exists flowable;
create database flowable;
-- alter  database flowable  character set = utf8mb4  collate = utf8mb4_unicode_ci; -- 支持表情符号
use flowable;
set SESSION sql_mode='';

drop table  if exists platform_data;
create table platform_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(12)                              comment '名称',
	founded                       	datetime                                 comment '成立',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "平台";
-- primary key will be created later for better import performance

drop table  if exists user_data;
create table user_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(12)                              comment '名称',
	mobile                        	varchar(44)                              comment '手机号码',
	avatar                        	varchar(28)                              comment '头像',
	age                           	int                                      comment '年龄',
	description                   	longtext                                 comment '描述',
	district                      	varchar(48)                              comment '区/县',
	role                          	varchar(48)                              comment '角色',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户";
-- primary key will be created later for better import performance

drop table  if exists role_data;
create table role_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(8)                               comment '名称',
	code                          	varchar(32)                              comment '编码',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "角色";
-- primary key will be created later for better import performance

drop table  if exists leave_record_data;
create table leave_record_data (
	id                            	varchar(48)          not null            comment 'ID',
	user                          	varchar(48)                              comment '用户',
	type                          	varchar(48)                              comment '类型',
	fromdate                      	date                                     comment 'Fromdate',
	todate                        	date                                     comment '迄今为止,',
	platform                      	varchar(48)                              comment '平台',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "留下记录";
-- primary key will be created later for better import performance

drop table  if exists leave_record_type_data;
create table leave_record_type_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(8)                               comment '名称',
	code                          	varchar(64)                              comment '编码',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "离开记录类型";
-- primary key will be created later for better import performance

drop table  if exists holyday_setting_data;
create table holyday_setting_data (
	id                            	varchar(48)          not null            comment 'ID',
	type                          	varchar(48)                              comment '类型',
	leave_days                    	int                                      comment '离开的日子',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "宗教节日的设置";
-- primary key will be created later for better import performance

drop table  if exists province_data;
create table province_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(120)                             comment '名称',
	platform                      	varchar(48)                              comment '平台',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "省";
-- primary key will be created later for better import performance

drop table  if exists city_data;
create table city_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(120)                             comment '名称',
	province                      	varchar(48)                              comment '省',
	platform                      	varchar(48)                              comment '平台',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "城市";
-- primary key will be created later for better import performance

drop table  if exists district_data;
create table district_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(120)                             comment '名称',
	city                          	varchar(48)                              comment '城市',
	platform                      	varchar(48)                              comment '平台',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "区/县";
-- primary key will be created later for better import performance

drop table  if exists user_domain_data;
create table user_domain_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(16)                              comment '名称',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户域";
-- primary key will be created later for better import performance

drop table  if exists user_white_list_data;
create table user_white_list_data (
	id                            	varchar(48)          not null            comment 'ID',
	user_identity                 	varchar(40)                              comment '用户身份',
	user_special_functions        	varchar(200)                             comment '用户特殊功能',
	domain                        	varchar(48)                              comment '域',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户白名单";
-- primary key will be created later for better import performance

drop table  if exists sec_user_data;
create table sec_user_data (
	id                            	varchar(48)          not null            comment 'ID',
	login                         	varchar(256)                             comment '登录',
	mobile                        	varchar(11)                              comment '手机号码',
	email                         	varchar(256)                             comment '电子邮件',
	pwd                           	varchar(64)                              comment '密码',
	weixin_openid                 	varchar(128)                             comment '微信openid',
	weixin_appid                  	varchar(128)                             comment '微信Appid',
	access_token                  	varchar(128)                             comment '访问令牌',
	verification_code             	int                                      comment '验证码',
	verification_code_expire      	datetime                                 comment '验证码过期',
	last_login_time               	datetime                                 comment '最后登录时间',
	domain                        	varchar(48)                              comment '域',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "安全用户";
-- primary key will be created later for better import performance

drop table  if exists user_app_data;
create table user_app_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(300)                             comment '标题',
	sec_user                      	varchar(48)                              comment '安全用户',
	app_icon                      	varchar(36)                              comment '应用程序图标',
	full_access                   	tinyint                                  comment '完全访问',
	permission                    	varchar(16)                              comment '许可',
	object_type                   	varchar(100)                             comment '访问对象类型',
	object_id                     	varchar(40)                              comment '对象ID',
	location                      	varchar(48)                              comment '位置',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户应用程序";
-- primary key will be created later for better import performance

drop table  if exists quick_link_data;
create table quick_link_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '名称',
	icon                          	varchar(200)                             comment '图标',
	image_path                    	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment '图片路径',
	link_target                   	varchar(200)                             comment '链接的目标',
	create_time                   	datetime                                 comment '创建时间',
	app                           	varchar(48)                              comment '应用程序',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "快速链接";
-- primary key will be created later for better import performance

drop table  if exists list_access_data;
create table list_access_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '名称',
	internal_name                 	varchar(200)                             comment '内部名称',
	read_permission               	tinyint                                  comment '读权限',
	create_permission             	tinyint                                  comment '创建权限',
	delete_permission             	tinyint                                  comment '删除权限',
	update_permission             	tinyint                                  comment '更新权限',
	execution_permission          	tinyint                                  comment '执行权限',
	app                           	varchar(48)                              comment '应用程序',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "访问列表";
-- primary key will be created later for better import performance

drop table  if exists object_access_data;
create table object_access_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(28)                              comment '名称',
	object_type                   	varchar(112)                             comment '访问对象类型',
	list1                         	varchar(80)                              comment '列表1',
	list2                         	varchar(80)                              comment '列表2',
	list3                         	varchar(80)                              comment '列表3',
	list4                         	varchar(80)                              comment '列表4',
	list5                         	varchar(80)                              comment '列表5',
	list6                         	varchar(80)                              comment '列表6',
	list7                         	varchar(80)                              comment '列表7',
	list8                         	varchar(80)                              comment '列表8',
	list9                         	varchar(80)                              comment '列表9',
	app                           	varchar(48)                              comment '应用程序',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "对象访问";
-- primary key will be created later for better import performance

drop table  if exists login_history_data;
create table login_history_data (
	id                            	varchar(48)          not null            comment 'ID',
	login_time                    	datetime                                 comment '登录时间',
	from_ip                       	varchar(44)                              comment '来自IP',
	description                   	varchar(16)                              comment '描述',
	sec_user                      	varchar(48)                              comment '安全用户',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "登录历史";
-- primary key will be created later for better import performance

drop table  if exists generic_form_data;
create table generic_form_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(20)                              comment '标题',
	description                   	varchar(48)                              comment '描述',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "通用的形式";
-- primary key will be created later for better import performance

drop table  if exists form_message_data;
create table form_message_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(24)                              comment '标题',
	form                          	varchar(48)                              comment '形式',
	level                         	varchar(28)                              comment '水平',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单信息";
-- primary key will be created later for better import performance

drop table  if exists form_field_message_data;
create table form_field_message_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(16)                              comment '标题',
	parameter_name                	varchar(16)                              comment '参数名称',
	form                          	varchar(48)                              comment '形式',
	level                         	varchar(28)                              comment '水平',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单字段的信息";
-- primary key will be created later for better import performance

drop table  if exists form_field_data;
create table form_field_data (
	id                            	varchar(48)          not null            comment 'ID',
	label                         	varchar(12)                              comment '标签',
	locale_key                    	varchar(44)                              comment '语言环境的关键',
	parameter_name                	varchar(16)                              comment '参数名称',
	type                          	varchar(36)                              comment '类型',
	form                          	varchar(48)                              comment '形式',
	placeholder                   	varchar(48)                              comment '占位符',
	default_value                 	varchar(12)                              comment '默认值',
	description                   	varchar(48)                              comment '描述',
	field_group                   	varchar(16)                              comment '字段组',
	minimum_value                 	varchar(60)                              comment '最小值',
	maximum_value                 	varchar(72)                              comment '最大值',
	required                      	tinyint                                  comment '要求',
	disabled                      	tinyint                                  comment '是否冻结',
	custom_rendering              	tinyint                                  comment '自定义渲染',
	candidate_values              	varchar(12)                              comment '候选人的价值观',
	suggest_values                	varchar(12)                              comment '建议值',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单字段";
-- primary key will be created later for better import performance

drop table  if exists form_action_data;
create table form_action_data (
	id                            	varchar(48)          not null            comment 'ID',
	label                         	varchar(8)                               comment '标签',
	locale_key                    	varchar(16)                              comment '语言环境的关键',
	action_key                    	varchar(24)                              comment '行动的关键',
	level                         	varchar(28)                              comment '水平',
	url                           	varchar(168)                             comment 'url',
	form                          	varchar(48)                              comment '形式',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单动作";
-- primary key will be created later for better import performance

drop table  if exists candidate_container_data;
create table candidate_container_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(28)                              comment '名称',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "候选人容器";
-- primary key will be created later for better import performance

drop table  if exists candidate_element_data;
create table candidate_element_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '名称',
	type                          	varchar(200)                             comment '类型',
	image                         	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment '图片',
	container                     	varchar(48)                              comment '容器',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "候选人元素";
-- primary key will be created later for better import performance

drop table  if exists wechat_workapp_identify_data;
create table wechat_workapp_identify_data (
	id                            	varchar(48)          not null            comment 'ID',
	corp_id                       	varchar(100)                             comment '公司标识',
	user_id                       	varchar(100)                             comment '用户Id',
	sec_user                      	varchar(48)                              comment '安全用户',
	create_time                   	datetime                                 comment '创建时间',
	last_login_time               	datetime                                 comment '最后登录时间',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "微信Workapp识别";
-- primary key will be created later for better import performance

drop table  if exists wechat_miniapp_identify_data;
create table wechat_miniapp_identify_data (
	id                            	varchar(48)          not null            comment 'ID',
	open_id                       	varchar(128)                             comment '开放Id',
	app_id                        	varchar(128)                             comment '应用程序Id',
	sec_user                      	varchar(48)                              comment '安全用户',
	create_time                   	datetime                                 comment '创建时间',
	last_login_time               	datetime                                 comment '最后登录时间',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "微信Miniapp识别";
-- primary key will be created later for better import performance




insert into platform_data values
	('P000001','EHR','2020-02-13 21:24:34','1');

insert into user_data values
	('U000001','王大锤','13987654321','image()','18','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000001','EMPLOYEE','1'),
	('U000002','王大锤0002','13900000002','image()0002','19','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000001','EMPLOYEE','1'),
	('U000003','王大锤0003','13900000003','image()0003','24','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000002','EMPLOYEE','1'),
	('U000004','王大锤0004','13900000004','image()0004','19','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000002','EMPLOYEE','1'),
	('U000005','王大锤0005','13900000005','image()0005','23','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000003','EMPLOYEE','1'),
	('U000006','王大锤0006','13900000006','image()0006','19','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000003','EMPLOYEE','1'),
	('U000007','王大锤0007','13900000007','image()0007','24','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000004','MANAGER','1'),
	('U000008','王大锤0008','13900000008','image()0008','20','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000004','MANAGER','1'),
	('U000009','王大锤0009','13900000009','image()0009','25','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000005','MANAGER','1'),
	('U000010','王大锤0010','13900000010','image()0010','23','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000005','MANAGER','1'),
	('U000011','王大锤0011','13900000011','image()0011','25','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000006','MANAGER','1'),
	('U000012','王大锤0012','13900000012','image()0012','21','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000006','BOSS','1'),
	('U000013','王大锤0013','13900000013','image()0013','25','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000007','BOSS','1'),
	('U000014','王大锤0014','13900000014','image()0014','24','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000007','BOSS','1'),
	('U000015','王大锤0015','13900000015','image()0015','23','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000008','BOSS','1'),
	('U000016','王大锤0016','13900000016','image()0016','18','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000008','BOSS','1');

insert into role_data values
	('EMPLOYEE','员工','EMPLOYEE','1'),
	('MANAGER','主管','MANAGER','1'),
	('BOSS','老板','BOSS','1');

insert into leave_record_data values
	('LR000001','U000001','ANNUAL_LEAVE','2017-07-31','2018-04-13','P000001','1'),
	('LR000002','U000001','ANNUAL_LEAVE','2018-03-15','2018-08-02','P000001','1'),
	('LR000003','U000002','ANNUAL_LEAVE','2018-07-16','2019-11-22','P000001','1'),
	('LR000004','U000002','ANNUAL_LEAVE','2019-10-21','2017-11-16','P000001','1'),
	('LR000005','U000003','ANNUAL_LEAVE','2019-11-10','2018-03-22','P000001','1'),
	('LR000006','U000003','ANNUAL_LEAVE','2018-03-31','2019-05-15','P000001','1'),
	('LR000007','U000004','ANNUAL_LEAVE','2017-08-06','2017-07-03','P000001','1'),
	('LR000008','U000004','SICK_LEACK','2020-01-19','2018-03-18','P000001','1'),
	('LR000009','U000005','SICK_LEACK','2019-10-02','2018-12-07','P000001','1'),
	('LR000010','U000005','SICK_LEACK','2017-03-07','2017-08-07','P000001','1'),
	('LR000011','U000006','SICK_LEACK','2019-02-22','2017-09-09','P000001','1'),
	('LR000012','U000006','SICK_LEACK','2018-08-06','2017-11-25','P000001','1'),
	('LR000013','U000007','SICK_LEACK','2019-08-24','2018-08-08','P000001','1'),
	('LR000014','U000007','PERSONAL_LEAVE','2019-03-14','2018-07-22','P000001','1'),
	('LR000015','U000008','PERSONAL_LEAVE','2017-07-18','2017-06-24','P000001','1'),
	('LR000016','U000008','PERSONAL_LEAVE','2017-10-17','2017-05-26','P000001','1'),
	('LR000017','U000009','PERSONAL_LEAVE','2017-12-23','2019-08-08','P000001','1'),
	('LR000018','U000009','PERSONAL_LEAVE','2018-07-20','2019-02-01','P000001','1'),
	('LR000019','U000010','PERSONAL_LEAVE','2018-03-16','2019-07-20','P000001','1'),
	('LR000020','U000010','PERSONAL_LEAVE','2017-10-18','2019-04-30','P000001','1'),
	('LR000021','U000011','MARRIAGE_HOLIDAY','2017-08-10','2017-06-18','P000001','1'),
	('LR000022','U000011','MARRIAGE_HOLIDAY','2017-09-25','2018-03-20','P000001','1'),
	('LR000023','U000012','MARRIAGE_HOLIDAY','2017-12-17','2019-12-07','P000001','1'),
	('LR000024','U000012','MARRIAGE_HOLIDAY','2018-01-03','2019-05-10','P000001','1'),
	('LR000025','U000013','MARRIAGE_HOLIDAY','2019-10-01','2019-02-11','P000001','1'),
	('LR000026','U000013','MARRIAGE_HOLIDAY','2018-09-20','2018-06-22','P000001','1'),
	('LR000027','U000014','MATERNITY_LEAVE','2017-10-09','2020-02-08','P000001','1'),
	('LR000028','U000014','MATERNITY_LEAVE','2017-10-20','2020-02-19','P000001','1'),
	('LR000029','U000015','MATERNITY_LEAVE','2018-06-13','2018-07-30','P000001','1'),
	('LR000030','U000015','MATERNITY_LEAVE','2018-02-25','2017-07-17','P000001','1'),
	('LR000031','U000016','MATERNITY_LEAVE','2018-09-19','2017-06-28','P000001','1'),
	('LR000032','U000016','MATERNITY_LEAVE','2019-05-22','2018-10-03','P000001','1');

insert into leave_record_type_data values
	('ANNUAL_LEAVE','年假','ANNUAL_LEAVE','1'),
	('SICK_LEACK','病假','SICK_LEACK','1'),
	('PERSONAL_LEAVE','事假','PERSONAL_LEAVE','1'),
	('MARRIAGE_HOLIDAY','婚假','MARRIAGE_HOLIDAY','1'),
	('MATERNITY_LEAVE','产假','MATERNITY_LEAVE','1');

insert into holyday_setting_data values
	('HS000001','ANNUAL_LEAVE','10','1'),
	('HS000002','PERSONAL_LEAVE','10','1');

insert into province_data values
	('P000001','四川','P000001','1'),
	('P000002','北京','P000001','1');

insert into city_data values
	('C000001','成都','P000001','P000001','1'),
	('C000002','北京','P000001','P000001','1'),
	('C000003','成都','P000002','P000001','1'),
	('C000004','北京','P000002','P000001','1');

insert into district_data values
	('D000001','成华区','C000001','P000001','1'),
	('D000002','朝阳区','C000001','P000001','1'),
	('D000003','锦江区','C000002','P000001','1'),
	('D000004','海淀区','C000002','P000001','1'),
	('D000005','成华区','C000003','P000001','1'),
	('D000006','朝阳区','C000003','P000001','1'),
	('D000007','锦江区','C000004','P000001','1'),
	('D000008','海淀区','C000004','P000001','1');

insert into wechat_workapp_identify_data values
	('WWI000001','corporation123','user123','SU000001','2020-01-30 13:37:49','2020-02-01 15:32:39','1'),
	('WWI000002','corporation1230002','user1230002','SU000001','2020-02-11 08:21:38','2020-02-13 13:44:13','1'),
	('WWI000003','corporation1230003','user1230003','SU000002','2020-02-08 04:07:18','2020-02-04 05:34:08','1'),
	('WWI000004','corporation1230004','user1230004','SU000002','2020-02-20 04:27:33','2020-02-02 17:47:35','1');

insert into wechat_miniapp_identify_data values
	('WMI000001','wechat_open_id_1234567890','wechat_miniapp_id_1234567890','SU000001','2020-02-13 03:01:16','2020-01-30 01:07:50','1'),
	('WMI000002','wechat_open_id_12345678900002','wechat_miniapp_id_12345678900002','SU000001','2020-02-02 23:09:33','2020-02-15 15:00:32','1'),
	('WMI000003','wechat_open_id_12345678900003','wechat_miniapp_id_12345678900003','SU000002','2020-02-19 01:02:43','2020-02-10 22:30:14','1'),
	('WMI000004','wechat_open_id_12345678900004','wechat_miniapp_id_12345678900004','SU000002','2020-02-06 21:15:43','2020-02-16 18:14:24','1');







delete from list_access_data ;
delete from object_access_data ;
delete from user_app_data ;
delete from login_history_data ;
delete from sec_user_data ;
delete from user_domain_data ;
delete from wechat_miniapp_identify_data;
delete from wechat_workapp_identify_data;
insert into user_domain_data values ('UD000001','用户区域','1');



insert into sec_user_data values('SU000001','User000001','13900000001','1000001@qq.com','24327F1C00D22210298A18D0DB9AA6C4C22DEAC4BEAE7C02E616442CA7764246', 'weixin_openid_000001', 'weixin_appid_000001', 'jwt_token_000001' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1);
insert into user_app_data values('UA000001','EHR','SU000001','university',1,'MXWR','Platform','P000001','/link/to/app','1');
insert into user_app_data values('UA000002','我的账户','SU000001','lock',1,'MXWR','SecUser','SU000001','/link/to/app','1');
insert into user_app_data values('UA000003','用户管理','SU000001','users',1,'MXWR','UserDomain','UD000001','/link/to/app','1');

/* ------------------------------ generate users for all target od marked as user4all ------------------------------------------ */
insert into sec_user_data values('SU000002','User000002','13900000002','1000002@qq.com','BB5210DAE99659C7164D7DBCFC51FB2D167D0DA372D58EF26A9F8533EEA2967C', 'weixin_openid_000002', 'weixin_appid_000002', 'jwt_token_000002' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1);
insert into user_app_data values('UA000004','用户: 王大锤','SU000002','store',1,'MXWR','User','U000001','/link/to/app','1');
insert into user_app_data values('UA000005','我的账户','SU000002','lock',1,'MXWR','SecUser','SU000002','/link/to/app','1');
insert into sec_user_data values('SU000003','User000003','13900000003','1000003@qq.com','9D4104DF2774FDEAAE074CA35B052D8F664F4F99064C7BEAB0B589C2605C4EDA', 'weixin_openid_000003', 'weixin_appid_000003', 'jwt_token_000003' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1);
insert into user_app_data values('UA000006','用户: 王大锤0002','SU000003','store',1,'MXWR','User','U000002','/link/to/app','1');
insert into user_app_data values('UA000007','我的账户','SU000003','lock',1,'MXWR','SecUser','SU000003','/link/to/app','1');
insert into sec_user_data values('SU000004','User000004','13900000004','1000004@qq.com','9B223EBD008D7B544A3A640739EBE47459D3A4C5296DDA00F594FAF60FE88B28', 'weixin_openid_000004', 'weixin_appid_000004', 'jwt_token_000004' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1);
insert into user_app_data values('UA000008','用户: 王大锤0003','SU000004','store',1,'MXWR','User','U000003','/link/to/app','1');
insert into user_app_data values('UA000009','我的账户','SU000004','lock',1,'MXWR','SecUser','SU000004','/link/to/app','1');
insert into sec_user_data values('SU000005','User000005','13900000005','1000005@qq.com','AE5F93F319636A96963C06D035B97F004D18E61D80129EFEA331784A6E21DC5C', 'weixin_openid_000005', 'weixin_appid_000005', 'jwt_token_000005' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1);
insert into user_app_data values('UA000010','用户: 王大锤0004','SU000005','store',1,'MXWR','User','U000004','/link/to/app','1');
insert into user_app_data values('UA000011','我的账户','SU000005','lock',1,'MXWR','SecUser','SU000005','/link/to/app','1');
insert into sec_user_data values('SU000006','User000006','13900000006','1000006@qq.com','5FBBDBEAD9F84D599E8819CEEA167854CDA0FFD8D297D17D12E4619CE76F3B55', 'weixin_openid_000006', 'weixin_appid_000006', 'jwt_token_000006' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1);
insert into user_app_data values('UA000012','用户: 王大锤0005','SU000006','store',1,'MXWR','User','U000005','/link/to/app','1');
insert into user_app_data values('UA000013','我的账户','SU000006','lock',1,'MXWR','SecUser','SU000006','/link/to/app','1');
insert into sec_user_data values('SU000007','User000007','13900000007','1000007@qq.com','A9652F0D7C1ACCB421BAF55EB3E7286AFA8F591897F1AE4CEB6A76402CCBE803', 'weixin_openid_000007', 'weixin_appid_000007', 'jwt_token_000007' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1);
insert into user_app_data values('UA000014','用户: 王大锤0006','SU000007','store',1,'MXWR','User','U000006','/link/to/app','1');
insert into user_app_data values('UA000015','我的账户','SU000007','lock',1,'MXWR','SecUser','SU000007','/link/to/app','1');
insert into sec_user_data values('SU000008','User000008','13900000008','1000008@qq.com','A4B83C2652CD6BECE5C7909576555B313078D7EE50AA028F26B8F0245C191B4B', 'weixin_openid_000008', 'weixin_appid_000008', 'jwt_token_000008' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1);
insert into user_app_data values('UA000016','用户: 王大锤0007','SU000008','store',1,'MXWR','User','U000007','/link/to/app','1');
insert into user_app_data values('UA000017','我的账户','SU000008','lock',1,'MXWR','SecUser','SU000008','/link/to/app','1');
insert into sec_user_data values('SU000009','User000009','13900000009','1000009@qq.com','88F8AB5F153081C5AB21F5E5354B4EB14286EFB43CEA588ED1C73FE2B46B35C1', 'weixin_openid_000009', 'weixin_appid_000009', 'jwt_token_000009' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1);
insert into user_app_data values('UA000018','用户: 王大锤0008','SU000009','store',1,'MXWR','User','U000008','/link/to/app','1');
insert into user_app_data values('UA000019','我的账户','SU000009','lock',1,'MXWR','SecUser','SU000009','/link/to/app','1');
insert into sec_user_data values('SU000010','User000010','13900000010','1000010@qq.com','EF8232ABB97CC3858F271527A1AA1452A33715A3AC48312A44B0940D5C948600', 'weixin_openid_000010', 'weixin_appid_000010', 'jwt_token_000010' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1);
insert into user_app_data values('UA000020','用户: 王大锤0009','SU000010','store',1,'MXWR','User','U000009','/link/to/app','1');
insert into user_app_data values('UA000021','我的账户','SU000010','lock',1,'MXWR','SecUser','SU000010','/link/to/app','1');
insert into sec_user_data values('SU000011','User000011','13900000011','1000011@qq.com','FE7AF5D4F030CD575C117A73124FC39AB41528DFFC41D2CFBC1130E755694243', 'weixin_openid_000011', 'weixin_appid_000011', 'jwt_token_000011' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1);
insert into user_app_data values('UA000022','用户: 王大锤0010','SU000011','store',1,'MXWR','User','U000010','/link/to/app','1');
insert into user_app_data values('UA000023','我的账户','SU000011','lock',1,'MXWR','SecUser','SU000011','/link/to/app','1');
insert into sec_user_data values('SU000012','User000012','13900000012','1000012@qq.com','999DD89E35807C62458F2D191D4F55548B49245EEC6E186FE9497EC867C40088', 'weixin_openid_000012', 'weixin_appid_000012', 'jwt_token_000012' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1);
insert into user_app_data values('UA000024','用户: 王大锤0011','SU000012','store',1,'MXWR','User','U000011','/link/to/app','1');
insert into user_app_data values('UA000025','我的账户','SU000012','lock',1,'MXWR','SecUser','SU000012','/link/to/app','1');
insert into sec_user_data values('SU000013','User000013','13900000013','1000013@qq.com','0AE92E17166CBB59341836C218E92EF083058CC4E3108C5FD2FB904650013A69', 'weixin_openid_000013', 'weixin_appid_000013', 'jwt_token_000013' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1);
insert into user_app_data values('UA000026','用户: 王大锤0012','SU000013','store',1,'MXWR','User','U000012','/link/to/app','1');
insert into user_app_data values('UA000027','我的账户','SU000013','lock',1,'MXWR','SecUser','SU000013','/link/to/app','1');
insert into sec_user_data values('SU000014','User000014','13900000014','1000014@qq.com','E79E64241204EB0FCE03C4BA0E315F21ECDB11D22264BE7B1AAD41D04D77A6D0', 'weixin_openid_000014', 'weixin_appid_000014', 'jwt_token_000014' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1);
insert into user_app_data values('UA000028','用户: 王大锤0013','SU000014','store',1,'MXWR','User','U000013','/link/to/app','1');
insert into user_app_data values('UA000029','我的账户','SU000014','lock',1,'MXWR','SecUser','SU000014','/link/to/app','1');
insert into sec_user_data values('SU000015','User000015','13900000015','1000015@qq.com','1D858671B95062DAFE1D989C089188CC4EFDF3D5C45D8F24DD20BF3E352A3D9B', 'weixin_openid_000015', 'weixin_appid_000015', 'jwt_token_000015' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1);
insert into user_app_data values('UA000030','用户: 王大锤0014','SU000015','store',1,'MXWR','User','U000014','/link/to/app','1');
insert into user_app_data values('UA000031','我的账户','SU000015','lock',1,'MXWR','SecUser','SU000015','/link/to/app','1');
insert into sec_user_data values('SU000016','User000016','13900000016','1000016@qq.com','14B1F5E667F8B6697C8A2952C3619D9AD82F846E5B32FD9F258918786B3ED519', 'weixin_openid_000016', 'weixin_appid_000016', 'jwt_token_000016' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1);
insert into user_app_data values('UA000032','用户: 王大锤0015','SU000016','store',1,'MXWR','User','U000015','/link/to/app','1');
insert into user_app_data values('UA000033','我的账户','SU000016','lock',1,'MXWR','SecUser','SU000016','/link/to/app','1');
insert into sec_user_data values('SU000017','User000017','13900000017','1000017@qq.com','1A803C7096681FC2AA7C55C46A6A99D8089481B96997774EA5B1C785C8035010', 'weixin_openid_000017', 'weixin_appid_000017', 'jwt_token_000017' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1);
insert into user_app_data values('UA000034','用户: 王大锤0016','SU000017','store',1,'MXWR','User','U000016','/link/to/app','1');
insert into user_app_data values('UA000035','我的账户','SU000017','lock',1,'MXWR','SecUser','SU000017','/link/to/app','1');


-- no change request type found

select mobile as `可用于登录的账号`, 'admin123' as `密码` from sec_user_data;

/*
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|


*/



-- Mysql innodb's foreign key has index automatically 
create unique index idx4id_ver_of_platform on platform_data (id, version);
create  index idx4founded_of_platform on platform_data (founded);

create unique index idx4id_ver_of_user on user_data (id, version);
create  index idx4mobile_of_user on user_data (mobile);
create  index idx4age_of_user on user_data (age);

create unique index idx4id_ver_of_role on role_data (id, version);
create unique index idx4code_of_role on role_data (code);

create unique index idx4id_ver_of_leave_record on leave_record_data (id, version);
create  index idx4fromdate_of_leave_record on leave_record_data (fromdate);
create  index idx4todate_of_leave_record on leave_record_data (todate);

create unique index idx4id_ver_of_leave_record_type on leave_record_type_data (id, version);
create unique index idx4code_of_leave_record_type on leave_record_type_data (code);

create unique index idx4id_ver_of_holyday_setting on holyday_setting_data (id, version);
create  index idx4leave_days_of_holyday_setting on holyday_setting_data (leave_days);

create unique index idx4id_ver_of_province on province_data (id, version);

create unique index idx4id_ver_of_city on city_data (id, version);

create unique index idx4id_ver_of_district on district_data (id, version);

create unique index idx4id_ver_of_user_domain on user_domain_data (id, version);

create unique index idx4id_ver_of_user_white_list on user_white_list_data (id, version);

create unique index idx4id_ver_of_sec_user on sec_user_data (id, version);
create unique index idx4login_of_sec_user on sec_user_data (login);
create unique index idx4email_of_sec_user on sec_user_data (email);
create unique index idx4mobile_of_sec_user on sec_user_data (mobile);
create  index idx4verification_code_of_sec_user on sec_user_data (verification_code);
create  index idx4verification_code_expire_of_sec_user on sec_user_data (verification_code_expire);
create  index idx4last_login_time_of_sec_user on sec_user_data (last_login_time);

create unique index idx4id_ver_of_user_app on user_app_data (id, version);
create  index idx4object_id_of_user_app on user_app_data (object_id);

create unique index idx4id_ver_of_quick_link on quick_link_data (id, version);
create  index idx4create_time_of_quick_link on quick_link_data (create_time);

create unique index idx4id_ver_of_list_access on list_access_data (id, version);

create unique index idx4id_ver_of_object_access on object_access_data (id, version);

create unique index idx4id_ver_of_login_history on login_history_data (id, version);
create  index idx4login_time_of_login_history on login_history_data (login_time);

create unique index idx4id_ver_of_generic_form on generic_form_data (id, version);

create unique index idx4id_ver_of_form_message on form_message_data (id, version);

create unique index idx4id_ver_of_form_field_message on form_field_message_data (id, version);

create unique index idx4id_ver_of_form_field on form_field_data (id, version);

create unique index idx4id_ver_of_form_action on form_action_data (id, version);

create unique index idx4id_ver_of_candidate_container on candidate_container_data (id, version);

create unique index idx4id_ver_of_candidate_element on candidate_element_data (id, version);

create unique index idx4id_ver_of_wechat_workapp_identify on wechat_workapp_identify_data (id, version);
create  index idx4corp_id_of_wechat_workapp_identify on wechat_workapp_identify_data (corp_id);
create  index idx4user_id_of_wechat_workapp_identify on wechat_workapp_identify_data (user_id);
create  index idx4create_time_of_wechat_workapp_identify on wechat_workapp_identify_data (create_time);
create  index idx4last_login_time_of_wechat_workapp_identify on wechat_workapp_identify_data (last_login_time);

create unique index idx4id_ver_of_wechat_miniapp_identify on wechat_miniapp_identify_data (id, version);
create  index idx4open_id_of_wechat_miniapp_identify on wechat_miniapp_identify_data (open_id);
create  index idx4app_id_of_wechat_miniapp_identify on wechat_miniapp_identify_data (app_id);
create  index idx4create_time_of_wechat_miniapp_identify on wechat_miniapp_identify_data (create_time);
create  index idx4last_login_time_of_wechat_miniapp_identify on wechat_miniapp_identify_data (last_login_time);
alter table platform_data add constraint pk4id_of_platform_data primary key (id);

alter table user_data add constraint pk4id_of_user_data primary key (id);
alter table user_data add constraint 
	fk4district_of_user_data foreign key (district) references district_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table user_data add constraint 
	fk4role_of_user_data foreign key (role) references role_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table role_data add constraint pk4id_of_role_data primary key (id);

alter table leave_record_data add constraint pk4id_of_leave_record_data primary key (id);
alter table leave_record_data add constraint 
	fk4user_of_leave_record_data foreign key (user) references user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table leave_record_data add constraint 
	fk4type_of_leave_record_data foreign key (type) references leave_record_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table leave_record_data add constraint 
	fk4platform_of_leave_record_data foreign key (platform) references platform_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table leave_record_type_data add constraint pk4id_of_leave_record_type_data primary key (id);

alter table holyday_setting_data add constraint pk4id_of_holyday_setting_data primary key (id);
alter table holyday_setting_data add constraint 
	fk4type_of_holyday_setting_data foreign key (type) references leave_record_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table province_data add constraint pk4id_of_province_data primary key (id);
alter table province_data add constraint 
	fk4platform_of_province_data foreign key (platform) references platform_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table city_data add constraint pk4id_of_city_data primary key (id);
alter table city_data add constraint 
	fk4province_of_city_data foreign key (province) references province_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table city_data add constraint 
	fk4platform_of_city_data foreign key (platform) references platform_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table district_data add constraint pk4id_of_district_data primary key (id);
alter table district_data add constraint 
	fk4city_of_district_data foreign key (city) references city_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table district_data add constraint 
	fk4platform_of_district_data foreign key (platform) references platform_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table user_domain_data add constraint pk4id_of_user_domain_data primary key (id);

alter table user_white_list_data add constraint pk4id_of_user_white_list_data primary key (id);
alter table user_white_list_data add constraint 
	fk4domain_of_user_white_list_data foreign key (domain) references user_domain_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table sec_user_data add constraint pk4id_of_sec_user_data primary key (id);
alter table sec_user_data add constraint 
	fk4domain_of_sec_user_data foreign key (domain) references user_domain_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table user_app_data add constraint pk4id_of_user_app_data primary key (id);
alter table user_app_data add constraint 
	fk4sec_user_of_user_app_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table quick_link_data add constraint pk4id_of_quick_link_data primary key (id);
alter table quick_link_data add constraint 
	fk4app_of_quick_link_data foreign key (app) references user_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table list_access_data add constraint pk4id_of_list_access_data primary key (id);
alter table list_access_data add constraint 
	fk4app_of_list_access_data foreign key (app) references user_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table object_access_data add constraint pk4id_of_object_access_data primary key (id);
alter table object_access_data add constraint 
	fk4app_of_object_access_data foreign key (app) references user_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table login_history_data add constraint pk4id_of_login_history_data primary key (id);
alter table login_history_data add constraint 
	fk4sec_user_of_login_history_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table generic_form_data add constraint pk4id_of_generic_form_data primary key (id);

alter table form_message_data add constraint pk4id_of_form_message_data primary key (id);
alter table form_message_data add constraint 
	fk4form_of_form_message_data foreign key (form) references generic_form_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table form_field_message_data add constraint pk4id_of_form_field_message_data primary key (id);
alter table form_field_message_data add constraint 
	fk4form_of_form_field_message_data foreign key (form) references generic_form_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table form_field_data add constraint pk4id_of_form_field_data primary key (id);
alter table form_field_data add constraint 
	fk4form_of_form_field_data foreign key (form) references generic_form_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table form_action_data add constraint pk4id_of_form_action_data primary key (id);
alter table form_action_data add constraint 
	fk4form_of_form_action_data foreign key (form) references generic_form_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table candidate_container_data add constraint pk4id_of_candidate_container_data primary key (id);

alter table candidate_element_data add constraint pk4id_of_candidate_element_data primary key (id);
alter table candidate_element_data add constraint 
	fk4container_of_candidate_element_data foreign key (container) references candidate_container_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table wechat_workapp_identify_data add constraint pk4id_of_wechat_workapp_identify_data primary key (id);
alter table wechat_workapp_identify_data add constraint 
	fk4sec_user_of_wechat_workapp_identify_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table wechat_miniapp_identify_data add constraint pk4id_of_wechat_miniapp_identify_data primary key (id);
alter table wechat_miniapp_identify_data add constraint 
	fk4sec_user_of_wechat_miniapp_identify_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
-- create extra index for time, number and mobile phone




create table info_lines(line varchar(400));

insert into info_lines values( '   SSSSSSSSSSSSSSS                                                                                                                  !!! ');
insert into info_lines values( ' SS:::::::::::::::S                                                                                                                !!:!!');
insert into info_lines values( 'S:::::SSSSSS::::::S                                                                                                                !:::!');
insert into info_lines values( 'S:::::S     SSSSSSS                                                                                                                !:::!');
insert into info_lines values( 'S:::::S            uuuuuu    uuuuuu      cccccccccccccccc    cccccccccccccccc    eeeeeeeeeeee        ssssssssss       ssssssssss   !:::!');
insert into info_lines values( 'S:::::S            u::::u    u::::u    cc:::::::::::::::c  cc:::::::::::::::c  ee::::::::::::ee    ss::::::::::s    ss::::::::::s  !:::!');
insert into info_lines values( ' S::::SSSS         u::::u    u::::u   c:::::::::::::::::c c:::::::::::::::::c e::::::eeeee:::::eess:::::::::::::s ss:::::::::::::s !:::!');
insert into info_lines values( '  SS::::::SSSSS    u::::u    u::::u  c:::::::cccccc:::::cc:::::::cccccc:::::ce::::::e     e:::::es::::::ssss:::::ss::::::ssss:::::s!:::!');
insert into info_lines values( '    SSS::::::::SS  u::::u    u::::u  c::::::c     cccccccc::::::c     ccccccce:::::::eeeee::::::e s:::::s  ssssss  s:::::s  ssssss !:::!');
insert into info_lines values( '       SSSSSS::::S u::::u    u::::u  c:::::c             c:::::c             e:::::::::::::::::e    s::::::s         s::::::s      !:::!');
insert into info_lines values( '            S:::::Su::::u    u::::u  c:::::c             c:::::c             e::::::eeeeeeeeeee        s::::::s         s::::::s   !!:!!');
insert into info_lines values( '            S:::::Su:::::uuuu:::::u  c::::::c     cccccccc::::::c     ccccccce:::::::e           ssssss   s:::::s ssssss   s:::::s  !!! ');
insert into info_lines values( 'SSSSSSS     S:::::Su:::::::::::::::uuc:::::::cccccc:::::cc:::::::cccccc:::::ce::::::::e          s:::::ssss::::::ss:::::ssss::::::s     ');
insert into info_lines values( 'S::::::SSSSSS:::::S u:::::::::::::::u c:::::::::::::::::c c:::::::::::::::::c e::::::::eeeeeeee  s::::::::::::::s s::::::::::::::s  !!! ');
insert into info_lines values( 'S:::::::::::::::SS   uu::::::::uu:::u  cc:::::::::::::::c  cc:::::::::::::::c  ee:::::::::::::e   s:::::::::::ss   s:::::::::::ss  !!:!!');
insert into info_lines values( ' SSSSSSSSSSSSSSS       uuuuuuuu  uuuu    cccccccccccccccc    cccccccccccccccc    eeeeeeeeeeeeee    sssssssssss      sssssssssss     !!! ');

select * from info_lines;
/* start with data patch */
/* The sql file is not found from: /Users/jarryzhou/githome/web-code-generator/sky/data-patch/flowable.sql */
-- no change request defined .
-- turn on safe mode
SET SQL_SAFE_UPDATES = 1;
-- change request type

/*
http://patorjk.com/software/taag/#p=testall&h=0&v=0&f=Graceful&t=Success!
   _____                                            _ 
  / ____|                                          | |
 | (___    _   _    ___    ___    ___   ___   ___  | |
  \\___   | | | |  / __|  / __|  / _  / __| / __| | |
  ____) | | |_| | | (__  | (__  |  __/ \\__  \\__  |_|
 |_____/   \\__,_|  \\___|  \\___|  \\___| |___/ |___/ (_)  
+----------+---------------------------------+---------------------+--------+
| Charset  | Description                     | Default collation   | Maxlen |
+----------+---------------------------------+---------------------+--------+
| gb2312   | GB2312 Simplified Chinese       | gb2312_chinese_ci   |      2 |
| gbk      | GBK Simplified Chinese          | gbk_chinese_ci      |      2 |
| utf8mb4  | UTF-8 Unicode                   | utf8mb4_general_ci  |      4 |
| utf32    | UTF-32 Unicode                  | utf32_general_ci    |      4 |
| gb18030  | China National Standard GB18030 | gb18030_chinese_ci  |      4 |
+----------+---------------------------------+---------------------+--------+

*/

