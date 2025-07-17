/** Set
 * Set merupakan implementasi dari struktur data yang berisikan data-data unique
 * Set mirip seperti Array, bedanya isi dataya selalu unique (tidak sama)
 * Jika kita memsukkan data yang sama, maka data hanya akan diterima satu saja
 * Set mengimplementasikan kontrak iterable, sehingga ketika diiterasi secara default
 * https://developer.mozilla.org/en-US/docs/Web/Java/Reference/Global_Object/Set
*/

/** Set Instance Method & Property
    +===========================+===========================================+
    | Method & Property         | Keterangan                                |
    +---------------------------+-------------------------------------------+
    | size                      | Panjang Set                               |
    | add()                     | Menambah data ke Set                      |
    | has(value): boolean       | Mengecek Set apakah memiliki data value   |
    | delete(value)             | Menghapus value dari Set                  |
    | forEach((value) => )      | Melakukan iterasi Set                     |
    +===========================+===========================================+
*/

let set = new Set()

set.add("ujun")
set.add("ujun")
set.add("Muhammad")
set.add("Junaidi")

console.log(set)

set.forEach(value => {
    console.log(value)
})