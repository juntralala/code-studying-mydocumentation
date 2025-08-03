/** Static Method
 * Kata kunci static juga tidak hanya bisa ditambahkan di field, tapi juga di method
 * Jika kita tambahkan di method, artinya method tersebut milik class nya, bukan prototype
 * Dan untuk mengakses mehtod tersebut, kita juga bisa lakukan seperti mengakses static field
*/

class MathUtils {
    static sum(...numbers){
        let total = 0;
        for(let number of numbers){
            total += number
        }
        return total
    }
}

console.log(MathUtils.sum(1, 2, 7))
