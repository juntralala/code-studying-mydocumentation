/**
 * Dalam contructor biasanya kita membuat property baik itu berisi value atau pun function
 * Didalam contructor, kita bisa memanggil contructor lain, dengan begitu kita bisa mewarisi semua property
   yang dibuat di contructor lain tersebut
 * Untuk memanggil contructor lain, kita bisa gunakan nama NamaContructor.class(this, parameter)
 * lebih tepatnya ini mencopy, bukan inheritance
 */

function Person(name, age) {
    this.name = name
    this.age = age
}

function Man(name, age, address) {
  Person.call(this, name, age)
  this.address = address 
}

let pria = new Man("UJUN", 19, "Handil")