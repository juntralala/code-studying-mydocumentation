// memasukan anonynous function kedalam variable
let tambah = function(a,b) { return a+b }

console.log(tambah(5,5))

// memsukan anonymous function kedalam argumen
function sayHello(fungsi) {
    console.log(`hello ${fungsi()}`)
}
sayHello(function(){ "Muhammad " + "Junaidi"})




function giveMeName(callback) {
    callback("Ujun")
}

giveMeName(function(name) {
    console.log(`Apakabar ${name}`)
})

giveMeName(function(name) {
    console.log(`lama tidak berjumpa ${name}`)
})
