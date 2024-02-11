/** Symbol For
 * Kadang agak sulit membuat Symbol harus selalu menggunakan variable
 * Pembuatan symbol juga bisa menggunakan static method Symbol.for(key)
 * Jika kita menggunakan key yang sama, Symbol yang sama akan selalu di kembalikan
*/

console.log(Symbol.for('foo') === Symbol.for('foo')) // true

const person = {}
person[Symbol.for('fisrtName')] = "Muhammad"
person[Symbol.for('lastName')] = "Junaidi"

console.log(person)
console.log(person[Symbol.for('fisrtName')])
console.log(person[Symbol.for('lastName')])