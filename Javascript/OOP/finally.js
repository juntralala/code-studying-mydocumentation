/**
 * Kadang kita ingin melakukan sesuatu entah itu terjadi error maupun tidak
 * Dalam try catch, didalam try catch kita bisa menambahkan block finally
 * Block finally ini akan selalu dieksekusi setelah try catch selesai, entah terjadi error atau tidak, 
   block finally akan selalu dieksekusi
*/

/** Try Finally
 * Kata kunci finally juga bisa digunakan tanpa perlu menggunakan catch
 * Biasanya digunakan dalam kasus tertentu
 */ // contoh try finally ada di bawah contoh try catch finally


class MathUtils {

    static sum(...numbers){
        if(numbers.length === 0) {
            throw new Error("Jumlah parameter harus lebih dari satu")
        } else {
            let total = 0
            for(let number of numbers){
                total += number 
            }
            return total
        }
    }

}

try {
    console.log(MathUtils.sum())
    console.log("kode block try akan berhenti")
} catch(error) {
    console.log(`Terjadi error : ${error.message}`)
} finally {
    console.log("Block finally akan selalau dieksekusi, mau ada error atau tidak")
}

console.log("AKHIR PROGRAM")


console.log("\n\nCONTOH TRY FINALLY\n\n")

class Counter {
    #counter = 0
    
    
    next() {
        try{
            return this.#counter
        } finally {
            this.#counter++
        }
    }
}
``
let counter = new Counter()
console.log(counter.next())
console.log(counter.next())
console.log(counter.next())
console.log(counter.next())