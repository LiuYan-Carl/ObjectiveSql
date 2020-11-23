DROP TABLE IF EXISTS `objective_sql`.`members`;
DROP TABLE IF EXISTS `objective_sql`.`orders`;
DROP TABLE IF EXISTS `objective_sql`.`order_lines`;

CREATE TABLE `objective_sql`.`members`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `no` VARCHAR(100),
   `name` VARCHAR(100),
   `gender` INT(2),
   `mobile` VARCHAR(11),
   `extended_attributes` VARCHAR(512),
   `registered_at` DATETIME,
   `updated_at` DATETIME,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `objective_sql`.`orders`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `no` VARCHAR(100),
   `member_id` INT(10) UNSIGNED,
   `amount` FLOAT(6,2),
   `quantity` FLOAT(6,2),
   `sales_at` DATETIME,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `objective_sql`.`order_lines`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `order_no` VARCHAR(100),
   `amount` FLOAT(6,2),
   `quantity` FLOAT(6,2),
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `objective_sql`.`products`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `barcode` VARCHAR(100),
   `name` VARCHAR(100),
   `category_id` int(10),
   `sales_price` FLOAT,
   `cost` FLOAT,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
