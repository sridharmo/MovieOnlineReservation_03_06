-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.26-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for movieonlinereservation
CREATE DATABASE IF NOT EXISTS `movieonlinereservation` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `movieonlinereservation`;


-- Dumping structure for table movieonlinereservation.movie_list
CREATE TABLE IF NOT EXISTS `movie_list` (
  `movieDate` date DEFAULT NULL,
  `movieID` int(4) NOT NULL AUTO_INCREMENT,
  `movieName` varchar(32) DEFAULT NULL,
  `movieTimeID` int(4) DEFAULT NULL,
  `Show1` int(4) DEFAULT NULL,
  `Show2` int(4) DEFAULT NULL,
  `Show3` int(4) unsigned DEFAULT NULL,
  PRIMARY KEY (`movieID`),
  KEY `FK_movie_list_timeinfo` (`movieTimeID`),
  CONSTRAINT `FK_movie_list_timeinfo` FOREIGN KEY (`movieTimeID`) REFERENCES `timeinfo` (`TimeID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table movieonlinereservation.movie_list: ~5 rows (approximately)
/*!40000 ALTER TABLE `movie_list` DISABLE KEYS */;
INSERT INTO `movie_list` (`movieDate`, `movieID`, `movieName`, `movieTimeID`, `Show1`, `Show2`, `Show3`) VALUES
	('2016-02-20', 1, 'Admiral YI', 1, NULL, NULL, NULL),
	('2016-02-20', 2, 'IP Man', 1, NULL, NULL, NULL),
	('2016-02-20', 3, 'Good Bad , Ugly', 1, NULL, NULL, NULL),
	('2016-02-20', 4, 'Toy story', 1, NULL, NULL, NULL),
	('2016-01-20', 5, 'Happy Days', 1, NULL, NULL, NULL);
/*!40000 ALTER TABLE `movie_list` ENABLE KEYS */;


-- Dumping structure for table movieonlinereservation.purchaseinfo
CREATE TABLE IF NOT EXISTS `purchaseinfo` (
  `PurchaseID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11),
  `MovieID` int(11) DEFAULT NULL,
  `NumberOfTickets` int(11) DEFAULT NULL,
  `TimeID` int(11) DEFAULT NULL,
  `TransactionStatus` int(11) DEFAULT NULL,
  `MailSend` int(11) DEFAULT NULL,
  PRIMARY KEY (`PurchaseID`),
  KEY `UserID` (`UserID`),
  KEY `MovieID` (`MovieID`),
  KEY `TimeID` (`TimeID`),
  CONSTRAINT `FK_purchaseinfo_movie_list` FOREIGN KEY (`MovieID`) REFERENCES `movie_list` (`movieID`),
  CONSTRAINT `FK_purchaseinfo_timeinfo1` FOREIGN KEY (`TimeID`) REFERENCES `timeinfo1` (`TimeID`),
  CONSTRAINT `FK_purchaseinfo_userinfo` FOREIGN KEY (`UserID`) REFERENCES `userinfo` (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table movieonlinereservation.purchaseinfo: ~0 rows (approximately)
/*!40000 ALTER TABLE `purchaseinfo` DISABLE KEYS */;
INSERT INTO `purchaseinfo` (`PurchaseID`, `UserID`, `MovieID`, `NumberOfTickets`, `TimeID`, `TransactionStatus`, `MailSend`) VALUES
	(1, 1, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `purchaseinfo` ENABLE KEYS */;


-- Dumping structure for table movieonlinereservation.timeinfo1
CREATE TABLE IF NOT EXISTS `timeinfo1` (
  `TimeID` int(11) NOT NULL AUTO_INCREMENT,
  `MovieTime` time DEFAULT NULL,
  `UpdatedBy` int(11) DEFAULT NULL,
  `CreatedBy` int(11) DEFAULT NULL,
  `CreatedDate` date DEFAULT NULL,
  `DeleteDate` date DEFAULT NULL,
  `RecordStatus` varchar(50) DEFAULT 'ACTIVE',
  PRIMARY KEY (`TimeID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table movieonlinereservation.timeinfo1: ~1 rows (approximately)
/*!40000 ALTER TABLE `timeinfo1` DISABLE KEYS */;
INSERT INTO `timeinfo1` (`TimeID`, `MovieTime`, `UpdatedBy`, `CreatedBy`, `CreatedDate`, `DeleteDate`, `RecordStatus`) VALUES
	(1, '15:39:24', NULL, NULL, NULL, NULL, 'ACTIVE');
/*!40000 ALTER TABLE `timeinfo1` ENABLE KEYS */;


-- Dumping structure for table movieonlinereservation.userinfo
CREATE TABLE IF NOT EXISTS `userinfo` (
  `UserID` int(11) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `SaveCardInfo` varchar(50) DEFAULT '',
  `CreditCardNumber` int(11) NOT NULL,
  `ExpirationMonth` int(11) NOT NULL,
  `ExpirationYear` int(11) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `ZipCode` int(11) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table movieonlinereservation.userinfo: ~2 rows (approximately)
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` (`UserID`, `Email`, `Password`, `SaveCardInfo`, `CreditCardNumber`, `ExpirationMonth`, `ExpirationYear`, `FirstName`, `LastName`, `ZipCode`) VALUES
	(1, 'sridhar_mo@yahoo.com', 'Welcome', NULL, 2222222, 0, 0, 'sri', 'mo', 0),
	(2, 'sridhar_mo@yahoo.com', 'welcome', NULL, 1234567, 0, 0, 'sr', 'mo', 0);
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
