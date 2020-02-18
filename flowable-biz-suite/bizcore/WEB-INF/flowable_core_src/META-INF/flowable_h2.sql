-- BUILD WITH MODEL TIME 700101T0800






drop table  if exists platform_data;
create table platform_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(12)                              comment '名称',
	founded                       	datetime                                 comment '成立',
	version                       	int                                      comment '版本'
	
) ;
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
	
) ;
-- primary key will be created later for better import performance

drop table  if exists role_data;
create table role_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(8)                               comment '名称',
	code                          	varchar(32)                              comment '编码',
	version                       	int                                      comment '版本'
	
) ;
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
	
) ;
-- primary key will be created later for better import performance

drop table  if exists leave_record_type_data;
create table leave_record_type_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(8)                               comment '名称',
	code                          	varchar(64)                              comment '编码',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists holyday_setting_data;
create table holyday_setting_data (
	id                            	varchar(48)          not null            comment 'ID',
	type                          	varchar(48)                              comment '类型',
	leave_days                    	int                                      comment '离开的日子',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists province_data;
create table province_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(120)                             comment '名称',
	platform                      	varchar(48)                              comment '平台',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists city_data;
create table city_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(120)                             comment '名称',
	province                      	varchar(48)                              comment '省',
	platform                      	varchar(48)                              comment '平台',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists district_data;
create table district_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(120)                             comment '名称',
	city                          	varchar(48)                              comment '城市',
	platform                      	varchar(48)                              comment '平台',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists user_domain_data;
create table user_domain_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(16)                              comment '名称',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists user_white_list_data;
create table user_white_list_data (
	id                            	varchar(48)          not null            comment 'ID',
	user_identity                 	varchar(40)                              comment '用户身份',
	user_special_functions        	varchar(200)                             comment '用户特殊功能',
	domain                        	varchar(48)                              comment '域',
	version                       	int                                      comment '版本'
	
) ;
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
	
) ;
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
	
) ;
-- primary key will be created later for better import performance

drop table  if exists quick_link_data;
create table quick_link_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '名称',
	icon                          	varchar(200)                             comment '图标',
	image_path                    	varchar(512)                             comment '图片路径',
	link_target                   	varchar(200)                             comment '链接的目标',
	create_time                   	datetime                                 comment '创建时间',
	app                           	varchar(48)                              comment '应用程序',
	version                       	int                                      comment '版本'
	
) ;
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
	
) ;
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
	
) ;
-- primary key will be created later for better import performance

drop table  if exists login_history_data;
create table login_history_data (
	id                            	varchar(48)          not null            comment 'ID',
	login_time                    	datetime                                 comment '登录时间',
	from_ip                       	varchar(44)                              comment '来自IP',
	description                   	varchar(16)                              comment '描述',
	sec_user                      	varchar(48)                              comment '安全用户',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists generic_form_data;
create table generic_form_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(20)                              comment '标题',
	description                   	varchar(48)                              comment '描述',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists form_message_data;
create table form_message_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(24)                              comment '标题',
	form                          	varchar(48)                              comment '形式',
	level                         	varchar(28)                              comment '水平',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists form_field_message_data;
create table form_field_message_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(16)                              comment '标题',
	parameter_name                	varchar(16)                              comment '参数名称',
	form                          	varchar(48)                              comment '形式',
	level                         	varchar(28)                              comment '水平',
	version                       	int                                      comment '版本'
	
) ;
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
	
) ;
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
	
) ;
-- primary key will be created later for better import performance

drop table  if exists candidate_container_data;
create table candidate_container_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(28)                              comment '名称',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists candidate_element_data;
create table candidate_element_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '名称',
	type                          	varchar(200)                             comment '类型',
	image                         	varchar(512)                             comment '图片',
	container                     	varchar(48)                              comment '容器',
	version                       	int                                      comment '版本'
	
) ;
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
	
) ;
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
	
) ;
-- primary key will be created later for better import performance




insert into platform_data values
	('P000001','EHR','2020-02-07 13:51:29','1');

