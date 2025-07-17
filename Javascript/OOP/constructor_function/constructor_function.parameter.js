/** Parameter di Constructor Function
 * Karena dalam Javascript class adalah berbentuk function, jadi secara default function tersebut memiliki
   parameter
 * Contructor function sama seperti function biasanya, yaitu bisa memiliki parameter, hal ini membuat ketika
   kita membuat object, kita bisa mengirim data langsung lewat parameter di contructor function tersebut
 */

function Person(name, age) {
    this.name = name
    this.age = age
    this.intro = function() {
        console.log(`Hallo, my name is ${this.name}`)
    } 
}

let ujun = new Person("UJUN", 19)

ujun.intro()

