/** Error Handling
 * Saat terjadi error di kode program javascript, kadang kita tidak ingin program kita berhenti
 * Di Javascript, kita bisa menangkap jika terjadi error
 * Kita bisa gunakan try catch statement untuk menangkap error
 * Pada block try, kita akan mencoba mengakses kode program yang bisa menyebabkan error, dan jika terjadi
   error, block try akan berhenti dan otomatis masuk ke block catch
 * Jika tidak terjadi error, block catch tidak akan dieksekusi
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

try {
    console.log(MathUtils.sum())
    console.log("kode block try akan berhenti")
} catch(error) {
    console.log(`Terjadi error : ${error.message}`)
}

console.log("AKHIR PROGRAM")