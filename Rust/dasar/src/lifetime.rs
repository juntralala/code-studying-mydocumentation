// 1 contoh lagi ada di generic.rs

/*
lifetime annotation tidak mengubah masa hidup suatu value
hanya membuat rust memberi pesan error lebih baik

lifetime annotation bisa di:
function
method
struct
*/


// lifetime annotation
fn longer<'a>(x: &'a str, y: &'a str) -> &'a str {
    if x.len() > y.len() {
        x
    } else {
        y
    }
}


// #[test] // bagaimana pun ini memang skenario error
// fn test_lifetime_annotation_dangling_reference() {
//     let string1 = String::from("Eko");
//     let result;
//     {
//         let string2 = String::from("Kurniawan");
//         result = longer(string1.as_str(), string2.as_str());
//     }
//     println!("The longest string is {}", result);
// }