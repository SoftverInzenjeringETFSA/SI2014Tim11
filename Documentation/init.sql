SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tim11baza
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tim11baza` DEFAULT CHARACTER SET latin1 ;
USE `tim11baza` ;

-- -----------------------------------------------------
-- Table `tim11baza`.`osoba`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim11baza`.`osoba` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `adresa` VARCHAR(255) NULL DEFAULT NULL,
  `datumZaposlenja` DATETIME NULL DEFAULT NULL,
  `ime` VARCHAR(255) NULL DEFAULT NULL,
  `jmbg` VARCHAR(255) NULL DEFAULT NULL,
  `pozicija` VARCHAR(255) NULL DEFAULT NULL,
  `prezime` VARCHAR(255) NULL DEFAULT NULL,
  `telefon` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tim11baza`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim11baza`.`admin` (
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  `id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_l953a6gqywk74n4ln40oom01l` (`username` ASC),
  CONSTRAINT `FK_as1rmx4ofyhjguia6ccyf1enx`
    FOREIGN KEY (`id`)
    REFERENCES `tim11baza`.`osoba` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tim11baza`.`firma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim11baza`.`firma` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `ime` VARCHAR(255) NULL DEFAULT NULL,
  `sjediste` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tim11baza`.`operater`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim11baza`.`operater` (
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `privilegije` BIT(1) NOT NULL,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  `id` BIGINT(20) NOT NULL,
  `firma` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_rc0yttrli0uxspggcglmrf5r5` (`username` ASC),
  INDEX `FK_t8adddr7odin9o04je3fpuhw5` (`firma` ASC),
  CONSTRAINT `FK_cug3pernmcc532wk6ojsa39jw`
    FOREIGN KEY (`id`)
    REFERENCES `tim11baza`.`osoba` (`id`),
  CONSTRAINT `FK_t8adddr7odin9o04je3fpuhw5`
    FOREIGN KEY (`firma`)
    REFERENCES `tim11baza`.`firma` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tim11baza`.`zaposlenik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim11baza`.`zaposlenik` (
  `dnevniTopliObrok` DOUBLE NOT NULL,
  `faktor` DOUBLE NOT NULL,
  `koeficijent` DOUBLE NOT NULL,
  `osnovica` DOUBLE NOT NULL,
  `id` BIGINT(20) NOT NULL,
  `firma` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_q5hd53a0uum7lie2suxkr4cpw` (`firma` ASC),
  CONSTRAINT `FK_mfvnir6nogi567y3ce88ssf4a`
    FOREIGN KEY (`id`)
    REFERENCES `tim11baza`.`osoba` (`id`),
  CONSTRAINT `FK_q5hd53a0uum7lie2suxkr4cpw`
    FOREIGN KEY (`firma`)
    REFERENCES `tim11baza`.`firma` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tim11baza`.`plata`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim11baza`.`plata` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `bolovanje` INT(11) NOT NULL,
  `brojRadnihDana` INT(11) NOT NULL,
  `datum` DATETIME NULL DEFAULT NULL,
  `godineStaza` INT(11) NOT NULL,
  `godisnjiOdmor` INT(11) NOT NULL,
  `nocniRad` DOUBLE NOT NULL,
  `prazniciRad` INT(11) NOT NULL,
  `stvarniRad` INT(11) NOT NULL,
  `zaposlenik` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_22cdjx263xy05ntuj5g6w42ep` (`zaposlenik` ASC),
  CONSTRAINT `FK_22cdjx263xy05ntuj5g6w42ep`
    FOREIGN KEY (`zaposlenik`)
    REFERENCES `tim11baza`.`zaposlenik` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;