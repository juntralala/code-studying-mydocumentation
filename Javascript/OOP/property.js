/** Property di class
 * Sama seperti pada constructor function, dalam class pun kita bisa menambahkan property
 * Karena hasil akhirnya adalah sebuah object, jadi sama saja, menambahkan property di class juga bisa
   dilakukan di instance object nya  
 */

class Person{
    constructor(name) {
        this.name = name
    }
}

let orang = new Person("orang")
orang.age = 19

console.log(orang)