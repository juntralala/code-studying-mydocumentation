# Page Result
* Sebelumnya kita sempat bahas tentang Page Result ketika menggunakan Paging
* Pada kasus jika kita ingin return dari Query Method nya adalah Page<T>, bukan List<T>, maka kita harus memberitahu Spring Data JPA bagaimana cara melakukan count query nya
* Kita bisa tambahkan query count nya pada attribute countQuery di Query Annotation
