-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3309
-- Час створення: Лют 21 2019 р., 14:25
-- Версія сервера: 5.7.24
-- Версія PHP: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База даних: `stomat`
--

-- --------------------------------------------------------

--
-- Структура таблиці `appointment`
--

DROP TABLE IF EXISTS `appointment`;
CREATE TABLE IF NOT EXISTS `appointment` (
  `appointment_id` int(24) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `price` int(128) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `client_id` int(11) NOT NULL,
  PRIMARY KEY (`appointment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Дамп даних таблиці `appointment`
--

INSERT INTO `appointment` (`appointment_id`, `name`, `price`, `date`, `client_id`) VALUES
(1, 'asd', 123, NULL, 0),
(2, 'asd', 123, NULL, 0);

-- --------------------------------------------------------

--
-- Структура таблиці `author`
--

DROP TABLE IF EXISTS `author`;
CREATE TABLE IF NOT EXISTS `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` int(128) DEFAULT NULL,
  `email` int(128) DEFAULT NULL,
  `country` int(128) DEFAULT NULL,
  `books` int(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблиці `author_books`
--

DROP TABLE IF EXISTS `author_books`;
CREATE TABLE IF NOT EXISTS `author_books` (
  `author_id` int(128) DEFAULT NULL,
  `book_id` int(128) DEFAULT NULL,
  KEY `FKfvabqdr9njwv4khjqkf1pbmma` (`author_id`),
  KEY `FKgg8l7xyje2rjham3sgxfk2dxm` (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблиці `book`
--

DROP TABLE IF EXISTS `book`;
CREATE TABLE IF NOT EXISTS `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `price` int(64) DEFAULT NULL,
  `description` varchar(64) DEFAULT NULL,
  `yearOfPublication` timestamp NULL DEFAULT NULL,
  `addedBy` int(64) NOT NULL,
  `author_id` int(64) NOT NULL,
  `readerid` int(64) NOT NULL,
  `added_by` int(11) NOT NULL,
  `year_of_publication` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблиці `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `client_id` int(24) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(128) DEFAULT NULL,
  `second_name` varchar(128) DEFAULT NULL,
  `third_name` varchar(128) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `phone` varchar(256) DEFAULT NULL,
  `sex` varchar(128) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `total_earn` int(255) DEFAULT NULL,
  `appointment_id` int(24) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

--
-- Дамп даних таблиці `client`
--

INSERT INTO `client` (`client_id`, `first_name`, `second_name`, `third_name`, `email`, `phone`, `sex`, `date_of_birth`, `total_earn`, `appointment_id`) VALUES
(4, 'admin', 'admin', 'admin', 'admin', 'admin', 'male', '2017-10-12', NULL, NULL),
(5, '', 'admin', 'admin', 'admin', '+380506149006', 'male', '2019-02-13', NULL, NULL),
(6, 'admin', 'admin', 'admin', 'admin', '+380506149006', 'male', '2019-02-13', NULL, NULL),
(7, 'admin', 'admin', 'admin', 'admin', '+380506149006', 'male', '2019-02-13', NULL, NULL),
(9, 'asd', 'asd', 'asd', '', '+380506149006', 'male', '2019-02-14', NULL, NULL),
(10, 'admin', 'admin', 'admin', 'admin@asdc.com', 'admin', 'male', '2019-02-14', NULL, NULL),
(11, 'asd', 'asd', 'asd', 'admin@asdc.com', '+380506149006', 'male', '2019-02-14', NULL, NULL),
(12, 'admin', 'admin', 'admin', 'mozgoowisp@gmail.com', '+380506149006', 'male', '2019-02-13', NULL, NULL),
(13, 'asd', 'asd', 'admin', 'mozgoowisp@gmail.com', '+380506149006', 'male', '2019-02-14', NULL, NULL),
(14, 'asd', 'asd', 'admin', 'mozgoowisp@gmail.com', '+380506149006', 'male', '2019-02-14', NULL, NULL),
(15, 'asd', 'asd', 'admin', 'mozgoowisp@gmail.com', '+380506149006', 'male', '2019-02-14', NULL, NULL),
(16, 'admin', 'admin', 'admin', 'mozgoowisp@gmail.com', '+380506149006', 'male', '2019-02-13', NULL, NULL),
(17, 'admin', 'admin', 'admin', 'admin@asdc.com', '+380506149006', 'male', '2019-02-13', NULL, NULL),
(18, 'admin', 'admin', 'admin', 'admin@asdc.com', '+380506149006', 'male', '2019-02-13', NULL, NULL),
(19, 'admin', 'admin', 'admin', 'mozgoowisp@gmail.com', 'admin', 'male', '2019-02-12', NULL, NULL),
(20, 'admin', 'admin', 'admin', 'mozgoowisp@gmail.com', 'admin', 'male', '2019-02-12', NULL, NULL),
(21, 'asd', 'admin', 'asd', 'mozgoowisp@gmail.com', '+380506149006', 'male', '2019-02-11', NULL, NULL),
(22, 'asd', 'admin', 'asd', 'mozgoowisp@gmail.com', '+380506149006', 'male', '2019-02-11', NULL, NULL),
(23, 'asd', 'asd', 'asd', 'asd@gmail.com', 'admin', 'male', '2019-02-13', NULL, NULL),
(24, 'admin', 'admin', 'admin', 'mozgoowisp@gmail.com', '+380506149006', 'male', '2019-02-12', NULL, NULL),
(25, '?????', '?????', '??????????', 'betskoroman95@gmail.com', '+380973229491', 'male', '2019-02-12', NULL, NULL),
(26, '???', '???', '???', 'mozgoowisp@gmail.com', '+380506149006', 'male', '2019-02-12', NULL, NULL),
(28, 'вапвапвап', 'вапвапв', 'авпвапвап', 'mozgoowisp@gmail.com', '+380506149006', 'male', '2019-02-20', NULL, NULL),
(29, 'Бецко', 'Роман', 'Михайлович', 'betskoroman95@gmail.com', '+380973229491', 'male', '1995-12-28', NULL, NULL),
(30, 'Бецко', 'Назар', 'Михайлович', 'asdasd@betsko.com', '+3123123', 'male', '1991-12-04', NULL, NULL),
(31, 'asd', 'asd', 'asd', 'asd', '+380506149006', 'female', '2011-02-06', NULL, NULL),
(32, 'asd', 'asd', 'asd', 'asd@gmail.com', '+380506149006', 'female', '2011-02-06', NULL, NULL),
(33, 'admin', 'admin', 'admin', 'mozgoowisp@gmail.com', '+380506149006', 'male', '2019-02-18', NULL, NULL),
(34, 'asd', 'asd', 'asd', 'mozgoowisp@gmail.com', '+380506149006', 'male', '2019-02-18', NULL, NULL),
(35, 'asd', 'asd', 'admin', 'mozgoowisp@gmail.com', '+380506149006', 'male', '2019-02-12', NULL, NULL);

-- --------------------------------------------------------

--
-- Структура таблиці `client_appointments`
--

DROP TABLE IF EXISTS `client_appointments`;
CREATE TABLE IF NOT EXISTS `client_appointments` (
  `client_id` int(11) NOT NULL,
  `appointment_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп даних таблиці `client_appointments`
--

INSERT INTO `client_appointments` (`client_id`, `appointment_id`) VALUES
(0, 0),
(0, 0);

-- --------------------------------------------------------

--
-- Структура таблиці `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(128) DEFAULT NULL,
  `secondName` varchar(128) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `first_name` varchar(255) NOT NULL,
  `second_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблиці `orderbooks`
--

DROP TABLE IF EXISTS `orderbooks`;
CREATE TABLE IF NOT EXISTS `orderbooks` (
  `readerid` int(128) DEFAULT NULL,
  `bookid` int(128) DEFAULT NULL,
  `book_id` int(11) NOT NULL,
  `reader_id` int(11) NOT NULL,
  KEY `FK8ke2a3uvysp2k1b2teg70t1je` (`reader_id`),
  KEY `FKsyjguoe2qip46di9ibatnbagu` (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблиці `procedureCriteria`
--

DROP TABLE IF EXISTS `procedureCriteria`;
CREATE TABLE IF NOT EXISTS `procedureCriteria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `price` int(128) DEFAULT NULL,
  `appointments` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблиці `reader`
--

DROP TABLE IF EXISTS `reader`;
CREATE TABLE IF NOT EXISTS `reader` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Обмеження зовнішнього ключа збережених таблиць
--

--
-- Обмеження зовнішнього ключа таблиці `author_books`
--
ALTER TABLE `author_books`
  ADD CONSTRAINT `FKfvabqdr9njwv4khjqkf1pbmma` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
  ADD CONSTRAINT `FKgg8l7xyje2rjham3sgxfk2dxm` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`);

--
-- Обмеження зовнішнього ключа таблиці `orderbooks`
--
ALTER TABLE `orderbooks`
  ADD CONSTRAINT `FK8ke2a3uvysp2k1b2teg70t1je` FOREIGN KEY (`reader_id`) REFERENCES `reader` (`id`),
  ADD CONSTRAINT `FKsyjguoe2qip46di9ibatnbagu` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
