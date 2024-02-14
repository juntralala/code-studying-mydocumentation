/** Tanpa JavaScript Modules
 * Sebelum kita membahasa JavaScript Module, sekarang kita akan coba dulu tanpa JavaScript Module
 * Saat kita membuat file JavaScript, lalu kita load file JavaScript tersebut, secara default semua kode
   JavaScript didalam file tersebut bisa diakses, baik itu variable atau function atau class 
*/

// ini sedikit berbahaya karena jika jika kita mendeklasi kan pada satu file.js dan fileLain.js 
// dengan nama variable yang sama maka bisa menyebabkan error

let name = "Muhammad Junaidi"

function sapa() {
  console.log("Hallo, apa kabar bro")
}

function dadah(){
  console.log("Sampai nanti bro, gua pulang dulu")
}