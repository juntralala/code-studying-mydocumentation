/** BigInt
 * BigInt merupakan tipe data Number yang bisa mencakup data angka lebih dari Number.MAX_SAFE_INTEGER
 * Untuk kasus number yang lebih dari itum sangat disarankan menggunakan tipe data BigInt
 * Cara penggunaan BigInt sana saja dengan penggunaan Number dan juga operator nya
 * BigInt cuman menerima bilangan bulat
 * htpps://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/BigInt  
*/

const a = BigInt(1024)
const b = BigInt("9394")
const c = 928n

console.log(typeof c)
console.log(Number.MAX_SAFE_INTEGER * 2)