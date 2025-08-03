/**
 * Reflect merupakan class yang digunakan untuk mengeksekusi Javascript function 
 * Refltct tidak memiliki constructor, dan cara penggunaan Reflect tidak dengan membuat object dengan cara
   new Reflect()
 * Cara penggunaan reflect adalah menggunakan static method nya yang banyak
 * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Reflect 
*/

const orang = {}

// set property
Reflect.set(orang, 'nama', "ujun")
Reflect.set(orang, 'umur', 19)

console.log(orang)

// get
console.log(Reflect.get(orang, 'nama'))
console.log(Reflect.get(orang, 'umur'))

// get
console.log(Reflect.has(orang, 'nama'))
console.log(Reflect.has(orang, 'umur'))
console.log(Reflect.has(orang, 'address'))