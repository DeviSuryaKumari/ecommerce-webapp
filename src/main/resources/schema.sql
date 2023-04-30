CREATE TABLE IF NOT EXISTS users(
 user_id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR (20) NOT NULL,
 username VARCHAR (20) NOT NULL,
 password VARCHAR (40) NOT NULL,
 email VARCHAR (20) NOT NULL,
 role ENUM('Customer', 'Seller') NOT NULL,
 is_logged_in TINYINT NOT NULL
);

CREATE TABLE IF NOT EXISTS products(
 product_id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR (20) NOT NULL,
 description VARCHAR (40) NOT NULL,
 price FLOAT NOT NULL,
 quantity_available INT NOT NULL,
 seller_id INT FOREIGN KEY NOT NULL
);

CREATE TABLE IF NOT EXISTS categories(
 category_id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR (20)
)

-- m2m in table name indicates many-to-many relationship between entities
CREATE TABLE IF NOT EXISTS product_category_m2m(
 product_id INT PRIMARY KEY FOREIGN KEY,
 category_id INT PRIMARY KEY FOREIGN KEY,
)

CREATE TABLE IF NOT EXISTS orders(
 order_id INT PRIMARY KEY AUTO_INCREMENT,
 user_id INT FOREIGN KEY,
 order_date DATETIME NOT NULL,
 order_status ENUM('PLACED', 'PROCESSING', 'DELIVERED') NOT NULL,
 total_price DOUBLE NOT NULL
)

-- m2m in table name indicates many-to-many relationship between entities
CREATE TABLE IF NOT EXISTS order_product_m2m(
 order_id INT PRIMARY KEY FOREIGN KEY,
 product_id INT PRIMARY KEY FOREIGN KEY,
 quantity INT NOT NULL
)

