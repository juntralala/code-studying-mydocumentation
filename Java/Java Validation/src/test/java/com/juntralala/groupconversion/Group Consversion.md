# Group Conversion
* Kadang ada kasus dimana terdapat sebuah class yang sudah memiliki field group, namun ternyata kita membutuhkan class tersebut di embed di class lain, sedangkan class lain menggunakan group berbeda
* Pada kasus seperti ini, kita bisa melakukan konversi grup
* Untuk melakukan konversi group, kita bisa menggunakan annotation @ConvertGroup, lalu tentukan dari group apa ke group apa

> jika tidak dilakukan conversion, nested validation tidak akan dijalankan