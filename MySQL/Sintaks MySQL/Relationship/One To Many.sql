/**
 * One to many relationship adalah relasi antar table dimana satu data bisa digunakan lebih dari satu kali ditable relasinya   
 * Berbeda dengan one to one yang bisa dugunakn cuman maksimal 1 kali di table relasinya, one to many tidak ada batasan berapa
   banyak data yang digunakan 
*/

/**
 * Contoh relasi antar table categories dan product, dimana kategori bisa digunakan oleh lebih dari satu product, yaitu relasinya
   one category to many product
 * Pembuatan relasi one to many sebenarnya sama dengan one to one, yang membedakan adalah, kita tidak perlu menggunakan unique key
   karena datanya memang bisa digunbakan/ditambahkan berkali-kali ditable relasinya
*/

CREATE TABLE categories(
    id VARCHAR(10) NOT NULL,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id) 
);

CREATE TABLE products (
    id VARCHAR(10) NOT NULL,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price INT UNSIGNED NOT NULL,
    quantity INT UNSIGNED NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_category VARCHAR(10) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_product_category FOREIGN KEY (id_category) REFERENCES categories (id) 
);