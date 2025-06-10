CREATE DATABASE  rh_tech ;
USE  rh_tech ;

CREATE TABLE  `funcionarios`(
    `id` BIGINT(20) AUTO_INCREMENT,
    `nome` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL UNIQUE,
    `senha` VARCHAR(8) NOT NULL,
    `cep` VARCHAR(8) NOT NULL,
    `endereco` VARCHAR(255) NOT NULL,
    `numero` INTEGER NOT NULL,
    `bairro` VARCHAR(255) NOT NULL,
    `cidade` VARCHAR(255) NOT NULL,
    `estado` VARCHAR(255) not null ,
    PRIMARY KEY(`id`));

    CREATE TABLE `cargos`(
        `id` BIGINT(20) AUTO_INCREMENT,
        `nome` VARCHAR(255) NOT NULL,
        `descricao` VARCHAR(255) NOT NULL,
        PRIMARY KEY(`id`)
    );
    