CREATE DATABASE tiendalicores;
use tiendalicores;

-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-12-2024 a las 00:23:58
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: tiendalicores
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla detalle_pedido
--

CREATE TABLE detalle_pedido (
  id_detalle_pedido int(11) NOT NULL,
  id_pedido int(11) DEFAULT NULL,
  id_licor int(11) DEFAULT NULL,
  tipo varchar(50) DEFAULT NULL,
  nombre varchar(100) DEFAULT NULL,
  cantidad int(11) DEFAULT NULL,
  precio_unitario decimal(10,2) DEFAULT NULL,
  total decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla detalle_pedido
--

INSERT INTO detalle_pedido (id_detalle_pedido, id_pedido, id_licor, tipo, nombre, cantidad, precio_unitario, total) VALUES
(1, 10, NULL, 'Whisky', 'Whisky Escocés', 50, 45.00, 2250.00),
(2, 10, NULL, 'Vino', 'Vino Tinto', 100, 15.50, 1550.00),
(3, 10, NULL, 'Whisky', 'Whisky Escocés', 50, 45.00, 2250.00),
(4, 12, NULL, 'Vino', 'Vino Tinto', 3, 15.50, 46.50),
(5, 12, NULL, 'Cerveza', 'Cerveza Rubia', 5, 3.50, 17.50),
(6, 12, NULL, 'Whisky', 'Whisky Escocés', 4, 45.00, 180.00),
(9, 15, NULL, 'Vino', 'Vino Tinto', 100, 15.50, 1550.00),
(10, 15, NULL, 'Vino', 'Vino Tinto', 100, 15.50, 1550.00),
(11, 17, NULL, 'Vino', 'Vino Tinto', 100, 15.50, 1550.00),
(12, 17, NULL, 'Vino', 'Vino Tinto', 100, 15.50, 1550.00),
(13, 19, NULL, 'Vino', 'Vino Tinto', 100, 15.50, 1550.00),
(14, 19, NULL, 'Vino', 'Vino Tinto', 100, 15.50, 1550.00),
(15, 19, NULL, 'Vino', 'Vino Tinto', 100, 15.50, 1550.00),
(16, 20, NULL, 'Vino', 'Vino Tinto', 100, 15.50, 1550.00),
(17, 20, NULL, 'Vino', 'Vino Tinto', 100, 15.50, 1550.00),
(18, 20, NULL, 'Vino', 'Vino Tinto', 100, 15.50, 1550.00),
(19, 20, NULL, 'Vino', 'Vino Tinto', 100, 15.50, 1550.00),
(20, 21, NULL, 'Cerveza', 'Cerveza Rubia', 200, 3.50, 700.00),
(21, 22, NULL, 'Vino', 'Vino Tinto', 100, 15.50, 1550.00),
(22, 22, NULL, 'Vino', 'Vino Tinto', 100, 15.50, 1550.00),
(23, 22, NULL, 'Vino', 'Vino Tinto', 100, 15.50, 1550.00),
(24, 22, NULL, 'Vino', 'Vino Tinto', 100, 15.50, 1550.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla licores
--

CREATE TABLE licores (
  id int(11) NOT NULL,
  tipo varchar(50) NOT NULL,
  nombre varchar(100) NOT NULL,
  marca varchar(100) DEFAULT NULL,
  cantidad int(11) NOT NULL,
  precio decimal(10,2) NOT NULL,
  pais_origen varchar(50) DEFAULT NULL,
  fecha_ingreso date DEFAULT NULL,
  descripcion text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla licores
--

INSERT INTO licores (id, tipo, nombre, marca, cantidad, precio, pais_origen, fecha_ingreso, descripcion) VALUES
(1, 'Vino', 'Vino Tinto', 'Marca A', 100, 15.50, 'Chile', '2024-01-01', 'Vino Tinto Seco'),
(2, 'Cerveza', 'Cerveza Rubia', 'Marca B', 200, 3.50, 'Alemania', '2024-01-01', 'Cerveza Artesanal'),
(3, 'Whisky', 'Whisky Escocés', 'Marca C', 50, 45.00, 'Escocia', '2024-01-01', 'Whisky añejado 12 años'),
(6, 'sadda', 'fa', 'dsad', 15, 263.00, 'dsad', '2024-12-07', 'dsad'),
(7, 'dsad', 'dasd', 'dsadas', 5151, 454.00, 'dasd', '2024-12-07', 'asdas'),
(8, 'dasd', 'das', 'dasd', 520, 102.00, 'das', '2024-12-07', 'dsad'),
(9, 'fasf', 'fsaf', 'fsa', 15, 201.00, 'fasf', '2024-12-07', 'fsa'),
(10, 'das', 'dads', 'dfsadfsa', 15, 451.00, 'dsadas', '2024-12-07', 'dsad'),
(11, 'DSAD', 'dsASD', 'SDADASD', 1451, 1021.00, 'DAsd', '2024-12-07', 'DASDA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla pedido
--

CREATE TABLE pedido (
  id_pedido int(11) NOT NULL,
  fecha date DEFAULT curdate(),
  total decimal(10,2) DEFAULT 0.00
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla pedido
--

INSERT INTO pedido (id_pedido, fecha, total) VALUES
(1, '2024-12-06', 0.00),
(2, '2024-12-06', 0.00),
(3, '2024-12-06', 0.00),
(4, '2024-12-06', 0.00),
(5, '2024-12-07', 0.00),
(6, '2024-12-07', 0.00),
(7, '2024-12-07', 0.00),
(8, '2024-12-07', 0.00),
(9, '2024-12-07', 0.00),
(10, '2024-12-07', 6050.00),
(11, '2024-12-07', 0.00),
(12, '2024-12-07', 244.00),
(13, '2024-12-07', 0.00),
(14, '2024-12-07', 0.00),
(15, '2024-12-07', 3100.00),
(16, '2024-12-07', 0.00),
(17, '2024-12-07', 3100.00),
(18, '2024-12-07', 0.00),
(19, '2024-12-07', 4650.00),
(20, '2024-12-07', 6200.00),
(21, '2024-12-07', 700.00),
(22, '2024-12-07', 6200.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla usuarios
--

CREATE TABLE usuarios (
  id int(11) NOT NULL,
  username varchar(50) NOT NULL,
  password varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla usuarios
--

INSERT INTO usuarios (id, username, password) VALUES
(1, 'admin', 'admin123');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla detalle_pedido
--
ALTER TABLE detalle_pedido
  ADD PRIMARY KEY (id_detalle_pedido),
  ADD KEY id_pedido (id_pedido),
  ADD KEY id_licor (id_licor);

--
-- Indices de la tabla licores
--
ALTER TABLE licores
  ADD PRIMARY KEY (id);

--
-- Indices de la tabla pedido
--
ALTER TABLE pedido
  ADD PRIMARY KEY (id_pedido);

--
-- Indices de la tabla usuarios
--
ALTER TABLE usuarios
  ADD PRIMARY KEY (id),
  ADD UNIQUE KEY username (username);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla detalle_pedido
--
ALTER TABLE detalle_pedido
  MODIFY id_detalle_pedido int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla licores
--
ALTER TABLE licores
  MODIFY id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla pedido
--
ALTER TABLE pedido
  MODIFY id_pedido int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla usuarios
--
ALTER TABLE usuarios
  MODIFY id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla detalle_pedido
--
ALTER TABLE detalle_pedido
  ADD CONSTRAINT detalle_pedido_ibfk_1 FOREIGN KEY (id_pedido) REFERENCES pedido (id_pedido) ON DELETE CASCADE,
  ADD CONSTRAINT detalle_pedido_ibfk_2 FOREIGN KEY (id_licor) REFERENCES licores (id) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;