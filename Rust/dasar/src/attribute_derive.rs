/* Derive
Salah satu Attribute yang sering digunakan adalah Derive Attribute
Derive Attribute adalah Attribute yang digunakan untuk membuat implementasi Trait secara otomatis
Tidak semua Trait bisa otomatis dibuat implementasinya, hanya yang sudah ditentukan
https://doc.rust-lang.org/rust-by-example/trait/derive.html 
*/

#[derive(Debug, PartialEq, PartialOrd)]
struct Company {
    name: String,
    location: String,
    website: String,
}

#[test]
fn test_attribute_debug() {
    let company = Company {
        name: "Rust".to_string(),
        location: "USA".to_string(),
        website: "https://www.rust-lang.org".to_string(),
    };
    
    println!("{:?}", company);
}