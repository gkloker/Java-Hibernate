# Java-Hibernate

### Create table

CREATE SCHEMA `test` ;

CREATE TABLE `test`.`user` (
`id` INT NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(45) NULL,
`last_name` VARCHAR(45) NULL,
`email` VARCHAR(45) NULL,
`phone` VARCHAR(45) NULL,
PRIMARY KEY (`id`));
