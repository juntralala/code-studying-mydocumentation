Synchronization di Java sebenarnya bekerja menggunakan lock
Ketika kita melakukan synchronized method, secara otomatis Java akan membuat intrinsic lock atau monitor lock
Ketika synchronized method dipanggil oleh thread, thread akan melakukan mencoba mendapatkan intrinsic lock, setelah method selesai (sukses ataupun error), maka thread akan mengembalikan intrinsic lock
Semua itu terjadi sejari secara otomatis di synchronized method
