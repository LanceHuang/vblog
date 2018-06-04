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
  `password` VARCHAR(30) NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `t_role`
(
  `id`   INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `t_permission`
(
  `id`   INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS `r_user_role`
(
  `id`  INT PRIMARY KEY      AUTO_INCREMENT,
  `uid` INT NOT NULL,
  `rid` INT NOT NULL,
  CONSTRAINT FOREIGN KEY (`uid`) REFERENCES t_user (`id`),
  CONSTRAINT FOREIGN KEY (`rid`) REFERENCES t_role (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `r_role_perm`
(
  `id`  INT PRIMARY KEY      AUTO_INCREMENT,
  `rid` INT NOT NULL,
  `pid` INT NOT NULL,
  CONSTRAINT FOREIGN KEY (`rid`) REFERENCES t_role (`id`),
  CONSTRAINT FOREIGN KEY (`pid`) REFERENCES t_permission (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS `t_blog`
(
  `id`          INT PRIMARY KEY   AUTO_INCREMENT,
  `author`      VARCHAR(50),
  `content`     TEXT     NOT NULL,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `update_time` DATETIME          DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP()
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- Add test data
INSERT INTO `t_user` (`name`, `password`) VALUES ('admin', 'admin123456');
INSERT INTO `t_user` (`name`, `password`) VALUES ('lance', '123456');
INSERT INTO `t_user` (`name`, `password`) VALUES ('leo', '123456');
INSERT INTO `t_user` (`name`, `password`) VALUES ('alice', '654321');

INSERT INTO `t_role` (`name`) VALUES ('root');
INSERT INTO `t_role` (`name`) VALUES ('member');
INSERT INTO `t_role` (`name`) VALUES ('guest');

INSERT INTO `t_permission` (`name`) VALUES ('*');
INSERT INTO `t_permission` (`name`) VALUES ('blog:*');
INSERT INTO `t_permission` (`name`) VALUES ('blog:read');
INSERT INTO `t_permission` (`name`) VALUES ('blog:write');
INSERT INTO `t_permission` (`name`) VALUES ('blog:share');

INSERT INTO `t_blog` (`author`, `content`) VALUES ('lance', 'Hello world');
INSERT INTO `t_blog` (`author`, `content`) VALUES ('alice', 'What a beautiful day!');

-- Add test relationship
INSERT INTO `r_user_role` (`uid`, `rid`) VALUES (1, 1);
INSERT INTO `r_user_role` (`uid`, `rid`) VALUES (2, 2);
INSERT INTO `r_user_role` (`uid`, `rid`) VALUES (3, 3);
INSERT INTO `r_user_role` (`uid`, `rid`) VALUES (4, 2);

INSERT INTO `r_role_perm` (`rid`, `pid`) VALUES (1, 1);
INSERT INTO `r_role_perm` (`rid`, `pid`) VALUES (2, 2);
INSERT INTO `r_role_perm` (`rid`, `pid`) VALUES (3, 3);
INSERT INTO `r_role_perm` (`rid`, `pid`) VALUES (3, 5);
