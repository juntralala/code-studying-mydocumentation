# CRUD Repository
* JpaRepository adalah turunan dari interface CrudRepository dan ListCrudRepository, dimana di interface tersebut banyak method yang bisa digunakan untuk melakukan operasi CRUD
* Kita tidak perlu lagi menggunakan Entity Manager untuk melakukan operasi CRUD, cukup gunakan JpaRepository
* Ada yang perlu diperhatikan di JpaRepository, method untuk CREATE dan UPDATE digabung dalam satu method save(), yang artinya method save() adalah CREATE or UPDATE
* https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html 
* https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/ListCrudRepository.html