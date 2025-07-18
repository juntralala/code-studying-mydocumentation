# Property Source
* Secara default, application properties hanya akan mengambil dari file di application.properties yang terdapat di classpath project
* Namun, Spring memiliki fitur yang bisa kita gunakan jika kita ingin menambahkan application properties dari file lain, namanya adalah PropertySource
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/PropertySource.html
* Kita bisa sebutkan Resource mana yang kita tambahkan ke application properties
* Jika kita ingin menambah lebih dari satu property source, kita bisa gunakan annotation PropertySources
