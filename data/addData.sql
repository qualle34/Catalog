INSERT INTO catalog.user(firstname, lastname, birthdate, phone, location) values('Андрей', 'Андреев', '2001-12-08', '+375112223344', 'Гродно');
INSERT INTO catalog.user(firstname, lastname, birthdate, phone, location) values('Дима', 'Димов', '1990-12-08', '+375112223344', 'Минск');
INSERT INTO catalog.user(firstname, lastname, birthdate, phone, location) values('Максим', 'Максимов', '1995-12-04', '+375112223344', 'Москва');
INSERT INTO catalog.user(firstname, lastname, birthdate, phone, location) values('Лена', 'Ленова', '1967-02-02', '+375112223344', 'Брест');
INSERT INTO catalog.user(firstname, lastname, birthdate, phone, location) values('Аня', 'Ааааа', '1988-12-09', '+375112223344', 'Киев');
INSERT INTO catalog.user(firstname, lastname, birthdate, phone, location) values('Коля', 'Котлин', '1960-12-09', '+375112223344', 'Москва');
INSERT INTO catalog.user(firstname, lastname, birthdate, phone, location) values('Света', 'Свет', '1989-12-09', '+375112223344', 'Гродно');
INSERT INTO catalog.user(firstname, lastname, birthdate, phone, location) values('Таня', 'Танина', '1997-12-09', '+375112223344', 'Прага');
INSERT INTO catalog.user(firstname, lastname, birthdate, phone, location) values('Егор', 'Егоров', '1978-12-09', '+375112223344', 'Берлин');
INSERT INTO catalog.user(firstname, lastname, birthdate, phone, location) values('Катя', 'Катева', '1956-12-09', '+375112223344', 'Киев');
INSERT INTO catalog.user(firstname, lastname, birthdate, phone, location) values('Admin', 'Admin', '1998-12-09', '+375000000000', 'Москва');

INSERT INTO catalog.credentials values(1, 'A1n', '$2a$10$n8vz9RSwa/tukPEYMW.yaetMqRjnDZ0CRC1RI06bKuUr73VUCrHQi', 'andrey@gmail.com');           # password- 2345uytr
INSERT INTO catalog.credentials values(2, 'Dimmer', '$2a$10$Y3VcTkUR0ZwZ0kIZee9e9etFPR1HsctICjNXHGbjzxc3hbGlrDjYK', 'dima@gmail.com');          # password- hgfd3456
INSERT INTO catalog.credentials values(3, 'Maximer', '$2a$10$ge8V9B.RtVvf8/2SlGLemui1ohaz93UGiepzPCGiGZVnm/hnCSkxm', 'max.makasin@gmail.com');  # password- iuty3465
INSERT INTO catalog.credentials values(4, 'Vova', '$2a$10$/SftPQLuet74uEXbzap17e3JJyt6wO8RTzulmY71U8GlURTnvqdwi', 'vova@gmail.com');            # password- poiu7890
INSERT INTO catalog.credentials values(5, 'Anna', '$2a$10$HgqfPiefsadzs8H5AxBvpeuu.gajP2nHuAORmyf4sPK3PB/EML/i6', 'anna@mail.ru');              # password- mnbv1234
INSERT INTO catalog.credentials values(6, 'Kola', '$2a$10$wGrKQj/d6zpi1q5XWyPByeGgVLUd4zhBzI.2Y9oWkBdFGzgsTxGPC', 'kola@gmail.com');            # password- zxcv0987
INSERT INTO catalog.credentials values(7, 'Svet', '$2a$10$Q9VU53RuOuY772z0/uei2ODhWXq.rWGFCLCi5ysehAfCUrm1KjOnu', 'svet34@tut.by');             # password- sdfg8567
INSERT INTO catalog.credentials values(8, 'Tanya', '$2a$10$o67Y3mfdnC//M/9CoSgBcOKjQrzL/LJ0M2IyrXyEPWqaD7vNEejzm', 'tanya8@gmail.com');         # password- dfgh3456
INSERT INTO catalog.credentials values(9, 'Egor', '$2a$10$4hXHWtwzje2gXb8gCM772.Pd3DQX.bQLTX7fNL1Tmu2zXdbY4Q7VW',  'error@gmail.com');          # password- asdf0987
INSERT INTO catalog.credentials values(10, 'Katya', '$2a$10$vjsSVPqs4Cu7im3JoxkVMu67to9xtADpSJuRzL5XnOpgqEQmP0SWC', 'kater@mail.ru');           # password- qwer7654
INSERT INTO catalog.credentials values(11, 'admin', '$2a$10$dt1Jmg.w/sgjVSo2u7Vks.CD6wOGe2PqX.vB9uVPfVswyIeS99/46', 'admin@gmail.com');         # password- admin

