/*
sama kayak bahasa lain juga,
tapi bisa dipake sebagai expression.
ada:
for in 
while
dan loop

untuk return nilai dari loop pakai keyword break
*/

#[test]
fn menggunakan_loop_sebagai_expression() {
    let mut counter: i32 = 0;
    let result = loop {
        counter += 1;
        break counter;
    };
    println!("{}", result);
}