# Konsep Java IO
* Di dalam Java IO, terdapat dua konsep utama yang wajib kita ketahui
* Pertama adalah lokasi sumber data (resource) yang perlu diakses, dan 
* Kedua adalah membuka stream (untuk membaca atau menulis) terhadap sumber data (resource) tersebut

## Resource
* Resource atau sumber data di Java IO bisa menggunakan beberapa mekanisme.
* Menggunakan class File, yang sudah bisa dilakukan sejak versi Java 1.0
* https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/File.html 
* Dan menggunakan class Path yang bisa digunakan sejak versi Java 7.0
* https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/nio/file/Path.html 

## IO Stream
* IO Stream merupakan representasi dari input data atau output data menuju resource.
* Stream mendukung banyak jenis data, seperti tipe data primitive, String, Object, dan lain-lain
* IO Stream berbeda dengan Java Stream yang dikenalkan sejak Java 8, walaupun namanya sama, tapi secara fitur dan konsep sangat berbeda
* IO Stream di Java didefinisikan oleh empat Interface utama :
* Stream untuk karakter: Reader dan Writer
* Stream untuk bytes: InputStream dan OutputStream
