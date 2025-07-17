/** Dengan Module
 * Namun jika kita menggunakan module, kita bisa secara selektif bagian kode mana saja yang mau kita 
   ekspos(export) ke luar
 * Secara default, kode yang kita buat menggunakan JavaScript Module tidak bisa digunakan dari luar file,
   kecuali kita memintanya untuk mengekspos keluar (export)
*/

export let name = "Muhammad Junaidi"

export function sapa() {
  console.log("Hallo, apa kabar bro")
}

export function dadah(){
  console.log("Sampai nanti bro, gua pulang dulu")
}