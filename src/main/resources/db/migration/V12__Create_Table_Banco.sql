CREATE TABLE IF NOT EXISTS `banco` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `agencia` int(4) DEFAULT NULL,
  `codigo_banco` int(4) DEFAULT NULL,
  `presencial` bit(1) DEFAULT NULL,
  `online` bit(1) DEFAULT NULL,
  `financiamento_residencial` bit(1) DEFAULT NULL,
  `financiamento_veiculo` bit(1) DEFAULT NULL,  
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_agencia` (`agencia`)
) ENGINE=InnoDB;