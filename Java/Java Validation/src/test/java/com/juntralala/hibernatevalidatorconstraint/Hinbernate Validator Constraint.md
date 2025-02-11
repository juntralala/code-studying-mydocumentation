# Hibernate Validation Constraint
* Selain Annotation Constraint yang terdapat di Bean Validation
* Hibernate Validator juga menyediakan Constraint tambahan
* Kita bisa melihat nya di package org.hibernate.validator.constraints
* https://docs.jboss.org/hibernate/stable/validator/api/org/hibernate/validator/constraints/package-summary.html

contohnya:
```java
@Range
@LuhnCheck
@CreditCardNumber
```