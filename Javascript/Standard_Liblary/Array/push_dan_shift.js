/** Array Queue
 * Dalam Struktur Data, terdapat tipe struktur data benama Queue (Antrian)
 * Dimana data masuk akan di posisikan paling belakang
 * Sedangkan data keluar akan diposisikan dari urutan paling depan
 * Mirip sekali dengan antrian, atau istilahnya FIFO (First In First Out)
 * Kita bisa menggunakan Array dengan bantuan function push() untuk menambahkan data di belakang, dan shift()
   untuk mengambil data dan menghapus data paling depan
*/

const queue = []

queue.push("ujun")
queue.push("Muhammad")
queue.push("Junaidi")

console.log(queue.shift())
console.log(queue.shift())
console.log(queue.shift())
console.log(queue.shift())

