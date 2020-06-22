#创建数据库
DROP DATABASE IF EXISTS huawei;
CREATE DATABASE huawei;
USE huawei;
#管理员表
DROP TABLE IF EXISTS admin;
CREATE TABLE admin(
	id INT AUTO_INCREMENT COMMENT'主键',
	aName VARCHAR(44) NOT NULL COMMENT'管理员名称',
	aPassword VARCHAR(44) NOT NULL COMMENT'密码',
	PRIMARY KEY(id)
)CHARSET 'utf8';
#插入测试数据 yes
INSERT INTO admin(aName,aPassword) VALUES('张三','123123'),
('张三1','123123'),
('张三2','123123');
#描述
DESC admin;
#查询
SELECT * FROM admin;
SELECT COUNT(0) AS totalCount FROM configure AS cof WHERE 1=1 cof.`cName` LIKE '%8%'
#用户表	
DROP TABLE IF EXISTS huser;
CREATE TABLE huser(
	id INT AUTO_INCREMENT COMMENT'主键',
	uName VARCHAR(44) NOT NULL COMMENT'用户名名称',
	uPassword VARCHAR(44) NOT NULL COMMENT'用户名密码',
	photo VARCHAR(255) COMMENT'头像',
	phone VARCHAR(44) NOT NULL COMMENT'手机号',
	country VARCHAR(44) COMMENT'国家地区',
	birthday TIMESTAMP COMMENT'生日',
	total INT COMMENT'积分',
	onsaleCoupon INT COMMENT'优惠券',
	cashCoupon INT COMMENT'代金券',
	petal INT COMMENT'花瓣',
	defaultAddress INT COMMENT'默认地址，外键',
	
	totalCheck INT COMMENT'所有选中的商品',
	totalPrice DOUBLE COMMENT'总价格',
	youPrice DOUBLE COMMENT'优惠价格',
	PRIMARY KEY(`id`,`phone`)
)CHARSET 'utf8';
#插入测试数据 yes
ALTER TABLE huser ADD defaultAddress INT 
INSERT INTO huser(uName,uPassword,photo,phone,country,birthday,total,onsaleCoupon,cashCoupon,petal) VALUES('王五','123123','img','1883288812','中国','2020-1-1',100,100,0,100),
('溜溜','123123','img','1883288812','中国','2020-1-1',100,100,0,100),
('小七','123123','img','1883288812','中国','2020-1-1',100,100,0,100);
#描述
DESC huser;
#查询
SELECT * FROM huser;
ALTER TABLE huser ADD totalCheck INT;
ALTER TABLE huser ADD totalPrice DOUBLE;
ALTER TABLE huser ADD youPrice DOUBLE;

UPDATE huser AS h SET h.`defaultAddress` = 1 WHERE h.`id` = 1 

SELECT c.`price` FROM shoppingcart AS s INNER JOIN combo AS c ON c.`id` = s.`comboId` WHERE s.`checked` = 0 AND s.`huserid` = 1 
SELECT COUNT(0) AS totalCheck FROM shoppingcart AS s WHERE s.`checked` = 0 AND s.`huserid` = 1
#地址表
DROP TABLE IF EXISTS address;
CREATE TABLE address(
	id INT AUTO_INCREMENT COMMENT'主键',
	huserid INT COMMENT'用户id',#
	aName VARCHAR(44) NOT NULL COMMENT'收货人',
	phone VARCHAR(33) NOT NULL COMMENT'收货电话',
	rePhone VARCHAR(44) NOT NULL COMMENT'备选号码',
	country VARCHAR(44) NOT NULL COMMENT'收货地址',
	detail VARCHAR(44) NOT NULL COMMENT'详细地址',
	postcode VARCHAR(44) COMMENT'邮编',	
	PRIMARY KEY(id),
	KEY `fk_address_huser`(huserid),
	CONSTRAINT `fk_address_huser` FOREIGN KEY(huserid) REFERENCES huser(id)
)CHARSET 'utf8';
#插入测试数据 yes
INSERT INTO address(huserid,aName,phone,rePhone,country,detail,postcode) VALUES(1,'李四','122032023','18824234','北京','故宫','033423'),
(2,'李四','122032023','18824234','北京','故宫1','033423'),
(3,'李四','122032023','18824234','北京','故宫2','033423');
#描述
DESC address;

#查询
SELECT * FROM address;
SELECT * FROM huser AS h WHERE h.`id` = 1
UPDATE huser AS h SET h.`defaultAddress` = 1
SELECT * FROM address AS a WHERE a.`huserid` = 1;
DELETE FROM address WHERE id > 6
#商品种类表
DROP TABLE IF EXISTS category;
CREATE TABLE category(
	id INT AUTO_INCREMENT COMMENT'主键',
	cName VARCHAR(44) NOT NULL COMMENT'种类名称',
	PRIMARY KEY(id)
)CHARSET 'utf8';
#插入测试数据 yes
INSERT INTO category(cName) VALUES('手机'),
('电脑'),
('平板'),
('智能穿戴&VR'),
('智能家居'),
('智慧屏'),
('耳机音箱'),
('配件'),
('生态产品'),
('增值服务&其他');
#描述
DESC category;
#查询
SELECT * FROM category WHERE id = 1;

SELECT c.`id`,c.`cName` FROM category AS c LEFT JOIN series AS s ON c.`id` = s.`categoryId` WHERE s.`id` = 1;

#商品细分（系列）表
DROP TABLE IF EXISTS series;
CREATE TABLE series(
	id INT AUTO_INCREMENT COMMENT'主键',
	sName VARCHAR(44) NOT NULL COMMENT'系列细分名称',
	image VARCHAR(44) COMMENT'系列细分图片',
	categoryId INT COMMENT'种类id',#
	PRIMARY KEY(id),
	KEY `fk_series_categoryId`(categoryId),
	CONSTRAINT `fk_series_categoryId` FOREIGN KEY(categoryId) REFERENCES category(id)
)CHARSET 'utf8';
#插入测试数据 yes
INSERT INTO series(sName,image,categoryId) VALUES('HUAWEI P系列','homeimage/category/1-1.png',1),
('HUAWEI Mate系列','homeimage/category/1-2.png',1),
('HUAWEI nova系列','homeimage/category/1-3.png',1),
('华为畅享系列','homeimage/category/1-4.png',1),
('HUAWEI 麦芒系列','homeimage/category/1-5.png',1),
('荣耀 V系列','homeimage/category/1-6.png',1),
('荣耀 HONOR系列','homeimage/category/1-7.png',1),
('荣耀 X系列','homeimage/category/1-8.png',1),
('荣耀 Play系列','homeimage/category/1-9.png',1),

('华为Matebook X系列','homeimage/category/2-1.png',2),
('华为Matebook系列','homeimage/category/2-2.png',2),
('华为Matebook D系列','homeimage/category/2-3.png',2),
('华为Matebook E系列','homeimage/category/2-4.png',2),
('荣耀MagicBook系列','homeimage/category/2-5.png',2),
('荣耀MagicBook Pro系列','homeimage/category/2-6.png',2),

('华为MatePad 系列','homeimage/category/3-1.png',3),
('华为畅享 系列','homeimage/category/3-2.png',3),
('荣耀数字系列','homeimage/category/3-3.png',3),
('荣耀畅玩系列','homeimage/category/3-4.png',3),

('VR','homeimage/category/4-1.png',4),
('智能手表','homeimage/category/4-2.png',4),
('儿童手表','homeimage/category/4-3.png',4),
('智能手环','homeimage/category/4-4.png',4),
('智能健康配件','homeimage/category/4-5.png',4),

('智能路由','homeimage/category/5-1.png',5),
('移动路由','homeimage/category/5-2.png',5),
('智能音箱','homeimage/category/5-3.png',5),
('WIFI放大器','homeimage/category/5-4.png',5),
('智能存储','homeimage/category/5-5.png',5),
('电视盒子','homeimage/category/5-6.png',5),
('HiLink生态','homeimage/category/5-7.png',5),

('华为智慧屏','homeimage/category/6-1.png',6),
('荣耀智慧屏','homeimage/category/6-2.png',6),

('真无线耳机','homeimage/category/7-1.jpg',7),
('有线耳机','homeimage/category/7-2.png',7),
('蓝牙耳机','homeimage/category/7-3.jpg',7),
('蓝牙音箱','homeimage/category/7-4.jpg',7),
('智能眼镜','homeimage/category/7-5.png',7),
('智能音箱','homeimage/category/7-6.png',7),

('穿戴配件','homeimage/category/8-1.jpg',8),
('电视盒子专属配件','homeimage/category/8-2.png',8),
('智慧屏配件','homeimage/category/8-3.png',8),
('平板配件','homeimage/category/8-4.png',8),
('个人电脑配件','homeimage/category/8-5.png',8),
('贴膜','homeimage/category/8-6.png',8),
('保护套','homeimage/category/8-7.png',8),
('保护壳','homeimage/category/8-8.png',8),
('生活周边','homeimage/category/8-9.png',8),
('智能硬件','homeimage/category/8-10.png',8),
('摄像机/镜头','homeimage/category/8-11.png',8),
('自拍杆/支架','homeimage/category/8-12.png',8),
('充电器/线材','homeimage/category/8-13.png',8),
('移动电源','homeimage/category/8-14.png',8),

('个护美妆','homeimage/category/9-1.png',9),
('影音娱乐','homeimage/category/9-2.png',9),
('厨电卫浴','homeimage/category/9-3.png',9),
('户外出行','homeimage/category/9-4.png',9),
('运动健身','homeimage/category/9-5.png',9),
('健康保健','homeimage/category/9-6.png',9),
('安防门锁','homeimage/category/9-7.png',9),
('环境卫士','homeimage/category/9-8.png',9),
('数码周边','homeimage/category/9-9.png',9),
('生活电器','homeimage/category/9-10.png',9),
('智能灯光','homeimage/category/9-11.png',9),

('AI 计算平台','homeimage/category/10-1.png',10),
('服务器','homeimage/category/10-2.png',10),
('电池更换服务','homeimage/category/10-3.png',10),
('华为云空间','homeimage/category/10-4.png',10),
('华为音乐卡','homeimage/category/10-5.png',10),
('花币卡','homeimage/category/10-6.png',10),
('华为视频卡','homeimage/category/10-7.png',10);

