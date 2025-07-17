/** Array Loop
 * Sebelumnya kita bisa menggunakan for in dan for of untuk mengiterasi Array, namun Array juga bisa
   memiliki method yang bernama forEach()
 * Method forEach bisa digunakan untuk mengiterasi data Array
 */

const array = ["ujun", "Muhammad", "Junaidi"]

array.forEach((value) => console.log(value))
array.forEach((value, index) => console.log(`${index} : ${value}`))