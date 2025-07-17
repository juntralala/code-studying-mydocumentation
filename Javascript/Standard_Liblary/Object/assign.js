/** Object Assign 
 * Kadang ada kasus  menggabungkan semua attribute dari sebuah object ke object lain
 * Hal ini bisa kita lakukan dengan menggunakn Object.assign(target, source)
*/

// contoh 1
const target = {firstName: "Muhammad"}
const source = {lastName: "Junaidi"}

Object.assign(target, source)

console.log("target : ", target)
console.log("source : ", source)

/* contoh2 */ console.log('\r\n')

const target2 = {firstName: "Muhammad", lastName: "Humaidi"}
const source2 = {lastName: "Junaidi"}

Object.assign(target2, source2) // lastName: "Humaidi" akan di timpa

console.log("target : ", target2)
console.log("source : ", source2)