/*
penggunaan if else yang itu kayak bahasa lain,
kecuali di rust, if bisa dipakai sebagai expression 
*/
#[test]
fn menggunakan_if_sebagai_expression() {
    let age = 10;
    let result: &str = if age < 18 {
        "dibawah umur"
    } else {
        "cukup umur"
    };

    println!("{}", result);
}