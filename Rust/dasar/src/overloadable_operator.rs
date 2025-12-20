/* overloadalbe operator
Sebelumnya kita pernah belajar operator matematika untuk tipe data number
Apakah tipe data selain number mendukung operator matematika seperti +, -, dan yang lainnya?
Secara default tidak, namun Rust memiliki fitur dimana kita bisa mengimplementasikan operator dalam bentuk method, sehingga bisa menggunakan operator matematika
Semua operator direpresentasikan dalam Trait yang bisa kita implementasikan
Semua Trait-nya berada di Module/Crate core::ops
https://doc.rust-lang.org/core/ops/index.html
*/

use std::ops::Add;

struct Apple {
    quantity: i32,
}

impl Add for Apple {
    type Output = Apple;

    fn add(self, rhs: Self) -> Self::Output {
        Apple {
            quantity: self.quantity + rhs.quantity,
        }
    }
}

#[test]
fn overloadable_operators() {
    let apple1 = Apple { quantity: 10 };
    let apple2 = Apple { quantity: 20 };
    let apple3 = apple1 + apple2;
    println!("Apple quantity: {}", apple3.quantity);
}
