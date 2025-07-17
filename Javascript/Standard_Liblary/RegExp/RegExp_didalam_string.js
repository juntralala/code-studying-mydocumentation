/** Regular Expression di String
 * Di JavaScript, tipe data string memiliki instance method yang dapat memanfaat kan RegExp untuk melakukan
   pencarian
    +===========================+===============================================================+
    | String Method             | Keterangan                                                    |
    +===========================+===============================================================+
    | match(regex): Array       | Mencari semua data yang sesuai dengan regex                   |
    | search(regex): index      | Mencari index data yang sesuai dengan regex                   |
    | replace(regex, value)     | mengubah data dengan value yang sesuai dengan regex           |
    | replaceAll(regex, value)  | mengubah semua data dengan value yang sesuai dengan regex     |
    | split(regex): Array       | Memotong string regex                                         |
    +===========================+===============================================================+
*/


const names = "ujun ejun udin ojun ijun"

console.log("Match not global   : ", names.match(/[aiueo]jun/i))
console.log("Match global       : ", names.match(/[aiueo]jun/ig))
console.log("Search not global  : ", names.search(/[aiueo]jun/i))
console.log("Search global      : ", names.search(/[aiueo]jun/ig))
console.log("Replace not global : ", names.replace(/[aiueo]jun/i, "SAYA"))
console.log("Replace global     : ", names.replace(/[aiueo]jun/ig, "SAYA"))
console.log("Replace All global : ", names.replaceAll(/[aiueo]jun/ig, "SAYA")) // kalau tidak pakai modifier global akan muncul warning
console.log("split              : ", names.split(/j/))

