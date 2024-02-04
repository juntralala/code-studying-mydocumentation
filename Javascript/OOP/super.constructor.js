/**
 * Penjelasan ada di contructor.js
 */

class Hero {
    constructor(name, role){
        this.name = name
        this.role = role
    }
}

class Marksman extends Hero{
    constructor(name){
        super(name, "Marksman")
    }
}

miya = new Marksman("Miya")
console.log(miya)