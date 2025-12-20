/* Iterator
Rust memiliki module Iterator, yang digunakan sebagai mekanisme untuk melakukan operasi terhadap urutan dari data
Semua tipe data yang multiple seperti Array, Slice dan Collection memiliki fitur Iterator
Dengan menggunakan Iterator, secara otomatis kita bisa melakukan iterasi data menggunakan For Loop terhadap value tersebut
https://doc.rust-lang.org/std/iter/index.html 
*/
#[test]
fn test_iterator() {
    let array: [i32; 5] = [1, 2, 3, 4, 5];
    let mut iterator = array.iter();
    
    while let Some(value) = iterator.next() {
        println!("{}", value);
    }
    
    for value in iterator {
        println!("{}", value);
    }
}


/* Iterator Methods
Iterator memiliki banyak sekali method yang bisa kita gunakan untuk memanipulasi data 
Kebanyakan method di Iterator itu menggunakan Closure sebagai parameternya
Ada banyak sekali method yang disediakan, dan disarankan untuk membaca dokumentasinya secara langsung
https://doc.rust-lang.org/std/iter/trait.Iterator.html 
*/
#[test]
fn test_iterator_method() {
    let vector: Vec<i32> = vec![1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
    println!("Vector: {:?}", vector);
    let sum: i32 = vector.iter().sum();
    println!("Sum: {}", sum);
    let count: usize = vector.iter().count();
    println!("Count: {}", count);
    let doubled: Vec<i32> = vector.iter().map(|x| x * 2).collect();
    println!("Doubled: {:?}", doubled);
    let odd: Vec<&i32> = vector.iter().filter(|x| *x % 2 != 0).collect();
    println!("Odd: {:?}", odd);
}