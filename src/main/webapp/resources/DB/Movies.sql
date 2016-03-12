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
  `movieDate` varchar(50) DEFAULT NULL,
  `movieID` int(4) NOT NULL AUTO_INCREMENT,
  `PriceID` int(4) DEFAULT NULL,
  `movieName` varchar(32) DEFAULT NULL,
  `Show1` int(4) DEFAULT NULL,
  `Show2` int(4) DEFAULT NULL,
  `Show3` int(4) DEFAULT NULL,
  `MovieDuration` int(4) DEFAULT NULL,
  PRIMARY KEY (`movieID`),
  KEY `FK_movie_list_timeinfo1` (`Show1`),
  KEY `FK_movie_list_timeinfo1_2` (`Show2`),
  KEY `Show3` (`Show3`),
  CONSTRAINT `FK_movie_list_timeinfo1` FOREIGN KEY (`Show1`) REFERENCES `timeinfo1` (`TimeID`),
  CONSTRAINT `FK_movie_list_timeinfo1_2` FOREIGN KEY (`Show2`) REFERENCES `timeinfo1` (`TimeID`),
  CONSTRAINT `FK_movie_list_timeinfo1_3` FOREIGN KEY (`Show3`) REFERENCES `timeinfo1` (`TimeID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table movieonlinereservation.movie_list: ~5 rows (approximately)
/*!40000 ALTER TABLE `movie_list` DISABLE KEYS */;
INSERT INTO `movie_list` (`movieDate`, `movieID`, `PriceID`, `movieName`, `Show1`, `Show2`, `Show3`, `MovieDuration`) VALUES
	('2016-02-20', 1, NULL, 'Admiral YI', 1, 1, 1, 123),
	('2016-02-20', 2, NULL, 'IP Man', 2, 1, 1, 134),
	('2016-02-20', 3, NULL, 'Good Bad , Ugly', 3, 1, 1, NULL),
	('2016-02-20', 4, NULL, 'Toy story', 2, 1, 1, NULL),
	('2016-01-20', 5, NULL, 'Happy Days', 1, 1, 1, 145);
/*!40000 ALTER TABLE `movie_list` ENABLE KEYS */;


-- Dumping structure for table movieonlinereservation.purchaseinfo
CREATE TABLE IF NOT EXISTS `purchaseinfo` (
  `PurchaseID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11),
  `MovieID` int(11) DEFAULT NULL,
  `NumberOfTickets` int(11) DEFAULT NULL,
  `TicketPrice` int(11) DEFAULT NULL,
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

-- Dumping data for table movieonlinereservation.purchaseinfo: ~1 rows (approximately)
/*!40000 ALTER TABLE `purchaseinfo` DISABLE KEYS */;
INSERT INTO `purchaseinfo` (`PurchaseID`, `UserID`, `MovieID`, `NumberOfTickets`, `TicketPrice`, `TimeID`, `TransactionStatus`, `MailSend`) VALUES
	(1, 1, 1, NULL, NULL, 1, NULL, NULL);
/*!40000 ALTER TABLE `purchaseinfo` ENABLE KEYS */;


-- Dumping structure for table movieonlinereservation.seats
CREATE TABLE IF NOT EXISTS `seats` (
  `SeatID` int(11) NOT NULL AUTO_INCREMENT,
  `TotalSeats` int(11) DEFAULT NULL,
  `MovieID` int(11) DEFAULT NULL,
  `NumberOfAvailableSeats` int(11) DEFAULT NULL,
  PRIMARY KEY (`SeatID`),
  KEY `FK_seats_movie_list` (`MovieID`),
  CONSTRAINT `FK_seats_movie_list` FOREIGN KEY (`MovieID`) REFERENCES `movie_list` (`movieID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table movieonlinereservation.seats: ~0 rows (approximately)
/*!40000 ALTER TABLE `seats` DISABLE KEYS */;
INSERT INTO `seats` (`SeatID`, `TotalSeats`, `MovieID`, `NumberOfAvailableSeats`) VALUES
	(1, 10, 2, 8);
/*!40000 ALTER TABLE `seats` ENABLE KEYS */;


-- Dumping structure for table movieonlinereservation.ticketprice
CREATE TABLE IF NOT EXISTS `ticketprice` (
  `TicketPriceID` int(11) NOT NULL,
  `TicketPrice` int(11) DEFAULT NULL,
  `MovieID` int(11) DEFAULT NULL,
  `TimeID` int(11) DEFAULT NULL,
  PRIMARY KEY (`TicketPriceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table movieonlinereservation.ticketprice: ~1 rows (approximately)
/*!40000 ALTER TABLE `ticketprice` DISABLE KEYS */;
INSERT INTO `ticketprice` (`TicketPriceID`, `TicketPrice`, `MovieID`, `TimeID`) VALUES
	(1, 10, 2, 2);
/*!40000 ALTER TABLE `ticketprice` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table movieonlinereservation.timeinfo1: ~4 rows (approximately)
/*!40000 ALTER TABLE `timeinfo1` DISABLE KEYS */;
INSERT INTO `timeinfo1` (`TimeID`, `MovieTime`, `UpdatedBy`, `CreatedBy`, `CreatedDate`, `DeleteDate`, `RecordStatus`) VALUES
	(1, '01:00:00', NULL, NULL, NULL, NULL, 'ACTIVE'),
	(2, '20:53:39', NULL, NULL, NULL, NULL, 'ACTIVE'),
	(3, '12:53:51', NULL, NULL, NULL, NULL, 'ACTIVE'),
	(4, '09:54:46', NULL, NULL, NULL, NULL, 'ACTIVE'),
	(5, '10:54:58', NULL, NULL, NULL, NULL, 'ACTIVE');
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

-- Dumping data for table movieonlinereservation.userinfo: ~6 rows (approximately)
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` (`UserID`, `Email`, `Password`, `SaveCardInfo`, `CreditCardNumber`, `ExpirationMonth`, `ExpirationYear`, `FirstName`, `LastName`, `ZipCode`) VALUES
	(1, 'sridhar_mo@yahoo.com', 'Welcome', NULL, 2222222, 0, 0, 'sri', 'mo', 0),
	(2, 'sridhar_mo@yahoo.com', 'welcome', NULL, 1234567, 0, 0, 'sr', 'mo', 0),
	(3, 'sri@yahoo.com', 'welcome', NULL, 23, 0, 0, 'sd', 'sd', 0),
	(4, 'sridhar@yahoo.com', 'welcome', NULL, 23, 0, 0, 'sd', 'sd', 0),
	(5, 'sridhar@yahoo.com', '123333', NULL, 0, 0, 0, 'sd', 'as', 0),
	(6, 'sri23@yahoo.com', 'welcome', 'saveCardInfo', 0, 0, 0, '', '', 0),
	(7, 'sri24@yahoo.com', 'welcome', 'saveCardInfo', 111111, 0, 0, '', '', 0);
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
