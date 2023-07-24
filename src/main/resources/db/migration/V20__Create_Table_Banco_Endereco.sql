CREATE TABLE IF NOT EXISTS `banco_endereco` (
  `id_banco` bigint(20) NOT NULL,
  `id_endereco` bigint(20) NOT NULL,
  PRIMARY KEY (`id_banco`,`id_endereco`),
  KEY `fk_banco_endereco_endereco` (`id_endereco`),
  CONSTRAINT `fk_banco_endereco` FOREIGN KEY (`id_banco`) REFERENCES `users` (`id`),
  CONSTRAINT `fk_banco_endereco_endereco` FOREIGN KEY (`id_banco`) REFERENCES `endereco` (`id`)
) ENGINE=InnoDB;