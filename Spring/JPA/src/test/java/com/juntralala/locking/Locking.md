# Locking
* Di kelas JPA, kita sudah bahas melakukan Pessimistic Locking
* Karena di Spring Data JPA, kita tidak perlu lagi menggunakan Entity Manager, bagaimana jika kita butuh melakukan Pessimistic Locking?
* Kita bisa membuat Query Method dengan menambahkan annotation @Lock
* https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/Lock.html 

```java
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Lock(PESSIMISTIC_WRITE)
    Optional<Product> findFirstByIdIs(Long name);
}
```