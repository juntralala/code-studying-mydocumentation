// with tidak direkomendasikan untuk digunakan
let orang = {
    namaDepan : "Muhammad",
    namaBelakang : "Junaidi",
    namaLengkap : "Muhammad Junaidi"
}

const namaDepan = "Budi"
const namaBelakang = "Nugraha"

with (orang) {
    console.log(namaDepan)
    console.log(namaBelakang)
    console.log(namaLengkap)
} 

console.log(orang.namaDepan)
console.log(orang.namaBelakang)
console.log(orang.namaLengkap)