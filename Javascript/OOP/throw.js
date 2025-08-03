/**
 * Throw Error
 * Saat kita membuat insatnce object dari class Error, tidak lantas otomatis terjadi error
 * Kita perlu membritahu program kita, bahwa kita akan mentrigger bahwa sebuah error sedang terjadi, atau
   istilahnya adalah melempar error, kita bisa gunakan katakunci throw, diikuti dengan instance object errornya
 * Jika terjadi error, maka otomatis, maka otomatis kode program kita akan berhenti, dan kita bisa melihat
   detail errornya di console di aplikasi browser kita 
 */


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

console.log(MathUtils.sum())