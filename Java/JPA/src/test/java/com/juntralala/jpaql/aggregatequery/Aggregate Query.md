# Aggregate Query
* JPA juga mendukung banyak sekali aggregate function seperti MIN, MAX, AVERAGE, dan lain-lain
* Keuntungan menggunakan aggregate function di JPA QL, dia bisa otomatis mentranslate ke aggregate function di database yang kita gunakan
* Untuk mengecek aggregate function yang didukung oleh JPA QL, kita harus lihat implementasi dari JPA Provider nya
* Contohnya di Hibernate ORM, kita bisa lihat daftar aggregate function yang didukung disini : 
* https://docs.jboss.org/hibernate/orm/6.2/userguide/html_single/Hibernate_User_Guide.html#hql-aggregate-functions 
