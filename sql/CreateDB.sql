CREATE DATABASE IF NOT EXISTS mystore;

CREATE TABLE IF NOT EXISTS mystore.product (
  `maker` VARCHAR(10) NOT NULL,
  `model` VARCHAR(50) NOT NULL UNIQUE,
  `type` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`model`)
);

CREATE TABLE IF NOT EXISTS mystore.laptop (
  `code` INT NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(50) NOT NULL UNIQUE,
  `speed` SMALLINT NOT NULL,
  `ram` SMALLINT NOT NULL,
  `hd` REAL NOT NULL,
  `price` DECIMAL(13,2),
  `screen` TINYINT NOT NULL,
  PRIMARY KEY (`code`),
  FOREIGN KEY (model) REFERENCES mystore.product(model)
);

CREATE TABLE IF NOT EXISTS mystore.pc (
  `code` INT NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(50) NOT NULL UNIQUE,
  `speed` SMALLINT NOT NULL,
  `ram` SMALLINT NOT NULL,
  `hd` REAL NOT NULL,
  `cd` VARCHAR(10) NOT NULL,
  `price` DECIMAL(13,2),
  PRIMARY KEY (`code`),
  FOREIGN KEY (model) REFERENCES mystore.product(model)
);

CREATE TABLE IF NOT EXISTS mystore.printer (
  `code` INT NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(50) NOT NULL UNIQUE,
  `color` CHAR(1) NOT NULL,
  `type` VARCHAR(10) NOT NULL,
  `price` DECIMAL(13,2),
  PRIMARY KEY (`code`),
  FOREIGN KEY (model) REFERENCES mystore.product(model)
);