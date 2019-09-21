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

INSERT INTO catalog.credentials(login, password, role, email) values('A1n', 'qwerty1', 'USER', 'andrey@gmail.com');
INSERT INTO catalog.credentials(login, password, role, email) values('Dimmer', 'qwerty2', 'USER', 'dima@gmail.com');
INSERT INTO catalog.credentials(login, password, role, email) values('Maximer', 'qwerty3', 'USER', 'max.makasin@gmail.com');
INSERT INTO catalog.credentials(login, password, role, email) values('Vova', 'qwerty4', 'USER', 'vova@gmail.com');
INSERT INTO catalog.credentials(login, password, role, email) values('Anna', 'qwerty5', 'USER', 'anna@mail.ru');
INSERT INTO catalog.credentials(login, password, role, email) values('Kola', 'qwerty6', 'USER', 'kola@gmail.com');
INSERT INTO catalog.credentials(login, password, role, email) values('Svet', 'qwerty7', 'USER', 'svet34@tut.by');
INSERT INTO catalog.credentials(login, password, role, email) values('Tanya', 'qwerty8', 'USER', 'tanya8@gmail.com');
INSERT INTO catalog.credentials(login, password, role, email) values('Egor', 'qwerty9', 'USER', 'error@gmail.com');
INSERT INTO catalog.credentials(login, password, role, email) values('Katya', 'qwerty10', 'USER', 'kater@mail.ru');

INSERT INTO catalog.seller_rating(rating, rating_count) values(0, 0);
INSERT INTO catalog.seller_rating(rating, rating_count) values(7.0, 3);
INSERT INTO catalog.seller_rating(rating, rating_count) values(0, 0);
INSERT INTO catalog.seller_rating(rating, rating_count) values(5.5, 4);
INSERT INTO catalog.seller_rating(rating, rating_count) values(8.9, 2);
INSERT INTO catalog.seller_rating(rating, rating_count) values(0, 0);
INSERT INTO catalog.seller_rating(rating, rating_count) values(0, 0);
INSERT INTO catalog.seller_rating(rating, rating_count) values(5, 1);
INSERT INTO catalog.seller_rating(rating, rating_count) values(0, 0);
INSERT INTO catalog.seller_rating(rating, rating_count) values(7.8, 8);

INSERT INTO catalog.deal(seller_id, buyer_id, title, sale_date) values(4, 1, 'Lexus ls', '2019-04-23');
INSERT INTO catalog.deal(seller_id, buyer_id, title, sale_date) values(2, 3, 'MacBook Air', '2019-05-08');
INSERT INTO catalog.deal(seller_id, buyer_id, title, sale_date) values(7, 2, 'Bloody R8', '2019-08-10');
INSERT INTO catalog.deal(seller_id, buyer_id, title, sale_date) values(9, 8, 'Mi Band 3', '2019-09-08');
INSERT INTO catalog.deal(seller_id, buyer_id, title, sale_date) values(4, 3, 'Huawei P Smart', '2019-05-08');

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

INSERT INTO catalog.user_chat values(1, 1);
INSERT INTO catalog.user_chat values(4, 1);
INSERT INTO catalog.user_chat values(2, 2);
INSERT INTO catalog.user_chat values(3, 2);

INSERT INTO catalog.message(chat_id, user_id, text, send_date) values(1, 1, 'Можно лексус?', '2019-07-12 11:30:45');
INSERT INTO catalog.message(chat_id, user_id, text, send_date) values(1, 4, 'Можно', '2019-07-12 11:32:14');
INSERT INTO catalog.message(chat_id, user_id, text, send_date) values(1, 1, 'Спасибо', '2019-07-12 11:35:30');
INSERT INTO catalog.message(chat_id, user_id, text, send_date) values(2, 3, 'Здрасте', '2019-07-13 09:34:30');

INSERT INTO catalog.comment(advert_id, user_id, text) values(1, 1, 'Топ телефон');
INSERT INTO catalog.comment(advert_id, user_id, text) values(2, 5, 'Вор');
INSERT INTO catalog.comment(advert_id, user_id, text) values(7, 4, 'Большой пробег');
INSERT INTO catalog.comment(advert_id, user_id, text) values(8, 10, 'Топ за свои деньги');
INSERT INTO catalog.comment(advert_id, user_id, text) values(3, 7, 'Для небольшого сада сойдет');