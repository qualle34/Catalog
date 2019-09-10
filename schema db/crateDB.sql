CREATE DATABASE IF NOT EXISTS `catalog`;

CREATE TABLE IF NOT EXISTS `catalog`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NULL,
  `birthdate` DATE NULL,
  `phone` VARCHAR(45) NULL,
  `location` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `catalog`.`credentials` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `user_creds_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `catalog`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `catalog`.`seller_rating` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `rating` DECIMAL(2,1) NOT NULL,
  `rating_count` INT NOT NULL,
  `end_vip_date` DATE NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `user_rating_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `catalog`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `catalog`.`sales_history` (
  `seller_id` INT NOT NULL,
  `buyer_id` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `sale_date` DATE NOT NULL,
  PRIMARY KEY (`seller_id`, `buyer_id`),
  INDEX `user_buyer_fk_idx` (`buyer_id` ASC) VISIBLE,
  CONSTRAINT `user_seller_fk`
    FOREIGN KEY (`seller_id`)
    REFERENCES `catalog`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_buyer_fk`
    FOREIGN KEY (`buyer_id`)
    REFERENCES `catalog`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `catalog`.`category` (
  `category_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  PRIMARY KEY (`category_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `catalog`.`advert` (
  `advert_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `price` DECIMAL(12,2) NOT NULL,
  PRIMARY KEY (`advert_id`, `user_id`, `category_id`),
  INDEX `user_advert_fk_idx` (`user_id` ASC) VISIBLE,
  INDEX `category_advert_fk_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `user_advert_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `catalog`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `category_advert_fk`
    FOREIGN KEY (`category_id`)
    REFERENCES `catalog`.`category` (`category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `catalog`.`comment` (
  `comment_id` INT NOT NULL AUTO_INCREMENT,
  `advert_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `text` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`comment_id`, `advert_id`, `user_id`),
  INDEX `user_comment_fk_idx` (`user_id` ASC) VISIBLE,
  INDEX `advert_comment_fk_idx` (`advert_id` ASC) VISIBLE,
  CONSTRAINT `user_comment_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `catalog`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `advert_comment_fk`
    FOREIGN KEY (`advert_id`)
    REFERENCES `catalog`.`advert` (`advert_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `catalog`.`chat` (
  `chat_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  PRIMARY KEY (`chat_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `catalog`.`user_chat` (
  `user_id` INT NOT NULL,
  `chat_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `chat_id`),
  INDEX `chat_uc_fk_idx` (`chat_id` ASC) VISIBLE,
  CONSTRAINT `user_userchat_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `catalog`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `chat_userchat_fk`
    FOREIGN KEY (`chat_id`)
    REFERENCES `catalog`.`chat` (`chat_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `catalog`.`message` (
  `message_id` INT NOT NULL AUTO_INCREMENT,
  `chat_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `text` VARCHAR(45) NOT NULL,
  `send_date` DATETIME NOT NULL,
  PRIMARY KEY (`message_id`, `chat_id`, `user_id`),
  INDEX `chat_message_fk_idx` (`chat_id` ASC) VISIBLE,
  INDEX `user_message_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `chat_message_fk`
    FOREIGN KEY (`chat_id`)
    REFERENCES `catalog`.`chat` (`chat_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_message_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `catalog`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
