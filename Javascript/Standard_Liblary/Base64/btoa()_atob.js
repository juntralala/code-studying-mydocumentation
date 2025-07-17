/** Base64
 * Base64 merupakan binary to text encoding, representasi binary data  dalam format string 
 * Base64 merupakan format text data yang aman untuk dikirimakan di web
 * Base64 merupakan encoding yang biasa digunakan ketika kita perlu mengirim data  dari client ke server
 * Karena encoding Base64 berupa text, oleh sebab itu sangat aman digunakan pada query param URL atau text
    atau text body dalam form
 * https://developer.mozilla.org/en-US/docs/Glossary/Base64
*/

/** Function Base64
 * JavaScript memiliki function bawaan untuk melakukan encode Base64 atau decode Base64
    +===============+===============================+
    | Function      | Keterangan                    |
    +===============+===============================+
    | btoa(value)   | Encode ke base64 dari value   |
    | atob(value)   | Decode dari base64 ke value   |
    +===============+===============================+
*/

const data = "Muhammad Junaidi = && /"

const encoded = btoa(data)
console.log(`encoded : ${encoded}`)

const decoded = atob(encoded)
console.log(`decoded : ${decoded}`)