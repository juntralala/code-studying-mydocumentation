/** Array Stack
 * Struktur data Stack (Tumpukan) kebalikan dari Queue, dimana aturannya mirip dengan aturan kartu
 * Saat kita memasukkan data, kita akan memasukkannya di urutan paling atas (atau belakang)
 * Sedangkan saat kita mengambil data, kita akan mengambil data paling atas (atau belakang), terlebih dulu 
 * Stack ini sifatnya LIFO(Last In Fisrt Out)
 * Untuk menambah di urutan paling belakang, kita bia menggunakan function push()
 * Dan untuk mengambil dan menghapus datapaling atas (atau belakang), kita gunakan function pop()
 */

const stack = []

stack.push("ujun")
stack.push("Muhammad")
stack.push("Junaidi")

console.log(stack.pop())
console.log(stack.pop())
console.log(stack.pop())
console.log(stack.pop())