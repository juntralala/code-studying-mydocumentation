/**
 * Javascript sebelumnya dikenal dengan bahasa pemrograman yang berbasis prototype
 * Memeang agak sedikit membingungkan dan tidak bisa dipungkiri banyak sekali yang bingung dengan konsep 
   prototype di javascript
 * Pada chapter ini, kita akan bahas tentang konsep prototype 
 */

/**
 * Saat kita membuat object dari contructor function , object tersebut disebut instance , semua property
   baik value atau method, akan berada di instance object nya
 * Setiap kita membuat constructor function, maka secara otomatis akan dibuatkan prototypenya, misal kita
   membuat contructor function Person, maka akan ada Person.prototype
 * Saat kita membuat sebuah object instance, secara otomatis object tersebut adalah turunan dari
   Contructor.prototype nya
 * Untuk mengakses sebuah prototype milik sebuah instance, kita bisa menggunakan __proto__ 
 */

/** Prototype
 *  Di JavaScript, setiap objek memiliki properti yang disebut prototype. 
 *  Prototype adalah suatu objek yang menyimpan properti dan metode yang dapat diakses oleh semua instansi
    objek yang dibuat dari suatu konstruktor. Dengan kata lain, prototype adalah cara untuk berbagi
    properti dan metode di antara objek-objek yang dibuat dari konstruktor yang sama.
 */