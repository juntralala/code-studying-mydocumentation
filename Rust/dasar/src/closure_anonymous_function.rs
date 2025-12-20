#[test]
fn test_closure() {
    let hello: fn(&str) -> String = |name: &str| -> String {
        format!("hello {}", name)
    };

    println!("{}",hello("ujun"));
}