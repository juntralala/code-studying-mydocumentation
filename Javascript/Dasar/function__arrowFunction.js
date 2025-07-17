/*
arrow function mirip seperti anonymous function

kekerungan arraow function dibanding functcion biasa
1. tidak memiliki fitur aguments object
2. tidak bisa menggunkan fitur function generator
3. tidak bisa mengkasies this
4. tidak bisa mengakses super
*/

const sapa = (nama) => {
    console.log(`Hai ${nama}`)
}
sapa("Muhammad Juniadi")

const sapa2 = (nama) => console.log(`Hai ${nama}`)
sapa2("Muhammad Juniadi")

const tambah = (a, b) => a+b
console.log(tambah( 10, 10))

// jika hanya ada 1 parameter pada arrao function kita bisa
// tidak menggunkan ()
const sapa3 = nama => console.log(`Hai ${nama}`)
sapa3("Muhammad Junaidi")



