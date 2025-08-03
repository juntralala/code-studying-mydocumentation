# Container Data.md
* Saat kita membuat class, kadang sering kita gunakan tipe data container, seperti misalnya Optional, Collection, List, Set, Map dan lain-lain \
* Secara default, jika kita isi data tersebut dengan data Object, misal @Valid List<Address>, maka secara otomatis Bean Validation akan melakukan validasi semua data object Address sesuai dengan constraint yang ada di dalam class Address 
* Tapi bagaimana jika kita memiliki misal field List<String>, atau Map<String, String>, bagaimana melakukan validasinya? Misal kita ingin semua data string di List tidak boleh kosong
* Untungnya, Bean Validation mendukung validasi terhadap data container seperti ini