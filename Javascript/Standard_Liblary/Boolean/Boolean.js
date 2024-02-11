/** Boolean
 * Boolean merupakan wrapper class untuk tipe data primitif boolean
 * Boolean memiliki method toString() untuk mengkonversi ke string
 * Dan memiliki method valueOf() untuk mengkonversi ke tipe boolean primitif
 * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Boolean
// memang tidak banyak yang bisa method tambhan pada object Boolean
*/

let boolean = Boolean(true)

console.log(boolean)
console.log(boolean.toString())
console.log(boolean.valueOf())


// tidak disarankan untuk menggunakan new Boolean(), karna hasil typeof nya akan menjadi object
console.log(typeof new Boolean(true))
console.log( true === new Boolean(true))
console.log(  true === Boolean(true))

