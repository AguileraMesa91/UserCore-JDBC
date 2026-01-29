CREATE SCHEMA `user_core_db`;

CREATE TABLE `user_core_db`.`users` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(250) NOT NULL,
  `age` INT NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);
