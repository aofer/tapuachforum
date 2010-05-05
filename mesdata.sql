-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- מארח: localhost
-- זמן ייצור: מאי 05, 2010 at 11:32 AM
-- גרסת שרת: 5.1.41
-- גרסת PHP: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- מאגר נתונים: `mesdata`
--

-- --------------------------------------------------------

--
-- מבנה טבלה עבור טבלה `foruminfo`
--

CREATE TABLE IF NOT EXISTS `foruminfo` (
  `name` varchar(20) NOT NULL,
  `numOfMessages` int(11) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- הוצאת מידע עבור טבלה `foruminfo`
--

INSERT INTO `foruminfo` (`name`, `numOfMessages`) VALUES
('Tapuach', 2);

-- --------------------------------------------------------

--
-- מבנה טבלה עבור טבלה `members`
--

CREATE TABLE IF NOT EXISTS `members` (
  `UserName` varchar(14) NOT NULL,
  `FirstName` varchar(14) NOT NULL,
  `LastName` varchar(14) NOT NULL,
  `Password` varchar(128) NOT NULL,
  `DataOfBirth` date NOT NULL,
  `NickName` varchar(14) NOT NULL,
  `DateOfJoin` date NOT NULL,
  `Email` varchar(25) NOT NULL,
  `isAdmin` bit(1) NOT NULL,
  `isModerator` bit(1) NOT NULL,
  `isLogin` bit(1) NOT NULL,
  PRIMARY KEY (`UserName`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- הוצאת מידע עבור טבלה `members`
--

INSERT INTO `members` (`UserName`, `FirstName`, `LastName`, `Password`, `DataOfBirth`, `NickName`, `DateOfJoin`, `Email`, `isAdmin`, `isModerator`, `isLogin`) VALUES
('userToCheck2', 'alex', 'iscoll', 'PaSSword', '2010-05-05', 'nowOut', '2010-05-05', '3@sd', b'0', b'0', b'0'),
('alexSup', 'alex', 'iscoll', 'edfr', '2010-05-05', 'superman', '2010-05-05', '3@sd', b'0', b'1', b'0');

-- --------------------------------------------------------

--
-- מבנה טבלה עבור טבלה `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `number` int(11) NOT NULL,
  `title` varchar(250) NOT NULL,
  `body` varchar(250) NOT NULL,
  `Author` varchar(14) NOT NULL,
  `IdFather` int(11) NOT NULL,
  `DateOfAdd` date NOT NULL,
  `DateOfEdit` date NOT NULL,
  PRIMARY KEY (`number`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- הוצאת מידע עבור טבלה `message`
--

INSERT INTO `message` (`number`, `title`, `body`, `Author`, `IdFather`, `DateOfAdd`, `DateOfEdit`) VALUES
(1, 'where is bob', 'working', 'alex', 0, '2010-05-05', '2010-05-05');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
