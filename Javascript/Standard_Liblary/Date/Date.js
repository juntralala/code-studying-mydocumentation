/** Date 
 * Javascript memiliki tipe data untuk merepresentasikan waktu dan tanggal, yaitu Date
 * Date merupkan representasi milisecond sejak tanggal 1 January 1970, atau dikenal dengan Epoch & Unix Timestamp
 * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Date
*/

/** Membuat Object Date
 * new Date()                       -> Membuat Date waktu saat ini
 * new Date(year, month, date)      -> Membuat Date dengan tanggal
 * new Date(year, month, date?, hour?, minute?, second?, milis?) -> membuat date sampai dengan milis
 * new Date(timestamp)              -> Membuat date dari epoch adatu unix timestamp
*/

let tanggal = new Date("01-02-2024")
let tanggal2 = new Date()
let tanggal3 = new Date("2024-02-01 06:36:30.000")
let tanggal4 = new Date("2024-02-01T06:36:30.000")

console.info(tanggal.toLocaleDateString())
console.info(tanggal2)
console.info(tanggal3)
console.info(tanggal4)