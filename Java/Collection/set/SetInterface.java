/**
* Set adalah salah satu collection yang berisi elemen-elemen yang unik, atau tidak boleh sama
* Set tidak memiliki index seperti List, oleh karena itu tidak ada jaminan data di Set akan terurut sesuai waktu kita memasukkan data ke Set
* Set tidak memiliki merhod baru, jadi hanya menggunakan method parent nya, yaitu Iteration dan Iterable
* karena tidak memiliki index, untuk mengambil data kita harus meng-iterasi satu persatu
*/

/** HashSet vs LinkedHashSet
* dibelakang HashSet dan LinkedSet sebenarnya sama-sama ada hash table, di mana data disimpan dalam sebuah hash table, dengan mengkalkulasikan hashCode() function
* yang membedakan adalah HashSet tidak menjamin data terurut sesuai waktu kita menambahkan data, sedangkan LinkedHashSet menjamin data terurut sesuai waktu kita menambahkan data
* urutan data LinkedHashSet bisa dijaga karena di belakangnya menggunakan double linked list
*/