// /*
// method ya method,
// method di rust bisa ada di struct, enum dan trait
// */

// /* Associated Function (mirip static method di bahasa OOP)
// Setiap function yang dibuat dalam impl kita sebut dengan Associated Functions, karena terkait dengan tipe data yang kita tentukan di impl
// Associated Functions yang memiliki parameter self artinya adalah Method, dan dipanggil setelah kita membuat instance nya
// Namun, kita juga bisa membuat function tanpa parameter self, yang artinya function tersebut tidak terhubung dengan instance-nya
// Untuk memanggil Associated Functions yang bukan Method, kita bisa langsung gunakan NamaType.nama_function()
// Biasanya Associated Functions bukan Method, digunakan untuk membuat instance dari Type nya
// */

// struct Person {
//     name: String,
//     age: i32,
// }

// impl Person {
//     fn intro(&self) {
//         println!("hello, my name is {}, i am {} old", self.name, self.age);
//     }

//     fn new(name: String, age: i32) -> Person {
//         Person{name: name, age: age}
//     }
// }

// #[test]
// fn test_method_dan_associated_function() {
//     let ujun = Person::new(String::from("ujun"), 12);
//     ujun.intro();
// }