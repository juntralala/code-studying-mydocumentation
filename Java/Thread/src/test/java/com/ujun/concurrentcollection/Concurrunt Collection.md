# Concurrent Collection

Java menyediakan Collection yang banyak digunakan untuk proses concurrent programming
Tidak seperti kebanyakan Collection di package java.util, Collection yang terdapat di java.util.concurrent memang dikhususkan untuk concurrent programming, sehingga thread safe

# Jenis Concurrent Collection

Secara garis besar, concurrent collection di Java terbagi menjadi dua interface
BlockingQueue, merupakan turunan dari Queue, dan dikhususkan untuk tipe collection FIFO (first in first out), seperti yang sebelumnya sudah kita bahas sekilas di ThreadPool Queue
ConcurrentMap, merupakan turunan dari Map, dan dikhususkan untuk Map yang thread safe dibanding implementasi Map di Java Collection
Kita akan coba bahas satu-satu di chapter selanjutnya