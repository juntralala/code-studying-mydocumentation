/*
Sebelumnya kita sering menggunakan println!
println! adalah macro, bukan function
Saat menggunakan macro println!, kita sering menambahkan parameter tambahan untuk menampilkan data
Secara default, data tidak bisa ditampilkan dalam macro println!, yang bisa ditampilkan hanyalah data yang sudah implementasi Module core:fmt
https://doc.rust-lang.org/core/fmt/index.html 
*/

/*
Saat kita menggunakan formatting, kita sering menggunakan {} (Display), atau {:?} (Debug). Pertanyaannya, lebih baik pilih yang mana? 
Sebenarnya kalo diperhatikan, kebanyakan tipe data yang primitive menggunakan Display, sedangkan tipe data kompleks seperti Array, Slice, itu banyak menggunakan Debug
Tapi sebenarnya kita juga bisa implementasi Display dan Debug secara bersamaan jika memang mau
*/

// tinggal bikin struct implement Display atau Debug
// aku malas bikin contohnya