# Constraint Viosalation
* Setelah kita menambahkan annotation Constraint ke class yang akan kita validasi, selanjutnya kita bisa mulai melakukan validasi terhadap object class tersebut menggunakan method validate() milik class Validator
* Hasil kembalian dari method validate() adalah Set<ConstraintViolation>, dimana ConstraintViolation tersebut merupakan representasi kesalaha dari constraint
* Jika terdapat kesalahan, otomatis terdapat ConstraintViolation, namun jika tidak ada kesalahan, maka tidak akan terdapat ConstraintViolation, alias Set nya akan berisi data kosong
* https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/constraintviolation 

> contohnya di com.juntralala.constraint.ConstraintTest