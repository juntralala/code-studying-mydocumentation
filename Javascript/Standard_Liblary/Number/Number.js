/** Number
 * Number merupakan function yang digunakan untuk konversi ke tipe data number
 * Jika data tidak bisa dikonversi ke number, secara otomatis hasinya adalah NaN
 * https://developer.mozilla.org/en-US/docs.Web/JavaScript/Reference/Global_Objects/Number
 */

const integer = "1234"
const decimal = "1234.12"
const input = "1234.12huruf"

const number = Number(input)

console.log(typeof input)
console.log(typeof number)

console.log(Number("BUKAN ANGKA"))