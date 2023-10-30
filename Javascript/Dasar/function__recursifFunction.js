function deret(a, d, n) {
    if (n === 1) {
        return a
    }
    return d + deret(a, d, n - 1)
}

let hasilDeret = deret(3, 2, 10)
console.log(hasilDeret)


function factorial(angka) {
    if (angka === 1) {
        return angka
    }

    return angka * factorial(angka - 1)
} 

let hasilFactorial = factorial(4)
console.log(hasilFactorial)