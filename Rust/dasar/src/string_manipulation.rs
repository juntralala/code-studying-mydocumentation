#[test]
fn string_manipulation() {
    let s: String = String::from("Muhammad Junaidi");
    // let s: &str = "Muhammad Junaidi";

    println!("{}", s.to_lowercase());
    println!("{}", s.to_uppercase());
    println!("{}", s.len());
    println!("{}", s.replace("Muhammad", "Ahmad"));
    println!("{}", s.starts_with("Muhammad"));
    println!("{}", s.ends_with("di"));
    println!("{}", s.trim());
    println!("{:?}", s.get(0..4));
}