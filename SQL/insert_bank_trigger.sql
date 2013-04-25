-- --------------------------------
-- trigger to insert into bank table when user do the registration.
-- VERSION 1.0 last edited by pratibind Jha
-- 		   
-- --------------------------------
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP TRIGGER IF EXISTS `insert_into_bank`; 

DELIMITER $$
USE `ebay`$$

CREATE TRIGGER `insert_into_bank` AFTER INSERT ON `user`
 FOR EACH ROW 
 BEGIN 
	 DECLARE t_bankId INT DEFAULT 0;
	 DECLARE t_userId INT DEFAULT 0;
	 DECLARE t_accountNum INT DEFAULT 0;
	 DECLARE t_atmNum INT DEFAULT 0;
	 SELECT MAX(userId) INTO t_userId FROM `user` ;
	 SELECT MAX(bankId) INTO t_bankId  FROM bank;
	 INSERT INTO bank (`userId`,`accountNum`,`atmNum`,`pinNum`,`password`,`balance`) VALUES
	 	(t_userId,CONCAT("1234_",t_userId+1),'1234',4321,'9876',100000);
 END$$
DELIMITER ;

