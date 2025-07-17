# High Level Concurrency Object
## Concurrency Utilities
 * Pada versi Java 5, Java merilis fitur yang bernama Concurrency Utilities, fitur ini berisikan dukungan high level API untuk membuat aplikasi multithreaded lebih mudah 
 * Concurrency Utilities memperkenalkan 3 packages baru di Java 5, yaitu 
   * java.util.concurrent 
   * java.util.concurrent.atomic, dan 
   * java.util.concurrent.locks
 * Semua package dan fitur tersebut nanti kita akan bahas satu persatu

## Kenapa Butuh High Level API?
 * Membuat dan melakukan management Thread secara manual di Java bukanlah hal bijak 
 * Mudah terjadi kesalahan, terutama seperti yang sudah kita jelaskan, masalah Race Condition dan Deadlock misalnya 
 * Selain itu, membuat aplikasi multithreaded menggunakan low level API (menggunakan Thread langsung) tidak terlalu produktif dan flexible 
 * Oleh karena itu, dalam pembuatan aplikasi sehari-hari, biasanya kita akan jarang sekali melakukan management thread secara manual, biasanya kita akan gunakan Concurrency Utilities
