create database IF not exists gestionProduits ;
use gestionProduits;

CREATE TABLE IF not exists `gestionproduits`.`client` (
  `id` INT NOT NULL auto_increment,
  `nom` VARCHAR(50) NULL,
  `prenom` VARCHAR(50) NULL,
  `age` INT NULL,
  `telephone` VARCHAR(50) NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE IF not exists `gestionproduits`.`fournisseur` (
  `id` INT NOT NULL auto_increment,
  `nom` VARCHAR(50) NULL,
  `dommain` VARCHAR(50) NULL,
  `address` VARCHAR(50) NULL,
  `telephone` VARCHAR(50) NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE IF not exists `gestionproduits`.`produit` (
  `id` INT NOT NULL auto_increment,
  `nom` VARCHAR(50) NULL,
  `type` VARCHAR(50) NULL,
  `quantite` INT NULL,
  `idclient` INT NULL,
  `idfournisseur` INT NULL,
  PRIMARY KEY (`id`));
-- constraint FK Foreign key (`idclient`) references ( `gestionproduits`.`client`(`idclient`)),
--   Foreign key (`idfournisseur`) references ( `gestionproduits`.`fournisseur`(`id`)));

