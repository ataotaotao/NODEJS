create database if not exists taobaoshop character set utf8;

create table if not exists shopinfo(
	id int primary key auto_increment,
    imgUrl varchar(50) not null unique,
    description varchar(100) not null,
    price decimal(10,3) not null
);

insert into shopinfo (imgUrl , description , price)
	values("img/1.webp","中伟实木餐桌椅组合简约现代小户型饭桌经济型餐桌长方形1桌6椅1450*950*760mm","2219.00"),
    ("img/2.webp","搭韩版休闲女鞋厚底港风街拍板鞋 红色 36","21.00"),
    ("img/3.webp","【配证书】S999纯银手镯女实心光面非老凤祥情侣推拉可调节手环男足银镯子简约首饰","278.00"),
    ("img/4.webp","TP-LINK TL-WDR5620 1200M 5G双频智能无线路由器 四天线智能wifi 稳定穿墙高速家用路由器","115.00"),
    ("img/5.webp","恩尼诺（aneno） 宽口径玻璃奶瓶婴儿新生奶嘴防胀气呛奶套装初生喝水米糊储奶安抚母婴喂养用品 A005粉+A006蓝","196.00"),
    ("img/6.webp","拖鞋女夏2019新款防滑外穿室内居家用浴室洗澡情侣凉拖鞋男 黑色 36-37","78.00"),
    ("img/7.webp","【送证书】恋爱石S999纯银手镯女非老凤祥开口光面简约森系实心手环足银镯子刻字送爱人生日礼 法语爱手镯-（JD配送不刻字） 约28克","259.00"),
	("img/8.webp","男鞋2019春季新款休闲鞋子 男士时尚百搭休闲运动鞋男韩版潮流小白鞋个性学生高帮运动板鞋男增高老爹鞋 S-WD883款白红色 40","69.00");
    
    
select * from shopinfo;


create table if not exists purchaseInfo(
	id int primary key auto_increment,
    price decimal(10,3) not null ,
    count int not null,
    total decimal(20,3) not null,
    time date ,
    shopid int,
    constraint fk foreign key (shopid) references shopinfo(id)
);

select * from purchaseInfo;
insert into purchaseInfo (price,count,total,time,shopId) values ('115','4','460','2019-02-26 08:51:31','4');

truncate purchaseInfo;

drop table purchaseInfo;

alter table purchaseInfo
	modify time varchar(50);









