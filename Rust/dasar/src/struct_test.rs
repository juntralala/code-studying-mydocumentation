/* struct
Struct adalah tipe data mirip Tuple yang bisa digunakan untuk menampung beberapa data dengan tipe yang berbeda
Yang membedakan dengan Tuple, pada Struct, kita bisa memberi nama untuk tiap data-nya, atau dibilang field, sehingga lebih jelas dibanding Tuple yang hanya menggunakan number
Dengan menambahkan nama pada data di Struct, secara otomatis kita tidak perlu harus menentukan urutan posisi data yang selalu sama, bisa berubah-ubah seiring pembuatan kode
Untuk membuat Struct, kita bisa gunakan kata kunci struct
*/

/* struct update syntax
Kayak tipedata yg lain, saat kita buat instance Struct sebagai immutable, maka semua field di instance tersebut tidak bisa diubah
Nah, jika kita ingin mengubah immutable struct, kita harus bikin instance baru yang isinya berbeda (pake mutable sebenarnya bisa sih, tapi, aku nggak tau kenapa ada fitur ini).
Kita bisa pakai struct update syntax untuk membuat instance baru, mau ada beda data field atau tidak
Namun saat menggunakan struct update syntax, hati-hati dengan field yang memiliki value di Heap, karena ownershipnya secara otomatis akan dipindahkan ke field di instance baru
contohnya ada di struct_test()
*/
pub struct Person {
    pub name: String,
    pub age: u8
}

// bikin struct tanpa satupun field juga bisa sih btw
struct Orang;


#[test]
fn struct_test() {
    let ujun: Person = Person {
        name: String::from("Muhammad Junaidi"),
        age: 20
    };

    println!("name : {}", ujun.name);
    println!("age : {}", ujun.age);

    // struct_update_syntax
    let ozon: Person = Person {
        name: String::from("ozon"),
        ..ujun
    };

    // destructuring struct (wajib semua field)
    let Person{name, age} = ujun;           // nah ownership name terpindah
    // destructuring struct (dan mengabaikan sisanya)
    let Person{name, ..} = ozon;

    let ujun = Person{
        name, // gak perlu nulis nama field, kalo ngambil nilai dari variable dengan nama yang sama
        age,
    };
}

// tuple struct
struct Cube (
    i32,
    i32,
    i32
);
#[test]
fn test_tuple_struct() {
    let cube: Cube = Cube(12, 8, 6);
    println!("{}", cube.0);
    println!("{}", cube.1);
    println!("{}", cube.2);
}