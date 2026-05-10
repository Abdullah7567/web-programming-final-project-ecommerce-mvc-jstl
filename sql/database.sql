CREATE DATABASE IF NOT EXISTS ecommerce_mvc CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE ecommerce_mvc;

DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  full_name VARCHAR(100) NOT NULL,
  email VARCHAR(120) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  phone VARCHAR(30),
  address TEXT,
  role VARCHAR(20) NOT NULL DEFAULT 'CUSTOMER',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE categories (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  description TEXT,
  is_active BOOLEAN DEFAULT TRUE
);

CREATE TABLE products (
  id INT AUTO_INCREMENT PRIMARY KEY,
  category_id INT NOT NULL,
  name VARCHAR(150) NOT NULL,
  description TEXT,
  price DECIMAL(10,2) NOT NULL,
  stock INT NOT NULL DEFAULT 0,
  image_url VARCHAR(500),
  is_active BOOLEAN DEFAULT TRUE,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_products_category FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE orders (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  total_amount DECIMAL(10,2) NOT NULL,
  status VARCHAR(40) NOT NULL DEFAULT 'Beklemede',
  CONSTRAINT fk_orders_user FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE order_items (
  id INT AUTO_INCREMENT PRIMARY KEY,
  order_id INT NOT NULL,
  product_id INT NOT NULL,
  quantity INT NOT NULL,
  unit_price DECIMAL(10,2) NOT NULL,
  subtotal DECIMAL(10,2) NOT NULL,
  CONSTRAINT fk_items_order FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
  CONSTRAINT fk_items_product FOREIGN KEY (product_id) REFERENCES products(id)
);

INSERT INTO users(full_name,email,password,phone,address,role) VALUES
('Admin Kullanıcı','admin@site.com','240be518fabd2724ddb6f04eeb1da5967448d7e831c08c8fa822809f74c720a9','5551112233','Merkez','ADMIN'),
('Demo Müşteri','user@site.com','e606e38b0d8c19b24cf0ee3808183162ea7cd63ff7912dbb22b5e803286b4446','5554443322','Samsun','CUSTOMER');

INSERT INTO categories(name,description,is_active) VALUES
('Telefon','Akıllı telefon ürünleri',1),('Bilgisayar','Laptop ve masaüstü bilgisayarlar',1),('Aksesuar','Teknolojik aksesuarlar',1),('Kitap','Kitap ürünleri',1),('Giyim','Giyim ürünleri',1);

INSERT INTO products(category_id,name,description,price,stock,image_url,is_active) VALUES
(1,'Akıllı Telefon X','128 GB hafıza, güçlü kamera ve uzun pil ömrü.',18999.90,12,'https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?w=600',1),
(2,'Laptop Pro 15','16 GB RAM, 512 GB SSD, öğrenci ve ofis kullanımı için uygundur.',32999.00,7,'https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=600',1),
(3,'Kablosuz Kulaklık','Bluetooth bağlantılı, mikrofonlu kulaklık.',1499.50,25,'https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=600',1),
(4,'Java Programlama Kitabı','Servlet, JSP ve JDBC konularını içeren kaynak kitap.',450.00,18,'https://images.unsplash.com/photo-1512820790803-83ca734da794?w=600',1),
(5,'Basic T-Shirt','Pamuklu rahat günlük tişört.',299.99,0,'https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?w=600',1);
