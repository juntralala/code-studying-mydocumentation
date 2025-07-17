/** Encode URL
 * Saat kita menulis URL, kadang kita ingin menambahkan query parameter misalnya
 * URL sendiri sudah memiliki standard encoding penulisan URL
 * Standard encoding ini dilakukan agar penulisan URL aman ketika diterima oleh server
 * Aman disini dalam artian informasi URL tidak berubah 
 * Contoh paling sederhana, misal kita mengirim spasi dalam URL, meski hal itu bisa dilakukan dalam URL, 
    tapi tetap disarankan untuk di encode agar nilai spasi tidak benar-benar terlihat seperti spasi pada
    URL nya     
*/

/** contoh Masalah tidak menggunakan encode 
 * Misalnya, ada query parameter dengan nama data, lalu kita ingin mengirimkan nilai kesana
 * Misal nilainya : &ujun=ujun& . Hal hasil URL nya aka sebagai berikut :
   https://contoh.com?data=&ujun=ujun&
 * URL diatas terlihat tidak ada masalah, tapi sebenarnya ketika diterima oleh server, parameter data
    bernilai kosong. Karena, karakter & dianggap sebagai pemisah antar parameter
 * Artinya tanda seperti & dan yang lainnya wajib di encode, agar tidak terjadi kesalahan data yang kita
    kirim
*/

/** Encode Function        (Beberapa) 
    +===============================+===============================================================+
    | Functions                     | Keterangan                                                    |
    +===============================+===============================================================+
    | ecnodeURI(value)              | Melakukan encode value, namun karakter yang dipesan di URI    |
    |                               |  tidak akan diubah ;,/?:@&=+$#                                |
    | encodeURICompunent(value)     | Melakukan encode value ke semua karakter                      |
    | decodeURI(encoded)            | Melakukan decode value hasil encodeURI()                      |
    | decodeURICompunent(encoded)   | Melakukan decode value hasil encodeURICompunent()             |
    +===============================+===============================================================+

*/
{  // contoh endcodeURI() dan decodeURI()
    let url = "https://contoh.com?data=ujun Muhammad Junaidi"
    console.info("url\t: ", url)
    
    let encoded = encodeURI(url)
    console.info("encoded\t: ", encoded)
    
    let decoded = decodeURI(encoded)
    console.info("decoded\t: ", decoded)
}

{  // contoh endcodeURICompunent() dan decodeURICompunent()
    let url = "https://contoh.com?data=ujun Muhammad Junaidi"
    console.info("url\t: ", url)
    
    let encoded = encodeURIComponent(url)
    console.info("encoded\t: ", encoded)
    
    let decoded = decodeURIComponent(encoded)
    console.info("decoded\t: ", decoded)
}

