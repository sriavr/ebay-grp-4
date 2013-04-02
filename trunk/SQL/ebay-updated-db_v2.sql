SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `eBay` ;
CREATE SCHEMA IF NOT EXISTS `eBay` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `eBay` ;

-- -----------------------------------------------------
-- Table `eBay`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eBay`.`user` ;

CREATE  TABLE IF NOT EXISTS `eBay`.`user` (
  `userId` INT NOT NULL AUTO_INCREMENT ,
  `firstName` VARCHAR(30) NOT NULL ,
  `lastName` VARCHAR(30) NOT NULL ,
  `homeAddress` VARCHAR(300) NULL ,
  `city` VARCHAR(30) NULL ,
  `state` VARCHAR(30) NOT NULL ,
  `pinCode` INT NOT NULL ,
  `telephoneNo` VARCHAR(12) NULL ,
  `email` VARCHAR(50) NOT NULL ,
  `password` VARCHAR(20) NOT NULL ,
  `secretQId` INT NULL ,
  `secretAnswer` VARCHAR(100) NULL ,
  `dob` DATE NOT NULL ,
  PRIMARY KEY (`userId`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eBay`.`secretQuestion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eBay`.`secretQuestion` ;

CREATE  TABLE IF NOT EXISTS `eBay`.`secretQuestion` (
  `secretQId` INT NOT NULL AUTO_INCREMENT ,
  `ques` VARCHAR(100) NULL ,
  PRIMARY KEY (`secretQId`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eBay`.`seller`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eBay`.`seller` ;

CREATE  TABLE IF NOT EXISTS `eBay`.`seller` (
  `sellerId` INT NOT NULL AUTO_INCREMENT ,
  `dateOfRegistration` DATE NULL ,
  `location` VARCHAR(30) NULL ,
  `feedbackScore` INT NULL ,
  `positiveFeedbackPercentage` INT NULL ,
  `userId` INT NOT NULL ,
  `sla` INT NULL ,
  PRIMARY KEY (`sellerId`) ,
  UNIQUE INDEX `userId_UNIQUE` (`userId` ASC) ,
  UNIQUE INDEX `sellerId_UNIQUE` (`sellerId` ASC) ,
  INDEX `fk_seller_2` (`userId` ASC) ,
  CONSTRAINT `fk_seller_2`
    FOREIGN KEY (`userId` )
    REFERENCES `eBay`.`user` (`userId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eBay`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eBay`.`product` ;

CREATE  TABLE IF NOT EXISTS `eBay`.`product` (
  `productId` INT NOT NULL ,
  `sellerId` INT NOT NULL ,
  `description` VARCHAR(600) NULL ,
  `title` VARCHAR(200) NULL ,
  `price` FLOAT NULL ,
  `quantity` INT NULL ,
  `photo` VARCHAR(200) NULL ,
  `discount` INT NULL ,
  PRIMARY KEY (`productId`) ,
  INDEX `fk_product_1` (`sellerId` ASC) ,
  CONSTRAINT `fk_product_1`
    FOREIGN KEY (`sellerId` )
    REFERENCES `eBay`.`seller` (`sellerId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eBay`.`userFeedBack`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eBay`.`userFeedBack` ;

CREATE  TABLE IF NOT EXISTS `eBay`.`userFeedBack` (
  `userFeedBackId` INT NOT NULL AUTO_INCREMENT ,
  `userId` INT NOT NULL ,
  `sellerId` INT NOT NULL ,
  `rate` VARCHAR(20) NULL ,
  `rating1` INT NULL ,
  `rating2` INT NULL ,
  `rating3` INT NULL ,
  `productId` INT NOT NULL ,
  `description` VARCHAR(200) NULL ,
  PRIMARY KEY (`userFeedBackId`) ,
  INDEX `fk_userFeedBack_1` (`userId` ASC) ,
  INDEX `fk_userFeedBack_2` (`productId` ASC) ,
  INDEX `fk_userFeedBack_3` (`sellerId` ASC) ,
  CONSTRAINT `fk_userFeedBack_1`
    FOREIGN KEY (`userId` )
    REFERENCES `eBay`.`user` (`userId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_userFeedBack_2`
    FOREIGN KEY (`productId` )
    REFERENCES `eBay`.`product` (`productId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_userFeedBack_3`
    FOREIGN KEY (`sellerId` )
    REFERENCES `eBay`.`seller` (`sellerId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eBay`.`userWishList`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eBay`.`userWishList` ;

CREATE  TABLE IF NOT EXISTS `eBay`.`userWishList` (
  `userWishListId` INT NOT NULL AUTO_INCREMENT ,
  `userId` INT NOT NULL ,
  `productId` INT NOT NULL ,
  PRIMARY KEY (`userWishListId`) ,
  INDEX `fk_userWishList_1` (`userId` ASC) ,
  INDEX `fk_userWishList_2` (`productId` ASC) ,
  CONSTRAINT `fk_userWishList_1`
    FOREIGN KEY (`userId` )
    REFERENCES `eBay`.`user` (`userId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_userWishList_2`
    FOREIGN KEY (`productId` )
    REFERENCES `eBay`.`product` (`productId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eBay`.`modesofpayment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eBay`.`modesofpayment` ;

CREATE  TABLE IF NOT EXISTS `eBay`.`modesofpayment` (
  `modesofpaymentId` INT NOT NULL AUTO_INCREMENT ,
  `modesofpayment` VARCHAR(30) NULL ,
  PRIMARY KEY (`modesofpaymentId`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eBay`.`shippingService`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eBay`.`shippingService` ;

CREATE  TABLE IF NOT EXISTS `eBay`.`shippingService` (
  `shippingServiceId` INT NOT NULL AUTO_INCREMENT ,
  `shippingService` VARCHAR(60) NULL ,
  PRIMARY KEY (`shippingServiceId`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eBay`.`returns`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eBay`.`returns` ;

CREATE  TABLE IF NOT EXISTS `eBay`.`returns` (
  `returnsId` INT NOT NULL AUTO_INCREMENT ,
  `refund` VARCHAR(30) NULL ,
  `returnscol` VARCHAR(30) NULL ,
  `warrantyType` VARCHAR(30) NULL ,
  `warrantyDuration` INT NULL ,
  `returnPolicy` VARCHAR(300) NULL ,
  PRIMARY KEY (`returnsId`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eBay`.`auction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eBay`.`auction` ;

CREATE  TABLE IF NOT EXISTS `eBay`.`auction` (
  `auctionId` INT NOT NULL ,
  `productId` INT NOT NULL ,
  `auctionType` VARCHAR(45) NULL ,
  `startingPrice` INT NULL ,
  `buyItNowPrice` INT NULL ,
  `duration` INT NULL ,
  `scheduledStartState` DATE NULL ,
  `modeofpaymentId` INT NOT NULL ,
  `shippingServiceId` INT NOT NULL ,
  `shippingserviceCost` INT NULL ,
  `handlingTime` INT NULL ,
  `returnsId` INT NOT NULL ,
  `paymentDescription` VARCHAR(300) NULL ,
  PRIMARY KEY (`auctionId`) ,
  INDEX `fk_auction_1` (`productId` ASC) ,
  INDEX `fk_auction_2` (`modeofpaymentId` ASC) ,
  INDEX `fk_auction_3` (`shippingServiceId` ASC) ,
  INDEX `fk_auction_4` (`returnsId` ASC) ,
  CONSTRAINT `fk_auction_1`
    FOREIGN KEY (`productId` )
    REFERENCES `eBay`.`product` (`productId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_auction_2`
    FOREIGN KEY (`modeofpaymentId` )
    REFERENCES `eBay`.`modesofpayment` (`modesofpaymentId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_auction_3`
    FOREIGN KEY (`shippingServiceId` )
    REFERENCES `eBay`.`shippingService` (`shippingServiceId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_auction_4`
    FOREIGN KEY (`returnsId` )
    REFERENCES `eBay`.`returns` (`returnsId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eBay`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eBay`.`order` ;

CREATE  TABLE IF NOT EXISTS `eBay`.`order` (
  `orderId` INT NOT NULL AUTO_INCREMENT ,
  `userId` INT NOT NULL ,
  `sellerId` INT NOT NULL ,
  `productId` INT NOT NULL ,
  `transactionId` INT NOT NULL ,
  `currentStatus` VARCHAR(30) NULL ,
  `orderPlacedDate` DATETIME NULL ,
  `statusUpdatedDate` DATETIME NULL ,
  `shipped` DATETIME NULL ,
  PRIMARY KEY (`orderId`) ,
  INDEX `fk_order_1` (`userId` ASC) ,
  INDEX `fk_order_2` (`sellerId` ASC) ,
  INDEX `fk_order_3` (`productId` ASC) ,
  CONSTRAINT `fk_order_1`
    FOREIGN KEY (`userId` )
    REFERENCES `eBay`.`user` (`userId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_2`
    FOREIGN KEY (`sellerId` )
    REFERENCES `eBay`.`seller` (`sellerId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_3`
    FOREIGN KEY (`productId` )
    REFERENCES `eBay`.`product` (`productId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eBay`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eBay`.`category` ;

CREATE  TABLE IF NOT EXISTS `eBay`.`category` (
  `categoryId` INT NOT NULL AUTO_INCREMENT ,
  `categoryName` VARCHAR(30) NOT NULL ,
  `parentCategoryId` INT NOT NULL ,
  PRIMARY KEY (`categoryId`) 
  
    )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eBay`.`productCategoryMapping`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eBay`.`productCategoryMapping` ;

CREATE  TABLE IF NOT EXISTS `eBay`.`productCategoryMapping` (
  `productCategoryMappingId` INT NOT NULL AUTO_INCREMENT ,
  `productId` INT NOT NULL ,
  `categoryId` INT NOT NULL ,
  PRIMARY KEY (`productCategoryMappingId`) ,
  INDEX `fk_productCategoryMapping_1` (`categoryId` ASC) ,
  INDEX `fk_productCategoryMapping_2` (`productId` ASC) ,
  CONSTRAINT `fk_productCategoryMapping_1`
    FOREIGN KEY (`categoryId` )
    REFERENCES `eBay`.`category` (`categoryId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_productCategoryMapping_2`
    FOREIGN KEY (`productId` )
    REFERENCES `eBay`.`product` (`productId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eBay`.`productSpecs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eBay`.`productSpecs` ;

CREATE  TABLE IF NOT EXISTS `eBay`.`productSpecs` (
  `productSpecsId` INT NOT NULL AUTO_INCREMENT ,
  `entity` VARCHAR(100) NULL ,
  `value` VARCHAR(500) NULL ,
  `type` VARCHAR(30) NULL ,
  `productId` INT NOT NULL ,
  PRIMARY KEY (`productSpecsId`) ,
  INDEX `fk_productSpecs_1` (`productId` ASC) ,
  CONSTRAINT `fk_productSpecs_1`
    FOREIGN KEY (`productId` )
    REFERENCES `eBay`.`product` (`productId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eBay`.`deals`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eBay`.`deals` ;

CREATE  TABLE IF NOT EXISTS `eBay`.`deals` (
  `dealsId` INT NOT NULL AUTO_INCREMENT ,
  `productId` INT NOT NULL ,
  `productDiscountPercent` INT NULL ,
  `dealStartDate` DATE NULL ,
  `dealEndDate` DATE NULL ,
  `dealSellingPrice` INT NOT NULL ,
  PRIMARY KEY (`dealsId`) ,
  INDEX `fk_deals_1` (`productId` ASC) ,
  UNIQUE INDEX `productId_UNIQUE` (`productId` ASC) ,
  CONSTRAINT `fk_deals_1`
    FOREIGN KEY (`productId` )
    REFERENCES `eBay`.`product` (`productId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eBay`.`productSellerMapping`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eBay`.`productSellerMapping` ;

CREATE  TABLE IF NOT EXISTS `eBay`.`productSellerMapping` (
  `productSellerMappingId` INT NOT NULL AUTO_INCREMENT ,
  `productId` INT NOT NULL ,
  `sellerId` INT NOT NULL ,
  PRIMARY KEY (`productSellerMappingId`) ,
  INDEX `fk_productSellerMapping_1` (`productId` ASC) ,
  INDEX `fk_productSellerMapping_2` (`sellerId` ASC) ,
  CONSTRAINT `fk_productSellerMapping_1`
    FOREIGN KEY (`productId` )
    REFERENCES `eBay`.`product` (`productId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_productSellerMapping_2`
    FOREIGN KEY (`sellerId` )
    REFERENCES `eBay`.`seller` (`sellerId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eBay`.`admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eBay`.`admin` ;

CREATE  TABLE IF NOT EXISTS `eBay`.`admin` (
  `adminId` INT NOT NULL AUTO_INCREMENT ,
  `adminUserName` VARCHAR(30) NOT NULL ,
  `adminPassword` VARCHAR(30) NULL ,
  `adminFirstName` VARCHAR(30) NULL ,
  `adminLastName` VARCHAR(30) NULL ,
  PRIMARY KEY (`adminId`) ,
  UNIQUE INDEX `adminId_UNIQUE` (`adminId` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eBay`.`cart`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eBay`.`cart` ;

CREATE  TABLE IF NOT EXISTS `eBay`.`cart` (
  `cartId` INT NOT NULL AUTO_INCREMENT ,
  `userId` INT NOT NULL ,
  `productId` INT NOT NULL ,
  `quantity` INT NULL ,
  `type` VARCHAR(1) NULL ,
  PRIMARY KEY (`cartId`) ,
  INDEX `fk_cart_1` (`userId` ASC) ,
  INDEX `fk_cart_2` (`productId` ASC) ,
  CONSTRAINT `fk_cart_1`
    FOREIGN KEY (`userId` )
    REFERENCES `eBay`.`user` (`userId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cart_2`
    FOREIGN KEY (`productId` )
    REFERENCES `eBay`.`product` (`productId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eBay`.`bank`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eBay`.`bank` ;

CREATE  TABLE IF NOT EXISTS `eBay`.`bank` (
  `bankId` INT NOT NULL AUTO_INCREMENT ,
  `userId` INT NOT NULL ,
  `accountNum` VARCHAR(45) NULL ,
  `atmNum` VARCHAR(45) NULL ,
  `pinNum` INT NULL ,
  `password` VARCHAR(45) NULL ,
  `balance` INT NULL ,
  PRIMARY KEY (`bankId`) ,
  UNIQUE INDEX `userId_UNIQUE` (`userId` ASC) ,
  UNIQUE INDEX `accountNum_UNIQUE` (`accountNum` ASC) ,
  INDEX `fk_bank_1` (`userId` ASC) ,
  CONSTRAINT `fk_bank_1`
    FOREIGN KEY (`userId` )
    REFERENCES `eBay`.`user` (`userId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
