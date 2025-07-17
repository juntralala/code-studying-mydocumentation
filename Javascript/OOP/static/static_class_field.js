/**
 * Jika kita menambahkan static dalam class field, secara otomatis field terebut tidak lagi milik instance
   object, melainkan milik class nya itu sendiri
 * Biasanya stattic digunakan, jika kita ingin membuat utility field atau function
 * Cara mengakses static field pun tidak lagi lewat object, melainkan lewat class nya
 * Static class field bisa diartikan sifatnya global, tidak peduli diakses dimana atau oleh siapa yang
   mengakses, hasilnya akan sama
 */

class Connfiguration {
    static name = "Belajar Javascript OOP"
    static version ="1.0.0"
    static author = "Muhammad Junaidi"
}

console.log(Connfiguration.name)
console.log(Connfiguration.version)
console.log(Connfiguration.author)