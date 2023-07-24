CREATE TABLE IF NOT EXISTS `banco_conta` (
  `id_banco` bigint(20) NOT NULL,
  `id_conta` bigint(20) NOT NULL,
  PRIMARY KEY (`id_banco`,`id_conta`),
  KEY `fk_user_conta_conta` (`id_conta`),
  CONSTRAINT `fk_banco_conta` FOREIGN KEY (`id_banco`) REFERENCES `banco` (`id`),
  CONSTRAINT `fk_banco_conta_conta` FOREIGN KEY (`id_conta`) REFERENCES `conta` (`id`)
) ENGINE=InnoDB;