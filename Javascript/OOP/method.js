/**
 * Membuat method di class sebenarnya, bisa dilakukan dengan cara sama seperti menambahkan method di 
   contructor function 
 * Namun, hal tersebut sebenarnya menambahkan method ke dalam instance object
 * Khusus untuk method sebaiknya kita menambahkan ke prototype, bukan ke instance object
 * Untungnya di class, ada cara mudah menambahkan method dan secara otomatis ditambahkan ke prototype
 */

class Person {
    constructor(name){
        this.name = name
        this.sapa = function() {
            console.log(`hello`)
        }
    }

    intro() {
        console.log(`I'am ${this.name}`)
    }
}

const ujun = new Person("ujun")
console.log(ujun)
console.log(ujun.__proto__)