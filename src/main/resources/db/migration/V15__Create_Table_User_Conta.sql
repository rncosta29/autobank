CREATE TABLE IF NOT EXISTS `user_conta` (
  `id_user` bigint(20) NOT NULL,
  `id_conta` bigint(20) NOT NULL,
  PRIMARY KEY (`id_user`,`id_conta`),
  KEY `fk_user_conta_conta` (`id_conta`),
  CONSTRAINT `fk_user_conta` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  CONSTRAINT `fk_user_conta_conta` FOREIGN KEY (`id_conta`) REFERENCES `conta` (`id`)
) ENGINE=InnoDB;