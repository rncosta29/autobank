﻿CREATE TABLE IF NOT EXISTS `conta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `agencia` int(4) DEFAULT NULL,
  `conta` int(12) DEFAULT NULL,
  `saldo` double DEFAULT NULL,
  `cartao_credito` bit(1) DEFAULT NULL,
  `numero_cartao_credito` varchar(17) DEFAULT NULL,
  `dia_vencimento_cartao_credito` varchar(2) DEFAULT NULL,
  `codigo_seguranca_cartao_credito` int(3) DEFAULT NULL,
  `limite_cartao_credito` double DEFAULT NULL,
  `cartao_debito` bit(1) DEFAULT NULL,
  `numero_cartao_debito` varchar(17) DEFAULT NULL,
  `limite_conta` bit(1) DEFAULT NULL,
  `data_vencimento_cartao_debito` datetime(6) DEFAULT NULL,
  `codigo_seguranca_cartao_debito` int(3) DEFAULT NULL,
  `saldo_limite_conta` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_agencia` (`agencia`),
  UNIQUE KEY `uk_numero_cartao_credito` (`numero_cartao_credito`),
  UNIQUE KEY `uk_numero_cartao_debito` (`numero_cartao_debito`)
) ENGINE=InnoDB;