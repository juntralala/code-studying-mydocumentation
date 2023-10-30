Many To Many adalah Table Relashion Ship yang paling kompleks, dan kadang membingungkan untuk pemula
Many To Many adalah relasi dimana ada relasi antar 2 table yang mana table pertama pertama bisa memiliki banyak relasi
  ditable kedua, dan table kedua juga punyak relasi di table pertama
Ini memang sedikit membingungkan, bagaimana caranya bisa relasi kebanyak secara bolak balik, sedangkan di table kita cuman
  punya 1 kolom untuk foreign key?
Contoh relasi Many TO Many adalah relasi antara prosuk dan penjualan, dimana setiap produk bisa dijual berkali-kali,
  dan setiap penjualan bisa untuk lebih dari satu produk

#PROBLEM# Bagaimana Implementasi Many To Many?
Sekarang pertanyaanya, bagaimana implementasi Many TO Many?
Apakah kita harus menambahkan id_order di table product? atau id_product di table orders? 

#TRY SOLVING# Id Product di table Order
Jika kita menambahkan id_product di table orders, artinya sekarang sudah benar, bahwa produk bisa di jual berkali-kali
Namun masalahnya adalah 1 order hanya bisa membeli 1 product, karena cuman ada 1 kolom untuk id_product
Ok kalo gitu kita tambahkan id_product1, id_product2, dan seterusnya. Solusi ini bisa dilakukan, tabi tidak baik, karena 
  akan selalu ada maksimal barang yang kita beli dalam satu order 
#TRY SOLVING# Id Order di table Product
Jika kita tambahkan id_order di table products, artinya satu order bisa membelih lebih dari 1 product, ok sudah benar
Tapi sayang nya sekarang masalahnya terbalik, satu product cuman bisa dijual satu kali, tidak bisa dijual berkali-kali,
  karena id_order nya cuman 1
Kalupun kita tambah id_order1, id_order2 dan seterusnya di table product, tetap ada batasan maksimal nya
Lantas bagaimana solusinya untuk relasi many to many

#SOLVING# Membuat Table Relasi Penengah
Solusi yang biasa dilakukan jika terjadi relas many to many adalah bisanya kita akan menambah 1 table dingahnya
Table ini bertugas sebagai jembatan untuk mengabungkan relasi many to many
Isi table penengah ini akan ada id dari table pertama dan table kedua, dalam kasus ini adalah id_product dan id_order
Dengan demikian, kita bisa menambahkan beberapa data ke dalam table relasi ini, sehingga berarti satu product bisa
  dijual berkali-kali di table order, dan satu order bisa lebih dari 1 product   


CREATE TABLE orders (
  id  INT NOT NULL AUTO_INCREMENT,
  total INT NOT NULL DEFAULT 0,
  order_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

CREATE TABLE orders_detail (
  id_product VARCHAR(10) NOT NULL,
  id_order    INT         NOT NULL,
  price       INT         NOT NULL,
  quantity    INT         NOT NULL,
  PRIMARY KEY (id_product, id_order)
);

ALTER TABLE orders_detail 
ADD CONSTRAINT fk_orders_detail_product 
FOREIGN KEY (id_product)REFERENCES products (id);

ALTER TABLE orders_detail 
ADD CONSTRAINT fk_orders_detail_orders
FOREIGN KEY (id_order)REFERENCES orders (id);

