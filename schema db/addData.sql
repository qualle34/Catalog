INSERT INTO catalog.user(firstname, lastname, birthdate, phone, location) values('Андрей', 'Андреев', '2001-12-08', '+375112223344', 'Гродно');
INSERT INTO catalog.user(firstname, lastname, birthdate, phone, location) values('Дима', 'Димов', '1990-12-08', '+375112223344', 'Минск');
INSERT INTO catalog.user(firstname, lastname, birthdate, phone, location) values('Максим', 'Максимов', '1995-12-04', '+375112223344', 'Москва');
INSERT INTO catalog.user(firstname, lastname, birthdate, phone, location) values('Лена', 'Ленова', '1967-02-02', '+375112223344', 'Брест');
INSERT INTO catalog.user(firstname, lastname, birthdate, phone, location) values('Аня', 'Ааааа', '1988-12-09', '+375112223344', 'Киев');

INSERT INTO catalog.credentials values(1, 'A1n', 'qwerty1', 'user', 'andrey@gmail.com');
INSERT INTO catalog.credentials values(2, 'Dimmer', 'qwerty2', 'user', 'dima@gmail.com');
INSERT INTO catalog.credentials values(3, 'Maximer', 'qwerty3', 'user', 'max.makasin@gmail.com');
INSERT INTO catalog.credentials values(4, 'Vova', 'qwerty4', 'user', 'vova@gmail.com');
INSERT INTO catalog.credentials values(5, 'Anna', 'qwerty5', 'user', 'anna@gmail.com');

INSERT INTO catalog.seller_rating(user_id, rating, rating_count) values(1, 0, 0);
INSERT INTO catalog.seller_rating(user_id, rating, rating_count) values(2, 7.0, 3);
INSERT INTO catalog.seller_rating(user_id, rating, rating_count) values(3, 0, 0);
INSERT INTO catalog.seller_rating(user_id, rating, rating_count) values(4, 5.5, 4);
INSERT INTO catalog.seller_rating(user_id, rating, rating_count) values(5, 8.9, 2);

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


