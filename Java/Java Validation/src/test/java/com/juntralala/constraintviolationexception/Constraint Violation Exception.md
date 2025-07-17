# Constraint Violation Exception
* Bean Validation secara default tidak membuat Exception ketika terjadi validasi error 
* Bean Validation hanya mengembalikan error validasi dalam bentuk Set berisi Constraint Violation 
* Beberapa framework atau library, kadang menginginkan Exception jika terjadi validasi error 
* Kita tidak butuh  membuat exception secara manual, Bean Validation sudah menyediakannya, yaitu ConstraintViolationException
* https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/constraintviolationexception 
