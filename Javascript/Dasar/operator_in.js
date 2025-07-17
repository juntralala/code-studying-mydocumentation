let orang = {
    namaDepan : "Muhammad",
    namabelakang : "Junaidi"
}
if ("Muhammad" in orang) {
    console.log("true")
} else {
    console.log("false")
}
if ("namaDepan" in orang) {
    console.log("true")
} else {
    console.log("false")
}

let arrayName = ["UJUN","UDIN","IPUL","AMAT"]
let cekNama = "UJUN" in arrayName 
let cekIndex = 0 in arrayName 
console.log(cekNama)
console.log(cekIndex)

delete arrayName[1]
cekIndex = 0 in arrayName
console.log(cekIndex)   // meski sudah dihapus tetap bernilai true