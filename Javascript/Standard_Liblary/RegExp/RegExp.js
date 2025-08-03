/** RegExp
 * RegExp merupakan implementasi dari regular expression di JavaScript\
 * Regular Expression merupakan fitur untuk mencari text dengan pola
 * Mebuat regular expression di Javascript bisa dilakukan dengan 2 cara, yaitu menggunakan literal notation
   dan membuat object RegExp
 * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/RegExp
*/

// cara pembuatan regex
let regExpNotasi= /ujun/
let regExpObject1 = new RegExp("ujun")
let regExpObject2 = new RegExp(/ujun/)

console.log(regExpNotasi)
console.log(regExpObject1)
console.log(regExpObject2)

console.log(typeof regExpNotasi)
console.log(typeof regExpObject1)
console.log(typeof regExpObject2)
