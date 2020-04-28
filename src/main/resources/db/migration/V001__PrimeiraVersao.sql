CREATE TABLE `pessoa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cep` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `rua` varchar(255) DEFAULT NULL,
  `sobrenome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci