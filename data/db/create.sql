-- -----------------------------------------------------
-- Schema catalog
-- -----------------------------------------------------
DROP DATABASE IF EXISTS `catalog`;
CREATE SCHEMA `catalog` DEFAULT CHARACTER SET utf8mb4;
USE `catalog`;


-- -----------------------------------------------------
-- Table `catalog`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `catalog`.`user` (
  `user_id` BIGINT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(30) NOT NULL,
  `lastname` VARCHAR(30) NULL,
  `birthdate` DATE NULL,
  `phone` VARCHAR(15) NULL,
  `location` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `catalog`.`credentials`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `catalog`.`credentials` (
  `user_id` BIGINT NOT NULL,
  `login` VARCHAR(25) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `email` VARCHAR(65) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  CONSTRAINT `user_creds_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `catalog`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `catalog`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `catalog`.`category` (
  `category_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`category_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `catalog`.`advert`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `catalog`.`advert` (
  `advert_id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `category_id` INT NULL,
  `title` VARCHAR(45) NOT NULL,
  `description` TEXT NOT NULL,
  `price` DECIMAL(12,2) NULL DEFAULT 0,
  `type` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`advert_id`, `user_id`),
  INDEX `user_advert_fk_idx` (`user_id` ASC) VISIBLE,
  INDEX `category_advert_fk_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `user_advert_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `catalog`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `category_advert_fk`
    FOREIGN KEY (`category_id`)
    REFERENCES `catalog`.`category` (`category_id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `catalog`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `catalog`.`comment` (
  `comment_id` BIGINT NOT NULL AUTO_INCREMENT,
  `advert_id` BIGINT NOT NULL,
  `user_id` BIGINT NULL,
  `text` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`comment_id`, `advert_id`),
  INDEX `user_comment_fk_idx` (`user_id` ASC) VISIBLE,
  INDEX `advert_comment_fk_idx` (`advert_id` ASC) VISIBLE,
  CONSTRAINT `user_comment_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `catalog`.`user` (`user_id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION,
  CONSTRAINT `advert_comment_fk`
    FOREIGN KEY (`advert_id`)
    REFERENCES `catalog`.`advert` (`advert_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `catalog`.`chat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `catalog`.`chat` (
  `chat_id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`chat_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `catalog`.`user_chat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `catalog`.`user_chat` (
  `user_id` BIGINT NOT NULL,
  `chat_id` BIGINT NOT NULL,
  PRIMARY KEY (`user_id`, `chat_id`),
  INDEX `chat_uc_fk_idx` (`chat_id` ASC) VISIBLE,
  CONSTRAINT `user_userchat_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `catalog`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `chat_userchat_fk`
    FOREIGN KEY (`chat_id`)
    REFERENCES `catalog`.`chat` (`chat_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `catalog`.`message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `catalog`.`message` (
  `message_id` BIGINT NOT NULL AUTO_INCREMENT,
  `chat_id` BIGINT NOT NULL,
  `user_id` BIGINT NULL,
  `text` VARCHAR(255) NOT NULL,
  `send_date` DATETIME NOT NULL,
  PRIMARY KEY (`message_id`, `chat_id`),
  INDEX `chat_message_fk_idx` (`chat_id` ASC) VISIBLE,
  INDEX `user_message_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `chat_message_fk`
    FOREIGN KEY (`chat_id`)
    REFERENCES `catalog`.`chat` (`chat_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `user_message_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `catalog`.`user` (`user_id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `catalog`.`deal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `catalog`.`deal` (
  `deal_id` BIGINT NOT NULL AUTO_INCREMENT,
  `seller_id` BIGINT NULL,
  `buyer_id` BIGINT NULL,
  `title` VARCHAR(45) NOT NULL,
  `sale_date` DATE NOT NULL,
  INDEX `user_buyer_fk_idx` (`buyer_id` ASC) VISIBLE,
  PRIMARY KEY (`deal_id`),
  CONSTRAINT `user_seller_fk`
    FOREIGN KEY (`seller_id`)
    REFERENCES `catalog`.`user` (`user_id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION,
  CONSTRAINT `user_buyer_fk`
    FOREIGN KEY (`buyer_id`)
    REFERENCES `catalog`.`user` (`user_id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `catalog`.`user_rating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `catalog`.`user_rating` (
  `user_id` BIGINT NOT NULL,
  `rating` DECIMAL(2,1) NOT NULL,
  `rating_count` INT NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `user_rating_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `catalog`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `catalog`.`vip_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `catalog`.`vip_info` (
  `advert_id` BIGINT NOT NULL,
  `buy_vip_date` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`advert_id`),
  CONSTRAINT `advert_vip_fk`
    FOREIGN KEY (`advert_id`)
    REFERENCES `catalog`.`advert` (`advert_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `catalog`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `catalog`.`role` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `catalog`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `catalog`.`user_role` (
  `user_id` BIGINT NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`),
  INDEX `role_userrole_fk_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `user_userrole_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `catalog`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `role_userrole_fk`
    FOREIGN KEY (`role_id`)
    REFERENCES `catalog`.`role` (`role_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;