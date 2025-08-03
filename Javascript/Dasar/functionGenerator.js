/*
function generator adalah function yang di gunakan untuk membuat data generator
generator adalah data yang bisa diiterasi seperti array
data generator sifatnya lazy
*/ 
function* angkaGanjil(start, end) {
    for (let i = start; i <= end; i++) {
        if (i % 2 === 1) {
            yield i
        }
    }
}

let bilanganGanjil = angkaGanjil(0, 20) 

for (const value of bilanganGanjil) {
    console.log(value)
}
