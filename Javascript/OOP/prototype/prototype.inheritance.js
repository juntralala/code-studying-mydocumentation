/**
 * Konsep prototype penting dalam warisan (inheritance) di JavaScript, di mana satu objek dapat "mewarisi" 
   properti dan metode dari objek lainnya melalui prototipe.
 */

// contoh kode ada di prototype.menambah_properti.js

/** Protorype Inheritance 
 * Sekarang kita tahu, bahwa prototype selalu memiliki parent, artinya dia adalah turunan, parent tertinggi
   adalah Object prototype 
 * Pertanyaannya bagaimana jika kita ingin melakukan inherintance ke Prototype lain?
 * Hal ini juga bisa dilakukan, namun agak sedikit tricky, karena hal ini sebenarnya untuk javascript modern
   tidak direkomendasikan lagi prektek OOP menggunakan Prototype, karena di ES6 sudah dikenal kata kunci
   class yang akan nanti dibahas di chapter tersendiri
 */

console.log("\ncontoh pewarisan prototype yang BENAR")

function Emplyee() {
}

function Manager() {
}

Manager.prototype = Object.create(Emplyee.prototype)

Emplyee.prototype.sayHello = function() {
    console.log("Hello, I'm Eployee")
}

Manager.prototype.sayHello = function() {
    console.log("Hello, I'm Manager") 
}

let pegawai = new Emplyee()
let menejer = new Manager()

pegawai.sayHello()
menejer.sayHello()




console.log("\n\ncontoh pewarisan prototype yang salah SALAH")
function Employee() {
}

function Manager() {
}

Manager.prototype = Employee.prototype

Employee.prototype.sayHello = function() {
    console.log("Hello, I'm Eployee")
}

Manager.prototype.sayHello = function() {
    console.log("Hello, I'm Manager")
}

let employee = new Employee()
let manager = new Manager()

employee.sayHello()
manager.sayHello()
