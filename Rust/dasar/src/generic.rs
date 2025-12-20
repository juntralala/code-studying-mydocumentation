// 1. Generic Function - Fungsi yang bekerja dengan berbagai tipe data
fn largest<T: PartialOrd>(list: &[T]) -> &T {
    let mut largest = &list[0];
    for item in list {
        if item > largest {
            largest = item;
        }
    }
    largest
}

#[test]
fn test_largest_with_integers() {
    let numbers = vec![34, 50, 25, 100, 65];
    assert_eq!(*largest(&numbers), 100);
}

#[test]
fn test_largest_with_chars() {
    let chars = vec!['y', 'm', 'a', 'q'];
    assert_eq!(*largest(&chars), 'y');
}

// 2. Generic Struct - Struct yang dapat menyimpan berbagai tipe data
struct Point<T> {
    x: T,
    y: T,
}

impl<T> Point<T> {
    fn new(x: T, y: T) -> Self {
        Point { x, y }
    }
}

#[test]
fn test_point_with_integers() {
    let point = Point::new(5, 10);
    assert_eq!(point.x, 5);
    assert_eq!(point.y, 10);
}

#[test]
fn test_point_with_floats() {
    let point = Point::new(1.5, 4.2);
    assert_eq!(point.x, 1.5);
    assert_eq!(point.y, 4.2);
}

// 3. Generic Struct dengan Multiple Type Parameters
struct Pair<T, U> {
    first: T,
    second: U,
}

impl<T, U> Pair<T, U> {
    fn new(first: T, second: U) -> Self {
        Pair { first, second }
    }

    fn get_first(&self) -> &T {
        &self.first
    }

    fn get_second(&self) -> &U {
        &self.second
    }
}

#[test]
fn test_pair_different_types() {
    let pair = Pair::new(42, "hello");
    assert_eq!(*pair.get_first(), 42);
    assert_eq!(*pair.get_second(), "hello");
}

#[test]
fn test_pair_same_types() {
    let pair = Pair::new(10, 20);
    assert_eq!(*pair.get_first(), 10);
    assert_eq!(*pair.get_second(), 20);
}

// 4. Generic Enum - Mirip Option dan Result di standard library
enum MyResult<T, E> {
    Success(T),
    Error(E),
}

impl<T, E> MyResult<T, E> {
    fn is_success(&self) -> bool {
        match self {
            MyResult::Success(_) => true,
            MyResult::Error(_) => false,
        }
    }

    fn unwrap(self) -> T {
        match self {
            MyResult::Success(val) => val,
            MyResult::Error(_) => panic!("Called unwrap on Error"),
        }
    }
}

#[test]
fn test_my_result_success() {
    let result: MyResult<i32, &str> = MyResult::Success(42);
    assert!(result.is_success());
    assert_eq!(result.unwrap(), 42);
}

#[test]
fn test_my_result_error() {
    let result: MyResult<i32, &str> = MyResult::Error("Something went wrong");
    assert!(!result.is_success());
}

// 5. Generic dengan Trait Bounds - Membatasi tipe yang bisa digunakan
use std::fmt::Display;

fn print_and_return<T: Display>(value: T) -> T {
    println!("Value: {}", value);
    value
}

struct Container<T: Display> {
    value: T,
}

impl<T: Display> Container<T> {
    fn new(value: T) -> Self {
        Container { value }
    }

    fn display(&self) -> String {
        format!("{}", self.value)
    }
}

#[test]
fn test_print_and_return() {
    let result = print_and_return(42);
    assert_eq!(result, 42);
}

#[test]
fn test_container_display() {
    let container = Container::new("Hello, Rust!");
    assert_eq!(container.display(), "Hello, Rust!");
}

// 6. Generic dengan Multiple Trait Bounds
fn compare_and_print<T: PartialOrd + Display>(a: T, b: T) -> T {
    if a > b {
        println!("{} is greater", a);
        a
    } else {
        println!("{} is greater or equal", b);
        b
    }
}

#[test]
fn test_compare_integers() {
    let result = compare_and_print(10, 5);
    assert_eq!(result, 10);
}

#[test]
fn test_compare_strings() {
    let result = compare_and_print("zebra", "apple");
    assert_eq!(result, "zebra");
}

// 7. Generic Collection/Wrapper
struct Stack<T> {
    items: Vec<T>,
}

impl<T> Stack<T> {
    fn new() -> Self {
        Stack { items: Vec::new() }
    }

    fn push(&mut self, item: T) {
        self.items.push(item);
    }

    fn pop(&mut self) -> Option<T> {
        self.items.pop()
    }

    fn is_empty(&self) -> bool {
        self.items.is_empty()
    }

    fn size(&self) -> usize {
        self.items.len()
    }
}

#[test]
fn test_stack_operations() {
    let mut stack = Stack::new();
    assert!(stack.is_empty());

    stack.push(1);
    stack.push(2);
    stack.push(3);

    assert_eq!(stack.size(), 3);
    assert_eq!(stack.pop(), Some(3));
    assert_eq!(stack.pop(), Some(2));
    assert_eq!(stack.size(), 1);
}

#[test]
fn test_stack_with_strings() {
    let mut stack = Stack::new();
    stack.push("hello");
    stack.push("world");

    assert_eq!(stack.pop(), Some("world"));
    assert_eq!(stack.pop(), Some("hello"));
    assert_eq!(stack.pop(), None);
}

// 8. Generic dengan Lifetime
struct Reference<'a, T> {
    value: &'a T,
}

impl<'a, T> Reference<'a, T> {
    fn new(value: &'a T) -> Self {
        Reference { value }
    }

    fn get(&self) -> &T {
        self.value
    }
}

#[test]
fn test_reference_wrapper() {
    let number = 42;
    let reference = Reference::new(&number);
    assert_eq!(*reference.get(), 42);
}

#[test]
fn test_reference_with_string() {
    let text = String::from("Rust");
    let reference = Reference::new(&text);
    assert_eq!(*reference.get(), "Rust");
}

// 9. Generic Method dengan Trait Implementation
trait Summable {
    fn sum(&self) -> i32;
}

struct NumberList<T> {
    items: Vec<T>,
}

impl Summable for NumberList<i32> {
    fn sum(&self) -> i32 {
        self.items.iter().sum()
    }
}

impl<T> NumberList<T> {
    fn new() -> Self {
        NumberList { items: Vec::new() }
    }

    fn add(&mut self, item: T) {
        self.items.push(item);
    }

    fn count(&self) -> usize {
        self.items.len()
    }
}

#[test]
fn test_number_list_sum() {
    let mut list = NumberList::new();
    list.add(1);
    list.add(2);
    list.add(3);

    assert_eq!(list.sum(), 6);
    assert_eq!(list.count(), 3);
}

// 10. Generic dengan Where Clause untuk readability
fn complex_function<T, U>(t: T, u: U) -> String
where
    T: Display + Clone,
    U: Display + Clone,
{
    format!("T: {}, U: {}", t, u)
}

#[test]
fn test_complex_function() {
    let result = complex_function(42, "hello");
    assert_eq!(result, "T: 42, U: hello");
}

#[test]
fn test_complex_function_same_type() {
    let result = complex_function(10, 20);
    assert_eq!(result, "T: 10, U: 20");
}

// 11. Generic dengan default type
struct Coordinate<T = i32> {
    x: T,
    y: T,
}
#[test]
fn test_generic_default_type() {
    let coordinate = Coordinate{x: 12, y:12};
    println!("x: {} y: {}", coordinate.x, coordinate.y)
}