-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 31, 2015 at 11:05 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tim11`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `password` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_l953a6gqywk74n4ln40oom01l` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`password`, `username`, `id`) VALUES
('pass', 'admin', 8);

-- --------------------------------------------------------

--
-- Table structure for table `firma`
--

CREATE TABLE IF NOT EXISTS `firma` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `sjediste` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci AUTO_INCREMENT=5 ;

--
-- Dumping data for table `firma`
--

INSERT INTO `firma` (`id`, `ime`, `sjediste`) VALUES
(4, 'Temp', 'Temp');

-- --------------------------------------------------------

--
-- Table structure for table `operater`
--

CREATE TABLE IF NOT EXISTS `operater` (
  `password` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `privilegije` bit(1) NOT NULL,
  `username` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `firma` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_rc0yttrli0uxspggcglmrf5r5` (`username`),
  KEY `FK_t8adddr7odin9o04je3fpuhw5` (`firma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Dumping data for table `operater`
--

INSERT INTO `operater` (`password`, `privilegije`, `username`, `id`, `firma`) VALUES
('pass', b'1', 'operater', 9, 4),
('pass2', b'0', 'operater2', 10, 4);

-- --------------------------------------------------------

--
-- Table structure for table `osoba`
--

CREATE TABLE IF NOT EXISTS `osoba` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adresa` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `datumZaposlenja` datetime DEFAULT NULL,
  `ime` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `jmbg` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `pozicija` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `prezime` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `telefon` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci AUTO_INCREMENT=16 ;

--
-- Dumping data for table `osoba`
--

INSERT INTO `osoba` (`id`, `adresa`, `datumZaposlenja`, `ime`, `jmbg`, `pozicija`, `prezime`, `telefon`) VALUES
(8, 'Dolina 15', '2015-05-31 10:50:32', 'Temp', '1505991170272', 'administrator', 'Tempi?', '+38761566311'),
(9, 'Dolina 15', '2015-05-31 10:50:32', 'Temp', '1505991170272', 'operater', 'Tempi?', '+38761566311'),
(10, 'Dalmatinska 11', '2015-05-31 10:50:32', 'Bez', '1010993178690', 'operater bez permisija', 'Permisija', '+38733444865'),
(11, 'Dolina 15', '2015-05-31 10:50:32', 'Temp', '1505991170272', 'zaposlenik', 'Tempi?', '+38761566311'),
(12, 'Džamijska 4', '2015-05-31 10:50:40', 'Testev', '1502994190023', 'Baja', 'Testevorovski', '+38761508633'),
(13, 'test 13', '2015-05-31 10:55:39', 'test', '1502994190023', 'baja', 'test', '+38761508633'),
(14, 'Adresa', '2015-05-31 10:58:43', 'Proba', '1502994190023', 'baja', 'Probovic', '+38761508633'),
(15, 'Moaadresa', '2015-05-31 11:03:33', 'Maja', '1502994190023', 'Baja', 'Baja', '+38761508633');

-- --------------------------------------------------------

--
-- Table structure for table `plata`
--

CREATE TABLE IF NOT EXISTS `plata` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bolovanje` int(11) NOT NULL,
  `brojRadnihDana` int(11) NOT NULL,
  `datum` datetime DEFAULT NULL,
  `godineStaza` int(11) NOT NULL,
  `godisnjiOdmor` int(11) NOT NULL,
  `nocniRad` double NOT NULL,
  `prazniciRad` int(11) NOT NULL,
  `stvarniRad` int(11) NOT NULL,
  `zaposlenik` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_22cdjx263xy05ntuj5g6w42ep` (`zaposlenik`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci AUTO_INCREMENT=2 ;

--
-- Dumping data for table `plata`
--

INSERT INTO `plata` (`id`, `bolovanje`, `brojRadnihDana`, `datum`, `godineStaza`, `godisnjiOdmor`, `nocniRad`, `prazniciRad`, `stvarniRad`, `zaposlenik`) VALUES
(1, 1, 4, '2015-05-31 10:50:32', 0, 1, 0, 0, 1, 11);

-- --------------------------------------------------------

--
-- Table structure for table `zaposlenik`
--

CREATE TABLE IF NOT EXISTS `zaposlenik` (
  `dnevniTopliObrok` double NOT NULL,
  `faktor` double NOT NULL,
  `koeficijent` double NOT NULL,
  `osnovica` double NOT NULL,
  `id` bigint(20) NOT NULL,
  `firma` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_q5hd53a0uum7lie2suxkr4cpw` (`firma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Dumping data for table `zaposlenik`
--

INSERT INTO `zaposlenik` (`dnevniTopliObrok`, `faktor`, `koeficijent`, `osnovica`, `id`, `firma`) VALUES
(1, 1, 1, 1, 11, 4),
(1, 1, 1, 1, 12, 4),
(1, 1, 1, 1, 13, 4),
(1, 1, 1, 1, 14, 4),
(1, 1, 1, 1, 15, 4);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `FK_as1rmx4ofyhjguia6ccyf1enx` FOREIGN KEY (`id`) REFERENCES `osoba` (`id`);

--
-- Constraints for table `operater`
--
ALTER TABLE `operater`
  ADD CONSTRAINT `FK_cug3pernmcc532wk6ojsa39jw` FOREIGN KEY (`id`) REFERENCES `osoba` (`id`),
  ADD CONSTRAINT `FK_t8adddr7odin9o04je3fpuhw5` FOREIGN KEY (`firma`) REFERENCES `firma` (`id`);

--
-- Constraints for table `plata`
--
ALTER TABLE `plata`
  ADD CONSTRAINT `FK_22cdjx263xy05ntuj5g6w42ep` FOREIGN KEY (`zaposlenik`) REFERENCES `zaposlenik` (`id`);

--
-- Constraints for table `zaposlenik`
--
ALTER TABLE `zaposlenik`
  ADD CONSTRAINT `FK_mfvnir6nogi567y3ce88ssf4a` FOREIGN KEY (`id`) REFERENCES `osoba` (`id`),
  ADD CONSTRAINT `FK_q5hd53a0uum7lie2suxkr4cpw` FOREIGN KEY (`firma`) REFERENCES `firma` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
