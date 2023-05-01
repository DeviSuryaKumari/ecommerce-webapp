use ecommercedb;

set FOREIGN_KEY_CHECKS = 0;
truncate table users;
truncate table products;
truncate table categories;
truncate table product_category_m2m;
truncate table orders;
truncate table order_product_m2m;
set FOREIGN_KEY_CHECKS = 1;

-- users seed data
INSERT INTO users(name, username, password, email, role, is_logged_in) VALUES ('seller1', 'seller1', 'pswd1', 'seller1@gmail.com', 'SELLER', false);
INSERT INTO users(name, username, password, email, role, is_logged_in) VALUES ('seller2', 'seller2', 'pswd2', 'seller2@gmail.com', 'SELLER', false);
INSERT INTO users(name, username, password, email, role, is_logged_in) VALUES ('seller3', 'seller3', 'pswd3', 'seller3@gmail.com', 'SELLER', false);
INSERT INTO users(name, username, password, email, role, is_logged_in) VALUES ('seller4', 'seller4', 'pswd4', 'seller4@gmail.com', 'SELLER', false);
INSERT INTO users(name, username, password, email, role, is_logged_in) VALUES ('seller5', 'seller5', 'pswd5', 'seller5@gmail.com', 'SELLER', false);

INSERT INTO users(name, username, password, email, role, is_logged_in) VALUES ('customer1', 'customer1', 'pswd6', 'customer1@gmail.com', 'CUSTOMER', false);
INSERT INTO users(name, username, password, email, role, is_logged_in) VALUES ('customer2', 'customer2', 'pswd7', 'customer2@gmail.com', 'CUSTOMER', false);
INSERT INTO users(name, username, password, email, role, is_logged_in) VALUES ('customer3', 'customer3', 'pswd8', 'customer3@gmail.com', 'CUSTOMER', false);
INSERT INTO users(name, username, password, email, role, is_logged_in) VALUES ('customer4', 'customer4', 'pswd9', 'customer4@gmail.com', 'CUSTOMER', false);
INSERT INTO users(name, username, password, email, role, is_logged_in) VALUES ('customer5', 'customer5', 'pswd10', 'customer5@gmail.com', 'CUSTOMER', false);

-- products seed data
INSERT INTO products(name, description, price, quantity_available, seller_id) VALUES ('product1', 'product1', 10, 5, 1);
INSERT INTO products(name, description, price, quantity_available, seller_id) VALUES ('product2', 'product2', 20, 5, 2);
INSERT INTO products(name, description, price, quantity_available, seller_id) VALUES ('product3', 'product3', 30, 5, 3);
INSERT INTO products(name, description, price, quantity_available, seller_id) VALUES ('product4', 'product4', 40, 5, 4);
INSERT INTO products(name, description, price, quantity_available, seller_id) VALUES ('product5', 'product5', 50, 5, 5);
INSERT INTO products(name, description, price, quantity_available, seller_id) VALUES ('product6', 'product6', 60, 5, 1);
INSERT INTO products(name, description, price, quantity_available, seller_id) VALUES ('product7', 'product7', 70, 5, 2);
INSERT INTO products(name, description, price, quantity_available, seller_id) VALUES ('product8', 'product8', 80, 5, 3);
INSERT INTO products(name, description, price, quantity_available, seller_id) VALUES ('product9', 'product9', 90, 5, 4);
INSERT INTO products(name, description, price, quantity_available, seller_id) VALUES ('product10', 'product10', 100, 5, 5);

-- categories seed data
INSERT INTO categories(name) VALUES ('category1');
INSERT INTO categories(name) VALUES ('category2');
INSERT INTO categories(name) VALUES ('category3');
INSERT INTO categories(name) VALUES ('category4');
INSERT INTO categories(name) VALUES ('category5');

-- product_category_m2m seed data
INSERT INTO product_category_m2m(product_id, category_id) VALUES (1, 1);
INSERT INTO product_category_m2m(product_id, category_id) VALUES (2, 1);
INSERT INTO product_category_m2m(product_id, category_id) VALUES (3, 2);
INSERT INTO product_category_m2m(product_id, category_id) VALUES (4, 2);
INSERT INTO product_category_m2m(product_id, category_id) VALUES (5, 3);
INSERT INTO product_category_m2m(product_id, category_id) VALUES (6, 3);
INSERT INTO product_category_m2m(product_id, category_id) VALUES (7, 4);
INSERT INTO product_category_m2m(product_id, category_id) VALUES (8, 4);
INSERT INTO product_category_m2m(product_id, category_id) VALUES (9, 5);
INSERT INTO product_category_m2m(product_id, category_id) VALUES (10, 5);

INSERT INTO product_category_m2m(product_id, category_id) VALUES (1, 5);
INSERT INTO product_category_m2m(product_id, category_id) VALUES (2, 5);
INSERT INTO product_category_m2m(product_id, category_id) VALUES (3, 3);
INSERT INTO product_category_m2m(product_id, category_id) VALUES (4, 3);
INSERT INTO product_category_m2m(product_id, category_id) VALUES (5, 4);
INSERT INTO product_category_m2m(product_id, category_id) VALUES (6, 4);
INSERT INTO product_category_m2m(product_id, category_id) VALUES (7, 2);
INSERT INTO product_category_m2m(product_id, category_id) VALUES (8, 2);
INSERT INTO product_category_m2m(product_id, category_id) VALUES (9, 1);
INSERT INTO product_category_m2m(product_id, category_id) VALUES (10, 1);

-- orders seed data
INSERT INTO orders(user_id, order_date, order_status, total_price) VALUES (6, '2023-04-29 13:45:12', 'PLACED', 55.0);
INSERT INTO orders(user_id, order_date, order_status, total_price) VALUES (7, '2023-04-21 11:25:17', 'PLACED', 45.0);
INSERT INTO orders(user_id, order_date, order_status, total_price) VALUES (8, '2023-04-04 08:15:46', 'PROCESSING', 120.0);
INSERT INTO orders(user_id, order_date, order_status, total_price) VALUES (9, '2023-03-09 11:25:17', 'DELIVERED', 90.0);
INSERT INTO orders(user_id, order_date, order_status, total_price) VALUES (10, '2023-04-30 14:37:09', 'PLACED', 79.0);

-- order_product_m2m seed data
INSERT INTO order_product_m2m(order_id, product_id, quantity) VALUES (1, 1, 2);
INSERT INTO order_product_m2m(order_id, product_id, quantity) VALUES (1, 2, 1);
INSERT INTO order_product_m2m(order_id, product_id, quantity) VALUES (2, 3, 3);
INSERT INTO order_product_m2m(order_id, product_id, quantity) VALUES (2, 4, 1);
INSERT INTO order_product_m2m(order_id, product_id, quantity) VALUES (3, 5, 2);
INSERT INTO order_product_m2m(order_id, product_id, quantity) VALUES (3, 6, 2);

INSERT INTO order_product_m2m(order_id, product_id, quantity) VALUES (4, 1, 2);
INSERT INTO order_product_m2m(order_id, product_id, quantity) VALUES (5, 2, 1);
INSERT INTO order_product_m2m(order_id, product_id, quantity) VALUES (4, 10, 3);
INSERT INTO order_product_m2m(order_id, product_id, quantity) VALUES (5, 7, 4);
INSERT INTO order_product_m2m(order_id, product_id, quantity) VALUES (2, 8, 2);
INSERT INTO order_product_m2m(order_id, product_id, quantity) VALUES (1, 9, 2);