#描述
DESC series;
#查询
SELECT * FROM series;
DELETE FROM series WHERE id = 72
#订单状态表
DROP TABLE IF EXISTS indentstate;
CREATE TABLE indentstate(
	id INT AUTO_INCREMENT COMMENT'主键',
	sName VARCHAR(44) COMMENT'
				  1：已下单
				  2：未付款
				  3：待收货
				  4：已完成
				  5：待评价
				  6：已取消',
	PRIMARY KEY(id)
)CHARSET 'utf8';
#插入测试数据 yes
INSERT INTO indentstate(sName) VALUES('已下单'),
('未付款'),
('待发货'),
('待收货'),
('已完成'),
('待评价'),
('已取消');
#描述
DESC indentstate;
#查询
SELECT * FROM indentstate;
SELECT * FROM series AS s WHERE 1=1 AND s.`sName` LIKE '%%' AND s.`categoryId` = 1 LIMIT 0 , 5
#商品促销表
DROP TABLE IF EXISTS promotion;
CREATE TABLE promotion(
	id INT AUTO_INCREMENT COMMENT'主键',
	title VARCHAR(44) NOT NULL COMMENT'促销标题',
	content VARCHAR(44) NOT NULL COMMENT'促销内容',
	PRIMARY KEY(id)
)CHARSET 'utf8';
#插入测试数据 yes
INSERT INTO promotion(title,content) VALUES('一站式换新','APP专享，最高再享250元补贴'),
('限量送','10/12/14/16/20点限量送10000mAh移动电源（荣耀指定手机共享）'),
('赠送积分','购买即赠商城积分，积分可抵现~'),
('限量送','10:00-23:00每个整点限量送10000mAh移动电源（荣耀指定手机共享'),
('限时优惠','限时优惠200元'),
('积分双倍抵现','下单使用5000以内积分可双倍抵现'),
('以旧换新抵现','APP专享，最高补贴350元'),
('赠送积分','购买即赠商城积分，积分可抵现~'),
('限量送','10:00-23:00每个整点限量送10000mAh移动电源（荣耀指定手机共享'),
('限时优惠','限时优惠200元'),
('积分双倍抵现','下单使用5000以内积分可双倍抵现'),
('以旧换新抵现','APP专享，最高补贴350元'),
('分期免息','银联、掌上生活、工行分期支付可享免息（免息活动适用于单款免息商品订单，含多款商品订单'),
('分期免息','银联、掌上生活、工行分期支付可享免息（免息活动适用于单款免息商品订单，含多款商品订单'),
('商品赠券','赠送优酷VIP半年卡5折券+幸福西饼百元礼包+樊登读书14天VIP');
#描述
DESC promotion;
#查询
SELECT * FROM promotion;

#商品表
DROP TABLE IF EXISTS commodity;
CREATE TABLE commodity(
	id INT AUTO_INCREMENT COMMENT'主键',
	cName VARCHAR(44) NOT NULL COMMENT'商品名',
	categoryid INT COMMENT'商品种类',#
	seriesId INT COMMENT'系列id',#
	putawayTime DATETIME COMMENT'上架时间',
	image VARCHAR(44) COMMENT'主页显示',	
	PRIMARY KEY(id),
	KEY `fk_shopping_category`(categoryid),
	CONSTRAINT `fk_shopping_category` FOREIGN KEY(categoryid) REFERENCES category(id),
	
	KEY `fk_commodity_seriesId`(seriesId),
	CONSTRAINT `fk_commodity_seriesId` FOREIGN KEY(seriesId) REFERENCES series(id)
)CHARSET 'utf8';
SELECT COUNT(0) AS totalCount FROM commodity AS com WHERE com.`seriesId` = 3
#插入测试数据 yes
SELECT com.* FROM commodity AS com INNER JOIN colorandconfigure AS cou ON com.`id` = cou.`commodityId` WHERE cou.`id` = 1;
INSERT INTO commodity(cName,categoryid,seriesId,putawayTime,image) VALUES('HUAWEI P30 Pro',1,1,'2020-2-2','homeimage/floor/1-0.png'),
('荣耀V30',1,2,'2020-2-2','homeimage/floor/1-1.png'),
('HUAffWEI P30',1,2,'2020-2-2','homeimage/floor/1-2.png'),
('HUAWfEI P30',1,4,'2020-2-2','homeimage/floor/1-3.png'),
('荣ff耀V30',1,5,'2020-2-2','homeimage/floor/1-4.png'),
('HUffAWEI P30',1,6,'2020-2-2','homeimage/floor/1-5.png'),
('HUAffWEI P30',1,7,'2020-2-2','homeimage/floor/1-6.png'),
('荣fff耀V30',1,8,'2020-2-2','homeimage/floor/1-7.png'),
('HUAffWEI P30',1,9,'2020-2-2','homeimage/floor/1-8.png'),
('HUAfffWEI P30',1,3,'2020-2-2','homeimage/floor/1-9.png'),
('荣ffff耀V30',1,2,'2020-2-2','homeimage/floor/1-10.png'),
('HUAWffEI P30',1,2,'2020-2-2','homeimage/floor/1-11.png'),
('HUAWfffEI P30',1,3,'2020-2-2','homeimage/floor/1-12.png'),
('荣耀fffV30',1,2,'2020-2-2','homeimage/floor/1-1.png'),
('HUAfWEI P30',1,9,'2020-2-2','homeimage/floor/1-13.png'),
('HUAfWfEI P30',1,7,'2020-2-2','homeimage/floor/1-14.png'),
('荣耀fffV30',1,2,'2020-2-2','homeimage/floor/1-1.png'),
('HUAffWEI P30',1,2,'2020-2-2','homeimage/floor/1-2.png'),
('HUAfWfEI P30',1,4,'2020-2-2','homeimage/floor/1-3.png'),
('f',1,5,'2020-2-2','homeimage/floor/1-4.png'),
('HUffffAfWEI P30',1,6,'2020-2-2','homeimage/floor/1-5.png'),
('HUAffffWEI P30',1,7,'2020-2-2','homeimage/floor/1-6.png'),
('荣f耀V30',1,8,'2020-2-2','homeimage/floor/1-7.png'),
('HUAffffWEI P30',1,9,'2020-2-2','homeimage/floor/1-8.png'),
('HUAffWEI P30',1,3,'2020-2-2','homeimage/floor/1-9.png'),
('荣fffff耀V30',1,2,'2020-2-2','homeimage/floor/1-10.png'),
('HUfAfWfffEI P30',1,2,'2020-2-2','homeimage/floor/1-11.png'),
('HUAWfEI P30',1,3,'2020-2-2','homeimage/floor/1-12.png'),
('荣ff耀fffV30',1,2,'2020-2-2','homeimage/floor/1-1.png'),
('HUAffWEI P30',1,9,'2020-2-2','homeimage/floor/1-13.png'),
('HUAWfEI P30',1,7,'2020-2-2','homeimage/floor/1-14.png'),

('荣耀dsV30',2,10,'2020-2-2','homeimage/floor/2-0.png'),
('HUAdfsdWEI P30',2,11,'2020-2-2','homeimage/floor/2-2.png'),
('HUdffdfAWEI P30',2,12,'2020-2-2','homeimage/floor/2-3.png'),
('荣df耀V30',2,13,'2020-2-2','homeimage/floor/2-4.png'),
('HUfAffWEI P30',2,14,'2020-2-2','homeimage/floor/2-5.png'),
('HUf耀dV30',2,16,'2020-2-2','homeimage/floor/2-7.png'),
('HUAWfdEI P30',2,17,'2020-2-2','homeimage/floor/2-8.png'),
('HUAffWdEI P30',2,18,'2020-2-2','homeimage/floor/2-9.png'),
('荣耀fdsV30',2,10,'2020-2-2','homeimage/floor/2-0.png'),
('HUAffdfAWEI P30',2,12,'2020-2-2','homeimage/floor/2-3.png'),
('荣df耀V30',2,13,'2020-2-2','homeimage/floor/2-4.png'),
('HUAffWEI P30',2,14,'2020-2-2','homeimage/floor/2-5.png'),
('HUfddffAdfWEI P30',2,15,'2020-2-2','homeimage/floor/2-6.png'),
('荣f耀fdV30',2,16,'2020-2-2','homeimage/floor/2-7.png'),
('HUAWfdEI P30',2,17,'2020-2-2','homeimage/floor/2-8.png'),
('HUAWdEI P30',2,18,'2020-2-2','homeimage/floor/2-9.png'),
('荣f耀dsV30',2,10,'2020-2-2','homeimage/floor/2-0.png'),
('HUAffdfsdWEI P30',2,11,'2020-2-2','homeimage/floor/2-2.png'),
('HUdfdfAWEI P30',2,12,'2020-2-2','homeimage/floor/2-3.png'),
('荣fdff耀V30',2,13,'2020-2-2','homeimage/floor/2-4.png'),
('HUffddfAdfWEI P30',2,15,'2020-2-2','homeimage/floor/2-6.png'),
('荣f耀dV30',2,16,'2020-2-2','homeimage/floor/2-7.png'),
('HUfAWfdEI P30',2,17,'2020-2-2','homeimage/floor/2-8.png'),
('HUAfWdEI P30',2,18,'2020-2-2','homeimage/floor/2-9.png'),
('荣f耀dsV30',2,10,'2020-2-2','homeimage/floor/2-0.png'),
('HUffAdfsdWEI P30',2,11,'2020-2-2','homeimage/floor/2-2.png'),
('HUdfffdfAWEI P30',2,12,'2020-2-2','homeimage/floor/2-3.png'),
('荣fdff耀V30',2,13,'2020-2-2','homeimage/floor/2-4.png'),
('HUAffWEI P30',2,14,'2020-2-2','homeimage/floor/2-5.png'),
('HUffdfdfAdfWEI P30',2,15,'2020-2-2','homeimage/floor/2-6.png'),
('荣耀dV30',2,16,'2020-2-2','homeimage/floor/2-7.png'),
('HUfAWffdEI P30',2,17,'2020-2-2','homeimage/floor/2-8.png'),
('HUAWdEI P30',2,18,'2020-2-2','homeimage/floor/2-9.png'),



