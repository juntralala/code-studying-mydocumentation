/** Module Object
 * Ketika  sebuah module berisikan banyak sekali export data, maka melakukan import satu persatu akan terlihat berantakan
 * Rekomendasinya saat kita ingin mengimport module yang sangat banyak export datanya, gunakan module object
 * Module Object sederhananya adalah object javascript yang berisi atribute hasil export pada module
 * Cara membuat module object bisa kita lakukan seperti ini :
  import * as NamaModule from "./Module.js"
 * selanjutnya kita bisa gunakan NamaModule sebagai object untuk module tersebut
*/

let name = "Muhammad Junaidi"
let age = 19

function sapa(name){
    console.log(`hallo ${name}`)
}

class Person {
    constructor(name, age){
        this.name = name 
        this.age = age
    }

    sapa(name){
        console.log(`hallo ${name}`)
    }
}

export{name, age, sapa, Person}

