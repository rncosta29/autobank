CREATE TABLE IF NOT EXISTS `endereco` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cep` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` int(6) DEFAULT NULL,
  `complemento` varchar(40) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;