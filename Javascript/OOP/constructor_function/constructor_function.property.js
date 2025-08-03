/** Property di Contutor Function 
 * Sebenarnya setela kita selesai membuat object, kita bisa dengan mudah menambahkan property ke dalam
   object tersebut hanya dengan menggunakn nama variable nya, diikuti tanda titik dan nama property
 * Namun jika seperti itu, maka contructor function yang sudah kita buat jadi tidak berguna, karna property
   nya hanya ada di object saja yang kita tambahkan property
 * Untuk menambahkan property didalam semua object yang dibuat contructor function, kita bisa gunakan katakunci
   this lalu diikuti dengan nama property nya
 */

function Person() {
    this.name
    this.age
}

let ujun = new Person()
ujun.name = "UJUN"
ujun.age = 19