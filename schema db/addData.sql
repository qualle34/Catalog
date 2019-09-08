INSERT INTO catalog.user(firstname, lastname, birthdate, phone, location) values('Андрей', 'Андреев', '2001-12-08', '+375112223344', 'Гродно');
INSERT INTO catalog.user(firstname, lastname, birthdate, phone, location) values('Дима', 'Димов', '1990-12-08', '+375112223344', 'Минск');
INSERT INTO catalog.user(firstname, lastname, birthdate, phone, location) values('Максим', 'Максимов', '1995-12-04', '+375112223344', 'Москва');
INSERT INTO catalog.user(firstname, lastname, birthdate, phone, location) values('Лена', 'Ленова', '1967-02-02', '+375112223344', 'Брест');
INSERT INTO catalog.user(firstname, lastname, birthdate, phone, location) values('Аня', 'Ааааа', '1988-12-09', '+375112223344', 'Киев');

INSERT INTO catalog.credentials(login, password, role, email) values('A1n', 'qwerty1', 'user', 'andrey@gmail.com');
INSERT INTO catalog.credentials(login, password, role, email) values('Dimmer', 'qwerty2', 'user', 'dima@gmail.com');
INSERT INTO catalog.credentials(login, password, role, email) values('Maximer', 'qwerty3', 'user', 'max.makasin@gmail.com');
INSERT INTO catalog.credentials(login, password, role, email) values('Vova', 'qwerty4', 'user', 'vova@gmail.com');
INSERT INTO catalog.credentials(login, password, role, email) values('Anna', 'qwerty5', 'user', 'anna@gmail.com');

INSERT INTO catalog.seller_rating(rating, rating_count) values(0, 0);
INSERT INTO catalog.seller_rating(rating, rating_count) values(7.0, 3);
INSERT INTO catalog.seller_rating(rating, rating_count) values(0, 0);
INSERT INTO catalog.seller_rating(rating, rating_count) values(5.5, 4);
INSERT INTO catalog.seller_rating(rating, rating_count) values(8.9, 2);

INSERT INTO catalog.sales_history values(4, 1, 'Lexus ls', '2019-04-23');
INSERT INTO catalog.sales_history values(2, 3, 'MacBook Air', '2019-05-08');

INSERT INTO catalog.category(title) values('Авто');
INSERT INTO catalog.category(title) values('Одежда');
INSERT INTO catalog.category(title) values('Всё для дома');
INSERT INTO catalog.category(title) values('Электроника');
INSERT INTO catalog.category(title) values('Ремонт');
INSERT INTO catalog.category(title) values('Сад и огород');
INSERT INTO catalog.category(title) values('Хобби и игры');
INSERT INTO catalog.category(title) values('Животные');

INSERT INTO catalog.advert(user_id, category_id, title, description, price) values(5, 4, 'Телефон Nokia', 'Nokia 123', 123.2);
INSERT INTO catalog.advert(user_id, category_id, title, description, price) values(4, 2, 'Кроссовки Nike', 'Nokia 123', 78.4);

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

INSERT INTO catalog.comment(advert_id, user_id, text) values(1, 5, 'Топ телефон');