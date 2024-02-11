/** Eposch & Unix Tme Stamp
 * Dalam Menggunakann tIpedata waktu, Biasanya di semua bahasa pemrograman akan mendukung yang namanya epoch
    & unix timestampp 
 * Epoch & UNix Timestamp hitungan milisecond setelah 1 January 1970
 * JavaScript pun mendukung pembuatan waktu dalam epoch dan unix  timestamp
 * Untuk mendapatkan waktu saat ini dalan epoch dan unix timestamp, kita bisa gunakan Date.now()
 * Untuk mengubah dari object Date ke epoch & dan unix timestamp, kita bisa gunakan function getTime()
*/

// biasanya jika melakukan komunikasi dengan app lain, akan dikirimkan dalam bentuk milisecond/epoch karna
// sudah di standarisasi

const tanggal = new Date()

console.info(tanggal.getTime())
console.info(Date.now())