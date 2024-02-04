/**
 * Bagaimana bisa property di protototype bisa diakses dari object instance
 * Ketika kita mengakses property di object instance, pertama akan di cek apakah di object tersebut terdapat
   property tersebut atau tidak. Jika tidak, maka akan di cek di __proto__(prototype) nya, jika masih tidak
   ada, akan di cek lagi di __proto__(prototype) yang lebih tinggi, begitu deterusnya, sampai berakhir di 
   Object Prototype
 */