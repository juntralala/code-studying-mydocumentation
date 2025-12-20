/* Macro
Sebelumnya, kita sudah sering menggunakan println!, itu bukanlah function, melainkan macro
Macro adalah fitur di Rust yang merupakan kode untuk membuat kode lainnya, di bahasa pemrograman lain, sering disebut dengan Metaprogramming
Kelebihan macro adalah, kisa bisa membuat kode yang kita mau sebelum Compiler melakukan kompilasi
Kekurangan macro adalah, implementasi macro lebih kompleks dibanding implementasi function biasa
*/
/* Declarative Macro
Salah satu cara yang umum dilakukan untuk membuat macro adalah Declarative Macro menggunakan macro_rules!
Saat membuat macro menggunakan macro_rules!, kita akan tentukan rule yang berisi (pattern) => {expansion}
Pattern merupakan kondisi yang diinginkan, dan expansion merupakan kode yang akan dibuat oleh macro
*/

macro_rules! hi {
    () => {
        println!("hi");   
    };
    ($name: expr) => {                       // <- ini yg dimaksud pattern
        println!("hi {}", $name);
    };
}

#[test]
fn membuat_macro() {
    hi!();
    hi!("ujun");
    hi! {
        "ujun"
    };
}

/* Pattern
Patterns yang terdapat di macro_rules sangat beragam, kita bisa cek di halaman dokumentasinya :
https://doc.rust-lang.org/reference/macros-by-example.html#metavariables 

contoh diatas
*/

/* Repitition
Kadang, saat membuat macro, kita butuh parameter lebih dari satu, atau di macro disebut repetition
Ketika menggunakan macro, kita bisa gunakan $() diikuti dengan koma, lalu repetion operator
*, artinya boleh berapapun
+, artinya boleh berapapun, tapi minimal satu
?, boleh satu atau kosong, sehingga tidak perlu pemisah koma 
 */

 macro_rules! iterate {
    ($array:expr) => {
        for i in $array {
            println!("{}", i);
        }
    };
    ($($item: expr), *) => {
        $(
            println!("{}", $item);
        )*
    };
}

#[test]
fn membuat_macro_repitition() {
    iterate!([1, 2, 3, 4, 5]);
    iterate!(10, 9, 8, 7, 6);
}
