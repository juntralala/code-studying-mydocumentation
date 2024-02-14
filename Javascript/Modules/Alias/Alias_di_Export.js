/** Alias di Export 
 * Kita bisa menggunakan alias ketika melakukan export di module
 * Caranya menggunakan kata kunci as, lalu diikuti dengan nama alias :
   export {variable as variableLain, function as functionLain, class as classLain} 
*/

// kita memang bisa melakukan alias di export, tapi tidak di sarankan 

let nama = "UJUN"

function sapa(){
    console.log("halo")
}

class Company {}

export {nama as pembuat, sapa as halo, Company as Perusahaan}