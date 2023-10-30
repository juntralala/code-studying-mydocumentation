console.clear()

let arrayNama = ["ujun","Dayat","Amat","Udin"]
console.table(arrayNama)

arrayNama.push("Ipul") // menambah element array diposisi akhir
console.table(arrayNama)

console.info(arrayNama.length)

delete arrayNama[2]     // menghapus element array tanpa menggeser index
console.table(arrayNama)
console.log(arrayNama.length) // panjang array setelah dihapus tidak berubah





