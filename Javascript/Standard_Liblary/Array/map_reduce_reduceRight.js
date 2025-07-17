/** Array Tranform
 * Array juga memiliki function yang digunakan untuk melakukan transformasi
 +===============================================+======================================================+
 | Function                                      | Keterangan                                           |
 +-----------------------------------------------+------------------------------------------------------+
 | map(value => return): Array<result>           | Melakukan Transformasi ke tiap value dan menghasilkan| 
 |                                               | array result                                         |
 | reduce(resultBefore, value => result): result | Melakukan transform dengan menggunakan value array   |
 |                                               | dan value selanjutnya, lalu hasilnya di lanjutkan ke |
 |                                               | ke iterasi selanjutnya                               |
 | reduceRight(resultBefore, value => result):   | Sama seperti reduce() namun dilakukan dari belakang  |
 | result                                        |                                                      |
 +===============================================+======================================================+ 
*/

let names = "ujun, ozon, taichou, kapten, jendral, ujunun, ubun halus".split(', ')
let namesUpper = names.map(value => value.toUpperCase())
console.log(namesUpper)

let namesReduce = names.reduce((resultBefore , name) => resultBefore.concat(": ", name))
console.log(namesReduce)

let numbers = [1, 2, 3, 4, 5]
let numbersDouble = numbers.map(number => number ** 2)
console.log(numbersDouble)

