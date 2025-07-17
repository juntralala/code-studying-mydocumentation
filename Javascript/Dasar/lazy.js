// lazy
function* angkaGanjil(start, end) {
    for (let i = start; i <= end; i++) {
        if (i % 2 === 1) {
            console.log(`yield ${i}`)
            yield i
        }    
    }    
}    

let bilanganGanjil = angkaGanjil(0, 20) 

for (const value of bilanganGanjil) {
    console.log(value)
}    

// igger
function angkaGanjilArray(start, end) {
    const result = []
    for (let i = start; i <= end; i++) {
        if (i % 2 === 1) {
            console.log(`excekusi ${i}`)
            result.push(i)
        }
    }
    return result
}

let bilanganGanjilArray = angkaGanjilArray( 0, 20)
for (const value of bilanganGanjilArray) {
    console.log(value)
}    
