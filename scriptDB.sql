-- MySQL Script generated by MySQL Workbench
-- Mon Sep  4 22:08:55 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema proyecto
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema proyecto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `proyecto` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `proyecto` ;

-- -----------------------------------------------------
-- Table `proyecto`.`informacion_personal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto`.`informacion_personal` (
  `id_usuario` VARCHAR(45) NOT NULL,
  `nombres` VARCHAR(50) NOT NULL,
  `apellidos` VARCHAR(50) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  UNIQUE INDEX `id_usuario` (`id_usuario` ASC) VISIBLE,
  UNIQUE INDEX `email` (`email` ASC) VISIBLE,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `proyecto`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto`.`admin` (
  `id_admin` VARCHAR(45) NOT NULL,
  `informacion_personal_id_usuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_admin`),
  UNIQUE INDEX `id_admin` (`id_admin` ASC) VISIBLE,
  INDEX `fk_admin_informacion_personal1_idx` (`informacion_personal_id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_admin_informacion_personal1`
    FOREIGN KEY (`informacion_personal_id_usuario`)
    REFERENCES `proyecto`.`informacion_personal` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `proyecto`.`estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto`.`estudiante` (
  `cta` VARCHAR(45) NOT NULL,
  `carrera` VARCHAR(50) NOT NULL,
  `estatus_voto` TINYINT NOT NULL DEFAULT '0',
  `informacion_personal_id_usuario` VARCHAR(45) NULL,
  PRIMARY KEY (`cta`),
  UNIQUE INDEX `cta` (`cta` ASC) VISIBLE,
  INDEX `fk_estudiante_informacion_personal1_idx` (`informacion_personal_id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_estudiante_informacion_personal1`
    FOREIGN KEY (`informacion_personal_id_usuario`)
    REFERENCES `proyecto`.`informacion_personal` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `proyecto`.`planilla`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto`.`planilla` (
  `id_planilla` VARCHAR(45) NOT NULL,
  `nombre_planilla` VARCHAR(45) NOT NULL,
  `votos` INT NULL DEFAULT '0',
  `estudiante_cta` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_planilla`),
  UNIQUE INDEX `id_planilla` (`id_planilla` ASC) VISIBLE,
  UNIQUE INDEX `nombre_planilla` (`nombre_planilla` ASC) VISIBLE,
  INDEX `fk_planilla_estudiante1_idx` (`estudiante_cta` ASC) VISIBLE,
  CONSTRAINT `fk_planilla_estudiante1`
    FOREIGN KEY (`estudiante_cta`)
    REFERENCES `proyecto`.`estudiante` (`cta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `proyecto`.`miembros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto`.`miembros` (
  `estudiante_cta` VARCHAR(45) NOT NULL,
  `planilla_id_planilla` VARCHAR(45) NOT NULL,
  INDEX `fk_estudiante_has_planilla_planilla1_idx` (`planilla_id_planilla` ASC) VISIBLE,
  INDEX `fk_estudiante_has_planilla_estudiante1_idx` (`estudiante_cta` ASC) VISIBLE,
  CONSTRAINT `fk_estudiante_has_planilla_estudiante1`
    FOREIGN KEY (`estudiante_cta`)
    REFERENCES `proyecto`.`estudiante` (`cta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_estudiante_has_planilla_planilla1`
    FOREIGN KEY (`planilla_id_planilla`)
    REFERENCES `proyecto`.`planilla` (`id_planilla`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;