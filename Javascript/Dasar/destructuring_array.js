let iniArray = ["UJUN", "Danu", "Tamjit", "Hendra", "Hendri"]

let [nama1, nama2, nama3] = iniArray        // tidak terjadi error meskipun jumlah variable tidak sebanyak jumlah elemen array
console.log(nama1)
console.log(nama2)
console.log(nama3)

console.log('')

let [orang1, orang2, orang3, ...punggal] = iniArray      // pakai spread syntax
console.log(orang1)
console.log(orang2)
console.log(orang3)
console.log(punggal)
