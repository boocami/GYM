-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-11-2019 a las 14:12:57
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdgym`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblentrenador`
--

CREATE TABLE `tblentrenador` (
  `usuario` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `idprofesion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblgenero`
--

CREATE TABLE `tblgenero` (
  `idgenero` int(11) NOT NULL,
  `nombregenero` varchar(20) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblmedicion`
--

CREATE TABLE `tblmedicion` (
  `idMedicion` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `estatura` int(11) NOT NULL,
  `peso` int(11) NOT NULL,
  `medidaCintura` int(11) NOT NULL,
  `PorcentajeGrasaFormula` int(11) NOT NULL,
  `imc` int(11) NOT NULL,
  `indiceGrasaInstrumento` int(11) NOT NULL,
  `foto` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `personausuario` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `personaentrenador` varchar(20) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblpersona`
--

CREATE TABLE `tblpersona` (
  `usuario` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `clave` int(4) NOT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `apellidopaterno` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `apellidomaterno` varchar(30) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblprofesion`
--

CREATE TABLE `tblprofesion` (
  `idprofesion` int(11) NOT NULL,
  `nombreprofesion` varchar(20) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblusuario`
--

CREATE TABLE `tblusuario` (
  `usuario` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `idgenero` int(11) NOT NULL,
  `fechanacimiento` int(11) NOT NULL,
  `fechaingreso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tblentrenador`
--
ALTER TABLE `tblentrenador`
  ADD PRIMARY KEY (`usuario`),
  ADD KEY `idprofesion` (`idprofesion`);

--
-- Indices de la tabla `tblgenero`
--
ALTER TABLE `tblgenero`
  ADD PRIMARY KEY (`idgenero`);

--
-- Indices de la tabla `tblmedicion`
--
ALTER TABLE `tblmedicion`
  ADD PRIMARY KEY (`idMedicion`),
  ADD KEY `personausuario` (`personausuario`),
  ADD KEY `personaentrenador` (`personaentrenador`);

--
-- Indices de la tabla `tblpersona`
--
ALTER TABLE `tblpersona`
  ADD PRIMARY KEY (`usuario`);

--
-- Indices de la tabla `tblprofesion`
--
ALTER TABLE `tblprofesion`
  ADD PRIMARY KEY (`idprofesion`);

--
-- Indices de la tabla `tblusuario`
--
ALTER TABLE `tblusuario`
  ADD PRIMARY KEY (`usuario`),
  ADD KEY `idgenero` (`idgenero`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tblmedicion`
--
ALTER TABLE `tblmedicion`
  MODIFY `idMedicion` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tblentrenador`
--
ALTER TABLE `tblentrenador`
  ADD CONSTRAINT `tblentrenador_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `tblpersona` (`usuario`),
  ADD CONSTRAINT `tblentrenador_ibfk_2` FOREIGN KEY (`idprofesion`) REFERENCES `tblprofesion` (`idprofesion`);

--
-- Filtros para la tabla `tblmedicion`
--
ALTER TABLE `tblmedicion`
  ADD CONSTRAINT `tblmedicion_ibfk_1` FOREIGN KEY (`personausuario`) REFERENCES `tblpersona` (`usuario`),
  ADD CONSTRAINT `tblmedicion_ibfk_2` FOREIGN KEY (`personaentrenador`) REFERENCES `tblpersona` (`usuario`);

--
-- Filtros para la tabla `tblusuario`
--
ALTER TABLE `tblusuario`
  ADD CONSTRAINT `tblusuario_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `tblpersona` (`usuario`),
  ADD CONSTRAINT `tblusuario_ibfk_2` FOREIGN KEY (`idgenero`) REFERENCES `tblgenero` (`idgenero`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
