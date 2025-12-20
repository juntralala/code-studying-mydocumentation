// closure artinya kita bisa membuat paramter dan return dengan tipe data function

#[test]
fn test_closure() {
    let hello: fn(&str) -> String = |name: &str| -> String {
        format!("hello {}", name)
    };

    println!("{}",hello("ujun"));
}