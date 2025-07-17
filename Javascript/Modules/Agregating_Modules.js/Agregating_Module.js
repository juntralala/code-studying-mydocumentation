/** Agregating Module
 * Kadang ada waktunya kita ingin meng agregate beberapa module mennjadi satu agar pengguaannya
   lebih sederhana
 * Jika module sudah banyak, maka ketika butuh banyak kode dari banyak module, maka kita harus sebutkan 
   sebutkan tersebut tiap kali kalo mau import  
 * Caranya sangat mudah, cukup gunakan perintah :
   export {a, b, c} from "./module.js"
*/

export { name, age } from "./datas.js"
export { sayHello } from "./sayHello.js"
export { Person } from "./Person.js"