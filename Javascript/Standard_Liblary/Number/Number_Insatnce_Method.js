/**
 * Number memiliki banya instance method, seperti :
 * Number.toLocalString(locale) untuk mengubah number menjadi string sesuai locale :
   https://www.lansweeper.com/knowledgebase/list-of-currency-culture-codes/
 * Number.toString(radix) untuk mengubah number menjadi string sesuai radix
 * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Number#instance_methods 
*/

// kalau static method harus diakses dari Class nya
// maka Instace method harus diakses dari instance object nya

// contoh beberapa nya

const num = Number("100000")

console.log(num.toString(2))
console.log(num.toLocaleString("id-ID"))
console.log(num.toLocaleString("en-US"))



let numb = 1324
console.log(numb.toString(2))




