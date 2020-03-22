use demo_zxw;

create table if not exists user(
	id int primary key auto_increment,
    username varchar(20) not null unique,
    password varchar(100) not null,
    email varchar(20) not null,
    regtime datetime not null
);

insert into user (username , password , email , regtime) 
	values ("tao12",123456,'1779791796@qq.com' , now());

insert into user (username,password,email,regtime) 
values ('tao1','e10adc3949ba59abbe56e057f20f883e','4578651@qq.com','2019-02-21 08:44:37');

select * from user;



truncate user;

select * from user;



alter table user
	modify regtime varchar(50) not null;
   
create table choose(
	id int primary key auto_increment,
    num tinyint not null
);


alter table choose
	modify num varchar(3) unique not null;


select * from user;


