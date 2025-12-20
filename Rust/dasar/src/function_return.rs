/*
ada yang unik di return nilai di rust,
kita bisa return tanpa keyword return, yakni meletakkan expresi di statement terakhir function
pakai keyword return juga bisa.
*/

fn _sum(nums: [i32;3]) -> i32 {
    let mut result: i32 = 0;
    for num in nums  {
        result += num;
    }
    result
}

#[test]
fn coba_return() {
    let result: i32 = _sum([1, 3, 6]);
    println!("hasil {}", result);
}