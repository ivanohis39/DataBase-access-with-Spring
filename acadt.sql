-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-01-2019 a las 13:06:01
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `acadt`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarEmpleados` (`emp_no` INT, `apellido` VARCHAR(50), `oficio` VARCHAR(50), `dir` INT, `fecha_alt` DATE, `salario` INT, `comision` INT, `dept_no` INT)  BEGIN
INSERT INTO EMPLEADOS VALUES (emp_no, apellido, oficio, dir,fecha_alt,salario, comision, dept_no);
COMMIT;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `menosTiempo` ()  BEGIN
SELECT * FROM empleados WHERE (EXTRACT(YEAR FROM SYSDATE())- EXTRACT(YEAR FROM fecha_alt)) <= 2;
COMMIT;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrarClientes` ()  BEGIN
SELECT * FROM clienteS;
COMMIT;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrarvVentas` ()  BEGIN
SELECT * FROM ventas WHERE(EXTRACT(YEAR FROM SYSDATE()) - EXTRACT(YEAR FROM FECHA_VENTA)) <= 2;
COMMIT;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `poblacion` varchar(50) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `nif` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombre`, `direccion`, `poblacion`, `telefono`, `nif`) VALUES
(1, 'Pepe', 'Pepinosia', 'Plasencia', '147852369', '123654789'),
(2, 'Ivan', 'Lusitania', 'Plasencia', '147852369', '258963147');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamentos`
--

CREATE TABLE `departamentos` (
  `dept_no` int(2) NOT NULL,
  `dnombre` varchar(15) DEFAULT NULL,
  `loc` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `departamentos`
--

INSERT INTO `departamentos` (`dept_no`, `dnombre`, `loc`) VALUES
(10, 'CONTABILIDAD', 'SEVILLA'),
(20, 'INVESTIGACION', 'MADRID'),
(30, 'VENTAS', 'BARCELONA'),
(40, 'PRODUCCION', 'BILBAO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `emp_no` int(4) NOT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  `oficio` varchar(50) DEFAULT NULL,
  `dir` int(2) DEFAULT NULL,
  `fecha_alt` date DEFAULT NULL,
  `salario` double(6,2) DEFAULT NULL,
  `comision` double(6,2) DEFAULT NULL,
  `dept_no` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`emp_no`, `apellido`, `oficio`, `dir`, `fecha_alt`, `salario`, `comision`, `dept_no`) VALUES
(2, 'ARRIBAS', 'ANALISTA', 1, '2001-03-07', 2000.00, 100.00, 20),
(5, 'INIAQUI', 'ELEPHANTE', 1, '2019-01-16', 5000.00, 200.00, 30),
(10, 'LOPEZ', 'PROGRAMADOR', NULL, '2019-01-11', 1200.00, 100.00, 10),
(39, 'Hisado', 'Programador', 10, '2019-01-11', 2500.00, 100.00, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id_producto` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `stock_actual` int(11) DEFAULT NULL,
  `stock_minimo` int(11) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_producto`, `descripcion`, `stock_actual`, `stock_minimo`, `precio`) VALUES
(1, 'Tomato', 100, 5, 2),
(2, 'Pepsi', 500, 10, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id_venta` int(11) NOT NULL,
  `fecha_venta` date NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `id_producto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id_venta`, `fecha_venta`, `id_cliente`, `id_producto`, `cantidad`) VALUES
(1, '2019-01-13', 1, 1, 1),
(2, '2019-01-13', 2, 2, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `departamentos`
--
ALTER TABLE `departamentos`
  ADD PRIMARY KEY (`dept_no`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`emp_no`),
  ADD KEY `fk_emp_deptno_depart` (`dept_no`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_producto`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id_venta`),
  ADD KEY `id_cliente_fk` (`id_cliente`),
  ADD KEY `id_prod_fk` (`id_producto`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `fk_emp_deptno_depart` FOREIGN KEY (`dept_no`) REFERENCES `departamentos` (`dept_no`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `id_cliente_fk` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`),
  ADD CONSTRAINT `id_prod_fk` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
