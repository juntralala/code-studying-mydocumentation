/* slice
Slice adalah reference ke sebagian elemen dari data collection (misal array)
Karena slice adalah reference, jadi dia tidak punya ownership
Contoh misal kita punya array dengan total data 10, kita mau ambil 5 data terdepan, maka kita bisa membuat Slice sebagai reference data dari data ke-1 sampai ke-5
*/

/* range pada slice
Saat kita ingin mengambil sebagian data Collection menjadi slice, kita butuh menentukan range untuk Slice yang akan kita ambil
Rust sendiri memiliki banyak jenis range, sebelumnya kita sudah bahas tentang Range (exclusive) dan Range Inclusive, selain itu masih ada yang lain
https://doc.rust-lang.org/std/ops/index.html#structs 
*/

#[test]
fn mencoba_slice() {
    let array1: [i32;10] = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
    let slice1: &[i32] = &array1[..];
    println!("{:?}", slice1);

    let slice2: &[i32] = &array1[0..6];
    println!("{:?}", slice2);

    let slice3: &[i32] = &array1[5..];
    println!("{:?}", slice3);
}


/*
Sebelumnya, saat kita menggunakan tipe data text, kita selalu buat dalam bentuk &str (String Slice), hal ini sebenarnya berarti &str itu adalah reference ke sebagian atau seluruh data str
Saat kita menggunakan tipe data String, kita juga mengambil sebagian karakter di String, hasil dari sebagian data itu adalah &str (String Slice)
Karena &str itu adalah Slice, yang artinya adalah reference, maka sebenarnya tidak memiliki ownership, dan oleh karena itu ketika kita assign ke variable lain atau ke function, yang di copy sebenarnya adalah reference nya, datanya tetap menggunakan data yang sama
*/
#[test]
fn string_slice() {
    let name: String = String::from("ucup surucup");
    let string_slice : &str = &name[0..=3];
    println!("{}", string_slice);
}