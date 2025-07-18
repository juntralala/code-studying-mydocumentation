# Declaration Transaction
* Saat kita menggunakan JPA secara manual, kita harus melakukan management transaction secara manual menggunakan EntityManager
* Spring menyediakan fitur Declarative Transaction, yaitu management transaction secara declarative, yaitu dengan menggunakan annotation @Transactional
* Annotation ini secara otomatis dibaca oleh Spring AOP, dan akan menjalankan transaction secara otomatis ketika memanggil method yang terdapat annotation @Transactional nya
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Transactional.html 

## Yang Perlu Diperhatikan
* Saat membuat method dengan annotation @Transactional, karena dia dibungkus oleh Spring AOP, jadi untuk menjalankannya, kita harus memanggil method tersebut dari luar object
* Misal kita memiliki CategoryService.create() dengan annotation @Transactional, jika kita panggil dari CategoryController, maka Spring AOP akan berjalan, namun jika dipanggil di CategoryService.test() misalnya, maka Spring AOP tidak akan berjalan

