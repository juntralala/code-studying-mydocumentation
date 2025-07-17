/*
- this didalam object method referensi object saat ini
- this pada global scope referensi window(biasanya pada browser)
- this pada function scope referensi window(biasanya pada browser)
- this pada function dengan struct undefined
- this dalam event, meupakan referensi ke element yang menerima event 

this didalam object methd yang menggunakan arrow function tidak bisa mengakses this
melainkan window(di browser)
*/

const iniObject = {
    nama : "object saya",
    x    : 12,
    fungsi : function() {
        console.log(this)
    }
}
iniObject.fungsi()

console.log(this)

function fungsi() {
    console.log(this)
}
fungsi()

const objArrFunct = {
    nama : "Ini Object Arrow Function",
    x    : 15,
    fungsi : () => console.log(this)
}
objArrFunct.fungsi()
