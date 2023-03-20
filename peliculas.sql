-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-03-2023 a las 13:56:00
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `peliculas`
--
CREATE DATABASE IF NOT EXISTS `peliculas` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci;
USE `peliculas`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `id_Genero` int(11) NOT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`id_Genero`, `nombre`) VALUES
(1, 'Drama'),
(2, 'Deportes'),
(3, 'Biográfica'),
(4, 'Épica'),
(5, 'Bélica'),
(6, 'Comedia'),
(7, 'Accion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero_peliculas`
--

CREATE TABLE `genero_peliculas` (
  `id_PeliGenero` int(11) NOT NULL,
  `Peliculas` int(11) DEFAULT NULL,
  `Genero` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `genero_peliculas`
--

INSERT INTO `genero_peliculas` (`id_PeliGenero`, `Peliculas`, `Genero`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 1),
(4, 2, 2),
(5, 2, 3),
(6, 3, 1),
(7, 3, 4),
(8, 3, 5),
(9, 4, 1),
(10, 4, 6),
(11, 5, 6),
(12, 5, 7),
(13, 6, 7),
(14, 7, 7),
(15, 7, 6),
(16, 8, 7),
(17, 8, 6),
(18, 9, 2),
(19, 9, 3),
(20, 10, 1),
(21, 10, 6),
(22, 11, 6),
(23, 12, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas`
--

CREATE TABLE `peliculas` (
  `id_Pelicula` int(11) NOT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `duracion` int(11) DEFAULT NULL,
  `clasificacion` varchar(50) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `director` varchar(20) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `interprete` varchar(50) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `trailer` varchar(50) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `musica` varchar(30) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `año` int(11) DEFAULT NULL,
  `distribuidora` varchar(50) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `comentarios` varchar(150) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `presupuesto` int(11) DEFAULT NULL,
  `imagen` varchar(200) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `valoracion` int(1) DEFAULT NULL,
  `sinopsis` varchar(200) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `pais` varchar(20) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `peliculas`
--

INSERT INTO `peliculas` (`id_Pelicula`, `nombre`, `duracion`, `clasificacion`, `director`, `interprete`, `trailer`, `musica`, `año`, `distribuidora`, `comentarios`, `presupuesto`, `imagen`, `valoracion`, `sinopsis`, `pais`) VALUES
(1, 'CREED III', 116, 'No recomendada para menores de 12 años', ' Michael B. Jordan', ' Michael B. Jordan, Tessa Thompson, Phylicia Rasha', 'https://youtu.be/IeZ5xDv3w6A', 'Joe Shirley', 2023, 'Metro-Goldwyn-Mayer\r\nWarner Bros', 'De lo mejor que vi en años. La calidad de las tomas, los detalles, la música. Todo acorde a cada momento. Te hace sentir como si estuvieras dentro de ', 75, 'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/pu5u25f2enavdf7ojppu3hf7zq-1666108043.jpeg', 3, 'Adonis Creed está prosperando en su carrera y en su vida familiar. Cuando un amigo de la infancia y antiguo prodigio del boxeo reaparece tras cumplir condena en la cárcel, está ansioso por demostrar q', 'Estados Unidos'),
(2, '	El método Williams', 144, 'No recomendado menores de 12 años', 'Reinaldo Marcus Gree', 'Will Smith,Aunjanue Ellis,Saniyya Sidney,Demi Sing', 'https://www.youtube.com/watch?v=b8HNgVtpuV0', 'Kris Bowers', 2021, 'Warner Bros. Pictures', 'Extraordinaria película... con grandiosos valores y la historia es emotiva sin ninguna dificultad. En realidad me encanto la película y el final es sa', 50, 'https://www.lavanguardia.com/peliculas-series/images/movie/poster/2021/11/w1280/p9v8y0f95KG2gxNiNckRQ22AeV7.jpg', 5, 'Richard Williams ayudó a criar a dos de las deportistas más extraordinarias de todos los tiempos, dos atletas que acabarían cambiando para siempre el deporte del tenis. Sirviéndose de métodos poco con', 'Estados Unidos'),
(3, '1917', 119, 'No recomendado menores de 12 años', 'Sam Mendes', 'George MacKay,Dean-Charles Chapman,Benedict Cumber', 'https://www.youtube.com/watch?v=YrbdN5zaouU', 'Thomas Newman', 2019, 'Universal Pictures', 'Tuve el corazón en un puño desde el minuto uno hasta el final con esa trama y esa impresionante BSO que me hacía tener en todo momento los sentimiento', 100, 'https://es.web.img3.acsta.net/pictures/20/01/09/15/10/0234685.jpg', 3, 'La película sigue a dos jóvenes soldados británicos a lo largo de un único día en lo más crudo de la Primera Guerra Mundial.', 'Reino Unido'),
(4, 'Green Book', 130, 'No recomendado menores de 13 años', 'Peter Farrelly', 'Viggo Mortensen,Mahershala Ali,Linda Cardellini', 'https://www.youtube.com/watch?v=eQQp_tXjP2U', 'Kris Bowers', 2018, 'Universal Pictures', 'Excelente película, las actuaciones son estupendas. La dignidad por sobretodo basada en la cultura, aguantando pero también poniendo las cosas en su l', 23, 'https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/I/91PWXIp8FOL._SL1500_.jpg', 4, 'Años 60. Tony Lip, un rudo italoamericano del Bronx, es contratado como chófer del virtuoso pianista negro Don Shirley. Ambos emprenderán un viaje para una gira de conciertos por el Sur de Estados Uni', 'Estados Unidos'),
(5, 'Uncharted', 116, 'No recomendado menores de 13 años', 'Ruben Fleischer', 'Tom Holland,Mark Wahlberg,Sophia Ali', 'https://www.youtube.com/watch?v=62bKO3LP6HA', 'Ramin Djawadi', 2022, 'Sony Pictures Releasing', 'Es una peli bastante entretenida y personalmente la considero como otra de las mejores adaptaciones de videojuegos. Si bien, la historia tiene cambios', 120, 'https://www.lahiguera.net/cinemania/pelicula/9741/uncharted-cartel-10299p.jpg', 5, 'Nathan Drake y su compañero Victor Sullivan se adentran en la peligrosa búsqueda del \"mayor tesoro jamás encontrado\". Al mismo tiempo, rastrean pistas que puedan conducir al hermano perdido de Drake.', 'Estados Unidos'),
(6, 'Objetivo: Washington', 121, 'No recomendado menores de 16 años', 'Ric Roman Waugh', 'Gerard Butler,Morgan Freeman,Danny Huston', 'https://www.youtube.com/watch?v=isVtXH7n9lI', 'David Buckley', 2019, 'Lionsgate Films', 'Muy buena película. Interesante y te atrapa. Aunque hay gente que siempre critica todo y no sabe ver el lado positivo de las cosas, esta película está', 40, 'https://es.web.img3.acsta.net/pictures/19/07/30/11/37/2253538.jpg', 3, 'Tras unos acontecimientos del pasado, el agente Mike Banning es acusado de tratar de asesinar al presidente de los Estados Unidos. Sin embargo Banning consigue escapar de su agencia y del FBI, y se ve', 'Estados Unidos'),
(7, 'The Kings Man: La pr', 131, 'Película no recomendada a menores de 16 años', 'Matthew Vaughn', 'Daniel Brühl,Rhys Ifans,Matthew Goode', 'https://www.youtube.com/watch?v=57-NJbPxFdU', 'Henry Jackman', 2021, 'Walt Disney Studios Motion Pictures', 'Para mi es mucho mejor q las otras 2, explican muy bien su origen y como se da la sutiliza de las acciones ya que es una organización secreta. Los rec', 100, 'https://cdn.sortiraparis.com/images/80/69688/569647-the-king-s-man-premiere-mission-bandes-annonces-et-nouvelle-date-de-sortie.jpg', 3, 'Un grupo formado por los tiranos y las mentes criminales más malvadas de la historia se une para desencadenar una guerra que matará a millones de personas. Un hombre tendrá que luchar contra reloj par', 'Reino Unido'),
(8, 'Spider-Man: No Way H', 148, 'Recomendada para mayores de 13 años', 'Jon Watts', 'Tom Holland,Zendaya,Benedict Cumberbatch', 'https://www.youtube.com/watch?v=SkmRT3M4Vx4', 'Michael Giacchino', 2021, 'Sony Pictures Releasing', 'UNA PURA MARAVILLA Realmente una pasada total, ha sido alucinante, ya no se hacen películas de superhéroes como esta. Todos sabíamos que el final de F', 200, 'https://www.ecartelera.com/carteles/15800/15882/005_m.jpg', 4, 'Esta versión extendida cuenta con más de 11 minutos contenido extra, incluyendo escenas eliminadas.Por primera vez en la historia cinematográfica de Spider-Man, nuestro héroe, vecino y amigo es desenm', 'Estados Unidos'),
(9, 'American Underdog', 112, 'Recomendada para Todos los Publicos', 'Jon Erwin', 'Zachary Levi,Anna Paquin,Dennis Quaid', 'https://www.youtube.com/watch?v=_6rn-6lKBJ8', 'John Debney', 2021, 'Lionsgate Films', 'Maravillosa y esperanzadora. Necesitas tener el corazón muy duro para no conmoverte. Ligera al mismo tiempo, fácil de digerir. No hay que pedirle arte', 25, 'https://lionsgate.brightspotcdn.com/24/f3/73928fc04b2585292f075821d66b/american-underdog-shareimage-nowavailable.jpg', 4, 'Basado en la inspiradora historia real de Kurt Warner, quien pasó de abastecer los estantes de un supermercado a convertirse en dos veces MVP de la NFL, campeón del Super Bowl y quarterback del Salón ', 'Estados Unidos'),
(10, 'Campeones', 124, 'Recomendada para Todos los Publicos', 'Javier Fesser', 'Javier Gutiérrez,Juan Margallo,Jesús Vidal', 'https://www.youtube.com/watch?v=a3e0hWT09YY', 'Rafael Arnau', 2018, 'Universal Pictures España', 'Es una película hermosa, con toques de comedia que ayudan a evitar el aburrimiento o monotonía del argumento lineal en ciertas partes. Ayuda mucho a e', 4, 'https://s2.ppllstatics.com/larioja/www/multimedia/201812/27/media/cortadas/campeones-khHE-U7087378160wQC-624x600@La%20Rioja.jpg', 5, 'Marcos es el segundo entrenador de un equipo de baloncesto profesional. Tras una trifulca, Marcos es despedido y obligado a cumplir 90 días de trabajos sociales entrenando a un equipo de personas con ', 'España'),
(11, 'Free Guy', 115, 'No recomendada para menores de 13 años', 'Shawn Levy', 'Ryan Reynolds,Jodie Comer,Lil Rel Howery', 'https://www.youtube.com/watch?v=4y4bEdfqfSM', 'Christophe Beck', 2021, '20th Century Studios', 'Me acabo de ver la película y wow, es bastante buena. La comedia con ese toque de acción y romanticismo es excelente. Es bastante entretenida aunque u', 100, 'https://es.web.img3.acsta.net/pictures/21/06/14/11/47/2960546.jpg', 5, 'Un cajero de un banco descubre que en realidad es un personaje sin papel dentro de un brutal videojuego de mundo interactivo.', 'Estados Unidos'),
(12, 'Resacón en Las Vegas', 100, 'No recomendada para menores de 18 años', 'Todd Phillips', 'Bradley Cooper,Ed Helms,Zach Galifianakis', 'https://www.youtube.com/watch?v=tcdUhdOlz9M', 'Christophe Beck', 2009, 'Warner Bros.', 'Si lo que buscas es una buena película de Comedia sin todos los elementos básicos que la distinguen de muchas otros filmes de comedia no dudes en verl', 35, 'https://www.lavanguardia.com/peliculas-series/images/movie/poster/2009/6/w1280/rqeim09TdaflSvPNVnCTBjUHlKu.jpg', 5, 'Cuatro amigos celebran la despedida de soltero de uno de ellos en Las Vegas. Pero, cuando a la mañana siguiente no pueden encontrar al novio y no recuerdan nada, deberán intentar volver sobre sus paso', 'Estados Unidos');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`id_Genero`);

--
-- Indices de la tabla `genero_peliculas`
--
ALTER TABLE `genero_peliculas`
  ADD PRIMARY KEY (`id_PeliGenero`),
  ADD KEY `FK_genero` (`Genero`),
  ADD KEY `FK_peliculas` (`Peliculas`);

--
-- Indices de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD PRIMARY KEY (`id_Pelicula`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `genero`
--
ALTER TABLE `genero`
  MODIFY `id_Genero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `genero_peliculas`
--
ALTER TABLE `genero_peliculas`
  MODIFY `id_PeliGenero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  MODIFY `id_Pelicula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `genero_peliculas`
--
ALTER TABLE `genero_peliculas`
  ADD CONSTRAINT `FK_genero` FOREIGN KEY (`Genero`) REFERENCES `genero` (`id_Genero`),
  ADD CONSTRAINT `FK_peliculas` FOREIGN KEY (`Peliculas`) REFERENCES `peliculas` (`id_Pelicula`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
