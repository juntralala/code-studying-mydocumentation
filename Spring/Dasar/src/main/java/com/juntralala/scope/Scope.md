# Scope
* Scope merupakan strategy cara sebuah object dibuat
* Secara default strategy object di Spring adalah singleton, artinya hanya dibuat sekali, dan ketika kita akses, akan mengembalikan object yang sama
* Namun kita juga bisa mengubah scope bean yang kita mau di Spring
* Untuk mengubah scope sebuah bean, kita bisa tambahkan annotation @Scope(value=”namaScope”)

> contoh akses bean nya di ScopeTEst
