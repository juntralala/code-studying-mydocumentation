#[test]
fn konversi_tipe_data() {
    let number: i32 = 100;

    let number2: i16 = number as i16;

    let number3: i8 = number as i8;

    println!("{}, {}", number3, number2)
}