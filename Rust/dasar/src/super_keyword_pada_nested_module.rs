/*
Saat kita membuat Nested Module, kadang kita ingin mengakses Module yang ada diatasnya
Untuk kasus seperti ini, kita bisa sebutkan nama module nya dari awal menggunakan crate, atau kita bisa sebut module parent nya dengan kata kunci super
*/

use second::third::say_hello as say_hello_third;

pub fn say_hello() {
    println!("Hello from first module");    
}

mod second {
    pub mod third {
        pub fn say_hello() {
            super::super::say_hello();
        }
    }
}

#[test]
fn super_keyword_pada_nested_module() {
    say_hello();

    say_hello_third();
}