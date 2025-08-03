/** Method di Contructor Function 
 * Sama seperti pada tipe data object lainnya, kita juga bisa menambahkan method di contructor function
 * Jika kita tambahkan method di contructor function, secara otomatis object akan memilikimethod tersebut 
 */

function Person() {
    this.name
    this.age
    this.intro = function() {
        console.log(`Hallo, my name is ${this.name}`)
    } 
}

let ujun = new Person()
ujun.name = "UJUN"
ujun.age = 19

ujun.intro()