-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Май 13 2015 г., 16:42
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `letterstbl`
--

INSERT INTO `letterstbl` (`letterID`, `senderID`, `recieverID`, `subject`, `text`, `sendDate`) VALUES
(1, 1, 2, 'subject1', 'askdhakllghskdjfgaksldfkjadfgdjfkg', '3893-09-23'),
(2, 1, 3, 'subject1', 'askdhakllghskdjfgaksldfkjadfgdjfkg22', '3893-09-23'),
(3, 1, 6, 'subject1', 'askdhakll', '3893-09-23'),
(4, 1, 6, 'subject1', 'askdhakll', '3893-09-23'),
(5, 1, 6, 'subject1', 'askdhakll', '3893-09-23'),
(6, 3, 6, 'subject1', 'askdhakll', '3893-09-23');

-- --------------------------------------------------------

--
-- Структура таблицы `peopletbl`
--

CREATE TABLE IF NOT EXISTS `peopletbl` (
`humanID` int(10) NOT NULL,
  `hName` varchar(10) NOT NULL,
  `hSurname` varchar(15) NOT NULL,
  `hFatherName` varchar(10) NOT NULL,
  `birthDate` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `peopletbl`
--

INSERT INTO `peopletbl` (`humanID`, `hName`, `hSurname`, `hFatherName`, `birthDate`) VALUES
(2, 'Vasya', 'Vaskin', 'Antonovich', '3893-09-23'),
(3, 'Kolya', 'Kolin', 'Vasevich', '3893-09-23'),
(4, 'Vasya', 'Vaskin', 'Antonovich', '3893-09-23'),
(5, 'Kolya', 'Kolin', 'Vasevich', '3893-09-23'),
(6, 'Vasya', 'Vaskin', 'Antonovich', '3893-09-23'),
(7, 'Kolya', 'Kolin', 'Vasevich', '3893-09-23'),
(8, 'Vasya', 'Vaskin', 'Antonovich', '3893-09-23'),
(9, 'Kolya', 'Kolin', 'Vasevich', '3893-09-23');

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
MODIFY `letterID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT для таблицы `peopletbl`
--
ALTER TABLE `peopletbl`
MODIFY `humanID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
