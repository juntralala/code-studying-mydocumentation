/* Optional value
Jika sebelumnya kita pernah belajar bahasa pemrograman seperti Java, JavaScript atau PHP, mungkin kita mengenal dengan istilah Null atau Undefined
Yaitu nilai kosong (tidak ada) pada variable
Rust tidak mengenal hal itu, saat membuat variable maka kita wajib mengisi value pada variable tersebut, hal ini agar ketika kita mengakses variable tersebut, akan aman karena sudah dipastikan bahwa variable tersebut berisi data
Lantas bagaimana jika kita ingin membuat variable yang memang datanya tidak wajib kita isi? Maka kita bisa menggunakan Option Enum
*/

// operator perbandingan juga bisa di overload btw

fn find(id: Option<String>) -> Option<String> {
    match id {
        None => None,
        Some(val) => Some("Finded User".to_string())
    }
}

#[test]
fn test_optional_value() { // note, enum data nggak bisa diambil kecuali pakai match ata if
    let user = find(Option::Some("id".to_string()));
    println!("{:?}", user);
    if let Option::Some(user_data) = user {
        println!("{}", user_data);
    }

    let user = find(Option::None);
    println!("{:?}", user);
}