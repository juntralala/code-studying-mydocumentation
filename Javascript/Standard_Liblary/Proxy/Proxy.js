/** Proxy
 * Proxy merupakan fitur yang bisa digunakan sebagai wakil sebuah data
 * Dengan menggunakan proxy, semua interaksi ke data akan selalu melalui Proxy terlebih dahulu
 * Dengan ini kita bisa melakukan apapun sebelum interaksi dilakukan ke data yang dituju
 * https://developer.mozilla.org/en-US/Web/JavaScript/Reference/Global_Objects/Proxy
*/ 

/** Proxy Handler
 * Pembuatan Proxy perlu menggunakan handler, dimana didalam handler kita bisa membuat function yang
   dinamakan interceptor yang digunakan ketika mengambil data atau mengubah data ke target
 * Untuk membuat Proxy kita bisa gunakan : new Proxy(target, handler)
*/

const target = {}

const handler = {
    get: function(target, property){
        console.log(`access property ${property}`)
        return target[property]
    },
    set: function(target, property, value){
        // disini kita bisa menambahkan validasi atau logging atau apapun
        if(value === null || value === undefined || value === NaN) {
            throw new Error("Data yang dimasukkan tidak boleh null, undefained atau NaN")
        } else {
            console.log(`change property ${property}: ${value}`)
            target[property] = value
        }
    }
}

const proxy = new Proxy(target, handler)
proxy.name = "Muhammad Junaidi"
proxy.age = 19

console.info(proxy.name)
console.info(proxy.age)
console.info(target)