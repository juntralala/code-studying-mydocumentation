# Component Scan
* Import adalah hal yang sangat menarik, karena kita bisa memecah Configuration Class menjadi banyak Class
* Namun semakin lama, pasti aplikasi kita akan semakin besar, dan secara otomatis Configuration Class akan menjadi banyak
* Melakukan import satu persatu sudah tidak menyenangkan lagi jika terlalu banyak
* Spring memiliki fitur component scan, dimana kita bisa secara otomatis mengimport Configuration di sebuah package dan sub package nya secara otomatis
* Untuk melakukan itu, kita bisa gunakan annotation @ComponentScan
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/ComponentScan.html 
