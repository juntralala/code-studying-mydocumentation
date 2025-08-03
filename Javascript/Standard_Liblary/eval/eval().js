/** eval()
 * Eval merupakan function yang digunakan untuk mengeksekusi kode javascript dari string
 * Fitur ini sangat menarik, namun perlu hati-hati ketika menggunakannya
 * Jika sampai salah penggunaan, maka bisa terjadi pengeksekusian kode program yang bisa menyebabkan
    masalah keamanan di website kita
 * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/eval
*/

let string = "console.log('data di database, diambil orang')"

eval(string)