insert into user_data values
	('U000001','王大锤','13987654321','image()','21','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000001','EMPLOYEE','1'),
	('U000002','王大锤0002','13900000002','image()0002','20','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000001','EMPLOYEE','1'),
	('U000003','王大锤0003','13900000003','image()0003','19','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000002','EMPLOYEE','1'),
	('U000004','王大锤0004','13900000004','image()0004','24','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000002','EMPLOYEE','1'),
	('U000005','王大锤0005','13900000005','image()0005','25','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000003','EMPLOYEE','1'),
	('U000006','王大锤0006','13900000006','image()0006','21','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000003','EMPLOYEE','1'),
	('U000007','王大锤0007','13900000007','image()0007','19','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000004','MANAGER','1'),
	('U000008','王大锤0008','13900000008','image()0008','19','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000004','MANAGER','1'),
	('U000009','王大锤0009','13900000009','image()0009','25','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000005','MANAGER','1'),
	('U000010','王大锤0010','13900000010','image()0010','18','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000005','MANAGER','1'),
	('U000011','王大锤0011','13900000011','image()0011','21','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000006','MANAGER','1'),
	('U000012','王大锤0012','13900000012','image()0012','21','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000006','BOSS','1'),
	('U000013','王大锤0013','13900000013','image()0013','18','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000007','BOSS','1'),
	('U000014','王大锤0014','13900000014','image()0014','22','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000007','BOSS','1'),
	('U000015','王大锤0015','13900000015','image()0015','24','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000008','BOSS','1'),
	('U000016','王大锤0016','13900000016','image()0016','19','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000008','BOSS','1');

insert into role_data values
	('EMPLOYEE','员工','EMPLOYEE','1'),
	('MANAGER','主管','MANAGER','1'),
	('BOSS','老板','BOSS','1');

insert into leave_record_data values
	('LR000001','U000001','ANNUAL_LEAVE','2017-11-10','2018-05-11','P000001','1'),
	('LR000002','U000001','ANNUAL_LEAVE','2019-01-29','2017-12-16','P000001','1'),
	('LR000003','U000002','ANNUAL_LEAVE','2017-07-21','2017-03-30','P000001','1'),
	('LR000004','U000002','ANNUAL_LEAVE','2019-04-10','2017-12-26','P000001','1'),
	('LR000005','U000003','ANNUAL_LEAVE','2019-07-04','2017-09-11','P000001','1'),
	('LR000006','U000003','ANNUAL_LEAVE','2017-04-23','2018-08-30','P000001','1'),
	('LR000007','U000004','ANNUAL_LEAVE','2019-03-14','2018-06-17','P000001','1'),
	('LR000008','U000004','SICK_LEACK','2018-09-07','2018-12-03','P000001','1'),
	('LR000009','U000005','SICK_LEACK','2018-05-29','2019-07-16','P000001','1'),
	('LR000010','U000005','SICK_LEACK','2020-02-04','2017-09-27','P000001','1'),
	('LR000011','U000006','SICK_LEACK','2018-05-31','2017-07-11','P000001','1'),
	('LR000012','U000006','SICK_LEACK','2019-11-24','2018-09-27','P000001','1'),
	('LR000013','U000007','SICK_LEACK','2019-03-04','2018-02-14','P000001','1'),
	('LR000014','U000007','PERSONAL_LEAVE','2018-04-08','2019-12-14','P000001','1'),
	('LR000015','U000008','PERSONAL_LEAVE','2017-03-03','2017-04-25','P000001','1'),
	('LR000016','U000008','PERSONAL_LEAVE','2017-06-28','2017-03-14','P000001','1'),
	('LR000017','U000009','PERSONAL_LEAVE','2017-12-01','2017-07-09','P000001','1'),
	('LR000018','U000009','PERSONAL_LEAVE','2018-06-15','2019-03-03','P000001','1'),
	('LR000019','U000010','PERSONAL_LEAVE','2018-09-16','2018-04-06','P000001','1'),
	('LR000020','U000010','PERSONAL_LEAVE','2017-11-10','2017-08-22','P000001','1'),
	('LR000021','U000011','MARRIAGE_HOLIDAY','2019-05-09','2017-03-06','P000001','1'),
	('LR000022','U000011','MARRIAGE_HOLIDAY','2018-03-25','2017-05-25','P000001','1'),
	('LR000023','U000012','MARRIAGE_HOLIDAY','2017-03-22','2019-10-02','P000001','1'),
	('LR000024','U000012','MARRIAGE_HOLIDAY','2018-03-01','2019-02-13','P000001','1'),
	('LR000025','U000013','MARRIAGE_HOLIDAY','2019-01-13','2019-12-20','P000001','1'),
	('LR000026','U000013','MARRIAGE_HOLIDAY','2018-11-02','2018-02-24','P000001','1'),
	('LR000027','U000014','MATERNITY_LEAVE','2019-05-03','2020-01-17','P000001','1'),
	('LR000028','U000014','MATERNITY_LEAVE','2017-12-30','2017-02-18','P000001','1'),
	('LR000029','U000015','MATERNITY_LEAVE','2017-07-21','2018-08-24','P000001','1'),
	('LR000030','U000015','MATERNITY_LEAVE','2017-03-19','2018-08-04','P000001','1'),
	('LR000031','U000016','MATERNITY_LEAVE','2019-02-27','2017-06-04','P000001','1'),
	('LR000032','U000016','MATERNITY_LEAVE','2019-05-19','2018-02-23','P000001','1');

