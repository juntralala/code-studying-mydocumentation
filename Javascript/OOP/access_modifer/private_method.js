/** Private Method
 * Sama sperti field, terdapat proposal juga untuk menambahkan fitur private method di EcmaScript
 * Dengan demikian, access modifier private juga sudah bisa digunakan di method
 * Caranya sama, dengan menambahkan # diawal method, maka secara otomatis method tersebut adalah private
 * Ingat fitur ini masih dalam tahapan, belum benar-benar menjadi standard EcmaScript, jadi mungkin tidak
   semua browser yang mendukung fitur ini
 * https://github.com/tc39/proposal-private-methods 
*/

class Person {
    name
    constructor(name){
        this.name = name
    }

    sapa(){
        if(this.name){
            this.#sapaPakeNama()
        } else {
            this.#sapaTanpaNama()
        }
    }

    #sapaTanpaNama(){
        console.log("Hai")
    }

    #sapaPakeNama(){
        console.log(`Hai, nama ku ${this.name}`)
    }
}


let ujun = new Person()

ujun.sapa()

ujun.name = "UJUN"
ujun.sapa()