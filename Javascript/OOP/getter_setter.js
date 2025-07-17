/**
 * Class juga mendukung pebuatan getter dan setter
 * Perlu diingat, getter dan setter ini akan berada di prorotype, bukan di instance object
 * sebelumnya ini sudah di bahas di Javascript dasar 
*/

class Person{
    constructor(firstName, lastName){
        this.firstName = firstName
        this.lastName = lastName
    }

    get fullName(){
        return `${this.firstName} ${this.lastName}`
    }

    set fullName(fullName){
        const result = fullName.split(' ', 2)
        this.firstName = result[0]
        this.lastName = result[1]
    }
}

let ujun = new Person()
ujun.fullName = "Muhammad Junaidi"
console.log(ujun)