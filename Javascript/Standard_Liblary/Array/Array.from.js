/**
 * Array.from() digunakan untuk membuat array baru dari array-like object. Metode ini memungkinkan kita
   mengonversi berbagai jenis objek menjadi array.
 * Array-like object adalah objek yang mirip dengan array dalam hal struktur, tetapi tidak benar-benar
   objek array. Array-like object memiliki elemen yang dapat diakses menggunakan indeks numerik dan
   memiliki properti length yang menunjukkan jumlah elemen. Namun, array-like object tidak memiliki method 
   array seperti push, pop, atau forEach, yang biasanya terkait dengan objek array sejati. 
 * spesifikasi object agar bisa dikonversi menjadi array menggunakan Array.from() :
   - Menyediakan property length
   - Element dapat diakses dengan index
 */

// contoh Array-Like Object
const arrayLike = {
    0: "Muhammad",
    1: "Junaidi",
    2: "ujun",
    3: "ini Array-Like Object",
    length: 4                      // <- jika lengt cuman 3 maka data yang dijadikan array 3 saja
}

console.log(Array.from(arrayLike))

