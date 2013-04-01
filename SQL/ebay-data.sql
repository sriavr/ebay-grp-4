-- --------------------------------
-- VERSION 1.1 last edited by Debargha, added data for category table
-- VERSION 1.1 last edited by Sridhar, added data for seller, product table
-- VERSION 1.2 last edited by Surya, added data for state, country, user table
-- --------------------------------

INSERT INTO `category` (`categoryId`, `categoryName`, `parentCategoryId`) VALUES
	(1, 'Mobiles1', 0),
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

insert into seller (sellerId, sellerPassword, sellerName, dateOfRegistration, location) values 
    (100,'seller1', 'seller1', curdate(),'hyderabad'),
    (101,'seller2', 'seller2', curdate(),'patna'),
    (102,'seller3', 'seller3', curdate(),'jharkand'),
    (103,'seller4', 'seller4', curdate(),'himachal pradesh'),
    (104,'seller5', 'seller5', curdate(),'ranchi'),
    (105,'seller6', 'seller6', curdate(),'vijayawada'),
    (106,'seller33', 'seller106', curdate(),'ananthapur'),
    (107,'seller8', 'seller8', curdate(),'nellore'),
    (108,'seller9', 'seller9', curdate(),'mysore') ;

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
    (210, 107, 'Beautiful portrait', 'A beautiful scenario that can be used as a wall hanging.', 5000, '/images/scenary1.jpg');

 insert into country (countryId, country) values   (51, 'India'),  (52, 'America');
 
 insert into state (stateId, countryId, state) values (20, 51, 'Andhra Pradesh'), (21, 51, 'Weest Bengal'),    (22, 51, 'Bihar'), (23, 51, 'Maharashtra'), (24, 51, 'Tamil Nadu'), (25, 51, 'Karnataka');

insert into secretquestion values (30, 'What is your mothers maiden name?'), (31, 'What is your favorite sport?'),  (32, 'What is your pet name?');




 insert into user values 

(10, 'Sridhar', 'Jammalamadaka', '1-23-23', 'hyderabad', 51, 20, 500020,'9924255323', 'sridhar.j@iiitb.org', 'sridhar123', 31, 'badminton', '1947-08-15'),

(11, 'Vamsi', 'Srungarapu', '19-234', 'jaggayapet', 51, 20, 500100,'8050897666', 'vamsikrishna.srungarapu@iiitb.org', 'vamsi123', 32, 'puppy', '1982-07-15'),

(12, 'Surya', 'Desai', '15-354', 'anantapur', 51, 20, 515001,'7259981049', 'suryapratap.desai@iiitb.org', 'surya123', 31, 'football', '1990-08-15'),

(13, 'Pavan', 'Kumar', '16-234', 'vijayawada', 51, 20, 502367,'9925678923', 'pavan.kumar@iiitb.org', 'pavan123', 32, 'mintu', '1988-04-12'),

(14, 'Ganguly', 'Dada', '1-34', 'kolkata', 51, 21, 505620,'9925465383', 'debargha.ganguly@iiitb.org', 'ganguly123', 31, 'tabletennis', '1967-05-25'),

(15, 'Pratibind', 'Jha', '1-5-23', 'Jharkhand', 51, 22, 567020,'8956255323', 'pratibind.jha@iiitb.org', 'pratibind123', 32, 'chotu', '1989-02-13'),

(16, 'Ranadheer', 'Kakkireni', '22-456', 'Kodad', 51, 20, 567920,'9845665323', 'randheer.kakkireni@iiitb.org', 'randheer123', 31, 'cricket', '1989-04-15');


INSERT INTO `admin` (`adminID`,`adminUserName`,`adminPassword`,`adminFirstName`,`adminLastName`) VALUES
 (1,'john', '123','john','raulson'),
 (2, 'smith','123','smith','fedrick'),
 (3, 'paul', '123', 'paul', 'malson');

