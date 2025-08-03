/** Super Contructor
 * Class Inheritance sifatnya sama seperti Prototype Inheritance
 * Bagaimana dengan Contructor Inheritance? Sebenarnya Constructor Inheritance hanyalah malakukan eksekusi
   contructor lain dengan tujuan agar property di contructor lain dapat ditambahkan ke instance object ini
 * Dalam kasus ini, jika kita ingin mencapai hasil yang sama, kita bisa gunakan kata kunci super didalam
   contructor
 * Kata kunci super digunakan untk memanggil contructor super class
 * Jika child class kita membuat contructor, maka kita wajib memanggil parent contructor, walaupun diparent
   tidak ada contructor 
*/

// keyword super untuk memanggil contructor superclass nya

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