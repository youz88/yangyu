-- 排序从1开始，越高级别越低
-- 系统创建ID为0

truncate TABLE yangyu_user;
INSERT INTO yangyu_user(id,real_name,nick_name,password,salt,gender,age,email,phone,is_lock,is_delete,create_id,create_date) VALUES
(1,'Hello','超级管理员','$2a$10$Np7Diiw4T8IdGTlkvO6e1eqfbmwLtmv5EoNnyQ0i2/NOgrbUIQ/Ou','super',0,18,'123456@qq.com','13812345678',0,0,0,now()),
(2,'World','管理员','$2a$10$Np7Diiw4T8IdGTlkvO6e1eqfbmwLtmv5EoNnyQ0i2/NOgrbUIQ/Ou','admin',0,18,'123456@qq.com','13512345678',0,0,0,now()),
(3,null,'游客',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,now());

truncate TABLE yangyu_role;
INSERT INTO yangyu_role(id,`name`,sign,description,is_delete,orders,create_id,create_date) VALUES
(1,'超级管理员','super','所有权限',0,1,0,now()),
(2,'管理员','admin','除系统管理权限',0,1,0,now()),
(3,'游客','tourist','没有删除权限',0,1,0,now());


-- systemId{1:资讯,2:博客,3:问答}
-- permission_type{0:目录,1:菜单,2:按钮}
truncate TABLE yangyu_permission;
INSERT INTO yangyu_permission(id,system_id,pid,permission_name,permission_type,permission_value,url,icon,is_delete,orders,create_id,create_date) VALUES
(1,0,0,'主页',0,null,'/','home',0,0,0,now()),
(2,1,1,'资讯',0,NULL,NULL,'global',0,1,0,now()),
(3,2,1,'博客',0,NULL,NULL,'book',0,2,0,now()),
(4,3,1,'问答',0,NULL,NULL,'message',0,3,0,now()),

(101,1,2,'全部资讯',1,'news:information:read','/news/information/index','',0,1,0,now()),
(111,2,3,'最新推荐',1,'blog:recommend:read','/blog/recommend/index','',0,1,0,now()),
(112,2,3,'我的博客',1,'blog:write:read','/blog/write/index','',0,2,0,now());

truncate TABLE yangyu_user_role;
INSERT INTO yangyu_user_role(id,user_id,role_id) VALUES
(1,1,1),
(2,2,2),
(3,3,3);

truncate TABLE yangyu_role_permission;
INSERT INTO yangyu_role_permission(id,role_id,permission_id) VALUES
(1,1,1),
(2,1,2),
(3,1,3),
(4,1,4),
(5,1,101),
(6,1,111),
(7,1,112),

(8,2,1),
(9,2,2),
(10,2,3),
(11,2,4),
(12,2,101),
(13,2,111),
(14,2,112),

(15,3,1),
(16,3,2),
(17,3,3),
(18,3,4),
(19,3,101),
(20,3,111),
(21,3,112);






