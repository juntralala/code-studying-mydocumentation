### Locale
DI Java, bahasa dan negara sudah ada representasinya, namanya adalah class Locale
Class Locale ini bisa digunakan sebagai representasi bahasa dan negara
Kenapa ada negara dan bahasa? Kenapa tidak negara saja, atau bahasa saja? Karena kadang ada bahasa yang sama untuk negara berbeda, atau bahasa berbeda untuk negara yang sama
Locale mengikuti standar IETF BCP 47, yang terdiri dari RFC 4647 "Matching of Language Tags” dan RFC 5646 "Tags for Identifying Languages"

### Pemilihan Bahasa
Penulisan bahasa di Locale menggunakan ISO 639 alpha 2 atau alpha 3
Ketika sebuah bahasa memiliki kode alpha 2 dan alpha 3, maka yang harus digunakan adalah alpha 2
https://www.loc.gov/standards/iso639-2/php/code_list.php 

### Penulisan Negara
Penulisan negara di Locale menggunakan ISO 3166 alpha-2 
https://www.iban.com/country-codes 
