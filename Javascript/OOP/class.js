/** Membuat Class
 * Sejak EcmaScript versi 6, diperkenalkan katakunci baru, yaitu class, ini merupakan katakunci yang
   digunakan untuk class di Javascript
 * Dengan katakunci class, kita tidak perlu lagi menggunakan contructor function untuk membuat class 
 */

// sebenarnya tidak ada bedanya pada implementasi OOP nya antara contructor function dan class
// dua duanya masih memiliki protorype, sama-sama based protorype

class Person {
}

const ujun = new Person()
console.log(ujun)