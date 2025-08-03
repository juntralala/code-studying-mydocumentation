# Perkenalan Servlet
* Servlet adalah standarisasi di Java untuk membuat Web
* Mirip seperti JDBC sebagai standarisasi untuk komunikasi ke Database
* Servlet adalah merupakan spesifikasi untuk membuat Web, dan dengan menggunakan Servlet, kita bisa menjalankan aplikasi Java Web di Web Server apapun yang sudah mengikuti standarisasi Servlet
* https://www.jcp.org/en/jsr/detail?id=340 

## Servlet API
* Servlet sendiri sangat low level, artinya saat kita menggunakan Servlet, semua harus kita lakukan secara manual
* Oleh karena itu, saat ini, tidak ada yang membuat aplikasi Java Web langsung menggunakan Servlet, kebanyakan menggunakan Web Framework
* Namun di kelas ini, sengaja dibahas tentang Servlet, agar kita tahu bagaimana cara kerja Web di Java

## Web Framework
* Saat ini, untuk membuat Web di Java, kebanyakan kita akan menggunakan Web Framework, misal seperti :
  * Spring Web MVC 
  * Java Server Page
  * Java Server Faces
  * Dan lain-lain

## Java Web Server
* Karena Servlet hanyalah sebuah spesifikasi, maka harus ada implementasinya
* Mirip seperti JDBC yang harus ada implementasinya dalam bentuk Driver
* Implementasi Servlet adalah sebuah Web Server, dimana ada banyak sekali Web Server yang bisa kita gunakan seperti :
  * Apache Tomcat
  * Jetty
  * Glassfish 
  * Wildfly
  * Dan lain-lain

