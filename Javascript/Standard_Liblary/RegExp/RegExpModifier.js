/** RegExp Modifier
 * RegExp memiliki modifier untuk mengubah sifat pencarian
    +==========-+=======================================================================+
    | Modifer   | Keterangan                                                            |
    +-----------+-----------------------------------------------------------------------+
    | i         | Regex menjadi incase sensitive                                        |
    | g         | Pencarian dilakukan secara global. Secara default setelah menemukan   |
    |           |  data pencarian akan berhenti                                         |
    | m         | Multiline, pencarian dilakukan di tiap baris (Enter)                  |
    +===========+=======================================================================+
 * Sebenarnya masih banyak lagi modifier RegExp selain yang disebutkan disini
*/

// defaultnya RegExp case sensitive

// contoh modier i
console.log("<<==================== contoh CASE SENSITIVE ====================>>")
const name1 = "ujun Muhammad ujun Junaidi"
const regex1 = /UJUN/

console.log("Hasil cari : ", regex1.exec(name1))
console.log("Data ditemukan : ", regex1.test(name1) )

console.log("\n\n<<==================== contoh CASE INSENSITIVE ====================>>")
const name2 = "ujun Muhammad ujun Junaidi"
const regex2 = /UJUN/i

console.log("Hasil cari : ", regex2.exec(name2))
console.log("Data ditemukan : ", regex2.test(name2) )

// contoh modifier g (global)
console.log("\n\n<--------------------- contoh Tidak GLOBAL --------------------->")
const name3 = "ujun Muhammad ujun Junaidi ujun"
const regex3 = /ujun/

var ke = 0
var hasil;
// while((hasil = regex3.exec(name3)) !== null){        // kalau tidak global tidak bisa di looping dan kalau di looping kan terjadi infinity looping 
//     console.log(`Hasil ke-${++ke} :  ${hasil}`)
// }

// ke = 0
// while((isExist = regex3.test(name3))){
//     console.log(`Data ditemukan ke-${++ke} :  ${isExist}`)
// }

console.log("\n\n<--------------------- contoh GLOBAL --------------------->")
const name4 = "ujun Muhammad ujun Junaidi ujun"
const regex4 = /ujun/g

ke = 0
while((hasil = regex4.exec(name4)) !== null){
    console.log(`Hasil ke-${++ke} :  ${hasil}`)
}

ke = 0
while((isExist = regex4.test(name4))){
    console.log(`Data ditemukan ke-${++ke} :  ${isExist}`)
}

// modifier m (multiline)
console.log("\n\n<==]>>>>>>>> contoh tidak MULTILINE <<<<<<<<<[==>")
const name5 = "Muhammad \nujun Junaidi ujun"
const regex5 = /^ujun/

console.log("Hasil cari : ", regex5.exec(name5))
console.log("Data ditemukan : ", regex5.test(name5) )


console.log("\n\n<==]>>>>>>>> contoh MULTILINE <<<<<<<<<[==>")
const name6 = "Muhammad \nujun Junaidi ujun"
const regex6 = /^ujun/m

console.log("Hasil cari : ", regex6.exec(name6))
console.log("Data ditemukan : ", regex6.test(name6) )


