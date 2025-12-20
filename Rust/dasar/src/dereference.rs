// baca tentang smart pointer

#[test]
fn test_dereference() {
    let value1 = Box::new(10);
    let value2 = Box::new(20);
    
    let result: i32 = *value1 * *value2;
    println!("result: {}", result);
}