# Buffer
* Saat publisher mengirim data terlalu cepat, maka secara default data akan di buffer
* Buffer mirip antrian, dimana secara default buffer di Flow ukurannya sekitar Flow.DEFAULT_BUFFER_SIZE (256), artinya jika publisher mengirim data terlalu cepat, maka buffer akan menampung data tersebut dahulu sampai sekitar 256 data, jika buffer sudah penuh, maka publisher harus menunggu sampai data di buffer di ambil oleh subscriber
* Jika 256 terlalu besar, kita bisa mengatur data buffer yang kita inginkan

>> lanjutkan ke Processor.md