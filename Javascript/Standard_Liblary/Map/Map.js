/**
 * Map merupakan representasidari struktur data key-value
 * Map mirip dengan tipe data object, hanya saja pada Map, semua method untuk manipulasi tipe data sudah
   sediakan
 * Map mengikuti kontak iterable, sehingga bisa di iterasi secara default
 * https:/developer.mozilla.org/en-US/docs/JavaScript/Reference/Global_Objects/Map 
*/

/** perbedaam Map dan Object
  +=====================================================+=================================================+
  | Map                                                 | Object                                          |
  +-----------------------------------------------------+-------------------------------------------------+
  | Pertama dibuat tidak memiliki key                   | Karena memiliki prototype, jadi bisa memiliki   |                                 
  |                                                     |  default key ketika pertama kali dibuat         |                             
  | Key bisa tipe data apapun                           | Key hanya bisa string atau symbol               |                             
  | Jumlah key bisa diketahui dengan jelas              | jumlah key tidak bisa diketahui, harus          |                             
  | attribute size                                      |  dihitung manual                                |     
  | Secara default tidak bisa dikonversi ke JSON        | bisa dikonversi ke JSON secara otomatis         |                             
  +=====================================================+=================================================+
*/

/** Map Instance Method & Property (beberapa)
    +===========================+===========================================+
    | Method & Property         | Keterangan                                |
    +---------------------------+-------------------------------------------+
    | size                      | Panjang Map                               |
    | clear()                   | Menghapus semua isi Map                   |
    | delete(key)               | Menghapus data Map berdasarkan key        |
    | get(key): value           | Mendapatkan data Map berdasarkan key      |
    | has(key): boolean         | Mengecek map apakah memiliki data key     |
    | set(key, value)           | mengubah data Map dengan key: value       |
    | forEach((value, key) => ) | melakukan iterasi Map                     |
    +===========================+===========================================+
*/

let map = new Map()
map.set("name", "ujun")
map.set("age", 19)
map.set("address", "Indonesai/KalimantanSelatan")

console.log(map)
console.log(map.get("name"))
console.log(map.get("age"))
console.log(map.get("address"))

map.forEach((value, key)=> {
    console.log(`${key}\t: ${value}`)
})

