/** Parsinf Date (Mengubah string date ke milisecond)
 * Kita juga bisa melakukan parsing membuat string date menggunakan method Date.parse(value)
 * Format string harus YYYY-MMM-DDTHH-mm-ss.sssZ
 * Dimana jika kita hanya membuat date berisi tanggal saja, kita cukup gunakan YYYY-MM-DD
 * Jika date dengan tanggal dan waktu, gunakan YYYY-MMM-DDTHH-mm-ss.sss
 * Jika date dengan tanggal, waktu serta timezone, gunakan YYYY-MMM-DDTHH-mm-ss.sssZ
 * Hasil parsing adalah unix timestamp, bukan object date
*/

let milisecond = Date.parse("2024-02-08T08:00:00.000+08:00")

console.info(milisecond)

const tanggal = new Date(time)
console.info(tanggal)
