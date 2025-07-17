/** Public Class Field
 * Secara default, saat kita menambahkan field, maka field terebut akan akan bisa diakses dari manapun
 * Jika kita ingin membuat filed yang bersifat private, kita bisa menggunakan tanda # sebelum field nya
 * Ini dinamakan private class field, dan hanya bisa diakses dari dalam class saja
 */

class Counter{
    #counter = 0

    increment(){
        this.#counter++
    }

    decrement(){
        this.#counter--
    }

    get counter(){
        return this.#counter
    }
}

let counter = new Counter()
counter.increment()
counter.increment()
counter.increment()
// counter.#counter = 100 // ini error
console.log(counter.counter)