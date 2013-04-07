

DELETE FROM user;
 insert into user (`userId`,`firstName`,`lastName`,`homeAddress`,`city`,`pinCode`,`telephoneNo`,`email`,`password`,`secretQId`,`secretAnswer`,`dob`) values 
(10, 'Sridhar', 'Jammalamadaka', '1-23-23', 'hyderabad', 500020,'9924255323', 'sridhar.j@iiitb.org', 'sridhar123', 31, 'badminton', '1947-08-15'),
(11, 'Vamsi', 'Srungarapu', '19-234', 'jaggayapet', 500100,'8050897666', 'vamsikrishna.srungarapu@iiitb.org', 'vamsi123', 32, 'puppy', '1982-07-15'),
(12, 'Surya', 'Desai', '15-354', 'anantapur', 515001,'7259981049', 'suryapratap.desai@iiitb.org', 'surya123', 31, 'football', '1990-08-15'),
(13, 'Pavan', 'Kumar', '16-234', 'vijayawada', 502367,'9925678923', 'pavan.kumar@iiitb.org', 'pavan123', 32, 'mintu', '1988-04-12'),
(14, 'Ganguly', 'Dada', '1-34', 'kolkata', 505620,'9925465383', 'debargha.ganguly@iiitb.org', 'ganguly123', 31, 'tabletennis', '1967-05-25'),
(15, 'Pratibind', 'Jha', '1-5-2', 'Jharkhand', 567020,'8956255323', 'pratibind.jha@iiitb.org', 'pratibind123', 32, 'chotu', '1989-02-13'),
(16, 'Ranadheer', 'Kakkireni', '22-456', 'Kodad', 567920,'9845665323', 'randheer.kakkireni@iiitb.org', 'randheer123', 31, 'cricket', '1989-04-15');


DELETE FROM seller;
insert into seller (sellerId, dateOfRegistration, location, userId) values 
    (100, curdate(),'hyderabad',10),
    (101, curdate(),'patna',11),
    (102, curdate(),'jharkand',12),
    (103, curdate(),'himachal pradesh',13),
    (104, curdate(),'ranchi',14),
    (105, curdate(),'vijayawada',15),
    (106, curdate(),'ananthapur',16);

DELETE FROM product;
insert into product (productId, sellerId, title, description, price, photo) values
    (200, 100, 'A1 shaving cream', 'Shaving cream that can give you an excellent shave', 75, '/images/default-pic.jpg'),
    (201, 100, 'Bhagavad Gita as it is', 'A classic book wirtten by Prabhupada',150, '/images/default-pic.jpg'),
    (202, 100, 'Park Avenue deoderant', 'A deoderant that keeps you fresh all the day', 200, '/images/default-pic.jpg'),
    (203, 101, 'Dell a5001 laptop', 'High performance laptop for enterprise users', 35000, '/images/default-pic.jpg'),
    (204, 102, 'Sanskrit shlokas CD', 'A devotional MP3 collection of 80 songs', 100, '/images/default-pic.jpg'),
    (205, 103, 'Soyvita health Drink', 'A health drink for inteolerants, pregnant women, lactating mothers and aged people', 130, '/images/default-pic.jpg'),
    (206, 104, 'Raagini electronic tanpura', 'An electronic machine for Shruthi. Used by classicial musicians and learners', 5000, '/images/default-pic.jpg'),
    (207, 105, 'UNIX concepts and applications book', 'A best seller book written by Sumitabha Das', 400, '/images/default-pic.jpg'),
    (208, 106, 'Haldirams Plain Khakhara', 'Plain Khakhara made out of wheat and ready to eat. Perfect for breakfast and snacks.', 300, '/images/default-pic.jpg'),
    (209, 104, 'Teach yourself UNIX book', 'A hand book written by Ruth Amely', 50, '/images/default-pic.jpg'),
    (210, 104, 'Beautiful portrait', 'A beautiful scenario that can be used as a wall hanging.', 5000, '/images/scenary1.jpg');

DELETE FROM secretquestion;
insert into secretquestion values (30, 'What is your mothers maiden name?'), (31, 'What is your favorite sport?'),  (32, 'What is your pet name?');

DELETE FROM admin;
INSERT INTO `admin` (`adminID`,`adminUserName`,`adminPassword`,`adminFirstName`,`adminLastName`) VALUES
 (1,'john', '123','john','raulson'),
 (2, 'smith','123','smith','fedrick'),
 (3, 'paul', '123', 'paul', 'malson');


DELETE FROM userfeedback;
 INSERT INTO `userfeedback` (`userFeedBackId`,`userId`,`sellerId`,`rate`,`rating1`,`rating2`,`rating3`,`productId`,`description`) VALUES 
	(1,10,100,'positive',6,7,5,200,' shaving Cream'),
	(2,11,101,'positive',9,10,8,200,' shaving Cream very good'),
	(3,11,104,'netural',9,10,6,200,' shaving Cream very good'),
	(4,11,101,'negative',4,3,8,200,' shaving Cream very good'),
	(5,11,102,'positive',9,7,3,200,' shaving Cream very good'),
	(6,11,101,'positive',9,10,8,201,' ice product'),
	(7,11,101,'netural',9,10,8,201,' ice product'),
	(8,11,102,'positive',9,10,8,201,' ice product'),
	(9,11,101,'negative',9,10,8,201,' ice product'),
	(10,11,105,'positive',9,10,8,202,' ice product');

delete from deals;
insert into deals (dealsId, productId, dealStartDate, dealEndDate, dealSellingPrice) values
    (3000,200,'2013-04-01','2013-04-03',60),
    (3001,201,'2013-03-02','2013-04-03',120),
    (3002,202,'2013-04-02','2013-04-03',80),
    (3003,203,'2013-04-01','2013-05-03',34000),
    (3004,204,'2013-04-02','2013-05-03',60),
    (3005,205,'2013-04-01','2013-04-10',120),
    (3006,206,'2013-03-01','2013-03-10',4000),
    (3007,207,'2013-03-03','2013-03-03',300),
    (3008,208,'2013-04-01','2013-05-03',200),
    (3009,209,'2013-04-10','2013-05-03',30);
    
delete from category;
INSERT INTO `category` (`categoryId`, `categoryName`, `parentCategoryId`) VALUES
	(1, 'Mobiles', 0),
	(2, 'Accessories', 0),
	(3, 'Computers', 0),
	(4, 'Laptops', 3),
	(5, 'PDA', 3),
	(6, 'Audio Accessories', 2),
	(7, 'Clothing', 2),
	(8, 'Footwears', 2),
	(9, 'Books and Magazines', 0),
	(10, 'Movies and Music', 0),
	(11, 'Sports Equipments', 0),
	(12, 'Novels', 9),
	(13, 'Home and Kitchen', 0),
	(14, 'Fiction Books', 9);    
