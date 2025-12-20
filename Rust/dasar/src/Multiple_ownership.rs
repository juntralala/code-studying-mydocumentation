/*
Pada umumnya, value biasanya hanya dimiliki oleh satu variable
Namun, mungkin akan ada kasus dimana satu value dimiliki oleh beberapa variable, contoh misal pada struktur data Graph, dimana satu titik bisa berasal dari beberapa titik
Seperti yang kita tahu, bahwa defaultnya di Rust satu value hanya bisa dimiliki oleh satu variable
Jika kita ingin membuat satu value bisa dimiliki oleh beberapa variable, kita harus menggunakan type Rc<T> (Reference Counted)
*/

/*
Rc<T> atau Reference Counted adalah tipe data Smart Pointer yang bisa digunakan untuk lebih dari satu variable owner
Penggunaan Rc<T> mirip seperti Box<T>
https://doc.rust-lang.org/alloc/rc/index.html 
https://doc.rust-lang.org/alloc/rc/struct.Rc.html 
*/

// malas untuk mraktekin