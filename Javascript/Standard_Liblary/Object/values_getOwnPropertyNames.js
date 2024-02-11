/** Object Property Name & Value
 * Object juga memiliki static method untuk digunakan mengambil semua properties dam value
 * Object.values() digunakan untuk mengambil semua property value
 * Object.getOwnPropertyNames() digunakan untuk menambil semua property name
 */

const person = {
    callingName: "Ujun",
    fisrtName: "Muhammad",
    lastName: "Junaidi"
}

let values = Object.values(person)
let propertyNames = Object.getOwnPropertyNames(person)

console.log(values)
console.log(propertyNames)