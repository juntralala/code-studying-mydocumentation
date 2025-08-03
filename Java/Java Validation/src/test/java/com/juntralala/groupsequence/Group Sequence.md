# Group Sequence    
* Saat kita melakukan validasi dengan beberapa group, tidak ada jaminan bahwa sebuah group akan dijalankan sebelum group yang lain
* Bean Validation memiliki annotation GroupSequence, ini digunakan untuk menentukan tahapan grup mana terlebih dahulu yang akan di validasi
* Kita bisa membuat group baru, lalu tambahkan annotation @GroupSequence, atau langsung di class nya
* Saat terjadi error validasi pada sebuah group, maka secara otomatis tidak akan dilanjutkan ke group selanjutnya