insert into leave_record_type_data values
	('ANNUAL_LEAVE','年假','ANNUAL_LEAVE','1'),
	('SICK_LEACK','病假','SICK_LEACK','1'),
	('PERSONAL_LEAVE','事假','PERSONAL_LEAVE','1'),
	('MARRIAGE_HOLIDAY','婚假','MARRIAGE_HOLIDAY','1'),
	('MATERNITY_LEAVE','产假','MATERNITY_LEAVE','1');

insert into holyday_setting_data values
	('HS000001','ANNUAL_LEAVE','10','1'),
	('HS000002','PERSONAL_LEAVE','8','1');

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

insert into user_domain_data values
	('UD000001','用户区域','1');

insert into user_white_list_data values
	('UWL000001','clariones','tester;ios-spokesperson','UD000001','1'),
	('UWL000002','13808188512','tester;ios-spokesperson0002','UD000001','1');

insert into sec_user_data values
	('SU000001','login','13900000001','suddy_chang@163.com','C183EC89F92A462CF45B95504792EC4625E847C90536EEFE512D1C9DB8602E95','wx123456789abcdefghijklmn','wxapp12098410239840','jwt_token_12345678','0','2020-02-07 22:58:07','2020-02-12 14:00:30','UD000001','1'),
	('SU000002','login0002','13900000002','2@qq.com','AC2F95628244C6975EB2C36942EA879ED93D93F5895EF3157733E4629FA86B92','wx123456789abcdefghijklmn0002','wxapp120984102398400002','jwt_token_123456780002','9999999','2020-01-27 10:29:22','2020-02-10 17:16:25','UD000001','1');

insert into user_app_data values
	('UA000001','审车平台','SU000001','users','1','MXWR','CarInspectionPlatform','CIP000001','/link/to/app','1'),
	('UA000002','账户管理','SU000001','bank','1','MXWR','UserDomain','UD000001','/link/to/app0002','1'),
	('UA000003','接车公司','SU000002','wechat','1','MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0003','1'),
	('UA000004','审车公司','SU000002','bar-chart','1','MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0004','1');

insert into quick_link_data values
	('QL000001','列表','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表','2020-02-12 19:27:58','UA000001','1'),
	('QL000002','列表0002','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0002','2020-02-15 21:29:10','UA000001','1'),
	('QL000003','列表0003','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0003','2020-02-06 18:28:44','UA000002','1'),
	('QL000004','列表0004','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0004','2020-01-30 01:39:58','UA000002','1'),
	('QL000005','列表0005','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0005','2020-01-28 16:35:25','UA000003','1'),
	('QL000006','列表0006','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0006','2020-02-05 20:30:39','UA000003','1'),
	('QL000007','列表0007','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0007','2020-02-06 07:06:42','UA000004','1'),
	('QL000008','列表0008','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0008','2020-01-30 06:02:53','UA000004','1');

insert into list_access_data values
	('LA000001','列表','levelOneCategoryList','1','1','1','1','1','UA000001','1'),
	('LA000002','列表0002','levelOneCategoryList0002','1','1','1','1','1','UA000001','1'),
	('LA000003','列表0003','levelOneCategoryList0003','1','1','1','1','1','UA000002','1'),
	('LA000004','列表0004','levelOneCategoryList0004','1','1','1','1','1','UA000002','1'),
	('LA000005','列表0005','levelOneCategoryList0005','1','1','1','1','1','UA000003','1'),
	('LA000006','列表0006','levelOneCategoryList0006','1','1','1','1','1','UA000003','1'),
	('LA000007','列表0007','levelOneCategoryList0007','1','1','1','1','1','UA000004','1'),
	('LA000008','列表0008','levelOneCategoryList0008','1','1','1','1','1','UA000004','1');

