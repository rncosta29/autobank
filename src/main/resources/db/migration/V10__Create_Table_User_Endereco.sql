CREATE TABLE IF NOT EXISTS `user_endereco` (
  `id_user` bigint(20) NOT NULL,
  `id_endereco` bigint(20) NOT NULL,
  PRIMARY KEY (`id_user`,`id_endereco`),
  KEY `fk_user_endereco_endereco` (`id_endereco`),
  CONSTRAINT `fk_user_endereco` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  CONSTRAINT `fk_user_endereco_endereco` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id`)
) ENGINE=InnoDB;