-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3309
-- Час створення: Бер 09 2019 р., 10:12
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
  `date_from` timestamp NULL DEFAULT NULL,
  `date_to` timestamp NULL DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `client_id` int(11) NOT NULL,
  `procedure_id` int(128) NOT NULL,
  PRIMARY KEY (`appointment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Дамп даних таблиці `appointment`
--

INSERT INTO `appointment` (`appointment_id`, `name`, `price`, `date_from`, `date_to`, `description`, `client_id`, `procedure_id`) VALUES
(10, 'Тест Аппойнтмент', 300, '2019-06-04 09:30:00', '2019-06-04 10:30:00', 'Якийсь там опис', 36, 0),
(11, 'Ще одна зустріч', 25, '2019-06-22 06:00:00', '2019-06-22 08:00:00', 'щось там поробив', 36, 0),
(12, 'asd', 123, '2019-06-02 21:00:00', '2019-06-02 21:00:00', 'asd', 40, 0),
(13, 'fjdjh', 1432, '2019-06-04 06:00:00', '2019-06-04 07:00:00', 'dfasdf', 36, 0),
(14, 'asd', 123, '2019-06-02 21:00:00', '2019-06-03 09:00:00', 'asd', 4, 0);

-- --------------------------------------------------------

--
-- Структура таблиці `appointment_procedure`
--

DROP TABLE IF EXISTS `appointment_procedure`;
CREATE TABLE IF NOT EXISTS `appointment_procedure` (
  `appointment_id` int(11) NOT NULL,
  `procedure_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

--
-- Дамп даних таблиці `client`
--

INSERT INTO `client` (`client_id`, `first_name`, `second_name`, `third_name`, `email`, `phone`, `sex`, `date_of_birth`, `total_earn`, `appointment_id`) VALUES
(4, 'admin', 'admin', 'admin', 'admin', 'admin', 'male', '2017-10-12', NULL, NULL),
(36, 'Юлія', 'Васурчак', 'Олегівна', 'vasurchak@gmail.com', '+380506149006', 'female', '1996-12-16', NULL, NULL),
(40, 'Роман', 'Бецко', 'Михайлович', 'betskoroman95@gmail.com', '+380973229491', 'male', '1995-12-28', NULL, NULL),
(41, 'Назар', 'Бецко', 'Михайлович', 'admin@asdc.com', '+380506149006', 'male', '1991-12-04', NULL, NULL),
(43, 'Іван', 'Іванов', 'Іванович', 'ivanov@gmail.com', '+380973229491', 'male', '1993-07-23', NULL, NULL);

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
-- Структура таблиці `procedure`
--

DROP TABLE IF EXISTS `procedure`;
CREATE TABLE IF NOT EXISTS `procedure` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `price` int(128) DEFAULT NULL,
  `appointment_id` int(11) DEFAULT NULL,
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
