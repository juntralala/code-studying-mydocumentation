/*
Saat kita menggunakan Reference atau Box<T>, kita bisa menggunakan * Operator untuk melakukan Dereference
Bagaimana jika kita menggunakan tipe lain? Misal Struct yang kita buat sendiri? Secara default kita tidak bisa menggunakan Deference
Namun, jika kita ingin membuat Struct yang kita buat memiliki kemampuan Dereference, kita bisa menggunakan Deref Trait
https://doc.rust-lang.org/std/ops/trait.Deref.html 
Khusus untuk Mutable Value, kita juga bisa menggunakan DerefMut
https://doc.rust-lang.org/std/ops/trait.DerefMut.html 
*/