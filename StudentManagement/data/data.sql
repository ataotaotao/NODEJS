use 51zxw;
select * from 51zxw_user;

truncate 51zxw_user;

select id,token_exptime from 51zxw_user where username =' tao1';

desc 51zxw_user;

CREATE TABLE IF NOT EXISTS student(
	id INT UNSIGNED AUTO_INCREMENT KEY,
	username VARCHAR(20) NOT NULL UNIQUE,
	age INT NOT NULL,
	sex VARCHAR(10)
);



desc student;

truncate student;

select * from student;

insert into student (username , age, sex)
	values 
    ('tao1',15,"男"),('tao2',15,"男"),('tao3',15,"男"),('tao4',15,"男"),('tao5',15,"男"),
    ('tao6',15,"男"),('tao7',15,"男"),('tao8',15,"男"),('tao9',15,"男"),('tao10',15,"男"),
    ('tao11',15,"男"),('tao12',15,"男"),('tao13',15,"男"),('tao14',15,"男"),('tao15',15,"男");

insert into student (username , age, sex)
	values ('tao16',15,"男");

