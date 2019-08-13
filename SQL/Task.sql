# Задание: 1 
SELECT model, speed, hd FROM mystore.pc WHERE price < 500;

# Задание: 2 
SELECT DISTINCT  maker FROM mystore.product WHERE type LIKE 'Printer';

# Задание: 3 
SELECT model, ram, screen FROM mystore.laptop WHERE price > 1000;

# Задание: 4 
SELECT * FROM mystore.printer WHERE color LIKE 'y';

# Задание: 5
SELECT model, speed, hd FROM mystore.pc WHERE (cd LIKE '12x' OR cd LIKE '24x') AND price < 600;

# Задание: 6 
SELECT prod.maker, lap.speed FROM mystore.product AS prod INNER JOIN mystore.laptop AS lap WHERE prod.model = lap.model AND lap.hd >= 100;

# Задание: 7 
SELECT model, price FROM mystore.product INNER JOIN mystore.laptop USING(model) WHERE maker like 'HP'
UNION
SELECT model, price FROM mystore.product INNER JOIN mystore.pc USING(model) WHERE maker like 'HP'
UNION
SELECT model, price FROM mystore.product INNER JOIN mystore.printer USING(model) WHERE maker like 'HP';

# Задание: 8
SELECT DISTINCT maker FROM mystore.product WHERE type LIKE 'PC' AND maker NOT IN (SELECT DISTINCT maker FROM mystore.product WHERE type LIKE 'Laptop');

# Задание: 9 
SELECT prod.maker FROM mystore.product AS prod INNER JOIN mystore.pc AS pc WHERE prod.model = pc.model AND pc.speed >= 450;

# Задание: 10 
SELECT model, price FROM mystore.printer WHERE price = (SELECT MAX(price) FROM mystore.printer);

# Задание: 11
SELECT AVG(speed) AS average_speed FROM mystore.pc;

# Задание: 12
SELECT AVG(speed) AS average_speed FROM mystore.laptop WHERE price > 1000;

# Задание: 13 
SELECT AVG(speed) AS average_speed FROM mystore.product INNER JOIN mystore.pc USING(model) WHERE maker LIKE 'ASUS';

# Задание: 14
SELECT speed, AVG(price) AS average_price FROM mystore.pc GROUP BY speed;

# Задание: 15
SELECT hd AS count FROM mystore.pc GROUP BY hd HAVING COUNT(hd) >= 2;

# Задание: 16 
SELECT i.model, j.model, i.speed, i.ram
FROM mystore.pc AS i, mystore.pc AS j
WHERE i.ram = j.ram and i.speed = j.speed and i.code > j.code;

# Задание: 17
SELECT model, speed FROM mystore.laptop WHERE speed < (SELECT MIN(speed) FROM mystore.pc); 

# Задание: 18
SELECT maker FROM  mystore.product AS prod INNER JOIN mystore.printer AS print USING(model) WHERE price = (SELECT MIN(price) FROM mystore.printer WHERE color ='y');

# Задание: 19
SELECT maker, AVG(screen) AS screen FROM mystore.product AS prod INNER JOIN mystore.laptop AS lap ON prod.model = lap.model GROUP BY maker;

# Задание: 20
SELECT maker, COUNT(maker) AS count FROM mystore.product WHERE type LIKE 'pc' GROUP BY maker HAVING COUNT(maker) >= 3;

# Задание: 21
SELECT prod.maker, MAX(pc.price) AS max_price FROM  mystore.product AS prod INNER JOIN mystore.pc AS pc ON prod.model = pc.model GROUP BY prod.maker;

# Задание: 22
SELECT speed, AVG(price) FROM mystore.pc WHERE speed > 600 GROUP BY speed;

# Задание: 23 
SELECT DISTINCT maker FROM mystore.product JOIN mystore.pc USING(model) WHERE speed >=750 AND maker
IN (SELECT DISTINCT maker FROM mystore.product JOIN mystore.laptop USING(model) WHERE speed >=750 );

# Задание: 24 
SELECT * FROM (
SELECT model, price FROM mystore.pc 
UNION 
SELECT model, price FROM mystore.laptop
UNION
SELECT model, price FROM mystore.printer) AS x ORDER BY price DESC LIMIT 1 ;

# Задание: 25
SELECT DISTINCT maker FROM mystore.product WHERE maker IN (SELECT maker FROM mystore.product WHERE type='printer')
AND maker IN (SELECT maker FROM mystore.product WHERE model = (SELECT model FROM mystore.pc WHERE speed = (SELECT MAX(speed) FROM mystore.pc WHERE ram = (SELECT MIN(ram) FROM mystore.pc)) AND ram = (SELECT MIN(ram) FROM mystore.pc)));

