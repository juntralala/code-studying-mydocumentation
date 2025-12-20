mod tipe_data;
mod konversi_tipe_data;
mod constanta;
mod if_else_if_else;
mod looping;
mod function_return;
mod slice_test;
mod struct_test;
mod method_dan_associated_function;
mod closure_or_anonymous_function;
mod trait_test;
mod super_keyword_pada_nested_module;
mod generic;
mod optional_value_atau_nilai_kosong;
mod overloadable_operator;
mod string_manipulation;
mod error_handling;
mod iterators;
mod lifetime;

fn main() {
    println!("Hello world");
}


#[test]
fn hello_test() {
    println!("Hello World");
}

#[test]
fn membuat_variable() {
    let name = "muhammad junaidi";
    println!("Hello {}", name);
}

#[test]
fn membuat_variable_mutable() {
    let mut name = "muhammad junaidi";
    println!("Hello {}", name);

    name = "ujun";
    println!("Helo juga, {}", name);
}

#[test]
fn shadowing_variable() { // membuat 2 variable dengan nama yang sama, dan variable pertama itu ketutup
    let name = "junaidi";
    println!("halo {}", name);
    
    let name = "ujun";
    println!("halo {}", name);
}