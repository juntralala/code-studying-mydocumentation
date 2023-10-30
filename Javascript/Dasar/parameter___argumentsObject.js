/* 
sebelum restParameter ada digunakan argumentsObject
namun ini sudah tidak disarankan lagi
*/

function totalNilaiOld() {
    let total = 0
    for (const value of arguments) {
        total += value
    }
    return total
}

let nama = "Muhammad Junaidi"
let totalNilai = totalNilaiOld(100,100,100,100)

console.log(`Nama : ${nama}\nTotal nilai : ${totalNilai}`)