-- BASE DE DATOS PARA TRAVIS, SE CREA ANTES DE EJECUTAR LOS TESTS
-- EN CASO DE QUE HAYA QUE CAMBIAR LA BASE DE DATOS, HABRÍA QUE CAMBIAR ESTE FICHERO TAMBIÉN (TIENE QUE SER IDÉNTICO A NUESTRA DB)


-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-03-2019 a las 19:15:40
-- Versión del servidor: 10.2.22-MariaDB
-- Versión de PHP: 7.2.14


CREATE DATABASE IF NOT EXISTS `u570270067_gps`;
USE `u570270067_gps`;

GRANT ALL PRIVILEGES ON *.* TO 'u570270067_user'@'localhost' IDENTIFIED BY 'gps2019';

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `u570270067_gps`
--
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `HOST`
--

CREATE TABLE `HOST` (
  `ID` int(11) NOT NULL,
  `LISTOFINTERESTS` longblob,
  `VERSION` int(11) DEFAULT NULL,
  `USER_NICKNAME` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `PLACE`
--

CREATE TABLE `PLACE` (
  `ADDRESS` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `PLACE`
--

INSERT INTO `PLACE` (`ADDRESS`, `DESCRIPTION`) VALUES
('Valencia', 'guapo'),
('Toboso', 'Robertitito GUapo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TRAVELER`
--

CREATE TABLE `TRAVELER` (
  `ID` int(11) NOT NULL,
  `DURATIONOFSTAY` int(11) DEFAULT NULL,
  `LISTOFCOUNTRIES` longblob,
  `LISTOFKNOWLEDGES` longblob,
  `VERSION` int(11) DEFAULT NULL,
  `USER_NICKNAME` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `USER`
--

CREATE TABLE `USER` (
  `NICKNAME` varchar(255) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `FULLNAME` varchar(255) DEFAULT NULL,
  `HOST` tinyint(1) DEFAULT '0',
  `PASSWD` varchar(255) DEFAULT NULL,
  `RATING` double DEFAULT NULL,
  `TRAVELER` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `USER`
--

INSERT INTO `USER` (`NICKNAME`, `DESCRIPTION`, `EMAIL`, `FULLNAME`, `HOST`, `PASSWD`, `RATING`, `TRAVELER`) VALUES
('Roberto', 'guapo', 'omega@gmail.com', 'Roberto Torres Prensa', 1, 'guapoguapo', 5, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `HOST`
--
ALTER TABLE `HOST`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_HOST_USER_NICKNAME` (`USER_NICKNAME`);

--
-- Indices de la tabla `TRAVELER`
--
ALTER TABLE `TRAVELER`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_TRAVELER_USER_NICKNAME` (`USER_NICKNAME`);

--
-- Indices de la tabla `USER`
--
ALTER TABLE `USER`
  ADD PRIMARY KEY (`NICKNAME`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `HOST`
--
ALTER TABLE `HOST`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `TRAVELER`
--
ALTER TABLE `TRAVELER`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `HOST`
--
ALTER TABLE `HOST`
  ADD CONSTRAINT `FK_HOST_USER_NICKNAME` FOREIGN KEY (`USER_NICKNAME`) REFERENCES `USER` (`NICKNAME`);

--
-- Filtros para la tabla `TRAVELER`
--
ALTER TABLE `TRAVELER`
  ADD CONSTRAINT `FK_TRAVELER_USER_NICKNAME` FOREIGN KEY (`USER_NICKNAME`) REFERENCES `USER` (`NICKNAME`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
