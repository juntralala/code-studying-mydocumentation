# Numeric Dan Ccaracter
## Numeric Data
* Input/Output Stream di Java membaca dan menulis data dalam tipe data bytes
* Untuk belajar Input dan Output Stream di Java, kita harus mengerti bagaimana Java berurusan dengan tipe data bytes, integers, characters da tipe data primitive lainnya

## Integer Data
* Tipe data int adalah 4 byte ukuran
* Tipe data long adalah 8 byte ukuran
* Tipe data short adalah 2 byte ukuran
* Namun walaupun data sebenarnya harus menggunakan tipe data byte, namun karena secara default saat kita membuat number di Java selalu menggunakan tipe data int, maka hampir kebanyakan return value dan parameter di IO Stream di Java menggunakan tipe data int
* Namun pada kasus tertentu yang data bytes banyak, kebanyakan menggunakan parameter atau return value array of bytes

## Character Data
* Selain Input dan Output Stream, di Java juga kita juga bisa membuat Stream khusus untuk jenis Resource Text menggunakan Reader dan Writer
* Dengan menggunakan Reader dan Writer, kita tidak perlu melakukan konversi tipe data Text menjadi Numeric secara manual
* Tipe data Text di Reader dan Writer bisa menggunakan tipe data char, char[] atau String