INSERT INTO catalog.user_rating values(1, 0, 0);
INSERT INTO catalog.user_rating values(2, 7.0, 3);
INSERT INTO catalog.user_rating values(3, 0, 0);
INSERT INTO catalog.user_rating values(4, 5.5, 4);
INSERT INTO catalog.user_rating values(5, 8.9, 2);
INSERT INTO catalog.user_rating values(6, 0, 0);
INSERT INTO catalog.user_rating values(7, 0, 0);
INSERT INTO catalog.user_rating values(8, 5, 1);
INSERT INTO catalog.user_rating values(9, 0, 0);
INSERT INTO catalog.user_rating values(10, 7.8, 8);
INSERT INTO catalog.user_rating values(11, 0, 0);

INSERT INTO catalog.role(name) values('USER');
INSERT INTO catalog.role(name) values('ADMIN');

INSERT INTO catalog.user_role values(1, 1);
INSERT INTO catalog.user_role values(2, 1);
INSERT INTO catalog.user_role values(3, 1);
INSERT INTO catalog.user_role values(4, 1);
INSERT INTO catalog.user_role values(5, 1);
INSERT INTO catalog.user_role values(6, 1);
INSERT INTO catalog.user_role values(7, 1);
INSERT INTO catalog.user_role values(8, 1);
INSERT INTO catalog.user_role values(9, 1);
INSERT INTO catalog.user_role values(10, 1);
INSERT INTO catalog.user_role values(11, 1);
INSERT INTO catalog.user_role values(11, 2);

INSERT INTO catalog.deal(seller_id, buyer_id, title, sale_date) values(4, 1, 'Lexus ls', '2019-04-23');
INSERT INTO catalog.deal(seller_id, buyer_id, title, sale_date) values(2, 3, 'MacBook Air', '2019-05-08');
INSERT INTO catalog.deal(seller_id, buyer_id, title, sale_date) values(7, 2, 'Bloody R8', '2019-08-10');
INSERT INTO catalog.deal(seller_id, buyer_id, title, sale_date) values(9, 8, 'Mi Band 3', '2019-09-08');
INSERT INTO catalog.deal(seller_id, buyer_id, title, sale_date) values(4, 2, 'Huawei P Smart', '2019-07-18');
INSERT INTO catalog.deal(seller_id, buyer_id, title, sale_date) values(1, 3, 'Sony SD33', '2019-09-08');
INSERT INTO catalog.deal(seller_id, buyer_id, title, sale_date) values(1, 2, 'Lenovo ideapad Y400', '2019-10-03');
INSERT INTO catalog.deal(seller_id, buyer_id, title, sale_date) values(6, 3, 'Asus ROG34', '2019-09-23');
INSERT INTO catalog.deal(seller_id, buyer_id, title, sale_date) values(5, 8, 'Volvo XC90', '2019-08-30');
INSERT INTO catalog.deal(seller_id, buyer_id, title, sale_date) values(10, 9, 'BMW X5M', '2019-09-07');

INSERT INTO catalog.category(title) values('Авто');
INSERT INTO catalog.category(title) values('Одежда');
INSERT INTO catalog.category(title) values('Всё для дома');
INSERT INTO catalog.category(title) values('Электроника');
INSERT INTO catalog.category(title) values('Ремонт');
INSERT INTO catalog.category(title) values('Сад и огород');
INSERT INTO catalog.category(title) values('Хобби и игры');
INSERT INTO catalog.category(title) values('Животные');

INSERT INTO catalog.advert(user_id, category_id, title, description, price, type) values(5, 4, 'Телефон Nokia', 'Nokia 3310', 46.2, 'SELL');
INSERT INTO catalog.advert(user_id, category_id, title, description, price, type) values(4, 2, 'Кроссовки Nike', 'Nike Air', 78.4, 'SELL');
INSERT INTO catalog.advert(user_id, category_id, title, description, type) values(9, 6, 'Лопата Raptor', 'Raptor TR', 'SELL');
INSERT INTO catalog.advert(user_id, category_id, title, description, price, type) values(7, 8, 'Клетка для кролика', 'Размер: 1м х 0.5м', 16.0, 'SELL');
INSERT INTO catalog.advert(user_id, category_id, title, description, price, type) values(2, 5, 'Дрель Bosch', 'GSR-13', 56.4, 'SELL');
INSERT INTO catalog.advert(user_id, category_id, title, description, price, type) values(8, 7, 'Геймпад Sony', 'DualShock 4 white', 48.4, 'SELL');
INSERT INTO catalog.advert(user_id, category_id, title, description, price, type) values(7, 1, 'Автомобиль Audi A7', 'Audi A7 2012', 35230.0, 'SELL');
INSERT INTO catalog.advert(user_id, category_id, title, description, price, type) values(3, 2, 'Куртка Xiaomi', 'Xiaomi mi jacket', 95.4, 'SELL');
INSERT INTO catalog.advert(user_id, category_id, title, description, price, type) values(3, 4, 'Куплю ноутбук', 'Xiaomi, Asus, Apple, Aser', 95.4, 'BUY');

