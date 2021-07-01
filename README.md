# Java-Hibernate

### Create table

CREATE SCHEMA `sga` ;

CREATE TABLE `sga`.`address` (
  `id_address` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NULL,
  `num_street` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`id_address`));

CREATE TABLE `sga`.`contact` (
  `id_contact` INT NOT NULL AUTO_INCREMENT,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id_contact`));

CREATE TABLE `sga`.`course` (
  `id_course` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`id_course`));

CREATE TABLE `sga`.`student` (
  `id_student` INT NOT NULL AUTO_INCREMENT,
  `id_address` INT NULL,
  `id_contact` INT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  PRIMARY KEY (`id_student`),
  INDEX `fk_address_idx` (`id_address` ASC) VISIBLE,
  INDEX `fk_contact_idx` (`id_contact` ASC) VISIBLE,
  CONSTRAINT `fk_address`
    FOREIGN KEY (`id_address`)
    REFERENCES `sga`.`address` (`id_address`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contact`
    FOREIGN KEY (`id_contact`)
    REFERENCES `sga`.`contact` (`id_contact`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `sga`.`assignment` (
  `id_assignment` INT NOT NULL AUTO_INCREMENT,
  `id_student` INT NULL,
  `id_course` INT NULL,
  `turn` VARCHAR(45) NULL,
  PRIMARY KEY (`id_assignment`),
  INDEX `fk_student_idx` (`id_student` ASC) VISIBLE,
  INDEX `fk_course_idx` (`id_course` ASC) VISIBLE,
  CONSTRAINT `fk_student`
    FOREIGN KEY (`id_student`)
    REFERENCES `sga`.`student` (`id_student`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_course`
    FOREIGN KEY (`id_course`)
    REFERENCES `sga`.`course` (`id_course`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

