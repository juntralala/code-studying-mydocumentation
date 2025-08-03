/*
default value adalah value yang diberikan kepada parameter
jika kita tidak memasukan nilai parameter ketika pemanggilan
function
*/

function tambah(a = 0, b = 0) {
    return a + b
}

console.log(tambah())
console.log(tambah(5))
console.log(tambah( 5 , 5 ))