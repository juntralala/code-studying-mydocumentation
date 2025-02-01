# Synchronization
* Masalah race condition sebelumnya yang terjadi di Java bisa diselesaikan dengan Synchronization
* Synchronization merupakan fitur dimana kita memaksa kode program hanya boleh diakses dan dieksekusi oleh satu thread saja
* Hal ini menyebabkan thread yang lain yang akan mengakses kode program tersebut harus menunggu thread yang lebih dahulu
  mengakses, sehingga proses Synchronization akan lebih lambat, namun proses Synchronization lebih aman karena tidak akan terjadi race condition
  