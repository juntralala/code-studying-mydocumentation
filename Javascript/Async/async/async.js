/** Async
 * Async digunakan untuk menandakan bahwa sebuah Function tersebut Async, dan mengembalikan Promise 
 * Dengan menggunakan Async, kita tidak perlu membuat Promise secara manual lagi
 */


// return Promise<String>
export function getNamePromise(){
    return new Promise(function(resolve, reject){
        resolve("Ujun")
    })
}

// return Promise<String>
export async function getNameAsync(){
    return "Ujun"
}