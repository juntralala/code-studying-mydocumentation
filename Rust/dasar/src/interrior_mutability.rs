/* Interrior Mutability
Interior Mutability adalah design pattern dalam Rust yang yang memperbolehkan kita mengubah data walaupun ada reference yang immutable terhadap data tersebut
Sebelumnya kita tahu untuk membuat mutable reference, kita bisa gunakan &mut, namun selain itu kita juga bisa menggunakan cara lain.
Untuk melakukan hal ini, kita bisa menggunakan type RefCell<T>
*/

/* RefCell<T>
Tidak seperti Rc<T>, RefCell<T> merepresentasikan single ownership pada data yang ditunjuk. Lantas apa bedanya dengan Box<T> ?
Pada materi borrowing kita tahu bahwa pada satu waktu, tidak diperbolehkan membuat mutable reference lebih dari satu, sehingga Rust tidak akan bisa melakukan kompilasi kode program
Dengan RefCell<T>, pengecekan jadi terjadi pada proses runtime (ketika program berjalan), bukan lagi ketika proses kompilasi
https://doc.rust-lang.org/core/cell/struct.RefCell.html 
*/

/* Aturan RefCell<T>
Banyak immutable borrow diperbolehkan
Satu mutable borrow diperbolehkan
Banyak mutable borrow tidak diperbolehkan
Sekaligus mutable dan immutable borrow tidak diperbolehkan
*/

// malas bikin contohnya