/*
- saat kita kode program javascript, secara default kode kita berjakan di mode
  bukan strict, atau istilahnya sloppy mode
- ketika strict mode dijalankan javascript akan menjadi :
    1. Merubah Javascript error yang tadinya silent error, mejad Throw Error
    2. Memperbaiki beberapa keesalahan beberapa javascript engine untuk 
       optimalisasi
    3. Menolak beberapa kode perintah yang kedepannya akan ddi gunakan di
       ECMAscript 
- cara menyalakkan strict mode :
    1. Tambahkan 'use strict' pada awal baris program kita
    2. Tambahkan 'use strict' pada awal baris suatu function
*/

'use strict'

function useStrictMode() {
    // 'use strict'

    const person = {
        nama : "Muhammad Junaidi"
    }

    // error
    // with (person) {
    //     console.log(nama)
    // }
}