/*
SQLyog Trial v13.1.8 (64 bit)
MySQL - 8.0.42 : Database - furni
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`furni` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `furni`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `address` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone` (`phone`),
  UNIQUE KEY `password` (`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `admin` */

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `cid` int NOT NULL,
  `category_name` varchar(100) DEFAULT NULL,
  `category_description` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `category` */

insert  into `category`(`cid`,`category_name`,`category_description`) values 
(1,'Bar Stool','Stylish Stools'),
(3,'Bookshelves','New Design Bookshelf'),
(2,'Beds','Stylish Beds'),
(4,'Cabinets','New Stylish Cabinets'),
(5,'Chair','Stylish and new Chairs'),
(6,'Dining Tables','New Dining Tables and Table Sets'),
(7,'Outdoor Furnitures','New Outdoor Furnitures'),
(8,'Sofa','New Stylish Sofa'),
(9,'Study Tables','Stylish Study Tables'),
(10,'Wardrobe','bsdsdghdfkvfdho');

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `customer_id` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10021 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `customer` */

insert  into `customer`(`customer_id`,`username`,`phone`,`email`,`password`,`address`,`created_at`,`updated_at`,`image`) values 
(10020,'Aman','8815904554','Amang@gmail.com','a,man@123','08,van shree nagar, navlakha,indore','2025-06-24 11:09:18','2025-06-24 11:09:18',''),
(10019,'Ayush Patel','7654382764','ayush@gmail.com','Ayush@1234','Tatiharakala ward no.5 mauganj Rewa madhyapradesh','2025-06-24 06:27:48','2025-06-24 09:51:35',NULL),
(10001,'piyush','+918815904554','abc@gmail.com','piyush@123','08,van shree nagar, navlakha,indore','2025-06-22 20:05:11','2025-06-22 20:05:11',NULL),
(10018,'praann','8827602605','abcde@gmail.com','praann@123','Tatiharakala ward no.5 mauganj Rewa madhyapradesh','2025-06-22 20:27:52','2025-06-22 20:27:52',''),
(1,'pragaya','4455667788','lkasjd@123','skdjhfklsjhfg','cff','2025-06-21 14:41:34','2025-06-21 19:20:04',NULL),
(10010,'prah','8815904554','8349815125','prah@123','08,van shree nagar, navlakha,indore','2025-06-22 20:08:39','2025-06-22 20:08:39',NULL),
(10016,'prsa','6121175779','abcd@gmail.com','prsa@123','Tatiharakala ward no.5 mauganj Rewa madhyapradesh','2025-06-22 20:17:14','2025-06-22 20:17:14',NULL);

/*Table structure for table `customer_meta` */

DROP TABLE IF EXISTS `customer_meta`;

CREATE TABLE `customer_meta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `status` varchar(20) DEFAULT 'Active',
  `notes` text,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `customer_id` (`customer_id`),
  CONSTRAINT `customer_meta_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `customer_meta` */

insert  into `customer_meta`(`id`,`customer_id`,`status`,`notes`,`updated_at`) values 
(1,1,'Active',NULL,'2025-06-22 16:14:12'),
(2,10001,'Active',NULL,'2025-06-22 22:26:08'),
(3,10010,'Active',NULL,'2025-06-22 22:02:14'),
(4,10016,'Active',NULL,'2025-06-22 22:02:14'),
(5,10018,'Active',NULL,'2025-06-22 22:02:14');

/*Table structure for table `order_items` */

DROP TABLE IF EXISTS `order_items`;

