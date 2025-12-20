// 1. ENUM DASAR
enum Direction {
    North,
    South,
    East,
    West,
}

// 2. ENUM DENGAN DATA (Variants dengan nilai)
enum Message {
    Quit,                       // Tanpa data
    Move { x: i32, y: i32 },   // Struct-like variant
    Write(String),              // Tuple-like variant
    ChangeColor(i32, i32, i32), // Multiple values
}

// 3. ENUM DENGAN GENERIC
enum Option<T> {
    Some(T),
    None,
}

enum Result<T, E> {
    Ok(T),
    Err(E),
}

// 4. ENUM DENGAN METHOD
enum WebEvent {
    PageLoad,
    PageUnload,
    KeyPress(char),
    Paste(String),
    Click { x: i64, y: i64 },
}

impl WebEvent {
    fn describe(&self) -> String {
        match self {
            WebEvent::PageLoad => String::from("Page loaded"),
            WebEvent::PageUnload => String::from("Page unloaded"),
            WebEvent::KeyPress(c) => format!("Key '{}' pressed", c),
            WebEvent::Paste(s) => format!("Pasted: {}", s),
            WebEvent::Click { x, y } => format!("Clicked at x={}, y={}", x, y),
        }
    }
}

// 5. ENUM DENGAN DISCRIMINANT (nilai eksplisit)
#[repr(u8)]
enum Color {
    Red = 1,
    Green = 2,
    Blue = 3,
}

// 6. ENUM RECURSIVE dengan Box
enum List {
    Cons(i32, Box<List>),
    Nil,
}

// 7. ENUM DENGAN ATTRIBUTE
#[derive(Debug, Clone, PartialEq)]
enum Status {
    Active,
    Inactive,
    Pending,
}

// 8. ENUM COMPLEX dengan berbagai tipe data
enum IpAddr {
    V4(u8, u8, u8, u8),
    V6(String),
}

fn main() {
    // === PENGGUNAAN ENUM DASAR ===
    let dir = Direction::North;
    
    // === PATTERN MATCHING ===
    match dir {
        Direction::North => println!("Heading north!"),
        Direction::South => println!("Heading south!"),
        Direction::East => println!("Heading east!"),
        Direction::West => println!("Heading west!"),
    }
    
    // === ENUM DENGAN DATA ===
    let msg1 = Message::Write(String::from("Hello"));
    let msg2 = Message::Move { x: 10, y: 20 };
    let msg3 = Message::ChangeColor(255, 0, 0);
    
    process_message(msg1);
    process_message(msg2);
    process_message(msg3);
    
    // === IF LET (Pattern matching sederhana) ===
    let event = WebEvent::KeyPress('x');
    if let WebEvent::KeyPress(c) = event {
        println!("Key pressed: {}", c);
    }
    
    // === WHILE LET ===
    let mut stack = vec![1, 2, 3];
    while let Some(top) = stack.pop() {
        println!("Popped: {}", top);
    }
    
    // === MENGGUNAKAN METHOD ===
    let click = WebEvent::Click { x: 100, y: 200 };
    println!("{}", click.describe());
    
    // === ENUM DENGAN DISCRIMINANT ===
    let red = Color::Red;
    println!("Red value: {}", red as u8);
    
    // === RECURSIVE ENUM ===
    let list = List::Cons(1, Box::new(List::Cons(2, Box::new(List::Nil))));
    print_list(&list);
    
    // === OPTION DAN RESULT (Built-in) ===
    let some_number = Some(5);
    let no_number: Option<i32> = None;
    
    match some_number {
        Some(n) => println!("Got number: {}", n),
        None => println!("No number"),
    }
    
    // === KOMBINASI DENGAN STRUCT ===
    let home = IpAddr::V4(127, 0, 0, 1);
    let loopback = IpAddr::V6(String::from("::1"));
    
    print_ip(home);
    print_ip(loopback);
    
    // === MATCH DENGAN GUARD ===
    let num = Some(4);
    match num {
        Some(x) if x < 5 => println!("Less than 5: {}", x),
        Some(x) => println!("Greater or equal 5: {}", x),
        None => println!("No value"),
    }
    
    // === MATCH DENGAN MULTIPLE PATTERNS ===
    let status = Status::Active;
    match status {
        Status::Active | Status::Pending => println!("In progress"),
        Status::Inactive => println!("Not active"),
    }
    
    // === DESTRUCTURING ===
    let msg = Message::Move { x: 5, y: 10 };
    if let Message::Move { x, y } = msg {
        println!("Moving to x={}, y={}", x, y);
    }
}

fn process_message(msg: Message) {
    match msg {
        Message::Quit => println!("Quit message"),
        Message::Move { x, y } => println!("Move to ({}, {})", x, y),
        Message::Write(text) => println!("Text: {}", text),
        Message::ChangeColor(r, g, b) => println!("Color RGB: ({}, {}, {})", r, g, b),
    }
}

fn print_list(list: &List) {
    match list {
        List::Cons(value, next) => {
            print!("{} -> ", value);
            print_list(next);
        }
        List::Nil => println!("Nil"),
    }
}

fn print_ip(ip: IpAddr) {
    match ip {
        IpAddr::V4(a, b, c, d) => println!("IPv4: {}.{}.{}.{}", a, b, c, d),
        IpAddr::V6(addr) => println!("IPv6: {}", addr),
    }
}

// === ADVANCED: ENUM DENGAN LIFETIME ===
enum Cow<'a> {
    Borrowed(&'a str),
    Owned(String),
}

// === ENUM DENGAN TRAIT ===
trait Drawable {
    fn draw(&self);
}

enum Shape {
    Circle(f64),
    Rectangle(f64, f64),
}

impl Drawable for Shape {
    fn draw(&self) {
        match self {
            Shape::Circle(r) => println!("Drawing circle with radius {}", r),
            Shape::Rectangle(w, h) => println!("Drawing rectangle {}x{}", w, h),
        }
    }
}