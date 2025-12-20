/*
Trait adalah definisi fungsionalitas untuk tipe data lain
Biasanya Trait digunakan untuk dasar dari implementasi beberapa tipe data
Di bahasa pemrograman lain seperti Java atau Golang, Trait mirip seperti Interface
Trait berisi definisi method tanpa implementasi konkrit
Untuk membuat Trait, kita bisa menggunakan kata kunci trait, diikuti dengan nama Trait nya

struct bisa di implementasikan ke struct atau enum
*/

trait CanSayHello {
    fn hello(&self, name: String); // bisa juga ini dikasih body method, sama kyak java, namanya default implementation
}

trait CanSayGoodBye {
    fn goodbye(&self, name: String) { // bisa punya default implementation
        println!("bye {}", name);
    }
}

struct Person {} 

impl CanSayHello for Person {
    fn hello(&self, name: String) {
        println!("hello {}", name);
    }
}
impl CanSayGoodBye for Person { // mengimplementasikan trait lebih 1
    fn goodbye(&self, name: String) {
        println!("goodbye {}", name);
    }
}

trait CanSay: CanSayHello + CanSayGoodBye { // <- fitur super trait (mirip pewarisan kalau di oop), pakai + untuk mewarisi lebih dari 1 trait

}

/*
Type itu bisa mengimplementasikan lebih dari satu Trait
Oleh karena itu, saat kita membuat parameter juga, kita bisa buat satu parameter untuk beberapa tipe Trait
Kita bisa gunakan tanda + (plus) jika ingin membuat parameter dengan tipe Multiple Trait, misal (impl Trait1 + Trait2 + Trait3)
*/

/* return trait
Selain untuk Parameter, Trait juga bisa digunakan sebagai Return Value di function
Namun seperti yang dijelaskan di awal, karen Trait tidak bisa dibuat instance-nya secara langsung, maka value yang kita kembalikan juga harus dalam bentuk implementasi Type nya
Untuk membuat Trait sebagai return value, kita perlu sebutkan seperti Parameter, yaitu impl NamaTrait nya
*/

/* conflict method name
Salah satu problem ketika menggunakan beberapa Trait adalah, kadang nama method di Trait bentrok atau konflik dengan method di Trait lainnya
Atau bahkah bisa bentrok dengan method di Type nya sendiri
Contoh sebelumnya, kita membuat method say_hello() di Trait CanSayHello, dan Person juga sudah memiliki method say_hello()
Saat kita buat implementasi dari Trait, Rust tidak akan menjadikan itu sebagai error, namun masalahnya terjadi ketika kita memanggil method nya
Rust akan menjadikan itu error karena method nya ambigu, Rust akan komplen karena ada beberapa method dengan nama yang sama
Cara agar kita bisa menentukan method yang ingin kita panggil, kita bisa sebutkan Type::nama_method(instance)
*/
#[test]
fn conflict_method_name() {
    let person = Person{};
    
    Person::hello(&person, "ajid".to_string());
    CanSayHello::hello(&person, "ajid".to_string());
}

/* Super Trait
Trait bisa digabungkan dengan konsep mirip pewarisan, dimana satu Trait bisa memiliki memiliki beberapa Trait dibawahnya
Trait yang ada diatasnya bisa kita sebut Super Trait
Misal kita punya Trait A, lalu kita buat Trait B dan Trait C, Trait A kita jadikan sebagai Super Trait dari Trait B dan Trait C
Artinya sekarang jika kita implementasi Trait B atau Trait C, secara otomatis kita harus implementasi juga Trait A
Trait boleh memiliki lebih dari satu Super Trait, caranya kita bisa gunakan tanda + (plus)
*/