CREATE TABLE `order_items` (
  `item_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `pid` int NOT NULL,
  `quantity` int NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`item_id`),
  KEY `order_id` (`order_id`),
  KEY `order_items_ibfk_2` (`pid`),
  CONSTRAINT `order_items_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`) ON DELETE CASCADE,
  CONSTRAINT `order_items_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `order_items` */

insert  into `order_items`(`item_id`,`order_id`,`pid`,`quantity`,`price`) values 
(2,8,20,2,22000.00),
(3,8,10,1,2500.00),
(4,9,10,1,2500.00),
(5,10,10,1,2500.00),
(6,11,10,1,2500.00),
(7,12,10,1,2500.00),
(8,13,10,1,2500.00),
(9,14,11,1,2000.00),
(11,18,10,1,2500.00),
(13,20,10,1,2500.00),
(14,21,11,1,2000.00),
(15,22,11,5,2000.00),
(16,23,23,7,22500.00),
(17,23,11,3,2000.00),
(18,24,11,1,2000.00),
(19,25,11,2,2000.00);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `order_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `total_amount` decimal(10,2) NOT NULL,
  `status` varchar(20) DEFAULT 'Pending',
  `shipping_address` varchar(200) NOT NULL,
  `payment_method` enum('COD','Online') DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `username` (`username`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`username`) REFERENCES `customer` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `orders` */

insert  into `orders`(`order_id`,`username`,`order_date`,`total_amount`,`status`,`shipping_address`,`payment_method`) values 
(7,'praann','2025-06-22 20:28:42',500.00,'Processing','prann patel, Naiarhi, Madhya Pradesh - 486340','COD'),
(8,'praann','2025-06-23 07:29:33',46500.00,'Shipped','ayush patel, Naiarhi, Madhya Pradesh - 486340','COD'),
(9,'praann','2025-06-23 07:35:30',2500.00,'Delivered','ayush patel, Naiarhi, Madhya Pradesh - 486340','COD'),
(10,'praann','2025-06-23 07:55:34',2500.00,'Shipped','ayush patel, Naiarhi, Madhya Pradesh - 486340','COD'),
(11,'praann','2025-06-23 07:59:12',2500.00,'Processing','ayush patel, Naiarhi, Madhya Pradesh - 486340','COD'),
(12,'praann','2025-06-23 08:03:06',2500.00,'Pending','ayush patel, Naiarhi, Madhya Pradesh - 486340','COD'),
(13,'praann','2025-06-23 08:06:43',2500.00,'Shipped','ayush patel, Naiarhi, Madhya Pradesh - 486340','COD'),
(14,'praann','2025-06-23 08:07:58',2000.00,'Pending','ayush patel, Naiarhi, Madhya Pradesh - 486340','COD'),
(15,'praann','2025-06-23 08:10:10',500.00,'Pending','ayush patel, Naiarhi, Madhya Pradesh - 486340','COD'),
(18,'praann','2025-06-23 11:39:50',2500.00,'Pending','ayush patel, Naiarhi, Madhya Pradesh - 486340','COD'),
(19,'praann','2025-06-23 11:41:38',500.00,'Pending','ayush patel, Naiarhi, Madhya Pradesh - 486340','COD'),
(20,'praann','2025-06-23 12:36:11',2500.00,'Delivered','ayush patel, Naiarhi, Madhya Pradesh - 486340','COD'),
(21,'praann','2025-06-23 12:44:33',2000.00,'Pending','ayush patel, Naiarhi, Madhya Pradesh - 486340','COD'),
(22,'praann','2025-06-24 00:19:46',10000.00,'Pending','ayush patel, Naiarhi, Madhya Pradesh - 486340','COD'),
(23,'Ayush Patel','2025-06-24 06:30:41',163500.00,'Pending','Ayush patel, Naigarhi, Madhya Pradesh - 486340','COD'),
(24,'Aman','2025-06-24 11:12:07',2000.00,'Pending','ayush patel, Naiarhi, Madhya Pradesh - 486340','COD'),
(25,'Ayush Patel','2025-06-24 11:26:42',4000.00,'Pending','ayush patel, Naiarhi, Madhya Pradesh - 486340','COD');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `pid` int NOT NULL AUTO_INCREMENT,
  `pname` varchar(100) NOT NULL,
  `description` text,
  `price` double NOT NULL,
  `quantity` int NOT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `cid` int DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `product` */

insert  into `product`(`pid`,`pname`,`description`,`price`,`quantity`,`image_url`,`cid`,`created_at`) values 
(10,'Adjustable Swivel Bar Stool','Effortlessly stylish and functional, this bar stool features a 360Â° swivel seat and adjustable height mechanism, making it perfect for kitchen islands or home bars. The sleek design and sturdy base offer both comfort and modern appeal.',2500,20,'Adjustable Swivel Bar Stool.png',1,'2025-06-23 01:27:39'),
(11,'Backless Counter Stool','Minimalist in design, maximum in versatility. This backless counter stool saves space while adding a contemporary touch to your kitchen or dining area. Its clean lines and compact form make it ideal for smaller spaces.',2000,15,'Backless Counter Stool.jpg',1,'2025-06-23 01:28:50'),
(12,'Bar Stool with Armrests','Relax in refined comfort. With supportive armrests and a cushioned seat, this bar stool is designed for long conversations and leisurely meals. A perfect blend of elegance and ergonomic design.',2200,17,'Bar Stool with Armrests.jpg',1,'2025-06-23 01:29:59'),
(13,'Bar Stool with Footrest','Elevate your seating experience. This stool includes a built-in footrest for added support and comfort. Its balanced proportions and durable construction make it a reliable choice for everyday use.',1560,12,'Bar Stool with Footrest.jpg',1,'2025-06-23 01:31:04'),
(14,'Industrial Metal Bar Stool','Bold and built to last. Inspired by urban loft aesthetics, this stool features a rugged metal frame and a raw, industrial finish. Ideal for modern kitchens, cafes, or workspaces.',2200,18,'Industrial Metal Bar Stool.jpg',1,'2025-06-23 01:32:05'),
(15,'Mid-Century Modern Bar Stool','Timeless charm meets modern flair. With its curved wooden frame, tapered legs, and upholstered seat, this stool brings a retro vibe to any setting. A must-have for lovers of vintage design.',1740,16,'Mid-Century Modern Bar Stool.jpg',1,'2025-06-23 01:33:01'),
(16,'Rattan Bar Stool','Natural texture, coastal elegance. Handwoven rattan and a sturdy frame combine to create a breezy, laid-back look. Perfect for beach-inspired interiors or boho-chic spaces.',3500,22,'Rattan Bar Stool.jpg',1,'2025-06-23 01:34:02'),
(17,'Scandinavian Style Bar Chair','Simplicity at its finest. Clean lines, light wood tones, and ergonomic design define this Nordic-inspired bar chair. A beautiful addition to minimalist and modern homes.',2670,14,'Scandinavian Style Bar Chair.jpg',1,'2025-06-23 01:35:11'),
(18,'Scandinavian Style Bar Chair','Simplicity at its finest. Clean lines, light wood tones, and ergonomic design define this Nordic-inspired bar chair. A beautiful addition to minimalist and modern homes.',2300,14,'Scandinavian Style Bar Chair.jpg',1,'2025-06-23 01:36:13'),
(19,'Wooden High Bar Chair','Classic craftsmanship, elevated. Made from solid wood with a rich finish, this high bar chair adds warmth and sophistication to any bar orÂ counterÂ setup.',1400,12,'Wooden High Bar Chair.jpg',1,'2025-06-23 01:37:19'),
(20,'Adjustable Smart Bed','Experience the future of sleep with our Adjustable Smart Bed. Designed with cutting-edge technology, it features customizable head and foot elevation, zero-gravity positioning, and anti-snore settingsâall controlled via remote or app. Integrated massage modes and under-bed lighting add a luxurious touch, while the sturdy frame supports a variety of mattress types. Ideal for those who value comfort, wellness, and innovation in their sleep routine.',22000,23,'Adjustable Smart Bed.jpg',2,'2025-06-23 01:39:46'),
(21,'Bunk Bed for Kids','Make bedtime fun and functional with our Bunk Bed for Kids. Crafted from durable wood or metal, this space-saving design features a secure ladder, high guardrails, and playful styling that sparks imagination. Whether for siblings or sleepovers, itâs a smart solution for shared roomsâoffering comfort, safety, and a touch of adventure.',17000,35,'Bunk Bed for Kids.jpg',2,'2025-06-23 01:40:42'),
(22,'King Size Bed','Command attention with our King Size Bedâa grand centerpiece for spacious bedrooms. With its expansive dimensions and solid construction, it offers unmatched comfort for couples or families who love to sprawl. Available in a variety of finishes and styles, this bed brings both luxury and practicality to your master suite.',32000,35,'King Size Bed.jpg',2,'2025-06-23 01:42:02'),
(23,'Low Height Japanese Bed','Inspired by Zen minimalism, the Low Height Japanese Bed embraces simplicity and serenity. Its near-floor design promotes a grounded, calming atmosphere, while the clean lines and natural wood tones reflect traditional Japanese aesthetics. Ideal for modern, minimalist, or boho interiors seeking a peaceful retreat.',22500,38,'Low Height Japanese Bed.jpg',2,'2025-06-23 01:43:09'),
(24,'Metal Frame Bed','Sleek, strong, and stylishâour Metal Frame Bed is a modern classic. Built with high-quality steel, it offers excellent support and longevity. The minimalist design suits a wide range of interiors, from industrial lofts to contemporary bedrooms. Easy to assemble and maintain, itâs a practical choice with timeless appeal.',23550,40,'Metal Frame Bed.jpg',2,'2025-06-23 01:44:02'),
(25,'Queen Size Platform Bed','Our Queen Size Platform Bed combines elegance with efficiency. Featuring a low-profile frame and sturdy slats, it eliminates the need for a box spring while offering ample mattress support. Choose from wood, metal, or upholstered finishes to match your dÃ©cor. Itâs the perfect blend of form and function for modern living.',32500,45,'Queen Size Platform Bed.jpg',2,'2025-06-23 01:45:25'),
(26,'Wooden Poster Bed','Make a bold statement with our Wooden Poster Bed. Featuring four tall posts and a solid wood frame, this bed exudes regal charm and timeless elegance. Whether left open or draped with fabric, it transforms your bedroom into a luxurious sanctuary reminiscent of classic royal suites.',25500,25,'Wooden Poster Bed.jpg',2,'2025-06-23 01:46:15'),
(27,'Wrought Iron Bed','Romantic and resilient, the Wrought Iron Bed blends vintage charm with modern durability. Intricate scrollwork and a powder-coated finish give it a graceful silhouette, while the robust frame ensures long-lasting support. A perfect choice for those who love antique-inspired or rusticÂ interiors.',22550,26,'Wrought Iron Bed.jpg',2,'2025-06-23 01:47:08'),
(28,'Upholstered Headboard Bed','Add a touch of luxury to your bedroom with our Upholstered Headboard Bed. The padded headboard, wrapped in soft fabric or faux leather, offers both comfort and sophistication. Perfect for reading or relaxing in bed, it creates a cozy focal point that elevates any bedroom dÃ©cor.',36520,36,'Upholstered Headboard Bed.jpg',2,'2025-06-23 01:48:02'),
(29,'Bookshelf with Sliding Panels','A blend of elegance and practicality, this bookshelf features smooth-sliding panels that conceal or reveal your collection with a gentle push. Ideal for modern homes, it offers a clean, clutter-free look while protecting books from dust. Choose glass panels for a sleek display or solid wood for a minimalist aesthetic.',9000,65,'Bookshelf with Sliding Panels.jpg',3,'2025-06-23 01:49:59'),
(30,'Compact Bookshelf for Small Spaces','Designed for tight corners and cozy nooks, this space-saving bookshelf delivers big on style and storage. Its slim profile and vertical design make it perfect for apartments, studios, or reading corners. Despite its size, it offers ample room for books, dÃ©cor, and essentials.',8600,86,'Compact Bookshelf for Small Spaces.jpg',3,'2025-06-23 01:50:45'),
(31,'Corner-bookshelf-unit','Make the most of unused corners with this cleverly designed bookshelf. Its angled structure fits snugly into any corner, transforming dead space into a stylish storage solution. With multiple tiers, itâs ideal for books, plants, or decorative accents.',12000,89,'Corner-bookshelf-unit.png',3,'2025-06-23 01:51:32'),
(32,'Floating Wall Bookshelves','Add a touch of modern magic with these gravity-defying shelves. Mounted directly to the wall, they create a clean, airy look while showcasing your favorite reads and dÃ©cor. Perfect for minimalist interiors, they free up floor space and elevate your wall game.',9800,98,'Floating Wall Bookshelves.jpg',3,'2025-06-23 01:52:24'),
(33,'Industrial Pipe Frame Bookshelf','Bold and rugged, this bookshelf combines metal piping with rustic wood for an urban loft vibe. Its open design and sturdy frame make it a standout piece in any roomâideal for books, plants, or vintage collectibles.',9625,102,'Industrial Pipe Frame Bookshelf.jpg',3,'2025-06-23 01:53:17'),
(34,'Kidsâ Animal-Themed Bookshelf','Turn tidying up into a jungle adventure! This playful bookshelf features adorable animal shapes and vibrant colors that spark imagination. Safe, sturdy, and fun, itâs perfect for nurseries, playrooms, or classrooms.',9360,59,'Kids’ Animal-Themed Bookshelf.jpg',3,'2025-06-23 01:54:47'),
(35,'Ladder-Style Bookshelf','Lean into style with this sleek, ladder-inspired design. Its tiered shelves offer a modern, airy look while providing plenty of space for books and dÃ©cor. Lightweight and easy to move, itâs a favorite for contemporary and Scandinavian interiors.',9999,99,'Ladder-Style Bookshelf.jpg',3,'2025-06-23 01:55:34'),
(36,'Rotating Bookshelf Tower','A true showstopper, this 360Â° rotating tower makes accessing your books a breeze. With a compact footprint and vertical design, itâs ideal for small spaces. Great for organizing books, toys, or office supplies with a twistâliterally.',7850,78,'Rotating Bookshelf Tower.jpg',3,'2025-06-23 01:56:18'),
(37,'Rustic Wooden Bookshelf','Crafted from solid wood with a weathered finish, this bookshelf exudes warmth and character. Its natural grain and sturdy build make it a timeless addition to farmhouse, cottage, or vintage-inspired spaces.',8960,65,'Rustic Wooden Bookshelf.jpg',3,'2025-06-23 01:57:14'),
(38,'Bathroom Storage Cabinet','Keep your bathroom neat and stylish with our Bathroom Storage Cabinet. Designed to hold toiletries, towels, and cleaning essentials, it features moisture-resistant materials and smart shelving. Choose from wall-mounted or freestanding options to suit your space, with finishes that complement both modern and traditional bathrooms.',8950,89,'Bathroom Storage Cabinet.jpg',4,'2025-06-23 02:00:55'),
(39,'Cabinet with Sliding Doors','Sleek and space-saving, this Cabinet with Sliding Doors is ideal for rooms where swing-out doors arenât practical. The smooth-glide panels reveal ample storage for books, dinnerware, or office supplies. Its minimalist design and clean lines make it a versatile fit for contemporary interiors.',8632,59,'Cabinet with Sliding Doors.jpg',4,'2025-06-23 02:03:22'),
(40,'Corner Storage Cabinet','Make the most of every inch with our Corner Storage Cabinet. Designed to tuck neatly into unused corners, it offers tiered shelving or rotating carousels for easy access. Whether in the kitchen, bathroom, or living room, it transforms awkward spaces into functional storage zones.',7520,75,'Corner Storage Cabinet.png',4,'2025-06-23 02:04:16'),
(41,'Glass Door Display Cabinet','Showcase your treasures in style with our Glass Door Display Cabinet. Featuring tempered glass panels and adjustable shelves, itâs perfect for displaying collectibles, fine china, or dÃ©cor. The transparent design adds elegance while protecting items from dust and damage.',10200,101,'Glass Door Display Cabinet.jpg',4,'2025-06-23 02:05:01'),
(42,'Metal Locker Cabinet','Durable and secure, the Metal Locker Cabinet is built for utility. Ideal for offices, gyms, or industrial settings, it features multiple compartments with lockable doors. Its powder-coated finish resists rust and wear, while ventilation slots ensure airflow for stored items.',12520,112,'Metal Locker Cabinet.jpg',4,'2025-06-23 02:05:57'),
(43,'Modern Wooden Filing Cabinet','Organize your workspace with sophistication using our Modern Wooden Filing Cabinet. Crafted from premium wood with smooth-glide drawers, it accommodates both letter and legal-size files. The clean design and warm finish make it a stylish addition to any home office.',15620,186,'Modern Wooden Filing Cabinet.jpg',4,'2025-06-23 02:06:49'),
(44,'Modular Kitchen Cabinet','Upgrade your culinary space with our Modular Kitchen Cabinet system. Designed for flexibility and efficiency, it includes customizable units for drawers, shelves, and built-in appliances. Available in a range of finishes and layouts, it brings both beauty and functionality to your kitchen.\r\n',22630,216,'Modular Kitchen Cabinet.png',4,'2025-06-23 02:07:48'),
(45,'Shoe Storage Cabinet','Say goodbye to cluttered entryways with our Shoe Storage Cabinet. With multiple tiers and closed compartments, it keeps your footwear organized and out of sight. Choose from sleek modern styles or rustic wooden finishes to match your homeâs aesthetic.',9980,98,'Shoe Storage Cabinet.JPG',4,'2025-06-23 02:08:53'),
(46,'Wall-Mounted Storage Unit','Maximize vertical space with our Wall-Mounted Storage Unit. Ideal for small rooms or minimalist interiors, it offers open or closed compartments for books, dÃ©cor, or essentials. Its floating design adds a modern touch while keeping your floorÂ areaÂ clear.',15321,123,'Wall-Mounted Storage Unit.jpeg',4,'2025-06-23 02:09:56'),
(49,'Barrel Chair','With its rounded back and wraparound arms, the barrel chair offers a cozy, cocoon-like feel. Inspired by the shape of a barrel, this chair is both stylish and supportiveâideal for reading nooks, lounges, or as a statement piece in your living room.',8630,158,'Barrel Chair.jpg',5,'2025-06-23 02:18:26'),
(50,'Dining Chair Set','Elevate your dining experience with our beautifully crafted Dining Chair Set. Designed for both comfort and style, each chair features a supportive backrest, cushioned seat, and sturdy frameâideal for long meals and lively conversations. Whether you prefer the timeless charm of solid wood, the sleek appeal of upholstered finishes, or the modern edge of metal accents, this set complements a wide range of dining tables and interiors. Available in sets of 2, 4, or 6, itâs perfect for everything from cozy breakfasts to festive dinner parties. Durable, elegant, and easy to maintainâthis is seating that brings people together.',23210,205,'Dining Chair Set.jpg',5,'2025-06-23 02:19:35'),
(51,'High-Back Executive Chair','Designed for productivity and posture, the high-back executive chair features ergonomic support, adjustable height, and plush cushioning. Perfect for home offices or corporate settings, it combines professional style with all-day comfort.',13560,210,'High-Back Executive Chair.jpg',5,'2025-06-23 02:20:35'),
(52,'Leather Club Chair','Exuding vintage charm and luxury, the leather club chair is known for its deep seat, low back, and rolled arms. Traditionally upholstered in rich leather, itâs a classic choice for libraries, lounges, or sophisticated living rooms.',12630,250,'Leather Club Chair.jpg',5,'2025-06-23 02:21:52'),
(53,'Rocking Chair','A symbol of relaxation, the rocking chair features curved legs that allow a gentle back-and-forth motion. Whether traditional wooden or modern upholstered, itâs perfect for nurseries, porches, or cozy corners where comfort is key.',15300,213,'Rocking Chair.jpg',5,'2025-06-23 02:23:25'),
(54,'Swing Chair','Add a playful and relaxing vibe with a swing chair. Suspended from the ceiling or a stand, it offers a gentle swaying motion and is often crafted from rattan, wicker, or fabric. Ideal for balconies, patios, or boho-inspired interiors.',13560,216,'Swing Chair.jpg',5,'2025-06-23 02:24:14'),
(55,'Swivel Chair','Functional and fun, the swivel chair rotates 360 degrees, offering flexibility and ease of movement. Common in offices and modern living rooms, itâs available in sleek, upholstered designs that blend comfort with contemporary flair.',9860,212,'Swivel Chair.jpg',5,'2025-06-23 02:25:21'),
(58,'Concrete Top Table','Bold and industrial, the Concrete Top Table makes a striking statement. Its solid concrete surface is both durable and stylish, offering a raw, textured look that pairs beautifully with metal or wood bases. Ideal for modern lofts or outdoor-inspired interiors, itâs built to last and impress.',26653,122,'Concrete Top Table.jpg',6,'2025-06-23 02:29:33'),
(59,'Drop Leaf Table','Smart and space-saving, the Drop Leaf Table adapts to your needs. With hinged sides that fold down when not in use, itâs perfect for compact spaces or multifunctional rooms. Whether used as a dining table or a console, its versatility and charm make it a practical favorite.',7530,65,'Drop Leaf Table.jpg',6,'2025-06-23 02:30:35'),
(60,'Extendable Dining Table','Designed for flexibility, the Extendable Dining Table expands to accommodate extra guests with ease. Whether itâs a quiet dinner or a festive gathering, this table adjusts to fit the moment. Available in wood, glass, or engineered finishes, itâs a stylish solution for dynamic living.',19999,153,'Extendable Dining Table.jpg',6,'2025-06-23 02:31:53'),
(61,'High Dining Table','Elevate your dining experienceâliterallyâwith the High Dining Table. Also known as a bar-height or counter-height table, it adds a casual, contemporary vibe to kitchens or open-plan spaces. Pair it with tall stools for a relaxed, social setting thatâs perfect for entertaining.',15632,123,'High Dining Table.jpg',6,'2025-06-23 02:32:44'),
(62,'Minimalist White Table','Clean, crisp, and effortlessly chic, the Minimalist White Table is a modern essential. Its smooth white finish and simple silhouette bring a sense of calm and clarity to your dining area. Ideal for Scandinavian, Japandi, or minimalist interiors.',11052,52,'Minimalist White Table.jpg',6,'2025-06-23 02:38:24'),
(63,'Outdoor Patio Dining Table','Built to brave the elements, the Outdoor Patio Dining Table combines weather-resistant materials with stylish design. Whether crafted from teak, metal, or HDPE, it offers a sturdy surface for alfresco meals and gatherings. A must-have for garden parties and sunny brunches.',16723,15325,'Outdoor Patio Dining Table.jpg',6,'2025-06-23 02:40:44'),
(64,'Oval Dining Table Set','Elegant and inviting, the Oval Dining Table softens your space with its curved edges and graceful form. It encourages conversation and flow, making it ideal for family meals or formal dinners. Available in wood, glass, or marble finishes to suit your style.',23000,123,'Oval Dining Table.jpg',6,'2025-06-23 02:41:52'),
(65,'Foldable Balcony Chairs','Compact, stylish, and easy to store, these foldable balcony chairs are perfect for small outdoor spaces. Crafted from durable materials like Sheesham wood or powder-coated metal, they offer comfort and portability without compromising on aestheticsâideal for balconies, patios, or terraces.',8500,85,'Foldable Balcony Chairs.jpg',7,'2025-06-23 02:44:12'),
(66,'Foldable Picnic Table','Designed for convenience and adventure, this foldable picnic table is lightweight yet sturdy. With a weather-resistant surface and collapsible frame, itâs perfect for camping, garden parties, or impromptu outdoor meals. Easy to carry, easier to enjoy.',12560,135,'Foldable Picnic Table.jpg',7,'2025-06-23 02:46:05'),
(67,'Folding Deck Chair','Relax in timeless style with this classic folding deck chair. Featuring a wooden or metal frame and a sling-style fabric seat, it offers a laid-back vibe for sunbathing, reading, or lounging by the pool. Folds flat for easy storage and transport.',5630,56,'Folding Deck Chair.jpg',7,'2025-06-23 02:47:02'),
(68,'Garden Bench with Backrest','A charming addition to any garden or patio, this bench combines comfort with rustic elegance. The supportive backrest and spacious seat make it perfect for long chats or quiet moments outdoors. Available in wood, cast iron, or FRP finishes.',9654,65,'Garden Bench with Backrest.jpg',7,'2025-06-23 02:47:52'),
(69,'Hammock Swing Chair','Float into relaxation with this cozy hammock swing chair. Made from soft cotton or velvet, itâs perfect for balconies, porches, or shaded garden corners. With its gentle sway and boho-inspired design, itâs a dreamy escape in your own backyard.',16520,125,'Hammock Swing Chair.jpg',7,'2025-06-23 02:48:36'),
(70,'Outdoor Bar Table Set','Turn your patio into a social hub with this outdoor bar table set. Featuring a high table and matching stools, itâs ideal for sipping cocktails or enjoying casual meals. Crafted from weather-resistant materials like wicker, teak, or metal for lasting style.',15236,156,'Outdoor Bar Table Set.jpg',7,'2025-06-23 02:49:26'),
(71,'Outdoor Metal Bistro Set','Chic and compact, this metal bistro set is perfect for balconies, decks, or garden corners. With its weather-resistant finish and elegant design, itâs ideal for morning coffee or evening wine under the stars. Includes a round table and two matching chairs.',5622,85,'Outdoor Metal Bistro Set.jpg',7,'2025-06-23 02:50:15'),
(72,'Teak Wood outdoor Rocking Chair','Crafted from premium teak wood, this outdoor rocking chair offers unmatched durability and natural beauty. Its ergonomic design and smooth rocking motion make it a favorite for porches, patios, or garden retreats. A timeless piece for tranquil moments.',7520,75,'Teak Wood outdoor Rocking Chair.jpg',7,'2025-06-23 02:51:05'),
(73,'Waterproof Bean Bag Lounger','Lounge in comfortârain or shine. This waterproof bean bag lounger is made from weather-resistant fabric and filled with soft beads for ultimate relaxation. Lightweight and portable, itâs perfect for poolside lounging, patios, or even indoor chill zones.',12444,124,'Waterproof Bean Bag Lounger.jpg',7,'2025-06-23 02:52:09'),
(75,'Armless Sofa','Sleek and space-efficient, the Armless Sofa brings a minimalist touch to your living space. Without bulky armrests, it offers a streamlined silhouette and flexible seating arrangements. Great for small rooms or as part of a modular setup.',12560,145,'Armless Sofa.jpg',8,'2025-06-23 02:54:27'),
(76,'high back seat','Designed for superior support, the High Back Seat provides extended comfort for your neck and shoulders. Ideal for long hours of sitting, itâs perfect for reading, relaxing, or working from home. Available in executive and casual styles to suit any setting.',12566,189,'high back seat.jpg',8,'2025-06-23 02:55:17'),
(77,'L shaped Sofa','Maximize seating and style with the L-Shaped Sofa. Its corner-hugging design is perfect for open-plan living rooms, offering ample space for lounging or entertaining. Choose from left- or right-aligned configurations to fit your layout.',16325,124,'l shaped.jpg',8,'2025-06-23 02:56:14'),
(78,'modular sofa set','Flexible and functional, the Modular Sofa Set adapts to your lifestyle. Composed of movable sections, it allows you to customize the layout to suit your space. Ideal for growing families or dynamic interiors that evolve over time.',26540,145,'modular sofa set.jpg',8,'2025-06-23 02:57:15'),
(79,'Recliner Sofa','Unwind in luxury with the Recliner Sofa. Featuring adjustable backrests and footrests, it offers personalized comfort at the touch of a button or lever. Perfect for movie nights, reading, or simply relaxing after a long day.',25000,125,'Recliner Sofa.jpg',8,'2025-06-23 02:57:56'),
(80,'Sleeper Sofa with Storage','A multitasking marvel, the Sleeper Sofa with Storage transforms from a stylish seat to a cozy bed in seconds. Hidden compartments offer space to store bedding, pillows, or seasonal itemsâideal for small homes or guest rooms.',15234,187,'Sleeper Sofa with Storage.jpg',8,'2025-06-23 02:58:45'),
(81,'sofa cum bed','Smart and space-saving, the Sofa Cum Bed is perfect for compact living. It functions as a comfortable sofa by day and converts into a bed at nightâgreat for overnight guests or studio apartments.',12456,125,'sofa cum bed.jpg',8,'2025-06-23 03:00:44'),
(82,'velvet sofa','Add a touch of opulence with the Velvet Sofa. Its rich texture and vibrant sheen create a luxurious focal point in any room. Soft to the touch and visually striking, itâs a favorite for elegant, statement-making interiors.',13487,154,'velvet sofa.jpg',8,'2025-06-23 03:02:13'),
(83,'Compact Study Nook with Drawers','Designed for small spaces with big ambitions, this compact study nook features a streamlined desk and built-in drawers for essential storage. Whether tucked into a bedroom corner or hallway alcove, it creates a focused workspace without overwhelming the room.',7589,78,'Compact Study Nook with Drawers.jpg',9,'2025-06-23 03:04:15'),
(84,'Foldable Laptop Table','Lightweight, portable, and practicalâthis foldable laptop table is your go-anywhere workstation. With a sturdy surface, cup holder, and device slots, itâs perfect for working from bed, sofa, or balcony. Folds flat for easy storage when not in use.',1560,299,'Foldable Laptop Table.jpg',9,'2025-06-23 03:05:18'),
(85,'Kidsâ Study Table with Organizer','Make learning fun and organized with this vibrant kidsâ study table. Featuring built-in compartments, pen holders, and a spacious top, it keeps books and supplies within easy reach. Rounded edges and playful colors make it safe and appealing for young learners.',5500,55,'Kids’ Study Table with Organizer.png',9,'2025-06-23 03:06:11'),
(86,'Minimalist Writing Table','Sleek and understated, this minimalist writing table is all about clean lines and clutter-free focus. With a smooth surface and optional drawer, itâs ideal for journaling, laptop work, or creative thinking. A perfect fit for modern, airy interiors.',7520,75,'Minimalist Writing Table.jpg',9,'2025-06-23 03:08:01'),
(87,'Scandinavian Style Study Table','Inspired by Nordic simplicity, this Scandinavian-style table features light wood tones, tapered legs, and a calming aesthetic. Functional yet beautiful, it includes open shelving or drawers for essentialsâideal for serene, stylish study spaces.',4250,45,'Scandinavian Style Study Table.jpg',9,'2025-06-23 03:08:54'),
(88,'Study Desk with Bookshelf Combo','Maximize vertical space with this smart desk-and-bookshelf combo. The integrated shelving keeps books, files, and dÃ©cor organized while the spacious desktop supports focused work. A great solution for students, professionals, or home offices.',7530,75,'Study Desk with Bookshelf Combo.jpg',9,'2025-06-23 03:09:39'),
(89,'Study Desk with Hutch','Stay organized and inspired with this study desk featuring a built-in hutch. The upper shelves are perfect for books, dÃ©cor, or stationery, while the lower drawers and desktop offer ample workspace. A classic choice for productivity with style.',4520,48,'Study Desk with Hutch.jpg',9,'2025-06-23 03:10:38'),
(90,'Study Table with Whiteboard Surface','Think, write, and erase with easeâthis study table doubles as a whiteboard! Ideal for brainstorming, tutoring, or creative planning, it includes a smooth, dry-erase surface and sturdy legs. A fun and functional upgrade for learners of all ages.',1250,450,'Study Table with Whiteboard Surface.jpg',9,'2025-06-23 03:11:36'),
(91,'Wall-Mounted Foldable Study Desk','Save space without sacrificing function. This wall-mounted foldable desk flips down when needed and folds away when not in use. Perfect for compact homes, it creates an instant study zone in bedrooms, hallways, or even kitchens.',3560,158,'Wall-Mounted Foldable Study Desk.jpg',9,'2025-06-23 03:12:36'),
(92,'dfbhdsb','rrjfjrehvfdugeh e',45221,45,'Blue Chair.jpg',5,'2025-06-24 11:18:22');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `phone` varchar(15) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `added_by` varchar(50) DEFAULT NULL,
  `security_question` varchar(255) DEFAULT NULL,
  `security_answer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`email`,`password`,`role`,`created_at`,`updated_at`,`phone`,`image`,`address`,`added_by`,`security_question`,`security_answer`) values 
