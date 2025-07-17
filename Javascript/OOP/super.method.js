/**
 * Selain untuk memanggil contructor di parent class nya, kata kunci super juga bisa dugunakan untuk
   memanggil function yang ada di parent class nya 
 */

class Hero {
    constructor(name, role){
        this.name = name
        this.role = role
    }

    attack() {
        console.log(`Hero ${this.name} menyerang`)
    }
}

class Marksman extends Hero{
    constructor(name){
        super(name, "Marksman")
    }

    attack() {
        console.log(`Marksman ${this.name} menyerang`)
    }

    attackParentClass(){
        super.attack()
    }
}

miya = new Marksman("Miya")

miya.attack()
miya.attackParentClass()