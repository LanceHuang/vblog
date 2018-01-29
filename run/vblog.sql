-- Create database
CREATE DATABASE IF NOT EXISTS `vblog`
  CHARACTER SET 'utf8'
  COLLATE 'utf8_general_ci';

USE `vblog`;

-- Create tables
CREATE TABLE IF NOT EXISTS `t_user`
(
  `id`       INT PRIMARY KEY      AUTO_INCREMENT,
  `name`     VARCHAR(20) NOT NULL,
  `password` VARCHAR(30) NOT NULL DEFAULT '123456'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `t_role`
(
  `id`   INT PRIMARY KEY AUTO_INCREMENT,
  `uid`  INT         NOT NULL,
  `name` VARCHAR(30) NOT NULL,
  FOREIGN KEY (uid) REFERENCES t_user (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS `t_grade`
(
  `id`    INT PRIMARY KEY AUTO_INCREMENT,
  `uid`   INT NOT NULL,
  `grade` DOUBLE,
  FOREIGN KEY (uid) REFERENCES t_user (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

