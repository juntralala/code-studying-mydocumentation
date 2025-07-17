/** Apa itu Promise?  
 * Promise merupakan proxy untuk sebuah nilai di masa depan(Future) yang belum diketahui saat pembuatan
   Promise tersebut  
 * Biasanya Promise digunakan sebagai proxy untuk proses Async
 * Penggunaan Promise sangat mudah, dan lebih mirip dengan kode Synchronous
 * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise
 */

/** Promise State
    +===========+-----------+-----------+-----------+
    | state     | pending   | fulfilled | rejected  |
    +===========+-----------+-----------+-----------+
    | result    | undefined | value     | error     |
    +===========+-----------+-----------+-----------+
 */

// Kenapa Promise dibuat / digunakan?
// karna untuk mengatasi / menghindari dari problem yang nama nya Callback Hell terutama pada
// proses-proses async


// Kode: Membuat Promise         (ini contoh saja, jangan di run!)
const promise = new Promise(function(resolve, reject){
    if(success){
        resolve(value)
    } else {
        reject(error)
    }
})