/** Pengenalan JSON
 * JSON singkatan dari JavaScript Object Notation
 * JSON Merupakan data String yang bentuknya mirip dengan Javascript Object
 * Saat ini JSON banyak sejali digunakan untuk komunikasi antara Server dan Client
 * https://www.json.org/json-en.html
 */

/**
 * Javascript mendukung konversi data dari string JSON menjadi Object atau sebaliknya
 * JSON.stringify() digunakan untuk melakukan konversi dari String ke Object
 * https://developer.mozilla.org/en-US/docs/Web/Java/Reference/Global_Object/JSON
*/

let person = {
    nama: "UJUN",
    age: 19,
    address: {
        country: "Indonesia",
        city: "Banjarmasin"
    }    
}

const stringJson = JSON.stringify(person)
const jsonObject = JSON.parse(stringJson)

console.log("stringJson : ", stringJson)
console.log("jsonObject : ", jsonObject)



