# Criteria Select Non Entity 
* Secara default, saat kita menggunakan CriteriaQuery.select(root), dia akan melakukan select Entity yang sudah kita pilih
* Criteria juga bisa digunakan untuk melakukan select ke non entity, seperti sudah pernah kita bahas di JPA QL
* Kita bisa memanfaatkan Root<T> untuk men-select field mana saja yang ingin kita select
