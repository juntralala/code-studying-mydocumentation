/** Date Getter dan Setter
 * Date juga memiliki banyak sekali method untuk mendapatkan informasi date dan juga mengubah informasi
   date, atau istilahnya getter dan setter
 * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Date#instance_methods
*/

const tanggal = new Date()
tanggal.setDate("20")

console.log("getFullYear() : ", tanggal.getFullYear())
console.log("getMonth () : ", tanggal.getFullYear())
console.log("getDate() : ", tanggal.getDate())
console.log("getHours() : ", tanggal.getHours())
console.log("getMinutes() : ", tanggal.getMinutes())
console.log("getSeconds() : ", tanggal.getSeconds())
console.log("getMiliseconds() : ", tanggal.getMilliseconds())
console.log("getTimezoneOffset() : ", tanggal.getTimezoneOffset())