insert into object_access_data values
	('OA000001','控制访问列表1','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1'),
	('OA000002','控制访问列表10002','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000001','1'),
	('OA000003','控制访问列表10003','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000002','1'),
	('OA000004','控制访问列表10004','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000002','1'),
	('OA000005','控制访问列表10005','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000003','1'),
	('OA000006','控制访问列表10006','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000003','1'),
	('OA000007','控制访问列表10007','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000004','1'),
	('OA000008','控制访问列表10008','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1');

insert into login_history_data values
	('LH000001','2020-02-09 17:39:10','192.168.1.1','登陆成功','SU000001','1'),
	('LH000002','2020-02-02 15:14:29','192.168.1.2','登陆成功0002','SU000001','1'),
	('LH000003','2020-02-16 18:04:28','192.168.1.1','登陆成功0003','SU000002','1'),
	('LH000004','2020-02-15 10:19:29','192.168.1.2','登陆成功0004','SU000002','1');

insert into generic_form_data values
	('GF000001','登记输入单','姓名就是你身份证上的名字','1');

insert into form_message_data values
	('FM000001','字段组合错误','GF000001','success','1'),
	('FM000002','字段组合错误0002','GF000001','info','1');

insert into form_field_message_data values
	('FFM000001','输入错误','name','GF000001','success','1'),
	('FFM000002','输入错误0002','name0002','GF000001','info','1');

insert into form_field_data values
	('FF000001','姓名','name','name','text','GF000001','姓名就是你身份证上的名字','李一一','姓名就是你身份证上的名字','基础信息','maybe any value','a value expression','1','1','1','','','1'),
	('FF000002','年龄','age','name0002','longtext','GF000001','姓名就是你身份证上的名字0002','李一一0002','姓名就是你身份证上的名字0002','扩展信息','maybe any value0002','a value expression0002','1','1','1','','','1');

insert into form_action_data values
	('FA000001','功能','name','save','default','genericFormManager/name/name0002/name0003/','GF000001','1'),
	('FA000002','功能0002','name0002','update','warning','genericFormManager/name/name0002/name0003/0002','GF000001','1');

insert into candidate_container_data values
	('CC000001','我只是一个容器','1');

insert into candidate_element_data values
	('CE000001','搜索到的匹配字段','类型描述','https://demo.doublechaintech.com/demodata/imageManager/genImage/100/400/200/grey/','CC000001','1'),
	('CE000002','搜索到的匹配字段0002','类型描述0002','https://demo.doublechaintech.com/demodata/imageManager/genImage/100/400/200/grey/','CC000001','1');

insert into wechat_workapp_identify_data values
	('WWI000001','corporation123','user123','SU000001','2020-02-02 14:31:59','2020-01-30 07:51:04','1'),
	('WWI000002','corporation1230002','user1230002','SU000001','2020-02-01 16:07:54','2020-02-10 18:49:39','1'),
	('WWI000003','corporation1230003','user1230003','SU000002','2020-02-15 02:26:40','2020-01-26 21:09:44','1'),
	('WWI000004','corporation1230004','user1230004','SU000002','2020-01-27 22:31:41','2020-02-06 16:45:24','1');

insert into wechat_miniapp_identify_data values
	('WMI000001','wechat_open_id_1234567890','wechat_miniapp_id_1234567890','SU000001','2020-01-31 22:21:24','2020-02-08 12:29:41','1'),
	('WMI000002','wechat_open_id_12345678900002','wechat_miniapp_id_12345678900002','SU000001','2020-02-13 22:25:51','2020-02-06 04:27:57','1'),
	('WMI000003','wechat_open_id_12345678900003','wechat_miniapp_id_12345678900003','SU000002','2020-02-14 16:29:19','2020-02-17 15:28:18','1'),
	('WMI000004','wechat_open_id_12345678900004','wechat_miniapp_id_12345678900004','SU000002','2020-02-05 19:40:12','2020-02-08 18:28:35','1');





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


-- no change request type found

select mobile as `可用于登录的账号`, 'admin123' as `密码` from sec_user_data;

/*
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|


*/



/* start with data patch */
/* The sql file is not found from: /home/philip/resin-3.1.12/webapps/sky/data-patch/flowable.sql */
