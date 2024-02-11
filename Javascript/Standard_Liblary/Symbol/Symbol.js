/** Symbol
 * Symbol merupakan tipe data yang digaransi akan selalu unique setiap kali kita membuat tipe data Symbol
 * Symbol kadang banyak digunakan untuk membuat key pada object
 * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Symbol
*/

const symbol = Symbol()
const symbol1 = Symbol('foo') // teks yang dimasukkan cuman sebagai deskripsi bukan value, supaya musah saat di debug
const symbol2 = Symbol('foo')
console.log(symbol1 === symbol2) // false

// <<<=====================================================================>>>
const fisrtName = Symbol()
const lastName = Symbol()

const person = {}
person[fisrtName] = "Muhammad"
person[lastName] = "Junaidi"

console.log(person)
console.log(person[fisrtName])
console.log(person[lastName])