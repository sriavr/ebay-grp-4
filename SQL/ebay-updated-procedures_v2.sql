-- -----------------------------------------------------
-- Procedure `eBay`.`getSubCategories`
-- -----------------------------------------------------
USE `eBay` ;
DROP procedure IF EXISTS `getSubCategories`;

delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getSubCategories`(IN catId INT)
BEGIN
    DECLARE temp INT DEFAULT catId;
    drop temporary table if exists tmpcat;
    create temporary table tmpcat (
        categoryId INT,
        done INT
    ) engine = memory;
    insert into tmpcat values (0,0);

    insert into tmpcat (categoryId, done) (select categoryId, 0 from category where parentCategoryId = temp);
    select categoryId into temp from tmpcat where done = 0 order by categoryId desc LIMIT 1 ;
    update tmpcat set done = 1 where categoryId = temp;
    WHILE temp <> 0 DO
        insert into tmpcat (categoryId, done) (select categoryId, 0 from category where parentCategoryId = temp);
        select categoryId into temp from tmpcat where done = 0 order by categoryId desc LIMIT 1 ;
        update tmpcat set done = 1 where categoryId = temp;
    END WHILE;
    insert into tmpcat values (catId, 1);
    delete from tmpcat where categoryId = 0;
    select t.categoryId, c.categoryName from tmpcat t, category c where t.categoryId = c.categoryId;
    -- select categoryId from tmpcat;
    drop temporary table tmpcat;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure `eBay`.`getProducts`
-- -----------------------------------------------------
DROP procedure IF EXISTS `getProducts`;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getProducts`(IN query VARCHAR(2000), IN catId INT, IN priceLower INT, IN priceHigher INT)
BEGIN
    DECLARE temp INT DEFAULT catId;
    DECLARE queryString VARCHAR(2002);
    select concat('%',query) into queryString;

    if query <> '' then
        select concat(queryString,'%') into queryString;
    end if;

    if priceHigher < priceLower or (priceHigher = 0 and priceLower = 0) then
        select 0 into priceLower from dual;
        select 100000000 into priceHigher from dual;
    end if;

    drop temporary table if exists tmpcat;
    create temporary table tmpcat (
        categoryId INT,
        done INT
    ) engine = memory;
    insert into tmpcat values (0,0);
    WHILE temp <> 0 DO
        insert into tmpcat (categoryId, done) (select categoryId, 0 from category where parentCategoryId = temp);
        select categoryId into temp from tmpcat where done = 0 order by categoryId desc LIMIT 1 ;
        update tmpcat set done = 1 where categoryId = temp;
    END WHILE;
    insert into tmpcat values (catId, 1);
    delete from tmpcat where categoryId = 0;
    
    if catId <> '' then
        select 
        p.productId, pcm.categoryId, p.description, p.title, p.price, p.quantity, p.photo, p.discount, 
        s.sellerId, s.location, u.firstName, u.lastName, u.email, u.telephoneNo
        from productcategorymapping pcm, product p, user u, seller s, tmpCat t
        where p.productId = pcm.productId and s.sellerId = p.sellerId and u.userId = s.userId and pcm.categoryId = t.categoryId
        and (p.title like queryString or p.description like queryString) 
        and p.price > priceLower and p.price < priceHigher
        order by p.productId;
    else
        select 
        p.productId, pcm.categoryId, p.description, p.title, p.price, p.quantity, p.photo, p.discount, 
        s.sellerId, s.location, u.firstName, u.lastName, u.email, u.telephoneNo
        from productcategorymapping pcm, product p, user u, seller s
        where p.productId = pcm.productId and s.sellerId = p.sellerId and u.userId = s.userId
        and (p.title like queryString or p.description like queryString)
        and p.price > priceLower and p.price < priceHigher
        order by p.productId;        
    end if;

    -- select queryString from dual;
    drop temporary table tmpcat;
END$$
DELIMITER ;

-- -----------------------------------------------------
-- Procedure `eBay`.`getDeals`
-- -----------------------------------------------------
DROP procedure IF EXISTS `getDeals`;

DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getDeals`(IN query VARCHAR(2000), IN catId INT, IN priceLower INT, IN priceHigher INT)
BEGIN
    DECLARE temp INT DEFAULT catId;
    DECLARE queryString VARCHAR(2002);
    select concat('%',query) into queryString;

    if query <> '' then
        select concat(queryString,'%') into queryString;
    end if;

    if priceHigher < priceLower or (priceHigher = 0 and priceLower = 0) then
        select 0 into priceLower from dual;
        select 100000000 into priceHigher from dual;
    end if;

    drop temporary table if exists tmpcat;
    create temporary table tmpcat (
        categoryId INT,
        done INT
    ) engine = memory;
    insert into tmpcat values (0,0);
    WHILE temp <> 0 DO
        insert into tmpcat (categoryId, done) (select categoryId, 0 from category where parentCategoryId = temp);
        select categoryId into temp from tmpcat where done = 0 order by categoryId desc LIMIT 1 ;
        update tmpcat set done = 1 where categoryId = temp;
    END WHILE;
    insert into tmpcat values (catId, 1);
    delete from tmpcat where categoryId = 0;
    
    if catId <> '' then
        select 
        p.productId, pcm.categoryId, p.description, p.title, p.price, p.quantity, p.photo, p.discount, 
        s.sellerId, s.location, u.firstName, u.lastName, u.email, u.telephoneNo,
		d.dealsId, d.productId, d.dealStartDate, d.dealEndDate, d.dealSellingPrice
        from productcategorymapping pcm, user u, seller s, tmpCat t, product p LEFT OUTER JOIN deals d on d.productId = p.productId 
        where p.productId = pcm.productId and s.sellerId = p.sellerId and u.userId = s.userId and pcm.categoryId = t.categoryId
        and (p.title like queryString or p.description like queryString) 
        and p.price > priceLower and p.price < priceHigher 
		and d.dealStartDate <= curdate() and d.dealEndDate >= curdate() order by p.productId;
    else
        select 
        p.productId, pcm.categoryId, p.description, p.title, p.price, p.quantity, p.photo, p.discount, 
        s.sellerId, s.location, u.firstName, u.lastName, u.email, u.telephoneNo,
		d.dealsId, d.productId, d.dealStartDate, d.dealEndDate, d.dealSellingPrice
        from productcategorymapping pcm, product p, user u, seller s, deals d
        where p.productId = pcm.productId and s.sellerId = p.sellerId and u.userId = s.userId
        and (p.title like queryString or p.description like queryString)
        and p.price > priceLower and p.price < priceHigher         
		and d.dealStartDate <= curdate() and d.dealEndDate >= curdate() order by p.productId;
    end if;

    -- select queryString from dual;
    drop temporary table tmpcat;
END$$
DELIMITER ;

-- --------------------------------------------------------------------------------
-- Procedure `eBay`.`getProductDeals`
-- --------------------------------------------------------------------------------
DROP procedure IF EXISTS `getProductDeals`;

delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getProductDeals`(IN query VARCHAR(2000), IN catId INT, IN priceLower INT, IN priceHigher INT)
BEGIN
    DECLARE temp INT DEFAULT catId;
    DECLARE queryString VARCHAR(2002);
    select concat('%',query) into queryString;

    if query <> '' then
        select concat(queryString,'%') into queryString;
    end if;

    if priceHigher < priceLower or (priceHigher = 0 and priceLower = 0) then
        select 0 into priceLower from dual;
        select 100000000 into priceHigher from dual;
    end if;

   drop temporary table if exists tmpcat;
    create temporary table tmpcat (
        categoryId INT,
        categoryName VARCHAR(200),
        done INT
    ) engine = memory;
    insert into tmpcat values (0,'All Categories',0);

    insert into tmpcat (categoryId, categoryName, done) (select categoryId, categoryName, 0 from category where parentCategoryId = temp);
    select categoryId into temp from tmpcat where done = 0 order by categoryId desc LIMIT 1 ;
    update tmpcat set done = 1 where categoryId = temp;

    WHILE temp <> 0 DO
        insert into tmpcat (categoryId, categoryName, done) (select categoryId, categoryName, 0 from category where parentCategoryId = temp);
        select categoryId into temp from tmpcat where done = 0 order by categoryId desc LIMIT 1 ;
        update tmpcat set done = 1 where categoryId = temp;
    END WHILE;


    insert into tmpcat (categoryId, categoryName, done)  (select categoryId, categoryName, 1 from category where categoryId = catId) ;

  
        select 
        p.productId, pcm.categoryId, p.description, p.title, p.price, p.quantity, p.photo, p.discount, 
        s.sellerId, s.location, u.firstName, u.lastName, u.email, u.telephoneNo,
		d.dealsId, d.productId, d.dealStartDate, d.dealEndDate, d.dealSellingPrice
        from productcategorymapping pcm, user u, seller s, tmpCat t, product p LEFT OUTER JOIN deals d on d.productId = p.productId 
        where p.productId = pcm.productId and s.sellerId = p.sellerId and u.userId = s.userId and pcm.categoryId = t.categoryId
        and (p.title sounds like queryString or p.title like queryString or p.description like queryString
        or p.description sounds like queryString or t.categoryName like queryString
        or s.location sounds like queryString or u.firstName sounds like queryString or u.lastName sounds like queryString
        or u.homeAddress sounds like queryString or u.city sounds like queryString) 
        and p.price > priceLower and p.price < priceHigher 
		and (ISNULL(d.dealsId) OR (d.dealStartDate <= curdate() and d.dealEndDate >= curdate())) order by p.productId;

    drop temporary table tmpcat;
END$$

delimiter $$

