/** Alias di Import
 * Atau rekomendasi sebenarnya melakukan alias di import
 * Sehingga ketika export nama tidak usah diubah
 * Untuk melakukan alias ketika import, kita bisa gunakan katakunci as, diikuti dengan nama alias
   import {variable as variableLain, function as functionLain, class as classLain} from "./namafile.js"
*/

let nama = "UJUN"

function sapa(){
    console.log("halo")
}

class Company {}

export {nama, sapa, Company}