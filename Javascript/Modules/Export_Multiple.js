/** Export Mutiple 
 * Sebelumnya kita selalu menggunakan kata kunci export di tiap diawal variable atau function atau class
 * Sebenarnya kita bisa menggunakan export secara sekaligus pada beberapa data, caranya cukup dengan 
   perintah : 
   export {variable, function, class, dll}
*/

let nama = "UJUN"

function sapa(){
    console.log("halo")
}

class Toko {}

export {nama, sapa, Toko}