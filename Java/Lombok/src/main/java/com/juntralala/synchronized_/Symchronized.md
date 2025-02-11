## Synchronized
* Saat belajar Java Thread, kita sudah tahu agar sebuat method aman dari race condition, kita biasanya menggunakan kata kunci synchronized, atau yang lebih baik adalah menggunakan Lock
* Lombok memiliki fitur untuk mempermudah kita ketika membuat Lock agar method yang kita buat aman dari race condition
* Kita bisa menggunakan annotation @Synchronized, dan jika kita ingin sharing lock dengan beberapa method, kita bisa gunakan value lock yang sama
