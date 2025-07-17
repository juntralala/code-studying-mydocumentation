/**
 * Menambah Property ke Prototype
 * Property itu mirip object, dimana kita bisa menambah property baik itu value ataupun method
 * Saat kita menambah property ke prototype secara otomatis semua object instance turunan dai object
   instance yang turunan dati prototype tersebut akan memiliki property tersebut
 */

function Person(name, age) {
    this.name = name
    this.age = age
    this.intro = function() {
        console.log(`Hallo, my name is ${this.name}`)
    } 
}

let ujun = new Person("UJUN", 19)
let dawi = new Person("Dawi",22)

Person.prototype.bye = () => {
    console.log(`Good Bye`)
} 

ujun.bye()
dawi.bye()
 

console.log(ujun)
console.log(dawi)