('荣耀sdfV30',3,17,'2020-2-2','homeimage/floor/3-0.png'),
('HUdfadAWEI P30',3,18,'2020-2-2','homeimage/floor/3-1.png'),
('HUAWdfEI P30',3,19,'2020-2-2','homeimage/floor/3-2.png'),
('荣ggggg耀sdfV30',3,18,'2020-2-2','homeimage/floor/3-3.png'),
('荣gdfV30',3,17,'2020-2-2','homeimage/floor/3-0.png'),
('HUdfAWEI P30',3,18,'2020-2-2','homeimage/floor/3-1.png'),
('HUAEI P30',3,19,'2020-2-2','homeimage/floor/3-2.png'),
('荣g耀gggsdfV30',3,18,'2020-2-2','homeimage/floor/3-3.png'),
('荣耀sdfV30',3,17,'2020-2-2','homeimage/floor/3-0.png'),
('HUdfaAWEI P30',3,18,'2020-2-2','homeimage/floor/3-1.png'),
('HUAWggdfEI P30',3,19,'2020-2-2','homeimage/floor/3-2.png'),
('荣耀gsdfV30',3,18,'2020-2-2','homeimage/floor/3-3.png');
#描述
DESC commodity;
#查询
SELECT * FROM commodity;



#套餐表
DROP TABLE IF EXISTS combo;
CREATE TABLE combo(
	id INT AUTO_INCREMENT COMMENT'主键',
	cName VARCHAR(44) NOT NULL COMMENT'套餐名',
	price DOUBLE COMMENT'套餐价格',
	Commodityid INT COMMENT'商品id',#
	huiPrice DOUBLE COMMENT'优惠价格',
	PRIMARY KEY(id),
	KEY `fk_combo_Commodityid`(Commodityid),
	CONSTRAINT `fk_combo_Commodityid` FOREIGN KEY(Commodityid) REFERENCES Commodity(id)
)CHARSET 'utf8';
ALTER TABLE combo ADD huiPrice DOUBLE
#插入测试数据 yes
INSERT INTO combo(cName,price,Commodityid,huiPrice) VALUES('官方标配',0,51,4234.33),
('音乐套餐1',300.99,50,4234.33),
('音乐套餐2',330.99,49,4234.33),
('音乐套餐3',340.99,48,4234.33),
('音乐套餐1',300.99,47,4234.33),
('音f乐套餐2',330.99,46,4234.33),
('音f乐套餐3',340.99,45,4234.33),
('音f乐套餐1',300.99,44,4234.33),
('音乐套餐2',330.99,43,4234.33),
('音f乐套餐3',340.99,42,4234.33),
('音乐套餐1',300.99,41,4234.33),
('音f乐套餐2',330.99,40,4234.33),
('音乐套餐3',340.99,39,4234.33),
('音乐套餐1',300.99,38,4234.33),
('音ff乐套餐3',340.99,37,4234.33),
('音f乐套餐1',300.99,36,4234.33),
('音乐套餐2',330.99,35,4234.33),
('音f乐套餐3',340.99,34,4234.33),
('音乐套餐1',300.99,33,4234.33),
('音f乐套餐2',330.99,32,4234.33),
('音乐套餐3',340.99,31,4234.33),
('音f乐套餐1',300.99,29,4234.33),
('音乐套餐2',330.99,28,4234.33),
('音乐套餐3',340.99,27,4234.33),
('音乐ff套餐1',300.99,26,4234.33),


('音乐套餐1',300.99,75,4234.33),
('音乐套餐2',330.99,74,4234.33),
('音乐套餐3',340.99,73,4234.33),
('音乐套餐1',300.99,72,4234.33),
('音f乐套餐2',330.99,71,4234.33),
('音f乐套餐3',340.99,70,4234.33),
('音f乐套餐1',300.99,69,4234.33),
('音乐套餐2',330.99,68,4234.33),
('音f乐套餐3',340.99,67,4234.33),
('音乐套餐1',300.99,66,4234.33),
('音f乐套餐2',330.99,65,4234.33),
('音乐套餐3',340.99,64,4234.33),
('音乐套餐1',300.99,63,4234.33),
('音ff乐套餐3',340.99,62,4234.33),
('音f乐套餐1',300.99,61,4234.33),
('音乐套餐2',330.99,60,4234.33),
('音f乐套餐3',340.99,59,4234.33),
('音乐套餐1',300.99,58,4234.33),
('音f乐套餐2',330.99,57,4234.33),
('音乐套餐3',340.99,56,4234.33),
('音f乐套餐1',300.99,55,4234.33),
('音乐套餐2',330.99,54,4234.33),
('音乐套餐3',340.99,53,4234.33),
('音乐ff套餐1',300.99,52,4234.33),



('音乐套餐1',300.99,2,4234.33),
('音乐套餐2',330.99,3,4234.33),
('音乐套餐3',340.99,4,4234.33),
('音乐套餐1',300.99,5,4234.33),
('音f乐套餐2',330.99,6,4234.33),
('音f乐套餐3',340.99,7,4234.33),
('音f乐套餐1',300.99,8,4234.33),
('音乐套餐2',330.99,9,4234.33),
('音f乐套餐3',340.99,10,4234.33),
('音乐套餐1',300.99,11,4234.33),
('音f乐套餐2',330.99,12,4234.33),
('音乐套餐3',340.99,13,4234.33),
('音乐套餐1',300.99,14,4234.33),
('音ff乐套餐3',340.99,16,4234.33),
('音f乐套餐1',300.99,17,4234.33),
('音乐套餐2',330.99,18,4234.33),
('音f乐套餐3',340.99,19,4234.33),
('音乐套餐1',300.99,20,4234.33),
('音f乐套餐2',330.99,21,4234.33),
('音乐套餐3',340.99,22,4234.33),
('音f乐套餐1',300.99,23,4234.33),
('音乐套餐2',330.99,24,4234.33),
('音乐套餐3',340.99,25,4234.33),
('音乐ff套餐1',300.99,26,4234.33),
('音乐套餐2',330.99,27,4234.33),
('音乐f套餐3',340.99,28,4234.33),
('音乐套餐1',300.99,29,4234.33),
('音乐f套餐2',330.99,30,4234.33),
('音乐套餐3',340.99,31,4234.33),
('音乐f套餐1',300.99,12,4234.33),
('音乐套餐2',330.99,33,4234.33),
('音f乐套餐3',340.99,35,4234.33),
('音乐套餐1',300.99,53,4234.33),
('音f乐套餐2',330.99,66,4234.33),
('音乐套餐3',340.99,7,4234.33),
('音乐f套餐1',300.99,8,4234.33),
('音乐套餐2',330.99,9,4234.33),
('音乐套餐3',340.99,10,4234.33),
('音f乐套餐1',300.99,11,4234.33),
('音乐套餐2',330.99,12,4234.33),
('音乐ff套餐1',300.99,14,4234.33),
('音f乐套餐2',330.99,15,4234.33),
('音乐f套餐3',340.99,16,4234.33),
('音乐套餐1',300.99,17,4234.33),
('音乐套餐2',330.99,18,4234.33),
('音乐套餐3',340.99,19,4234.33),
('音乐套餐1',300.99,20,4234.33),
('音f乐套餐2',330.99,21,4234.33),
('音乐套餐3',340.99,22,4234.33),
('音f乐套餐1',300.99,23,4234.33),
('音乐套餐2',330.99,24,4234.33),
('音f乐套餐3',340.99,25,4234.33),
('音乐f套餐1',300.99,26,4234.33),
('音ff乐套餐2',330.99,27,4234.33),
('音乐f套餐3',340.99,28,4234.33),
('音f乐f套餐1',300.99,29,4234.33),
('音ff乐套餐2',330.99,30,4234.33),
('音乐套餐3',340.99,31,4234.33),
('音f乐套餐1',300.99,12,4234.33),
('音f乐f套餐2',330.99,33,4234.33),
('音乐套餐3',340.99,35,4234.33),
('音乐f套餐1',300.99,53,4234.33),
('音乐套餐2',330.99,66,4234.33),
('音乐套餐3',340.99,33,4234.33);

#描述
DESC combo;
#查询
SELECT * FROM combo;
#重点,颜色配置对应商品,有货
SELECT COUNT(*) AS coun FROM colorandconfigure AS c LEFT JOIN commodity AS com ON c.`commodityId` = com.`id` WHERE com.`id` = 1 AND c.`colorId` = 2 AND c.`configureId` = 1;

SELECT co.* FROM color AS co LEFT JOIN colorandconfigure AS cou ON co.`id` = cou.`colorId` WHERE cou.`commodityId` = 1 GROUP BY co.id
SELECT * FROM commodity
SELECT * FROM colorandconfigure AS cl WHERE cl.`id` = 128



DROP TABLE IF EXISTS combocommodity;
CREATE TABLE combocommodity(
	id INT AUTO_INCREMENT COMMENT'主键',
	Comboid INT COMMENT'套餐id',#
	Commodityid INT COMMENT'商品id',#
	PRIMARY KEY(id),
	KEY `fk_combocommodity_Comboid`(Comboid),
	CONSTRAINT `fk_combocommodity_Comboid` FOREIGN KEY(Comboid) REFERENCES Combo(id),
	
	KEY `fk_combocommodity_Commodityid`(Commodityid),
	CONSTRAINT `fk_combocommodity_Commodityid` FOREIGN KEY(Commodityid) REFERENCES Commodity(id)
)CHARSET 'utf8';
SELECT * FROM indentstate 
#插入测试数据 yes
#套餐对应的商品
SELECT * FROM combocommodity AS ccd LEFT JOIN combo AS cb ON cb.`id` = ccd.`Comboid` LEFT JOIN commodity AS com ON com.`id` = ccd.`Commodityid` LEFT JOIN colorandconfigure AS cl ON cl.`commodityId` = ccd.`Commodityid` WHERE cb.`id` =62
INSERT INTO combocommodity(Comboid,Commodityid) VALUES(3,7),
(2,2),
(3,3),
(4,1),
(5,2),
(6,34),
(7,1),
(8,3),
(9,3),
(10,1),
(11,52),
(12,3),
(13,23),
(3,3),
(4,1),
(5,2),
(6,34),
(7,1),
(8,3),
(9,3),
(10,1),
(11,52),
(12,3),
(13,23),
(14,2),
(14,2),
(15,3),
(16,61),
(17,2),
(18,3),
(19,34),
(20,2),
(21,23),
(22,1),
(23,42),
(24,3),
(25,3),
(26,2),
(27,3);
#描述
DESC combocommodity;
#查询
SELECT * FROM combocommodity

#商品颜色表
DROP TABLE IF EXISTS color;
CREATE TABLE color(
	id INT AUTO_INCREMENT COMMENT'主键',
	cName VARCHAR(44) NOT NULL COMMENT'商品颜色',
	PRIMARY KEY(id)
)CHARSET 'utf8';
#插入测试数据 yes
SELECT co.* FROM color AS co LEFT JOIN colorandconfigure AS cou ON co.`id` = cou.`colorId` WHERE cou.`commodityId` = 1;
INSERT INTO color(cName) VALUES('幻夜黑'),
('鲽鱼d白'),
('鲽的f鱼白'),
('鲽d鱼d白'),
('鲽鱼d白'),
('鲽dd白'),
('鲽鱼ddd白'),
('鲽白'),
('鲽ddfa鱼dd白'),
('鲽'),
('鲽鱼d白'),
('鲽鱼dd白'),
('黑中黑');
#描述
DESC color;
#查询
SELECT * FROM color;


