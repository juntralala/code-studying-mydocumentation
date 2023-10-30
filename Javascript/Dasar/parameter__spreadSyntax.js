/*
terkadang kita terlanjur memiliki tipedata array
untungnya kita juga bisa mengirimkan array kerest parameter
kita bisa gunakan ...(titik tiga) diikuti dengan arraynya ketika pemangggilan function
fitur ini dinamakan SPREAD SYNTAX
*/

function totalNilai(nama , ...nilai_nilai) {
    let total = 0
    for (const nilai of nilai_nilai) {
        total += nilai
    }
    console.log(`nama : ${nama}\n$Total nilai : ${total}`)
}


let arrayNilai = [98,85,65,75]

totalNilai("Arsyad", ...arrayNilai)
totalNilai("Arsyad", ...[98,85,65,75])