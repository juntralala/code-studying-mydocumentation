# Grouping Constraint
* Secara default, saat Validator melakukan validasi, validator akan memvalidasi semua field yang memiliki constraint
* Kadang, ada saatnya misal kita ingin melakukan pengecekan beberapa hal saja pada kondisi tertentu, misal terdapat satu class yang digunakan untuk beberapa aksi, sehingga membutuhkan kombinasi validasi yang berbeda
* Dalam kasus ini, kita bisa menggunakan Grouping Constraints
* Grouping Constraint merupakan teknik mengelompokkan constraint yang terdapat di class
* Dengan menambahkan group, saat melakukan validasi, kita bisa memilih group mana yang akan divalidasi
* Setiap constraint bisa memiliki lebih dari satu grup