#商品配置表
DROP TABLE IF EXISTS configure;
CREATE TABLE configure(
	id INT AUTO_INCREMENT COMMENT'主键',
	cName VARCHAR(44) NOT NULL COMMENT'配置名称',
	PRIMARY KEY(id)
)CHARSET 'utf8';
#插入测试数据 yes
INSERT INTO configure(cName) VALUES('全网通8GB+128GB'),
('全网通4GB+64GB'),
('全网通3GB+64GB'),
('全网通3GB+6334GB'),
('全网通5GB+64GB'),
('全网通5GB+634GB'),
('全网通2GB+64GB'),
('全网通4GB+634GB'),
('全网通6GB+644GB'),
('全网通7GB+654GB'),
('全网通1GB+614GB'),
('全网通12GB+624GB'),
('全网通3GB+644GB'),
('全网通5GB+654GB'),
('全网通34GB+64GB');
#描述
DESC configure;
#查询
SELECT * FROM configure;


SELECT * FROM colorandconfigure
#颜色跟配置细表
DROP TABLE IF EXISTS colorandconfigure;
CREATE TABLE colorandconfigure(
	id INT AUTO_INCREMENT COMMENT'主键',
	configureId INT COMMENT'配置id',#
	colorId INT COMMENT'颜色id',#
	store INT COMMENT'商品库存',
	price DOUBLE COMMENT'商品价格',
	images VARCHAR(444) NOT NULL COMMENT'商品颜色图片',
	title VARCHAR(44) NOT NULL COMMENT'配置商品标题',
	descs VARCHAR(44) COMMENT'配置商品描述',
	promotionId INT COMMENT'促销id',#
	commodityId INT COMMENT'商品id',#
	PRIMARY KEY(id),
	KEY `fk_colorandconfigure_configureId`(configureId),
	CONSTRAINT `fk_colorandconfigure_configureId` FOREIGN KEY(configureId) REFERENCES configure(id),
	
	KEY `fk_colorandconfigure_colorId`(colorId),
	CONSTRAINT `fk_colorandconfigure_colorId` FOREIGN KEY(colorId) REFERENCES color(id),
	
	KEY `fk_colorandconfigure_promotionId`(promotionId),
	CONSTRAINT `fk_colorandconfigure_promotionId` FOREIGN KEY(promotionId) REFERENCES promotion(id),
	
	KEY `fk_colorandconfigure_commodityId`(commodityId),
	CONSTRAINT `fk_colorandconfigure_commodityId` FOREIGN KEY(commodityId) REFERENCES commodity(id)
)CHARSET 'utf8';
#插入测试数据 yes
INSERT INTO colorandconfigure(configureId,colorId,store,price,images,title,descs,promotionId,commodityId) VALUES
(8,9,12,33299.99,'3-1-1.jpg;3-1-2.png;3-1-3.png;3-1-4.png;3-1-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀3机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,1),
(2,2,132,3299.99,'1-2-1.png;1-2-2.png;1-2-3.png;1-2-4.png;1-2-5.png;1-2-6.png;1-2-7.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,2),
(3,3,12,3299.99,'1-3-1.png;1-3-2.png;1-3-3.png;1-3-4.png;1-3-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128蝶羽白','【30S国内旅赢荣耀耳机！③还有更多优惠券包等你拿！',1,3),
(4,4,132,3299.99,'1-4-1.png;1-4-2.png;1-4-3.png;1-4-4.png;1-4-5.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,4),
(5,5,12,3299.99,'2-1-1.png;2-1-2.png;2-1-3.png;2-1-4.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 白','【荣耀30S新品】①购机赢国内旅晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,6),
(6,6,132,3299.99,'2-2-1.jpg;2-2-2.png;2-2-3.png;2-2-4.png;2-2-5.png;2-2-6.png;','荣耀30S 3双模5G 麒麟820 5G芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,5),
(7,7,12,3299.99,'3-1-1.jpg;3-1-2.png;3-1-3.png;3-1-4.png;3-1-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+1GB 蝶羽白','【荣耀30S新品】①购机赢国内法耀耳机！③还有更多优惠券包等你拿！',1,7),
(1,1,12,33299.99,'1-1-1.png;1-1-2.png;1-1-3.png;1-1-4.png;1-1-5.png;1-1-6.png;1-1-7.png;1-1-8.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀3机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,9),
(2,2,132,3299.99,'1-2-1.png;1-2-2.png;1-2-3.png;1-2-4.png;1-2-5.png;1-2-6.png;1-2-7.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,8),
(3,3,12,3299.99,'1-3-1.png;1-3-2.png;1-3-3.png;1-3-4.png;1-3-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128蝶羽白','【30S国内旅赢荣耀耳机！③还有更多优惠券包等你拿！',1,10),
(4,4,132,3299.99,'1-4-1.png;1-4-2.png;1-4-3.png;1-4-4.png;1-4-5.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,11),
(5,5,12,3299.99,'2-1-1.png;2-1-2.png;2-1-3.png;2-1-4.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 白','【荣耀30S新品】①购机赢国内旅晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,12),
(6,6,132,3299.99,'2-2-1.jpg;2-2-2.png;2-2-3.png;2-2-4.png;2-2-5.png;2-2-6.png;','荣耀30S 3双模5G 麒麟820 5G芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,13),
(7,7,12,3299.99,'3-1-1.jpg;3-1-2.png;3-1-3.png;3-1-4.png;3-1-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+1GB 蝶羽白','【荣耀30S新品】①购机赢国内法耀耳机！③还有更多优惠券包等你拿！',2,7),
(1,1,12,33299.99,'1-1-1.png;1-1-2.png;1-1-3.png;1-1-4.png;1-1-5.png;1-1-6.png;1-1-7.png;1-1-8.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀3机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,14),
(2,2,132,3299.99,'1-2-1.png;1-2-2.png;1-2-3.png;1-2-4.png;1-2-5.png;1-2-6.png;1-2-7.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,25),
(3,3,12,3299.99,'1-3-1.png;1-3-2.png;1-3-3.png;1-3-4.png;1-3-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128蝶羽白','【30S国内旅赢荣耀耳机！③还有更多优惠券包等你拿！',1,14),
(4,4,132,3299.99,'1-4-1.png;1-4-2.png;1-4-3.png;1-4-4.png;1-4-5.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,16),
(5,5,12,3299.99,'2-1-1.png;2-1-2.png;2-1-3.png;2-1-4.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 白','【荣耀30S新品】①购机赢国内旅晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,17),
(6,6,132,3299.99,'2-2-1.jpg;2-2-2.png;2-2-3.png;2-2-4.png;2-2-5.png;2-2-6.png;','荣耀30S 3双模5G 麒麟820 5G芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,18),
(7,7,12,3299.99,'3-1-1.jpg;3-1-2.png;3-1-3.png;3-1-4.png;3-1-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+1GB 蝶羽白','【荣耀30S新品】①购机赢国内法耀耳机！③还有更多优惠券包等你拿！',1,19),
(1,1,12,33299.99,'1-1-1.png;1-1-2.png;1-1-3.png;1-1-4.png;1-1-5.png;1-1-6.png;1-1-7.png;1-1-8.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀3机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,20),
(2,2,132,3299.99,'1-2-1.png;1-2-2.png;1-2-3.png;1-2-4.png;1-2-5.png;1-2-6.png;1-2-7.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,21),
(3,3,12,3299.99,'1-3-1.png;1-3-2.png;1-3-3.png;1-3-4.png;1-3-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128蝶羽白','【30S国内旅赢荣耀耳机！③还有更多优惠券包等你拿！',1,33),
(4,4,132,3299.99,'1-4-1.png;1-4-2.png;1-4-3.png;1-4-4.png;1-4-5.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,42),
(5,5,12,3299.99,'2-1-1.png;2-1-2.png;2-1-3.png;2-1-4.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 白','【荣耀30S新品】①购机赢国内旅晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,61),
(6,6,132,3299.99,'2-2-1.jpg;2-2-2.png;2-2-3.png;2-2-4.png;2-2-5.png;2-2-6.png;','荣耀30S 3双模5G 麒麟820 5G芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,51),
(7,7,12,3299.99,'3-1-1.jpg;3-1-2.png;3-1-3.png;3-1-4.png;3-1-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+1GB 蝶羽白','【荣耀30S新品】①购机赢国内法耀耳机！③还有更多优惠券包等你拿！',1,17),
(1,1,12,33299.99,'1-1-1.png;1-1-2.png;1-1-3.png;1-1-4.png;1-1-5.png;1-1-6.png;1-1-7.png;1-1-8.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀3机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',11,11),
(2,2,132,3299.99,'1-2-1.png;1-2-2.png;1-2-3.png;1-2-4.png;1-2-5.png;1-2-6.png;1-2-7.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',4,12),##########
(3,3,12,3299.99,'1-3-1.png;1-3-2.png;1-3-3.png;1-3-4.png;1-3-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128蝶羽白','【30S国内旅赢荣耀耳机！③还有更多优惠券包等你拿！',3,31),
(4,4,132,3299.99,'1-4-1.png;1-4-2.png;1-4-3.png;1-4-4.png;1-4-5.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,3),
(5,5,12,3299.99,'2-1-1.png;2-1-2.png;2-1-3.png;2-1-4.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 白','【荣耀30S新品】①购机赢国内旅晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,4),
(6,6,132,3299.99,'2-2-1.jpg;2-2-2.png;2-2-3.png;2-2-4.png;2-2-5.png;2-2-6.png;','荣耀30S 3双模5G 麒麟820 5G芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,55),
(7,7,12,3299.99,'3-1-1.jpg;3-1-2.png;3-1-3.png;3-1-4.png;3-1-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+1GB 蝶羽白','【荣耀30S新品】①购机赢国内法耀耳机！③还有更多优惠券包等你拿！',1,27),
(1,1,12,33299.99,'1-1-1.png;1-1-2.png;1-1-3.png;1-1-4.png;1-1-5.png;1-1-6.png;1-1-7.png;1-1-8.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀3机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,31),
(2,2,132,3299.99,'1-2-1.png;1-2-2.png;1-2-3.png;1-2-4.png;1-2-5.png;1-2-6.png;1-2-7.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,32),
(3,3,12,3299.99,'1-3-1.png;1-3-2.png;1-3-3.png;1-3-4.png;1-3-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128蝶羽白','【30S国内旅赢荣耀耳机！③还有更多优惠券包等你拿！',1,23),
(4,4,132,3299.99,'1-4-1.png;1-4-2.png;1-4-3.png;1-4-4.png;1-4-5.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,44),
(5,5,12,3299.99,'2-1-1.png;2-1-2.png;2-1-3.png;2-1-4.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 白','【荣耀30S新品】①购机赢国内旅晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,26),
(6,6,132,3299.99,'2-2-1.jpg;2-2-2.png;2-2-3.png;2-2-4.png;2-2-5.png;2-2-6.png;','荣耀30S 3双模5G 麒麟820 5G芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,45),
(7,7,12,3299.99,'3-1-1.jpg;3-1-2.png;3-1-3.png;3-1-4.png;3-1-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+1GB 蝶羽白','【荣耀30S新品】①购机赢国内法耀耳机！③还有更多优惠券包等你拿！',1,17),
(1,1,12,33299.99,'1-1-1.png;1-1-2.png;1-1-3.png;1-1-4.png;1-1-5.png;1-1-6.png;1-1-7.png;1-1-8.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀3机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,11),
(2,2,132,3299.99,'1-2-1.png;1-2-2.png;1-2-3.png;1-2-4.png;1-2-5.png;1-2-6.png;1-2-7.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,22),
(3,3,12,3299.99,'1-3-1.png;1-3-2.png;1-3-3.png;1-3-4.png;1-3-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128蝶羽白','【30S国内旅赢荣耀耳机！③还有更多优惠券包等你拿！',1,23),
(4,4,132,3299.99,'1-4-1.png;1-4-2.png;1-4-3.png;1-4-4.png;1-4-5.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,43),
(5,5,12,3299.99,'2-1-1.png;2-1-2.png;2-1-3.png;2-1-4.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 白','【荣耀30S新品】①购机赢国内旅晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,43),
(6,6,132,3299.99,'2-2-1.jpg;2-2-2.png;2-2-3.png;2-2-4.png;2-2-5.png;2-2-6.png;','荣耀30S 3双模5G 麒麟820 5G芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,51),
(7,7,12,3299.99,'3-1-1.jpg;3-1-2.png;3-1-3.png;3-1-4.png;3-1-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+1GB 蝶羽白','【荣耀30S新品】①购机赢国内法耀耳机！③还有更多优惠券包等你拿！',1,17),
(1,1,12,33299.99,'1-1-1.png;1-1-2.png;1-1-3.png;1-1-4.png;1-1-5.png;1-1-6.png;1-1-7.png;1-1-8.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀3机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,21),
(2,2,132,3299.99,'1-2-1.png;1-2-2.png;1-2-3.png;1-2-4.png;1-2-5.png;1-2-6.png;1-2-7.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,32),
(3,3,12,3299.99,'1-3-1.png;1-3-2.png;1-3-3.png;1-3-4.png;1-3-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128蝶羽白','【30S国内旅赢荣耀耳机！③还有更多优惠券包等你拿！',1,31),
(4,4,132,3299.99,'1-4-1.png;1-4-2.png;1-4-3.png;1-4-4.png;1-4-5.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,34),
(5,5,12,3299.99,'2-1-1.png;2-1-2.png;2-1-3.png;2-1-4.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 白','【荣耀30S新品】①购机赢国内旅晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,16),
(6,6,132,3299.99,'2-2-1.jpg;2-2-2.png;2-2-3.png;2-2-4.png;2-2-5.png;2-2-6.png;','荣耀30S 3双模5G 麒麟820 5G芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,45),
(7,7,12,3299.99,'3-1-1.jpg;3-1-2.png;3-1-3.png;3-1-4.png;3-1-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+1GB 蝶羽白','【荣耀30S新品】①购机赢国内法耀耳机！③还有更多优惠券包等你拿！',2,7),
(1,1,12,33299.99,'1-1-1.png;1-1-2.png;1-1-3.png;1-1-4.png;1-1-5.png;1-1-6.png;1-1-7.png;1-1-8.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀3机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,21),
(2,2,132,3299.99,'1-2-1.png;1-2-2.png;1-2-3.png;1-2-4.png;1-2-5.png;1-2-6.png;1-2-7.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,42),
(3,3,12,3299.99,'1-3-1.png;1-3-2.png;1-3-3.png;1-3-4.png;1-3-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128蝶羽白','【30S国内旅赢荣耀耳机！③还有更多优惠券包等你拿！',4,3),
(4,4,132,3299.99,'1-4-1.png;1-4-2.png;1-4-3.png;1-4-4.png;1-4-5.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',3,4),
(5,5,12,3299.99,'2-1-1.png;2-1-2.png;2-1-3.png;2-1-4.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 白','【荣耀30S新品】①购机赢国内旅晒单赢荣耀耳机！③还有更多优惠券包等你拿！',5,6),
(6,6,132,3299.99,'2-2-1.jpg;2-2-2.png;2-2-3.png;2-2-4.png;2-2-5.png;2-2-6.png;','荣耀30S 3双模5G 麒麟820 5G芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',2,5),
(7,7,12,3299.99,'3-1-1.jpg;3-1-2.png;3-1-3.png;3-1-4.png;3-1-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+1GB 蝶羽白','【荣耀30S新品】①购机赢国内法耀耳机！③还有更多优惠券包等你拿！',3,7),
(1,1,12,33299.99,'1-1-1.png;1-1-2.png;1-1-3.png;1-1-4.png;1-1-5.png;1-1-6.png;1-1-7.png;1-1-8.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀3机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',2,1),
(2,2,132,3299.99,'1-2-1.png;1-2-2.png;1-2-3.png;1-2-4.png;1-2-5.png;1-2-6.png;1-2-7.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',4,2),
(3,3,12,3299.99,'1-3-1.png;1-3-2.png;1-3-3.png;1-3-4.png;1-3-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128蝶羽白','【30S国内旅赢荣耀耳机！③还有更多优惠券包等你拿！',3,3),
(4,4,132,3299.99,'1-4-1.png;1-4-2.png;1-4-3.png;1-4-4.png;1-4-5.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,43),
(5,5,12,3299.99,'2-1-1.png;2-1-2.png;2-1-3.png;2-1-4.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 白','【荣耀30S新品】①购机赢国内旅晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,6),
(6,6,132,3299.99,'2-2-1.jpg;2-2-2.png;2-2-3.png;2-2-4.png;2-2-5.png;2-2-6.png;','荣耀30S 3双模5G 麒麟820 5G芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',3,15),
(7,7,12,3299.99,'3-1-1.jpg;3-1-2.png;3-1-3.png;3-1-4.png;3-1-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+1GB 蝶羽白','【荣耀30S新品】①购机赢国内法耀耳机！③还有更多优惠券包等你拿！',6,1),
(1,1,12,33299.99,'1-1-1.png;1-1-2.png;1-1-3.png;1-1-4.png;1-1-5.png;1-1-6.png;1-1-7.png;1-1-8.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀3机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,13),
(2,2,132,3299.99,'1-2-1.png;1-2-2.png;1-2-3.png;1-2-4.png;1-2-5.png;1-2-6.png;1-2-7.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,32),
(3,3,12,3299.99,'1-3-1.png;1-3-2.png;1-3-3.png;1-3-4.png;1-3-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128蝶羽白','【30S国内旅赢荣耀耳机！③还有更多优惠券包等你拿！',1,33),
(4,4,132,3299.99,'1-4-1.png;1-4-2.png;1-4-3.png;1-4-4.png;1-4-5.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',3,41),
(5,5,12,3299.99,'2-1-1.png;2-1-2.png;2-1-3.png;2-1-4.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 白','【荣耀30S新品】①购机赢国内旅晒单赢荣耀耳机！③还有更多优惠券包等你拿！',4,1),
(6,6,132,3299.99,'2-2-1.jpg;2-2-2.png;2-2-3.png;2-2-4.png;2-2-5.png;2-2-6.png;','荣耀30S 3双模5G 麒麟820 5G芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',5,6),
(7,7,12,3299.99,'3-1-1.jpg;3-1-2.png;3-1-3.png;3-1-4.png;3-1-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+1GB 蝶羽白','【荣耀30S新品】①购机赢国内法耀耳机！③还有更多优惠券包等你拿！',7,7),
(1,1,12,33299.99,'1-1-1.png;1-1-2.png;1-1-3.png;1-1-4.png;1-1-5.png;1-1-6.png;1-1-7.png;1-1-8.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀3机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',8,2),
(2,2,132,3299.99,'1-2-1.png;1-2-2.png;1-2-3.png;1-2-4.png;1-2-5.png;1-2-6.png;1-2-7.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,32),
(3,3,12,3299.99,'1-3-1.png;1-3-2.png;1-3-3.png;1-3-4.png;1-3-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128蝶羽白','【30S国内旅赢荣耀耳机！③还有更多优惠券包等你拿！',4,12),
(4,4,132,3299.99,'1-4-1.png;1-4-2.png;1-4-3.png;1-4-4.png;1-4-5.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',6,12),
(5,5,12,3299.99,'2-1-1.png;2-1-2.png;2-1-3.png;2-1-4.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 白','【荣耀30S新品】①购机赢国内旅晒单赢荣耀耳机！③还有更多优惠券包等你拿！',2,6),
(6,6,132,3299.99,'2-2-1.jpg;2-2-2.png;2-2-3.png;2-2-4.png;2-2-5.png;2-2-6.png;','荣耀30S 3双模5G 麒麟820 5G芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',4,52),
(7,7,12,3299.99,'3-1-1.jpg;3-1-2.png;3-1-3.png;3-1-4.png;3-1-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+1GB 蝶羽白','【荣耀30S新品】①购机赢国内法耀耳机！③还有更多优惠券包等你拿！',1,7),
(1,1,12,33299.99,'1-1-1.png;1-1-2.png;1-1-3.png;1-1-4.png;1-1-5.png;1-1-6.png;1-1-7.png;1-1-8.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀3机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',2,57),
(2,2,132,3299.99,'1-2-1.png;1-2-2.png;1-2-3.png;1-2-4.png;1-2-5.png;1-2-6.png;1-2-7.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',6,32),
(3,3,12,3299.99,'1-3-1.png;1-3-2.png;1-3-3.png;1-3-4.png;1-3-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128蝶羽白','【30S国内旅赢荣耀耳机！③还有更多优惠券包等你拿！',6,33),
(4,4,132,3299.99,'1-4-1.png;1-4-2.png;1-4-3.png;1-4-4.png;1-4-5.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',7,44),
(5,5,12,3299.99,'2-1-1.png;2-1-2.png;2-1-3.png;2-1-4.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 白','【荣耀30S新品】①购机赢国内旅晒单赢荣耀耳机！③还有更多优惠券包等你拿！',7,6),
(6,6,132,3299.99,'2-2-1.jpg;2-2-2.png;2-2-3.png;2-2-4.png;2-2-5.png;2-2-6.png;','荣耀30S 3双模5G 麒麟820 5G芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',7,5),
(7,7,12,3299.99,'3-1-1.jpg;3-1-2.png;3-1-3.png;3-1-4.png;3-1-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+1GB 蝶羽白','【荣耀30S新品】①购机赢国内法耀耳机！③还有更多优惠券包等你拿！',11,7),
(1,1,12,33299.99,'1-1-1.png;1-1-2.png;1-1-3.png;1-1-4.png;1-1-5.png;1-1-6.png;1-1-7.png;1-1-8.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀3机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',7,31),
(2,2,132,3299.99,'1-2-1.png;1-2-2.png;1-2-3.png;1-2-4.png;1-2-5.png;1-2-6.png;1-2-7.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,24),
(3,3,12,3299.99,'1-3-1.png;1-3-2.png;1-3-3.png;1-3-4.png;1-3-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128蝶羽白','【30S国内旅赢荣耀耳机！③还有更多优惠券包等你拿！',1,23),
(4,4,132,3299.99,'1-4-1.png;1-4-2.png;1-4-3.png;1-4-4.png;1-4-5.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,24),
(5,5,12,3299.99,'2-1-1.png;2-1-2.png;2-1-3.png;2-1-4.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 白','【荣耀30S新品】①购机赢国内旅晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,26),
(6,6,132,3299.99,'2-2-1.jpg;2-2-2.png;2-2-3.png;2-2-4.png;2-2-5.png;2-2-6.png;','荣耀30S 3双模5G 麒麟820 5G芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,27),
(7,7,12,3299.99,'3-1-1.jpg;3-1-2.png;3-1-3.png;3-1-4.png;3-1-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+1GB 蝶羽白','【荣耀30S新品】①购机赢国内法耀耳机！③还有更多优惠券包等你拿！',1,28),
(1,1,12,33299.99,'1-1-1.png;1-1-2.png;1-1-3.png;1-1-4.png;1-1-5.png;1-1-6.png;1-1-7.png;1-1-8.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀3机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,29),
(2,2,132,3299.99,'1-2-1.png;1-2-2.png;1-2-3.png;1-2-4.png;1-2-5.png;1-2-6.png;1-2-7.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,30),
(3,3,12,3299.99,'1-3-1.png;1-3-2.png;1-3-3.png;1-3-4.png;1-3-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128蝶羽白','【30S国内旅赢荣耀耳机！③还有更多优惠券包等你拿！',1,31),
(4,4,132,3299.99,'1-4-1.png;1-4-2.png;1-4-3.png;1-4-4.png;1-4-5.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,32),
(5,5,12,3299.99,'2-1-1.png;2-1-2.png;2-1-3.png;2-1-4.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 白','【荣耀30S新品】①购机赢国内旅晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,33),
(6,6,132,3299.99,'2-2-1.jpg;2-2-2.png;2-2-3.png;2-2-4.png;2-2-5.png;2-2-6.png;','荣耀30S 3双模5G 麒麟820 5G芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,34),
(7,7,12,3299.99,'3-1-1.jpg;3-1-2.png;3-1-3.png;3-1-4.png;3-1-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+1GB 蝶羽白','【荣耀30S新品】①购机赢国内法耀耳机！③还有更多优惠券包等你拿！',1,35),
(1,1,12,33299.99,'1-1-1.png;1-1-2.png;1-1-3.png;1-1-4.png;1-1-5.png;1-1-6.png;1-1-7.png;1-1-8.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀3机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,36),
(2,2,132,3299.99,'1-2-1.png;1-2-2.png;1-2-3.png;1-2-4.png;1-2-5.png;1-2-6.png;1-2-7.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,42),
(3,3,12,3299.99,'1-3-1.png;1-3-2.png;1-3-3.png;1-3-4.png;1-3-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128蝶羽白','【30S国内旅赢荣耀耳机！③还有更多优惠券包等你拿！',1,37),
(4,4,132,3299.99,'1-4-1.png;1-4-2.png;1-4-3.png;1-4-4.png;1-4-5.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,38),
(5,5,12,3299.99,'2-1-1.png;2-1-2.png;2-1-3.png;2-1-4.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 白','【荣耀30S新品】①购机赢国内旅晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,39),
(6,6,132,3299.99,'2-2-1.jpg;2-2-2.png;2-2-3.png;2-2-4.png;2-2-5.png;2-2-6.png;','荣耀30S 3双模5G 麒麟820 5G芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,40),
(7,7,12,3299.99,'3-1-1.jpg;3-1-2.png;3-1-3.png;3-1-4.png;3-1-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+1GB 蝶羽白','【荣耀30S新品】①购机赢国内法耀耳机！③还有更多优惠券包等你拿！',1,41),
(1,1,12,33299.99,'1-1-1.png;1-1-2.png;1-1-3.png;1-1-4.png;1-1-5.png;1-1-6.png;1-1-7.png;1-1-8.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀3机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,42),
(2,2,132,3299.99,'1-2-1.png;1-2-2.png;1-2-3.png;1-2-4.png;1-2-5.png;1-2-6.png;1-2-7.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,43),
(3,3,12,3299.99,'1-3-1.png;1-3-2.png;1-3-3.png;1-3-4.png;1-3-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128蝶羽白','【30S国内旅赢荣耀耳机！③还有更多优惠券包等你拿！',1,44),
(4,4,132,3299.99,'1-4-1.png;1-4-2.png;1-4-3.png;1-4-4.png;1-4-5.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',4,45),
(5,5,12,3299.99,'2-1-1.png;2-1-2.png;2-1-3.png;2-1-4.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 白','【荣耀30S新品】①购机赢国内旅晒单赢荣耀耳机！③还有更多优惠券包等你拿！',2,46),
(6,6,132,3299.99,'2-2-1.jpg;2-2-2.png;2-2-3.png;2-2-4.png;2-2-5.png;2-2-6.png;','荣耀30S 3双模5G 麒麟820 5G芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,47),
(7,7,12,3299.99,'3-1-1.jpg;3-1-2.png;3-1-3.png;3-1-4.png;3-1-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+1GB 蝶羽白','【荣耀30S新品】①购机赢国内法耀耳机！③还有更多优惠券包等你拿！',1,48),
(1,1,12,33299.99,'1-1-1.png;1-1-2.png;1-1-3.png;1-1-4.png;1-1-5.png;1-1-6.png;1-1-7.png;1-1-8.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀3机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,49),
(2,2,132,3299.99,'1-2-1.png;1-2-2.png;1-2-3.png;1-2-4.png;1-2-5.png;1-2-6.png;1-2-7.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,50),
(3,3,12,3299.99,'1-3-1.png;1-3-2.png;1-3-3.png;1-3-4.png;1-3-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128蝶羽白','【30S国内旅赢荣耀耳机！③还有更多优惠券包等你拿！',1,51),
(4,4,132,3299.99,'1-4-1.png;1-4-2.png;1-4-3.png;1-4-4.png;1-4-5.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,52),
(5,5,12,3299.99,'2-1-1.png;2-1-2.png;2-1-3.png;2-1-4.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 白','【荣耀30S新品】①购机赢国内旅晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,53),
(6,6,132,3299.99,'2-2-1.jpg;2-2-2.png;2-2-3.png;2-2-4.png;2-2-5.png;2-2-6.png;','荣耀30S 3双模5G 麒麟820 5G芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,54),
(7,7,12,3299.99,'3-1-1.jpg;3-1-2.png;3-1-3.png;3-1-4.png;3-1-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+1GB 蝶羽白','【荣耀30S新品】①购机赢国内法耀耳机！③还有更多优惠券包等你拿！',1,55),

(4,4,132,3299.99,'1-4-1.png;1-4-2.png;1-4-3.png;1-4-4.png;1-4-5.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',4,69),
(5,5,12,3299.99,'2-1-1.png;2-1-2.png;2-1-3.png;2-1-4.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 白','【荣耀30S新品】①购机赢国内旅晒单赢荣耀耳机！③还有更多优惠券包等你拿！',2,70),
(6,6,132,3299.99,'2-2-1.jpg;2-2-2.png;2-2-3.png;2-2-4.png;2-2-5.png;2-2-6.png;','荣耀30S 3双模5G 麒麟820 5G芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,71),
(7,7,12,3299.99,'3-1-1.jpg;3-1-2.png;3-1-3.png;3-1-4.png;3-1-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+1GB 蝶羽白','【荣耀30S新品】①购机赢国内法耀耳机！③还有更多优惠券包等你拿！',1,72),
(1,1,12,33299.99,'1-1-1.png;1-1-2.png;1-1-3.png;1-1-4.png;1-1-5.png;1-1-6.png;1-1-7.png;1-1-8.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀3机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,76),
(2,2,132,3299.99,'1-2-1.png;1-2-2.png;1-2-3.png;1-2-4.png;1-2-5.png;1-2-6.png;1-2-7.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品】①购机赢国内旅游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,74),
(3,3,12,3299.99,'1-3-1.png;1-3-2.png;1-3-3.png;1-3-4.png;1-3-5.png;','荣耀30S 双模5G 麒麟820 5G SOC芯片 8GB+128蝶羽白','【30S国内旅赢荣耀耳机！③还有更多优惠券包等你拿！',1,75),
(4,4,132,3299.99,'1-4-1.png;1-4-2.png;1-4-3.png;1-4-4.png;1-4-5.png;','荣耀30S 3双模5G 麒麟820 5G SOC芯片 8GB+128GB 蝶羽白','【荣耀30S新品游大奖！②晒单赢荣耀耳机！③还有更多优惠券包等你拿！',1,76);

#描述
DESC colorandconfigure;
#查询
SELECT * FROM colorandconfigure;

SELECT * FROM commodity AS com WHERE com.`id` = 1

#促销内对应商品表
DROP TABLE IF EXISTS promotionden;
CREATE TABLE promotionden(
	id INT AUTO_INCREMENT COMMENT'主键',
	promotionid INT COMMENT'促销id',#
	colorandconfigureid INT COMMENT'配置颜色id',#
	PRIMARY KEY(id)
)CHARSET 'utf8';
SELECT co.*,cou.`images` FROM color AS co LEFT JOIN colorandconfigure AS cou ON co.`id` = cou.`colorId` WHERE cou.`commodityId` = 1 GROUP BY co.id;
SELECT * FROM colorandconfigure AS c WHERE c.`id` = 1
#插入测试数据 yes
INSERT INTO promotionden(promotionid,colorandconfigureid) VALUES(1,1),
(1,2),
(1,3),
(1,4),
(1,5),
(1,6),
(1,7),
(1,8),
(1,9),
(1,10),
(1,11),
(1,12),
(1,13),
(1,14),
(1,15),
(1,16),
(1,17),
(1,18),
(1,19),
(1,20),
(2,2),
(2,3),
(2,4),
(2,5),
(2,6),
(2,7),
(2,8),
(2,9),
(2,10),
(2,11),
(2,12),
(2,13),
(2,14),
(2,15),
(2,16),
(2,17),
(2,18),
(2,19),
(2,20),
(3,2),
(3,3),
(3,4),
(3,5),
(3,6),
(3,7),
(3,8),
(3,9),
(3,10),
(3,11),
(3,12),
(3,13),
(3,14),
(3,15),
(3,16),
(3,17),
(3,18),
(3,19),
(3,20);
#描述
DESC promotionden;
#查询
SELECT * FROM promotionden;

SELECT * FROM combo WHERE id = 33
#购物车表
DROP TABLE IF EXISTS shoppingcart;
CREATE TABLE shoppingcart(
	id INT AUTO_INCREMENT COMMENT'主键',
	colorAndConfigureId INT COMMENT'商品颜色跟配置id，外键',#
	total INT COMMENT'商品数量',
	totalPrice DOUBLE COMMENT'总价',
	checked BIT COMMENT'选中商品',
	comboId	INT COMMENT'套餐id',#
	huserid INT COMMENT'用户id',#
	PRIMARY KEY(id),
	KEY `fk_shopping_colorAndConfigureId`(colorAndConfigureId),
	CONSTRAINT `fk_shopping_colorAndConfigureId` FOREIGN KEY(colorAndConfigureId) REFERENCES colorAndConfigure(id),
	
	KEY `fk_shopping_comboId`(comboId),
	CONSTRAINT `fk_shopping_comboId` FOREIGN KEY(comboId) REFERENCES combo(id),
	
	KEY `fk_shopping_huserid`(huserid),
	CONSTRAINT `fk_shopping_huserid` FOREIGN KEY(huserid) REFERENCES huser(id)
)CHARSET 'utf8';
SELECT * FROM colorAndConfigure;
#插入测试数据 yes
INSERT INTO shoppingcart(colorAndConfigureId,total,totalPrice,checked,comboId,huserid) VALUES(1,2,2323.2323,0,1,1),
(2,1,333.2323,1,2,1),
(3,13,3333.233,1,3,1),
(4,13,3333.23223,1,4,1),
(5,1,333.2323,1,5,1),
(6,1,333.2323,1,6,1),
(7,1,333.2323,1,7,1),
(8,12,234235.23,0,3,1);
#描述
DESC shoppingcart;
#查询
SELECT COUNT(0) AS checkedCount FROM shoppingcart AS s WHERE s.`huserid` = 1 AND s.`checked` = 1;
#订单表
DROP TABLE IF EXISTS indent;
CREATE TABLE indent(
	id INT AUTO_INCREMENT COMMENT'主键',
	huserid INT COMMENT'用户id',#
	Stateid INT COMMENT'订单状态',#
	checked BIT COMMENT'订单选中',
	orderdate DATETIME COMMENT'下单时间',
	addressId INT COMMENT'地址id',#
	payment DOUBLE COMMENT'实付款',
	integral INT COMMENT'积分',
	PRIMARY KEY(id),
	KEY `fk_indent_huser`(huserid),
	CONSTRAINT `fk_indent_huser` FOREIGN KEY(huserid) REFERENCES huser(id),
	
	KEY `fk_indent_State`(Stateid),
	CONSTRAINT `fk_indent_State` FOREIGN KEY(Stateid) REFERENCES indentstate(id),
	
	KEY `fk_indent_addressId`(addressId),
	CONSTRAINT `fk_indent_addressId` FOREIGN KEY(addressId) REFERENCES address(id)
)CHARSET 'utf8';
#插入测试数据 yes
INSERT INTO indent(huserid,Stateid,checked,orderdate,addressId,payment,integral) VALUES(1,1,0,DEFAULT,1,5044.44,100),
(2,1,0,DEFAULT,2,5034.44,100),
(3,1,0,DEFAULT,3,5054.44,100);
#描述
DESC indent;
#查询
SELECT * FROM indent AS i WHERE i.`id` NOT IN(10,11);
UPDATE indent SET Stateid = 3 WHERE id IN(29);
SELECT * FROM indent AS i WHERE i.`id` IN(29);
SELECT * FROM indentstate 
#跟订单相关
SELECT * FROM indentDetail;	
SELECT * FROM indentdispose;
DELETE FROM indentDetail WHERE indentId = 29;
DELETE FROM indentdispose WHERE indentId = 9;
#订单详情表
DROP TABLE IF EXISTS indentDetail;
CREATE TABLE indentDetail(
	id INT AUTO_INCREMENT COMMENT'主键',
	indentId INT COMMENT'订单id',#
	colorAndConfigureId INT COMMENT'颜色配置id',#
	isAppraise BIT COMMENT'是否评价',
	comboId	INT COMMENT'套餐id',#
	total INT COMMENT'商品数量',
	PRIMARY KEY(id),
	KEY `fk_indentDetail_indentId`(indentId),
	CONSTRAINT `fk_indentDetail_indentId` FOREIGN KEY(indentId) REFERENCES indent(id),
	
	KEY `fk_indentDetail_colorAndConfigureId`(colorAndConfigureId),
	CONSTRAINT `fk_indentDetail_colorAndConfigureId` FOREIGN KEY(colorAndConfigureId) REFERENCES colorAndConfigure(id),
	
	KEY `fk_indentDetail_comboId`(comboId),
	CONSTRAINT `fk_indentDetail_comboId` FOREIGN KEY(comboId) REFERENCES combo(id)
)CHARSET 'utf8';
#插入测试数据 yes
INSERT INTO indentDetail(indentId,colorAndConfigureId,isAppraise,comboId,total) VALUES(1,1,0,1,12),
(2,1,1,1,12),
(3,1,0,2,12);
ALTER TABLE indentDetail ADD total INT 
#描述
DESC indentDetail;
#查询
SELECT * FROM indentDetail;	

#订单处理表
DROP TABLE IF EXISTS indentdispose;
CREATE TABLE indentdispose(
	id INT AUTO_INCREMENT COMMENT'主键',
	indentid INT COMMENT'订单详细id',#
	disposeDate DATETIME COMMENT'处理时间',
	disposeMessage VARCHAR(44) NOT NULL COMMENT'处理信息',
	PRIMARY KEY(id),
	KEY `fk_indentdispose_indentid`(indentid),
	CONSTRAINT `fk_indentdispose_indentid` FOREIGN KEY(indentid) REFERENCES indent(id)
)CHARSET 'utf8';
#插入测试数据 yes
INSERT INTO indentdispose(indentid,disposeDate,disposeMessage) VALUES(1,'2020-2-2','已下单'),
(1,'2020-2-3','已发货'),
(1,'2020-2-4','已签收');
#描述
DESC indentdispose;
#查询
SELECT * FROM indentdispose;


#最近浏览表
DROP TABLE IF EXISTS browse;
CREATE TABLE browse(
	id INT AUTO_INCREMENT COMMENT'主键',
	huserId INT COMMENT'用户id',#
	colorandConfigureId INT COMMENT'颜色跟配置id',#
	browseTime DATETIME COMMENT'浏览时间',
	PRIMARY KEY(id),
	KEY `fk_browse_huserId`(huserId),
	CONSTRAINT `fk_browse_huserId` FOREIGN KEY(huserId) REFERENCES huser(id),
	
	KEY `fk_browse_colorandConfigureId`(colorandConfigureId),
	CONSTRAINT `fk_browse_colorandConfigureId` FOREIGN KEY(colorandConfigureId) REFERENCES colorandConfigure(id)
)CHARSET 'utf8';
#插入测试数据 yes
INSERT INTO browse(huserId,colorandConfigureId,browseTime) VALUES(1,1,DEFAULT),
(1,2,DEFAULT),
(1,3,DEFAULT);
#描述
DESC browse;
#查询
SELECT * FROM browse;

#评价表
DROP TABLE IF EXISTS Appraise;
CREATE TABLE Appraise(
	id INT AUTO_INCREMENT COMMENT'主键',
	huserId INT COMMENT'用户id',#
	colorandConfigureId INT COMMENT'颜色跟配置id',#
	Appraisetime DATETIME COMMENT'评论时间',
	Content VARCHAR(54) COMMENT'评价内容',
	
	Grade INT COMMENT'分数  1：一颗星
				2：两颗星
				3：三颗星
				4：四颗星
				5：五颗星',
	Tags INT COMMENT'点赞',
	Images VARCHAR(444) COMMENT'图片',
	PRIMARY KEY(id),
	KEY `fk_Appraise_huserId`(huserId),
	CONSTRAINT `fk_Appraise_huserId` FOREIGN KEY(huserId) REFERENCES huser(id),
	
	KEY `fk_Appraise_colorandConfigureId`(colorandConfigureId),
	CONSTRAINT `fk_Appraise_colorandConfigureId` FOREIGN KEY(colorandConfigureId) REFERENCES colorandConfigure(id)
)CHARSET 'utf8';
#插入测试数据 yes
INSERT INTO Appraise(huserId,colorandConfigureId,Appraisetime,Content,Grade,Tags,Images) VALUES(1,1,DEFAULT,'很好',5,0,'img'),
(2,1,DEFAULT,'很好',5,0,'img'),
(3,1,DEFAULT,'很好',5,0,'img');
#描述
DESC Appraise;
#查询
SELECT * FROM Appraise;
	
#回复表
DROP TABLE IF EXISTS returnappraise;
CREATE TABLE returnappraise(
	id INT AUTO_INCREMENT COMMENT'主键',
	huserId INT COMMENT'用户id',#
	Appraiseid INT COMMENT'评论id',#
	Images VARCHAR(444) COMMENT'图片',
	Appraisetime DATETIME COMMENT'评论时间',
	Content VARCHAR(444) COMMENT'回复内容',
	Tags INT COMMENT'点赞',
	PRIMARY KEY(id),
	KEY `fk_returnappraise_huserId`(huserId),
	CONSTRAINT `fk_returnappraise_huserId` FOREIGN KEY(huserId) REFERENCES huser(id),
	
	KEY `fk_returnappraise_Appraiseid`(Appraiseid),
	CONSTRAINT `fk_returnappraise_Appraiseid` FOREIGN KEY(Appraiseid) REFERENCES Appraise(id)
)CHARSET 'utf8';
#插入测试数据 yes
INSERT INTO returnappraise(huserId,Appraiseid,Images,Appraisetime,Content,Tags) VALUES(1,1,'img',DEFAULT,'很好',11),
(2,1,'img',DEFAULT,'zhende?',11),
(2,1,'img',DEFAULT,'jiade?',11);
#描述
DESC returnappraise;
#查询
SELECT * FROM returnappraise;

#联动
#一级菜单
DROP TABLE IF EXISTS oneMenu;
CREATE TABLE oneMenu(
	id INT AUTO_INCREMENT COMMENT'主键',
	Category INT COMMENT'种类id',#
	PRIMARY KEY(id),
	KEY `fk_linkage_Category`(Category),
	CONSTRAINT `fk_linkage_Category` FOREIGN KEY(Category) REFERENCES Category(id)
)CHARSET 'utf8';
#插入测试数据 yes
INSERT INTO oneMenu(Category) VALUES(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10);
#描述
DESC oneMenu;
#查询
SELECT * FROM oneMenu;

#二级菜单
DROP TABLE IF EXISTS twoMenu;
CREATE TABLE twoMenu(
	id INT AUTO_INCREMENT COMMENT'主键',
	oneMenuid INT COMMENT'一级菜单',#
	seriesid INT COMMENT'细分id',#
	PRIMARY KEY(id),
	KEY `fk_linkage_oneMenuid`(oneMenuid),
	CONSTRAINT `fk_linkage_oneMenuid` FOREIGN KEY(oneMenuid) REFERENCES oneMenu(id),
	KEY `fk_linkage_seriesid`(seriesid),
	CONSTRAINT `fk_linkage_seriesid` FOREIGN KEY(seriesid) REFERENCES series(id)
)CHARSET 'utf8';
SELECT * FROM twoMenu AS t INNER JOIN series AS s ON t.`seriesid` = s.`id` WHERE oneMenuid = 1;
#插入测试数据 yes
INSERT INTO twoMenu(oneMenuid,seriesid) VALUES(1,1),
(1,2),
(1,3),
(1,4),
(1,5),
(1,6),
(1,7),
(1,8),
(1,9),

(2,10),
(2,11),
(2,12),
(2,13),
(2,14),
(2,15),

(3,16),
(3,17),
(3,18),
(3,19),

(4,20),
(4,21),
(4,22),
(4,23),
(4,24),

(5,25),
(5,26),
(5,27),
(5,28),
(5,29),
(5,30),
(5,31),

(6,32),
(6,33),

(7,34),
(7,35),
(7,36),
(7,37),
(7,38),
(7,39),

(8,40),
(8,41),
(8,42),
(8,43),
(8,44),
(8,45),
(8,46),
(8,47),
(8,48),
(8,49),
(8,50),
(8,51),
(8,52),
(8,53),

(9,54),
(9,55),
(9,56),
(9,57),
(9,58),
(9,59),
(9,60),
(9,61),
(9,62),
(9,63),
(9,64),


(10,65),
(10,66),
(10,67),
(10,68),
(10,69),
(10,70),
(10,71);
#描述
DESC twoMenu;
#查询
SELECT * FROM twoMenu AS t INNER JOIN series AS s ON t.`seriesid` = s.`id` WHERE t.`oneMenuid` = 2; #group by t.`oneMenuid`;

#楼层表#category  series commodity colorandconfigure
DROP TABLE IF EXISTS floors;
CREATE TABLE floors(
	id INT AUTO_INCREMENT COMMENT'主键',
	categoryid INT COMMENT'商品类别id',#
	PRIMARY KEY(id),
	KEY `fk_floors_categoryid`(categoryid),
	CONSTRAINT `fk_floors_categoryid` FOREIGN KEY(categoryid) REFERENCES category(id)
)CHARSET 'utf8';
#插入测试数据 yes
INSERT INTO floors(categoryid) VALUES(1),
(2),
(3);
#描述
DESC floors;
#查询
SELECT * FROM promotion WHERE id = 1
SELECT * FROM floors;
SELECT * FROM Commodity;
SELECT * FROM series AS s WHERE s.`categoryId` = 1;
SELECT * FROM colorandconfigure AS c LEFT JOIN floorscom AS f ON c.`id` = f.`colorandconfigureid` WHERE f.`floorsid` = 1
#楼层表#category  series commodity colorandconfigure
DROP TABLE IF EXISTS floorscom;
CREATE TABLE floorscom(
	id INT AUTO_INCREMENT COMMENT'主键',
	floorsid INT COMMENT'楼层id',#
	colorandconfigureid INT COMMENT'颜色配置id',#
	
	PRIMARY KEY(id),
	KEY `fk_floorscom_floorsid`(floorsid),
	CONSTRAINT `fk_floorscom_floorsid` FOREIGN KEY(floorsid) REFERENCES floors(id),
	
	KEY `fk_floorscom_colorandconfigureid`(colorandconfigureid),
	CONSTRAINT `fk_floorscom_colorandconfigureid` FOREIGN KEY(colorandconfigureid) REFERENCES colorandconfigure(id)
)CHARSET 'utf8';
SELECT * FROM floorscom AS f LEFT JOIN commodity AS c ON f.`commodityid` = c.`id` WHERE f.`floorsid` = 1;
SELECT * FROM floors;

#插入测试数据 yes
INSERT INTO floorscom(floorsid,colorandconfigureid) VALUES(1,1),
(1,2),
(1,32),
(1,33),
(1,6),
(1,5),
(1,7),
(1,9),
(1,8),
(1,10),
(1,11),
(1,12),
(1,13),
(1,18),
(1,69),

(2,37),
(2,24),
(2,53),
(2,105),
(2,106),
(2,108),
(2,109),
(2,110),
(2,41),
(2,112),

(3,127),
(3,128),
(3,129),
(3,130),
(3,131),
(3,132),
(3,133),
(3,134);
#描述
DESC floorscom;
#查询
SELECT * FROM floorscom;
SELECT * FROM commodity;

#轮播表
DROP TABLE IF EXISTS carousel;
CREATE TABLE carousel(
	id INT AUTO_INCREMENT COMMENT'主键',
	orders INT COMMENT'顺序',
	Image VARCHAR(113) COMMENT'轮播图片',
	href VARCHAR(423) COMMENT'链接地址',
	Colorandconfigureid INT COMMENT'颜色配置id',#
	PRIMARY KEY(id),
	KEY `fk_carousel_Colorandconfigureid`(Colorandconfigureid),
	CONSTRAINT `fk_carousel_Colorandconfigureid` FOREIGN KEY(Colorandconfigureid) REFERENCES Colorandconfigure(id)
)CHARSET 'utf8';

#插入测试数据 yes
INSERT INTO carousel(Image,href,Colorandconfigureid,orders) VALUES('homeimage/carouselimg/1.jpg','http://',1,1),
('homeimage/carouselimg/2.jpg','http://',2,2),
('homeimage/carouselimg/3.jpg','http://',3,3),
('homeimage/carouselimg/4.jpg','http://',4,4),
('homeimage/carouselimg/5.jpg','http://',5,5);
#描述
DESC carousel;
#查询
SELECT * FROM carousel;

#推送表
DROP TABLE IF EXISTS push;
CREATE TABLE push(
	id INT AUTO_INCREMENT COMMENT'主键',
	Image VARCHAR(113) COMMENT'推送图片',
	href VARCHAR(423) COMMENT'链接地址',
	Colorandconfigureid INT COMMENT'颜色配置id',#
	PRIMARY KEY(id),
	KEY `fk_push_Colorandconfigureid`(Colorandconfigureid),
	CONSTRAINT `fk_push_Colorandconfigureid` FOREIGN KEY(Colorandconfigureid) REFERENCES Colorandconfigure(id)
)CHARSET 'utf8';
#插入测试数据 yes
INSERT INTO push(Image,href,Colorandconfigureid) VALUES('img','http://',1),
('img','http://',2),
('img','http://',3);
#描述
DESC push;
#查询
SELECT * FROM push;
SELECT * FROM address WHERE huserid = 1
DELETE FROM address WHERE huserid = 1
#热销单品表
DROP TABLE IF EXISTS hot;
CREATE TABLE hot(
	id INT AUTO_INCREMENT COMMENT'主键',
	Image VARCHAR(113) COMMENT'热销图片',
	href VARCHAR(423) COMMENT'链接地址',
	Colorandconfigureid INT COMMENT'颜色配置id',#
	PRIMARY KEY(id),
	KEY `fk_hot_Colorandconfigureid`(Colorandconfigureid),
	CONSTRAINT `fk_hot_Colorandconfigureid` FOREIGN KEY(Colorandconfigureid) REFERENCES Colorandconfigure(id)
)CHARSET 'utf8';
#插入测试数据 yes
INSERT INTO hot(Image,href,Colorandconfigureid) VALUES('img','http://',1),
('img','http://',2),
('img','http://',3);
#描述
DESC hot;
#查询
SELECT * FROM hot;

#推荐表
DROP TABLE IF EXISTS nominate;
CREATE TABLE nominate(
	id INT AUTO_INCREMENT COMMENT'主键',
	href VARCHAR(423) COMMENT'链接地址',
	Colorandconfigureid INT COMMENT'颜色配置id',#
	PRIMARY KEY(id),
	KEY `fk_nominate_Colorandconfigureid`(Colorandconfigureid),
	CONSTRAINT `fk_nominate_Colorandconfigureid` FOREIGN KEY(Colorandconfigureid) REFERENCES Colorandconfigure(id)
)CHARSET 'utf8';
#插入测试数据 no
INSERT INTO nominate(href,Colorandconfigureid) VALUES('http://',1),
('http://',2),
('http://',3);
#描述
DESC nominate;
#查询
SELECT * FROM nominate;

