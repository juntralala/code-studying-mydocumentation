# Named Query 
* JPA memiliki fitur bernama Named Query, dimana kita bisa membuat alias untuk JPA QL yang kita buat
* Salah satu keuntungan menggunakan Named Query adalah, kita bisa menggunakan JPA QL yang sudah kita buat berkali-kali hanya dengan menyebutkan nama alias nya
* Biasanya Named Query akan di tempatkan di Entity Class yang sesuai dengan Query nya
* Untuk membuat Named Query, kita bisa gunakan annotation NamedQuery
* https://jakarta.ee/specifications/persistence/3.1/apidocs/jakarta.persistence/jakarta/persistence/namedquery 
* Dan untuk memanggilnya, kita bisa gunakan EntityManager.createNamedQuery(alias, class)
