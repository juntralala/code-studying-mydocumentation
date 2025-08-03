# Criteria Builder
* CriteriaQuery merupakan object yang digunakan untuk menambahkan informasi query yang akan kita lakukan, seperti select dari entity mana, field apa yang akan diambil dan kondisi where apa yang akan digunakan
* https://jakarta.ee/specifications/persistence/3.1/apidocs/jakarta.persistence/jakarta/persistence/criteria/criteriaquery 
* Setelah selesai membuat CriteriaQuery, kita bisa gunakan EntityManager.createQuery(criteria) untuk mengkonversi menjadi Query hasilnya
