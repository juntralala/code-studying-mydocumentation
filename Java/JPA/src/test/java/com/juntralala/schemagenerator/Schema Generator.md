# Schema Generator
* Dari awal, kita selalu membuat table di database secara manual sebelum menjalankan unit test Java nya 
* JPA memiliki fitur untuk membuat Table secara otomatis dari Class Entity yang ada 
* Walaupun fitur ini sangat menarik, namun sangat tidak disarankan untuk membuat table secara otomatis, karena akan sulit melakukan tracking perubahan schema database nya 
* Sangat disarankan menggunakan database versioning seperti flywaydb
* https://flywaydb.org/

---
* Untuk menggunakan fitur Hibernate Schema Generator, kita bisa gunakan property jakarta.persistence.schema-generation.database.action di file persistence.xml, dengan value :
  * none, tidak melakukan apapun
  * create, membuat schema 
  * drop, menghapus schema 
  * drop-and-create, menghapus schema dan membuat nya


Contoh:
```xml
<properties>
    <property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
    <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://172.20.82.191:3306/jpa_test"/>

<!--  satu baris ini untuk menggunakan schema generator-->
    <property name="jakarta.persistence.schema-generation.database.action" value="drop-and-create"/>

    <property name="jakarta.persistence.jdbc.user" value="super"/>
    <property name="jakarta.persistence.jdbc.password" value=""/>
    <property name="hibernate.show_sql" value="true"/>
    <property name="hibernate.format_sql" value="true"/>
</properties>
```

