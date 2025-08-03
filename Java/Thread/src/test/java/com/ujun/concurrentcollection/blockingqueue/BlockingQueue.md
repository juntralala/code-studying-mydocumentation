# BlockingQueue
* BlockingQueue merupakan turunan dari Queue, dari namanya kita tahu bahwa ini adalah collection dengan tipe antrian, yang membedakan sifat dari BlockingQueue adalah dia aman diakses oleh beberapa thread, baik itu yang memasukkan data, atau mengambil data
* BlockingQueue mendukung method wait ketika mengambil data, dan juga wait ketika menyimpan data
* Jika queue kosong, thread yang mengambil data akan diminta untuk menunggu sampai data ada
* Dan jika queue penuh, thread yang mengambil data akan diminta untuk menunggu sampai ada tempat kosong
* https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/BlockingQueue.html


## Blocking Queue Methods
|             | Throws exception | Special value | Blocks          | Times out             |
|-------------|------------------|---------------|-----------------|-----------------------|
| **Insert**  | add(e)           | offer(e)      | put(e)          | offer(e, time, unit)  |
| **Remove**  | remove()         | poll()        | take()          | poll(time, unit)      |
| **Examine** | element()        | peek()        | not applicable  | not applicable        |

## Implementasi Blocking Queue
* ArrayBlockingQueue, implementasi BlockingQueue dengan ukuran fix
* LinkedBlockingQueue, implementasi BlockingQueue dengan ukuran bisa berkembang
* PriorityBlockingQueue, implementasi BlockingQueue dengan otomatis berurut berdasarkan prioritas
* DelayQueue, implementasi BlockingQueue untuk tipe data Delayed, dimana data tidak bisa diambil sebelum waktu delay yang telah ditentukan
* SynchronousQueue, implementasi BlockingQueue dimana thread yang menambah data harus menunggu sampai ada thread yang mengambil data, begitu juga kebalikannya
