-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Май 12 2015 г., 17:59
-- Версия сервера: 5.6.21
-- Версия PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `letters`
--

-- --------------------------------------------------------

--
-- Структура таблицы `letterstbl`
--

CREATE TABLE IF NOT EXISTS `letterstbl` (
`letterID` int(10) NOT NULL,
  `senderID` int(10) NOT NULL,
  `recieverID` int(10) NOT NULL,
  `subject` varchar(20) NOT NULL,
  `text` text NOT NULL,
  `sendDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `peopletbl`
--

CREATE TABLE IF NOT EXISTS `peopletbl` (
  `humanID` int(10) NOT NULL DEFAULT '1',
  `hName` varchar(10) NOT NULL,
  `hSurname` varchar(15) NOT NULL,
  `hFatherName` varchar(10) NOT NULL,
  `birthDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `letterstbl`
--
ALTER TABLE `letterstbl`
 ADD PRIMARY KEY (`letterID`);

--
-- Индексы таблицы `peopletbl`
--
ALTER TABLE `peopletbl`
 ADD PRIMARY KEY (`humanID`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `letterstbl`
--
ALTER TABLE `letterstbl`
MODIFY `letterID` int(10) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
