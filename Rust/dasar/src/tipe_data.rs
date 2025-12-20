/*
saat tidak secara explisit menentukan tipe data maka default tipedatanya
number = i32
decimal = float64
*/
#[test]
fn tipe_data_number() {
    let number1: i8 = 127;
    let number2: i16 = 32_000;
    let number3: i32 = 2_000_000_000;
    let number4: i64 = 1_000_000_000_000_000_000;
    let number5: i128 = 9999;

    let number6: u8 = 255;
    let number7: u16 = 64_000;
    let number8: u32 = 2_000_000_000;
    let number9: u64 = 1_000_000_000_000_000_000;
    let number10: u128 = 9999;

    let des1: f32 = 0.12121;
    let des2: f64 = 0.12121;

    let usize1: isize = 12121; // tipe data integer 32/64bit tergantung platform (os) 32bit atau 64bit
    let usize2: usize = 12121; // unsignednya

    println!("{}, {}, {}, {}, {}", number1, number2, number3, number4, number5);
    println!("{}, {}, {}, {}, {}", number6, number7, number8, number9, number10);
    println!("{}, {}", des1, des2);
    println!("{}, {}", usize1, usize2);
}

#[test]
fn tipe_data_boolean() {
    let a: bool = true;
    println!("{}", a);
}

#[test]
fn tipe_data_char() {
    let a: char = 'a';
    let b: char = 'b';
    println!("{}", a);
    println!("{}", b);
}

/*
Tuple adalah tipe data kumpulan lebih dari satu tipe data
Jumlah data di Tuple sudah final, artinya tidak bisa berkurang atau bertambah
Jika kita membuat Tuple dengan total ada 3 data, maka tidak akan bisa diubah lagi jumlah data dan juga tipe data nya
Untuk membuat Tuple, kita bisa gunakan () tanda kurung 
*/
#[test]
fn tipe_data_tuple() {
    let mut items: (i32, f64, bool) = (2121, 0.32, false);
    println!("{:?}", items);

    let item1: i32 = items.0;
    let item2: f64 = items.1;
    let item3: bool = items.2;
    println!("{}, {}, {}", item1, item2, item3);

    let (a, b, c) = items; // destrccture tuple
    println!("{}, {}, {}", a, b, c);

    items.0 = 30000;
    items.1 = 31.0231;
    print!("{:?}", items);
}

/*
Unit adalah tuple tanpa nilai apapun, ditulisnya ()
Hal ini mungkin kelihatan tidak ada gunanya
Biasanya Unit ini digunakan untuk function-function yang tidak membutuhkan hasil data apapun
*/
fn _hello() {
    println!("Halo");
}
#[test]
fn tipe_data_unit(){
    let mut kosong: () = _hello();
    println!("{:?}", kosong);
    
    kosong = ();
    println!("{:?}", kosong);
}

#[test]
fn tipe_data_array() {
    let mut arr: [i32;5] = [120, 40, 50, 1, 2]; 
    println!("{:?}", arr);
    
    let item1: i32 = arr[1];
    let item2: i32 = arr[4];
    println!("{}, {}", item1, item2);
    
    arr[0] = 100;
    println!("{:?}", arr);

    println!("panjang: {}", arr.len())
}

/*
Rust memiliki tipe data text yang fixed size, yaitu &str (string slice), dan yang bisa mengembang ukurannya, yaitu String
&str karena ukurannya fixed size, jadi Rust akan menyimpannya di Stack, sedangkan String karena bisa mengembang, maka disimpan di Heap

&str itu masih punya method, tapi kaya immutable biasanya, method yg modifikasi teks adalah bikin &str baru
 */
#[test]
fn tipe_data_str_dan_string() {
    let fixed_text: &str = "hello";
    let text: String = String::from("ujun");

    println!("{} {}", fixed_text, text);
}

/*
sebuah tipe data yang sering untuk membantu perulangan 
*/
#[test]
fn tipe_data_range_exclusive() {
    let rentang = 1..3;
    println!("{:?}", rentang);

    for i in 1..10 { // tidak termasuk 10
        println!("Hello {}", i);
    }
}

/*
Selain Range yang exclusive, Rust juga memiliki tipe data Range Inclusive
Implementasinya berbeda dengan Range sebelumnya
https://doc.rust-lang.org/std/ops/struct.RangeInclusive.html 
*/
#[test]
fn tipe_data_range_inclusive() {
    let rentang = 1..=10; // termasuk 10
    for i in rentang {
        println!("Hello {}", i);
    }
}