INSERT INTO catalog.vip_info values(6, '2019-09-08');
INSERT INTO catalog.vip_info values(7, '2019-09-01');

INSERT INTO catalog.chat(title) values('Lexus ls');
INSERT INTO catalog.chat(title) values('MacBook Air');
INSERT INTO catalog.chat(title) values('Bloody R8');
INSERT INTO catalog.chat(title) values('Mi Band 3');
INSERT INTO catalog.chat(title) values('Huawei P Smart');
INSERT INTO catalog.chat(title) values('Sony SD33');
INSERT INTO catalog.chat(title) values('Lenovo ideapad Y400');
INSERT INTO catalog.chat(title) values('Asus ROG34');
INSERT INTO catalog.chat(title) values('Volvo XC90');
INSERT INTO catalog.chat(title) values('BMW X5M');

INSERT INTO catalog.user_chat values(4, 1);
INSERT INTO catalog.user_chat values(1, 4);
INSERT INTO catalog.user_chat values(2, 3);
INSERT INTO catalog.user_chat values(3, 2);
INSERT INTO catalog.user_chat values(7, 2);
INSERT INTO catalog.user_chat values(2, 7);
INSERT INTO catalog.user_chat values(9, 8);
INSERT INTO catalog.user_chat values(8, 9);
INSERT INTO catalog.user_chat values(4, 2);
INSERT INTO catalog.user_chat values(2, 4);
INSERT INTO catalog.user_chat values(1, 3);
INSERT INTO catalog.user_chat values(3, 1);
INSERT INTO catalog.user_chat values(1, 2);
INSERT INTO catalog.user_chat values(2, 1);
INSERT INTO catalog.user_chat values(6, 3);
INSERT INTO catalog.user_chat values(3, 6);
INSERT INTO catalog.user_chat values(5, 8);
INSERT INTO catalog.user_chat values(8, 5);
INSERT INTO catalog.user_chat values(10, 9);
INSERT INTO catalog.user_chat values(9, 10);

INSERT INTO catalog.message(chat_id, user_id, text, send_date) values(1, 1, 'Можно лексус?', '2019-07-12 11:30:45');
INSERT INTO catalog.message(chat_id, user_id, text, send_date) values(1, 4, 'Можно', '2019-07-12 11:32:14');
INSERT INTO catalog.message(chat_id, user_id, text, send_date) values(1, 1, 'Спасибо', '2019-07-12 11:35:30');
INSERT INTO catalog.message(chat_id, user_id, text, send_date) values(2, 3, 'Здрасте', '2019-07-13 09:34:30');
INSERT INTO catalog.message(chat_id, user_id, text, send_date) values(7, 2, 'Здрасте', '2019-07-13 09:34:30');
INSERT INTO catalog.message(chat_id, user_id, text, send_date) values(2, 7, 'Привет', '2019-07-11 09:34:30');
INSERT INTO catalog.message(chat_id, user_id, text, send_date) values(9, 8, 'Здрасте', '2019-08-13 09:34:30');
INSERT INTO catalog.message(chat_id, user_id, text, send_date) values(4, 2, 'Здрасте', '2019-07-13 09:34:30');
INSERT INTO catalog.message(chat_id, user_id, text, send_date) values(2, 4, 'Здрасте', '2019-07-13 09:34:30');
INSERT INTO catalog.message(chat_id, user_id, text, send_date) values(1, 3, 'Здрасте', '2019-07-13 09:34:30');
INSERT INTO catalog.message(chat_id, user_id, text, send_date) values(1, 2, 'Здрасте', '2019-04-12 09:34:30');
INSERT INTO catalog.message(chat_id, user_id, text, send_date) values(6, 3, 'Привет', '2019-07-13 09:34:30');
INSERT INTO catalog.message(chat_id, user_id, text, send_date) values(5, 8, 'Здрасте', '2019-07-13 09:34:30');
INSERT INTO catalog.message(chat_id, user_id, text, send_date) values(8, 5, 'Здрасте', '2019-07-13 09:34:30');
INSERT INTO catalog.message(chat_id, user_id, text, send_date) values(10, 9, 'Здрасте', '2019-07-13 09:34:30');
INSERT INTO catalog.message(chat_id, user_id, text, send_date) values(9, 10, 'Привет', '2019-07-13 09:34:30');
INSERT INTO catalog.message(chat_id, user_id, text, send_date) values(10, 9, 'Можно скидку?', '2019-07-13 09:34:30');

INSERT INTO catalog.comment(advert_id, user_id, text) values(1, 1, 'Топ телефон');
INSERT INTO catalog.comment(advert_id, user_id, text) values(2, 5, 'Вор');
INSERT INTO catalog.comment(advert_id, user_id, text) values(7, 4, 'Большой пробег');
INSERT INTO catalog.comment(advert_id, user_id, text) values(8, 10, 'Топ за свои деньги');
INSERT INTO catalog.comment(advert_id, user_id, text) values(3, 7, 'Для небольшого сада сойдет');