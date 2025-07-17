## Singleton
* Saat Java Web dijalankan, Servlet hanya akan dibuat satu kali, alias singleton
* Oleh karena itu, HTTP Request yang masuk akan selalu menggunakan Servlet yang sama
* Hal ini perlu diperhatikan, karena jika kode yang kita buat tidak Thread Safe, maka data antar HTTP Request bisa tertukar
* Oleh karena itu, pastikan kode yang kita buat harus Thread Safe


> contoh unsave: UnsaveServelet.java  
> contoh save: SaveServelet.java  
> contoh save: ServletCouter.java