/*
rest parameter adalah satu parameter yang dapat menerima banyak argument
yang kemudian dikonversi menjadi array
*/

function totalNilai(nama , ...nilai_nilai) {
    let total = 0
    for (const nilai of nilai_nilai) {
        total += nilai
    }
    console.log(`nama : ${nama}\n$Total nilai : ${total}`)
}

totalNilai("Arsyad",98,85,65,75)