(1,'Anand','Anand@gmail.com','Anand','Admin','2025-06-19 12:24:21','2025-06-24 12:11:08','8815904556','images/IMG_20240607_144429.jpg','Tatiharakala ward no.5 mauganj Rewa madhyapradesh',NULL,'what is your nickname?','Beta'),
(2,'Aman','Aman@gmail.com','Aman@123','Customer','2025-06-19 12:24:21','2025-06-19 12:24:21',NULL,NULL,NULL,NULL,NULL,NULL),
(3,'Ankit Patel','Ankit@gmail.com','Ankit@123','Customer','2025-06-19 12:33:24','2025-06-19 12:33:24',NULL,NULL,NULL,NULL,NULL,NULL),
(4,'Anshu','Anshu@gmail.com','Anshu@123','Customer','2025-06-19 21:46:03','2025-06-19 21:46:03',NULL,NULL,NULL,NULL,NULL,NULL),
(5,'pragyeypatel','ap6447739@gmail.com','Pragyey@123','admin','2025-06-22 11:11:15','2025-06-22 11:11:15','8815904554',NULL,'08,van shree nagar, navlakha,indore','Anand',NULL,NULL),
(6,'praann','abcde@gmail.com','praann@123','customer','2025-06-22 20:27:52','2025-06-24 06:56:49','8827602605','images/IMG_20240607_144429.jpg','Tatiharakala ward no.5 mauganj Rewa madhyapradesh',NULL,'what is your name','lucky'),
(7,'Ayush Patel','ayush@gmail.com','Ayush@123','customer','2025-06-24 06:27:48','2025-06-24 09:57:11','7654382763','','Tatiharakala ward no.5 mauganj Rewa madhyapradesh',NULL,'What is your favorite color?','Blue'),
(8,'Pradumn','pradumn@gmail.com','Pradumn@123','member','2025-06-24 10:59:09','2025-06-24 10:59:09','2316516545','images/pradhum.jpg','08,van shree nagar, navlakha,indore','Anand',NULL,NULL),
(9,'Aman','Amang@gmail.com','a,man@123','customer','2025-06-24 11:09:18','2025-06-24 11:09:17','8815904554','','08,van shree nagar, navlakha,indore',NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
