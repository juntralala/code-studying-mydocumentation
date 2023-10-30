/** List interface
* List adalah struktur data collection yang memiliki sifat sebagai berikut
*   - element List bisa duplikat
*   - data List terurut sesuai posisi kita memasukkan data
*   - memiliki index, sehingga kita bisa mengakses element List menggunakan index
* di java ada beberapa iplementasi List, kita bisa memilih sesuai kebutuhan kita
*/

/** ArrayList vs LinkedList
* +=========+=========================================+=============================================+
* | operasi | ArrayList                               | LinkedList                                  |
* + --------+-----------------------------------------+---------------------------------------------+
* | add     | cepat jika kapasitas array belum penuh, | cepat karna hanya menambahkan node di akhir |
* |         | namun lambat jika array penuh           |                                             |
* | get     | cepat karna tinggal menggunakan index   | lambat karena harus mengecek dari node awal |
* |         |                                         | sampai ketemu indexnya                      |
* | set     | cepat karena tinggal gunakan index array| lambat karena harus mengecek dari node awal |
* |         |                                         | sampai ketemu                               |
* | remove  | lambat karena harus mengeser data di    | cepat karena tinggal rubah prev dan next    |
* |         | belalang data yang dihapus              | di sebelah data yang dihapus                |
* +=========+=========================================+=============================================+
*/