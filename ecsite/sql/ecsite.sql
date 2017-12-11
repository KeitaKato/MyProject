SET names utf8;

drop database if exists ecsite;
create database if not exists ecsite;
use ecsite;
drop table if exists login_user_transaction;
create table login_user_transaction(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
cart_total_price int(11) default 0,
insert_date datetime,
updated_date datetime
);
drop table if exists item_info_transaction;
create table item_info_transaction(
id int not null primary key auto_increment,
item_name varchar(30),
item_price int,
item_category enum("生肉","生魚","青果","飲料","調味料","冷凍食品","冷蔵食品"),
item_img varchar(255),
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
INSERT INTO item_info_transaction(item_name, item_price, item_category, item_img, item_stock) VALUES
("トマト",100,'青果',"./picture/itemImg/fd400590.jpg",50),
("ニンジン",98,'青果',"./picture/itemImg/fd400314.jpg",50),
("ホウレンソウ",98,'青果',"./picture/itemImg/f58m_2236.jpg",50),
("ブロッコリー",100,'青果',"./picture/itemImg/fd400070.jpg",50),
("豚肉500g",680,'生肉',"./picture/itemImg/niku_buta.png",20),
("鯖",198,'生魚',"./picture/itemImg/fish_saba2.png",20),
("ジュース",150,'飲料',"./picture/itemImg/gatag-00014136.jpg",100),
("マヨネーズ",198,'調味料',"./picture/itemImg/cooking_mayonnaise.png",100),
("冷凍スパゲティ",298,'冷凍食品',"./picture/itemImg/pasta-329522_960_720.jpg",20),
("ハム",138,'冷蔵食品',"./picture/itemImg/PPS_suraisusaretahamu_TP_V.jpg",60);
INSERT INTO login_user_transaction(login_id, login_pass, user_name) VALUES("internous", "internous01", "test");