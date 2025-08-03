/** Contoh Async Method
 * Ada banyak method Async yang terdapat di JavaScript yang akan kita bahas kali ini adalah :
    => setTimeout(callback, timeInMilis), digunakan untuk menjalankan proses Async sekali dalam waktu
       tertentu
    => setInteval(callback, timeInMilis), digunakan untuk menjalankan proses Async secara periodik dalam   
       waktu tertentu
*/

function sapa(){
   console.log("Hai")
   console.log("Function sapa telah dipanggil")
}

setTimeout(sapa, 6000)

setInterval(()=> console.log(new Date()), 1000)

console.log("PROGRAM Telah SELESAI")