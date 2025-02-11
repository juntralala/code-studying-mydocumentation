# Nested Validation
* Secara default, jika terdapat nested object, Bean Validation tidak akan melakukan validasi terhadap data object tersebut
* Misal kita punya class Person, dimana  memiliki field address dengan tipe class Address,  secara default isi dalam class Address tidak akan divalidasi
* Jika kita ingin melakukan validasi terhadap nested object tersebut, kita perlu menambahkan annotation @Valid
* `@Valid` juga bisa digunakan untuk nested object yang terdapat di dalam Array atau Collection
* https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/valid 
