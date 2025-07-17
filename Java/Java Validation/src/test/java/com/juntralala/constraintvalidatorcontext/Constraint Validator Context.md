# Constraint Validator Context
* Saat kita membuat ConstraintValidator, pada method isValid terdapat parameter ConstraintValidatorContext 
* Sebenarnya dalam keadaan ideal, kita tidak butuh menggunakan parameter tersebut, tapi pada materi ini kita akan bahas kegunaannya 
* ConstraintValidatorContext digunakan untuk membuat custom message atau path, jika dirasa memang diperlukan 
* Contoh pada kasus Class-Level Constraint, ketika terjadi error, maka secara default path nya adalah root objectnya, kadang-kadang kita ingin memberi tahu field mana yang error. Pada kasus ini kita bisa menggunakan ConstraintValidatorContext
* https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/constraintvalidatorcontext

> contohnya tidak kubuat, kecuali potongan kode dibawah ini saja (aku malas 🧢) 

### contoh kode jika ditambahkan pada Class-level constraint
// method CheckPasswordValidator#isValid()
```java
boolean isValid = value.getPassword().equals(value.getRetypePassword());

if (!isValid) {
    context.disableDefaultConstraintViolation();
    context.buildConstraintViolationWithTemplate("password is different with retypePassword")
          .addPropertyNode("password")
          .addConstraintViolation();
    context.buildConstraintViolationWithTemplate("retypePassword is different with password")
          .addPropertyNode("retypePassword")
          .addConstraintViolation();
}

return isValid;
```
  
unittest:
```java

Register register = new Register("admin", "rahasia", "rahasia1234");

var violations = validator.validate(register);

printViolationsInfo(violations);
```
