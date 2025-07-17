/** Object Freeze dan Seal
 * Secara default, Object bida diubah atau dihapus properties nya
 * Jika kita ingin mengubah object menjadi object yang tidak bisa diubah atau dihapus, kita bisa
   menggunakan beberapa static method
 * Object.freeze() digunakan untuk mengubah object menjadi object yang tidak bisa diubah atau dihapus
   attributenya
 * Object.seal() digunakan untuk mengubah object menjadi object yang tidak bisa dihapus attributenya  
*/

const person = {
    firstName: "Muhammad",
    lastName: "Junaidi"
}

Object.freeze(person)
// Object.seal(person)

person.firstName = "Ahmad"
person.callingName = "ujun"
delete person.lastName

console.log(person)