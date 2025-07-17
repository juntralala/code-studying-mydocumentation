# Cross-Parameter Constraint
* Untuk melakukan validasi beberapa Field, kita bisa menggunakan fitur Class-Level Constraint 
* Sekarang bagaimana jika kita ingin melakukan validasi beberapa Parameter? Misal pada Method Parameter atau Constructor Parameter? 
* Hal ini tidak bisa menggunakan Class-Level Constraint, namun ada cara sendiri untuk melakukan hal ini 
* Yaitu dengan menggunakan Annotation @SupportedValidationTarget 
* Kita bisa menggunakan @SupportedValidationTarget pada ConstraintValidator, untuk melakukan validasi semua parameter di Method atau Constructor