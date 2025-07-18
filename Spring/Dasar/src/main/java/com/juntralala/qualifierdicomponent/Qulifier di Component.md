# Qualifier
* Seperti yang sudah dijelaskan di awal, jika terdapat bean dengan tipe data yang sama lebih dari satu, maka secara otomatis Spring akan bingung memilih bean yang mana yang akan digunakan
* Kita perlu memilih salah satu menjadi primary, yang secara otomatis akan dipilih oleh Spring
* Namun jika kita ingin memilih bean secara manual, kita juga bisa menggunakan @Qualifier
* Kita bisa tambahkan @Qualifier di constructor parameter, di setter method atau di field
