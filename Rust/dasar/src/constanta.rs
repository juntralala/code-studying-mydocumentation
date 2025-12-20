/*
Constant adalah variable immutable menggunakan kata kunci const
Yang membedakan const dan let adalah, const tidak memiliki mutable, selain itu nilai const harus dideklarasikan ketika kode program dibuat (bukan dijalankan), oleh karena itu nilai const tidak bisa hasil dari kalkulasi nilai lain yang belum jelas hasilnya
Untuk membuat const, wajib disebutkan tipe datanya secara eksplisit
Nama const di Rust harus huruf besar, dan biasanya pemisah kata menggunakan _ (garis bawah)
*/
#[test]
fn membuat_const() {
    const MAX: i32 = 100;
    println!("{}", MAX);
}