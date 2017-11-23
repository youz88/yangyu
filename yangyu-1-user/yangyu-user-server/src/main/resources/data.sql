-- 排序从1开始，越高级别越低
-- 系统创建ID为0

truncate TABLE yangyu_user;
INSERT INTO yangyu_user(id,real_name,nick_name,password,salt,gender,age,email,phone,is_lock,is_delete,create_id,create_date) VALUES
(1,'Hello','超级管理员','$2a$10$Np7Diiw4T8IdGTlkvO6e1eqfbmwLtmv5EoNnyQ0i2/NOgrbUIQ/Ou','super',0,18,'123456@qq.com','13812345678',0,0,0,now()),
(2,'World','管理员','$2a$10$Np7Diiw4T8IdGTlkvO6e1eqfbmwLtmv5EoNnyQ0i2/NOgrbUIQ/Ou','admin',0,18,'123457@qq.com','13512345678',0,0,0,now()),
(3,null,'游客',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,now());

truncate TABLE yangyu_role;
INSERT INTO yangyu_role(id,`name`,sign,description,is_delete,orders,create_id,create_date) VALUES
(1,'超级管理员','super','所有权限',0,1,0,now()),
(2,'管理员','admin','除系统管理权限',0,1,0,now()),
(3,'游客','tourist','没有删除权限',0,1,0,now());


-- systemId{1:资讯,2:博客,3:问答,4:管理}
-- permission_type{0:目录,1:菜单,2:按钮}
-- component 代表前端渲染的组件名
truncate TABLE yangyu_permission;
INSERT INTO yangyu_permission(id,system_id,pid,permission_name,permission_type,permission_value,url,component,icon,is_delete,orders,create_id,create_date) VALUES
(1,0,0,'主页',0,null,'/',NULL,'home',0,0,0,now()),
(2,1,1,'资讯',0,NULL,NULL,NULL,'global',0,1,0,now()),
(3,2,1,'博客',0,NULL,NULL,NULL,'book',0,2,0,now()),
(4,3,1,'问答',0,NULL,NULL,NULL,'message',0,3,0,now()),
(5,4,1,'管理',0,NULL,NULL,NULL,'bars',0,4,0,now()),
-- 资讯
(101,1,2,'全部资讯',1,'news:information:read','/news/information/index','NewsInformationIndex',NULL,0,1,0,now()),
-- 博客
(111,2,3,'最新推荐',1,'blog:recommend:read','/blog/recommend/index','BlogRecommendIndex',NULL,0,1,0,now()),
(112,2,3,'我的博客',1,'blog:write:read','/blog/self/index','BlogSelfIndex',NULL,0,2,0,now()),
-- 问答
(121,3,4,'技术问答',1,'technical:question:read','/technical/question/index','TechnicalQuestionIndex',NULL,0,1,0,now()),
(122,3,4,'技术分享',1,'technical:share:read','/technical/share/index','TechnicalShareIndex',NULL,0,2,0,now()),
-- 管理
(131,4,5,'菜单管理',1,'menu:manage:read','/menu/manage/index','MenuManageIndex',NULL,0,1,0,now()),
(132,4,5,'用户管理',1,'user:manage:read','/user/manage/index','UserManageIndex',NULL,0,2,0,now()),
(133,4,5,'资讯管理',1,'news:manage:read','/news/manage/index','NewsManageIndex',NULL,0,3,0,now());

truncate TABLE yangyu_user_role;
INSERT INTO yangyu_user_role(id,user_id,role_id) VALUES
(1,1,1),
(2,2,2),
(3,3,3);

truncate TABLE yangyu_role_permission;
INSERT INTO yangyu_role_permission(id,role_id,permission_id) VALUES
-- 超级管理员
(1,1,1),
(2,1,2),
(3,1,3),
(4,1,4),
(5,1,5),
(6,1,101),
(7,1,111),
(8,1,112),
(9,1,121),
(10,1,122),
(11,1,131),
(12,1,132),
(13,1,133),

-- 管理员
(101,2,1),
(102,2,2),
(103,2,3),
(104,2,4),
(105,2,5),
(106,2,101),
(107,2,111),
(108,2,112),
(109,2,121),
(110,2,122),
(111,2,131),
(112,2,132),
(113,2,133),

-- 游客
(201,3,1),
(202,3,2),
(203,3,3),
(204,3,4),
(205,3,101),
(206,3,111),
(207,3,112),
(208,3,121),
(209,3,122);




