//                         CONSTRUCTOR FUNCTION
// ini cara pembuatan object sebelum EcmaScript V6

/** Membuat Object 
 * Sebenarnya kita sudah belajar tipe data object, dengan cara membuat variable dengan tipe data object
 * Namun pembuatan object dengan tipe data object, akan selalu membuat object selalu unik, sedangkan di OOP
   biasanya kita akan membaut class sebagai cetakan, sehingga bisa membuat object dengan karakteristik yang
   sama berkali-kali tanpa harus tanpa harus mendeklarasikan object berkali-kali seperti menggunakan tipe
   data object 
 */

/** Membuat constructor function
 * Sebelum EcmaScript Versi 6, pembuatan class biasanya menggunakan function. Hal ini dikarenakan
   sebenarnya, Javascript bukanlah bahasa pemrograman yang berfokus ke OOP
 * Untuk membuat class di javascrip lama, biasanya kita membuat function
 * function ini kita sebut constructor function
*/

/** Membuat Object dari Constructor Function 
 * Setelah membuat class(constructor fucntion), jika kita ingin membuat object dari class tersebut, kita
   bisa gunakan kata kunci new, lalu diikuti dengan constructor function nya  
 */

function Person() {
}

let orang = new Person()