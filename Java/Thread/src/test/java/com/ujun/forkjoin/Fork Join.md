# Fork / Join
* Fork/Join merupakan fitur yang mulai kenalkan di Java 7 untuk membantu mempercepat proses secara parallel memanfaatkan semua cpu processor. Proses ini dicapai menggunakan teknik Devide and Conquer
* Secara sederhana, Fork/Join akan melakukan FORK, memecah pekerjaan menjadi pekerjaan yang lebih kecil dan dieksekusi secara asynchronous
* Setelah proses FORK selesai, proses JOIN akan dilakukan, yaitu menggabungkan hasil semua pekerjaan yang telah selesai menjadi satu hasil
* Fork/Join menggunakan thread pool bernama ForkJoinPool dan menggunakan thread ForkJoinWorkerThread
* https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/ForkJoinPool.html 
* https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/ForkJoinWorkerThread.html 

## Fork Join Diagram
![Diagram Fork Join](diagram_fork_join.jpg)

## Work Stealing Algorithm
* Fork/Join Thread menggunakan algoritma work stealing (mencuri), artinya jika Fork/Join akan secara maksimal menjalankan pekerjaan di semua thread, dan jika ada thread yang sudah selesai, maka thread tersebut akan coba mencuri pekerjaan dari queue thread lain
* Algoritma ini memastikan bahwa semua thread akan bekerja dan pekerjaan diselesaikan secepatnya

> lanjutkan dengan ForkJoinPoolTest.java kemudian ForkJoinTask
