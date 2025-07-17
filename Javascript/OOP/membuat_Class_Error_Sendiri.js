/**
 * Walaupun Javascript sudah memiliki standard class Error 
 * Namun alangkah baiknya kita membedekan tiap jenis error
 * Untuk membuat error sendiri secara manual sangatlah mudah, cukup membuat class turunan dari class Error
 * Dan jangan lupa tambahkan parameter message, agar bisa dikirimkan ke parameter contructor class Error
*/

class ValidationError extends Error {
    constructor(message, field){
        super(message)
        this.field = field
    }
}

class MathUtils {

    static sum(...numbers){
        if(numbers.length === 0) {
            throw new ValidationError("Jumlah parameter harus lebih dari satu", 'numbers')
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
} catch(e) {
    if(e instanceof ValidationError){
        console.log(`Terjadi Error pada field : ${e.field} dengan error : ${e.message}`)
    } else {
        console.log(`Terjadi error : ${e.message}`)
    }
}