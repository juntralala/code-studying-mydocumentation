/** Upload File dengan AJAX
 * Selain menggunakan JSON, Query Param, Form, kadang kira butuh mengirimkan file ke Server
 * Untuk mengirimkan file ke Server, kita perlu menggunakan object FormData, lalu kita perlu menambahkan
   object File ke dalam FormData tersebut
 * https://developer.mozilla.org/en-US/docs/Web/API/FormData
 * https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/file
 * https://developer.mozilla.org/en-US/docs/Web/API/File
 * https://developer.mozilla.org/en-US/docs/Web/API/FileList
 */

// kalau data nya dikirim dalam object FormData nanti data nya dikirim dalam multipart/form-data
// atau istilahnya data nya dikirim dalam bentuk binary makanya bisa mengirm file

// cara penggunaan object FormData sama dengan object URLSearchParam, tetapi pada method appen()
// kita bisa menambahkan object File

// untuk mendapatkan data file kita akan menggunakan element HTML <input type="file">, nah ketika 
// form html memiliki <input type="file">, maka pada object javascript nya akan memiliki property .files
// property files berupa object FileList

// untuk mengambil File dari FileList digunakan method item(index), kalau mau mengambil data pertama berati
// FileList.item(0)