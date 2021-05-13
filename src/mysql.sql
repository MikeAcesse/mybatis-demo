CREATE DATABASE ssmdemo;

DROP TABLE IF EXISTS tb_user;
CREATE TABLE tb_user (
id char(32) NOT NULL,
user_name varchar(32) DEFAULT NULL,
password varchar(32) DEFAULT NULL,
name varchar(32) DEFAULT NULL,
age int(10) DEFAULT NULL,
sex int(2) DEFAULT NULL,
birthday date DEFAULT NULL,
created datetime DEFAULT NULL,
updated datetime DEFAULT NULL,
PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO ssmdemo.tb_user (id,user_name, password, name, age, sex, birthday, created, updated) VALUES ('1','zpc', '123456', '鹏程', '22', '1', '1990-09-02', sysdate(), sysdate());
INSERT INTO ssmdemo.tb_user (id, user_name, password, name, age, sex, birthday, created, updated) VALUES ('2', 'hj', '123456', '静静', '22', '1', '1993-09-05', sysdate(), sysdate());