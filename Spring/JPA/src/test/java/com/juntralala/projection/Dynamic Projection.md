# Dynamic Projection
* Kadang kita mungkin ingin membuat beberapa jenis Projection Interface / Record
* Pada kasus ini, kita bisa menggunakan Generic di Query Method nya, dan juga menambahkan parameter Class di parameter terakhir Query Method nya


```java
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    <T> List<T> findAllByNameIs(String name, Class<T> model);
    
```