drop database if exists ecsite;

create database if not exists ecsite;
use ecsite;

drop table if exists login_user_transaction;

create table login_user_transaction(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
insert_date datetime,
updated_date datetime
);

drop table if exists item_info_transaction;

create table item_info_transaction(
id int not null primary key auto_increment,
item_name varchar(30),
item_price int,
item_stock int,
insert_date datetime,
update_date datetime
);

drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
id int not null primary key auto_increment,
item_transaction_id int,
total_price int,
total_count int,
user_master_id varchar(16),
pay varchar(30),
insert_date datetime,
delete_date datetime
);


INSERT INTO item_info_transaction(item_name, item_price, item_stock) VALUES
("トマト", 100, 50),
("ニンジン",98,50),
("ホウレンソウ",98,50),
("ブロッコリー",100,50),
("豚肉500g",680,20),
("魚",198,20),
("ジュース",150,100),
("マヨネーズ",198,100),
("冷凍スパゲティ",298,20),
("ハム",138,60);
INSERT INTO login_user_transaction(login_id, login_pass, user_name) VALUES("internous", "internous01", "test");