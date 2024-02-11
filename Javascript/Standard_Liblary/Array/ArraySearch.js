/** Array Search
 * Array memiliki bayak function untuk melakukan pencarian
    +=======================================+=======================================+
    | Function                              | Keterangan                            |
    +---------------------------------------+---------------------------------------+
    | find(value => boolean): value         | Mencari data sesuai kondisi           |
    | findIndex(value => boolean): number   | Mencari Index sesuai kondisi          |
    | includes(value): boolean              | Mengecek apakah terdapat data         |
    | indexOf(value): number                | Mengecek posisi index data            |
    | lastIndexOf(value): number            | Menegecek posisi Index data terakhir  |
    +=======================================+=======================================+ 
*/


const datas = ["ujun", "dawi", "amang", "udin", "adul", "ujun", "utuh"]

console.log(datas.find(value => value.length > 4 ))
console.log(datas.findIndex(value => value === "amang" ))
console.log(datas.includes("udin"))
console.log(datas.indexOf("ujun"))
console.log(datas.lastIndexOf("ujun"))

