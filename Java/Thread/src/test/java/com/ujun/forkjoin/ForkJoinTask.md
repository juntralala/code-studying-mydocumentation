# ForkJoinTask
* ForkJoinPool merupakan turunan dari ExecutorService, jadi cara penggunaannya sama dengan ExecutorService sebelumnya yang sudah kita bahas
* Namun agar tujuan dari ForkJoinPool tercapai, baiknya kita menggunakan ForkJoinTask sebagai task yang kita submit ke ForkJoinPool
* ForkJoinTask adalah turunan dari Callable, sehingga kita bisa menggunakan method execute() atau submit() untuk mengirim task ke ForkJoinPool
* https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/ForkJoinTask.html 

## RecursiveAction dan RecursiveTask
* ForkJoinTask adalah abstract class, dan terdapat 2 abstract class turunannya yang bisa kita gunakan agar lebih mudah membuat ForkJoinTask
* RecursiveAction, merupakan class yang bisa kita gunakan untuk task yang tidak mengembalikan result seperti Runnable
* RecursiveTask, merupakan class yang bisa kita gunakan untuk task yang mengembalikan result seperti Callable
* https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/RecursiveAction.html
* https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/RecursiveTask.html 

