/** Operator instanceof
 * Kadang ada kasus dimana kita ingin mengecek aoakah sebuah object merupaakn instance dari class tertentu
   atau bukan
 * Kita tidak bisa menggunakan operator typeof, karena object dari class, jika kita gunakan operator
   typeof, hasilnya adalah "object"
 * Operator instanceof akan menghasilkan boolean, true jika benar object tersebut adalah instance dari object nya
   false jika bukan
*/

/** Operator instance of di Class Inheritance
 * Operator instanceof mendukung class inheritance, artinya instanceof juga bisa digunkan untuk mengecek
   apakah sebuah object adalah instce dari class tertentu atau turunan dai class tertentu
*/

class Employee{}

class Manager extends Employee{}

const ozon = new Employee()
const ujun = new Manager()

console.log(ozon instanceof Employee) // true
console.log(ujun instanceof Employee) // false (jika bukan turunan Emplyee)  // true (jika turunan Employee)

console.log(ozon instanceof Manager) // false 
console.log(ujun instanceof Manager) // true

