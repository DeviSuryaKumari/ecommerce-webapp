--USE e-commerce-database;

CREATE TABLE IF NOT EXISTS users(
 user_id INT AUTO_INCREMENT,
 name VARCHAR (20) NOT NULL,
 username VARCHAR (20) NOT NULL,
 password VARCHAR (80) NOT NULL,
 email VARCHAR (20) NOT NULL,
 role ENUM('CUSTOMER', 'SELLER') NOT NULL,
 is_logged_in SMALLINT NOT NULL,
 PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS products(
 product_id INT AUTO_INCREMENT,
 name VARCHAR (20) NOT NULL,
 description VARCHAR (40) NOT NULL,
 price FLOAT NOT NULL,
 quantity_available INT NOT NULL,
 seller_id INT NOT NULL,
 FOREIGN KEY (seller_id) REFERENCES users(user_id) ON DELETE CASCADE,
 PRIMARY KEY (product_id)
);

CREATE TABLE IF NOT EXISTS categories(
 category_id INT AUTO_INCREMENT,
 name VARCHAR (20),
 PRIMARY KEY (category_id)
);

-- m2m in table name indicates many-to-many relationship between entities
CREATE TABLE IF NOT EXISTS product_category_m2m(
 product_id INT NOT NULL,
 FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE,
 category_id INT NOT NULL,
 FOREIGN KEY (category_id) REFERENCES categories(category_id) ON DELETE CASCADE,
 PRIMARY KEY (product_id, category_id)
);

CREATE TABLE IF NOT EXISTS orders(
 order_id INT AUTO_INCREMENT,
 user_id INT NOT NULL,
 FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
-- YYYY-MM-DD hh:mm:ss
 order_date DATETIME NOT NULL,
 order_status ENUM('PLACED', 'PROCESSING', 'DELIVERED') NOT NULL,
 total_price DOUBLE NOT NULL,
 PRIMARY KEY (order_id)
);

-- m2m in table name indicates many-to-many relationship between entities
CREATE TABLE IF NOT EXISTS order_product_m2m(
 order_id INT NOT NULL,
 FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE,
 product_id INT NOT NULL,
 FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE,
 PRIMARY KEY (order_id, product_id),
 quantity INT NOT NULL
);

