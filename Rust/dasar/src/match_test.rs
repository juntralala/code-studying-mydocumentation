fn main() {
    println!("=== 1. MATCH DASAR ===");
    let number = 3;
    match number {
        1 => println!("Satu"),
        2 => println!("Dua"),
        3 => println!("Tiga"),
        _ => println!("Angka lain"),
    }

    println!("\n=== 2. MATCH DENGAN MULTIPLE PATTERNS ===");
    let day = 6;
    match day {
        1 | 2 | 3 | 4 | 5 => println!("Hari kerja"),
        6 | 7 => println!("Akhir pekan"),
        _ => println!("Hari tidak valid"),
    }

    println!("\n=== 3. MATCH DENGAN RANGE ===");
    let age = 25;
    match age {
        0..=12 => println!("Anak-anak"),
        13..=17 => println!("Remaja"),
        18..=59 => println!("Dewasa"),
        60.. => println!("Lansia"),
        ..0 => println!("Invalid, umur tidak boleh kurang dari 0"),
    }

    println!("\n=== 4. MATCH DENGAN GUARD (if condition) ===");
    let num = 4;
    match num {
        x if x < 0 => println!("Negatif: {}", x),
        x if x == 0 => println!("Nol"),
        x if x % 2 == 0 => println!("Genap positif: {}", x),
        x => println!("Ganjil positif: {}", x),
    }

    println!("\n=== 5. MATCH TUPLE ===");
    let point = (0, 5);
    match point {
        (0, 0) => println!("Origin"),
        (0, y) => println!("Pada sumbu Y: {}", y),
        (x, 0) => println!("Pada sumbu X: {}", x),
        (x, y) => println!("Point ({}, {})", x, y),
    }

    println!("\n=== 6. MATCH ENUM ===");
    enum Direction {
        North,
        South,
        East,
        West,
    }
    
    let dir = Direction::North;
    match dir {
        Direction::North => println!("Ke Utara"),
        Direction::South => println!("Ke Selatan"),
        Direction::East => println!("Ke Timur"),
        Direction::West => println!("Ke Barat"),
    }

    println!("\n=== 7. MATCH ENUM DENGAN DATA ===");
    enum Message {
        Quit,
        Move { x: i32, y: i32 },
        Write(String),
        ChangeColor(i32, i32, i32),
    }
    
    let msg = Message::Move { x: 10, y: 20 };
    match msg {
        Message::Quit => println!("Keluar"),
        Message::Move { x, y } => println!("Pindah ke ({}, {})", x, y),
        Message::Write(text) => println!("Tulis: {}", text),
        Message::ChangeColor(r, g, b) => println!("Warna RGB({}, {}, {})", r, g, b),
    }

    println!("\n=== 8. MATCH DENGAN @ BINDING ===");
    let value = 15;
    match value {
        n @ 1..=10 => println!("Angka {} dalam range 1-10", n),
        n @ 11..=20 => println!("Angka {} dalam range 11-20", n),
        n => println!("Angka {} di luar range", n),
    }

    println!("\n=== 9. MATCH DESTRUCTURING STRUCT ===");
    struct Point {
        x: i32,
        y: i32,
    }
    
    let p = Point { x: 0, y: 7 };
    match p {
        Point { x: 0, y: 0 } => println!("Origin"),
        Point { x: 0, y } => println!("Pada sumbu Y di {}", y),
        Point { x, y: 0 } => println!("Pada sumbu X di {}", x),
        Point { x, y } => println!("Point di ({}, {})", x, y),
    }

    println!("\n=== 10. MATCH DENGAN IGNORING ===");
    let triple = (1, 2, 3);
    match triple {
        (1, _, _) => println!("Pertama adalah 1, sisanya diabaikan"),
        (_, 2, _) => println!("Kedua adalah 2"),
        _ => println!("Tidak cocok"),
    }

    println!("\n=== 11. MATCH DENGAN .. (REST PATTERN) ===");
    let numbers = (1, 2, 3, 4, 5);
    match numbers {
        (first, .., last) => println!("Pertama: {}, Terakhir: {}", first, last),
    }

    println!("\n=== 12. MATCH STRING ===");
    let name = "Budi";
    match name {
        "Ahmad" => println!("Halo Ahmad!"),
        "Budi" => println!("Halo Budi!"),
        "Citra" => println!("Halo Citra!"),
        _ => println!("Halo, siapa namamu?"),
    }

    println!("\n=== 13. MATCH CHAR ===");
    let letter = 'a';
    match letter {
        'a'..='z' => println!("Huruf kecil"),
        'A'..='Z' => println!("Huruf besar"),
        '0'..='9' => println!("Angka"),
        _ => println!("Karakter lain"),
    }

    println!("\n=== 14. MATCH BOOLEAN ===");
    let is_active = true;
    let status = match is_active {
        true => "Aktif",
        false => "Nonaktif",
    };
    println!("Status: {}", status);

    println!("\n=== 15. MATCH DENGAN RETURN VALUE ===");
    let grade = 85;
    let letter_grade = match grade {
        90..=100 => "A",
        80..=89 => "B",
        70..=79 => "C",
        60..=69 => "D",
        _ => "F",
    };
    println!("Nilai: {}", letter_grade);

    println!("\n=== 16. NESTED MATCH ===");
    enum Color {
        RGB(i32, i32, i32),
        HSL(i32, i32, i32),
    }
    
    let color = Color::RGB(255, 0, 0);
    match color {
        Color::RGB(r, g, b) => {
            match r {
                255 => println!("Red penuh!"),
                _ => println!("RGB: ({}, {}, {})", r, g, b),
            }
        }
        Color::HSL(h, s, l) => println!("HSL: ({}, {}, {})", h, s, l),
    }

    println!("\n=== 17. MATCH DENGAN REFERENCE ===");
    let reference = &4;
    match reference {
        &val => println!("Nilai: {}", val),
    }

    println!("\n=== 18. MATCH ARRAY/SLICE ===");
    let arr = [1, 2, 3];
    match arr {
        [1, 2, 3] => println!("Array [1, 2, 3]"),
        [1, x, y] => println!("Array dimulai dengan 1: [{}, {}]", x, y),
        _ => println!("Array lain"),
    }

    println!("\n=== 19. MATCH DENGAN MULTIPLE GUARDS ===");
    let pair = (2, -2);
    match pair {
        (x, y) if x == y => println!("Sama"),
        (x, y) if x + y == 0 => println!("Berlawanan"),
        (x, y) if x > y => println!("{} lebih besar dari {}", x, y),
        (x, y) => println!("{} lebih kecil dari {}", x, y),
    }

    println!("\n=== 20. MATCH COMPLEX ENUM ===");
    enum Vehicle {
        Car { brand: String, year: i32 },
        Bike { brand: String },
        Boat,
    }
    
    let my_car = Vehicle::Car {
        brand: String::from("Toyota"),
        year: 2020,
    };
    
    match my_car {
        Vehicle::Car { brand, year } if year > 2015 => {
            println!("Mobil {} modern (tahun {})", brand, year)
        }
        Vehicle::Car { brand, year } => {
            println!("Mobil {} lama (tahun {})", brand, year)
        }
        Vehicle::Bike { brand } => println!("Motor {}", brand),
        Vehicle::Boat => println!("Perahu"),
    }

    println!("\n=== 21. MATCH DENGAN WILDCARD DI TENGAH ===");
    let nums = (1, 2, 3, 4);
    match nums {
        (1, _, _, 4) => println!("Dimulai 1, diakhiri 4"),
        _ => println!("Pattern lain"),
    }

    println!("\n=== 22. MATCH UNTUK ERROR HANDLING ===");
    fn divide(a: i32, b: i32) -> Result<i32, String> {
        if b == 0 {
            Err(String::from("Tidak bisa dibagi nol"))
        } else {
            Ok(a / b)
        }
    }
    
    let result = divide(10, 2);
    match result {
        Ok(value) => println!("Hasil: {}", value),
        Err(error) => println!("Error: {}", error),
    }

    println!("\n=== 23. MATCH DENGAN DESTRUCTURING DAN RENAME ===");
    struct Person {
        name: String,
        age: i32,
    }
    
    let person = Person {
        name: String::from("Ali"),
        age: 30,
    };
    
    match person {
        Person { name: n, age: a } if a >= 18 => {
            println!("{} adalah dewasa (umur {})", n, a)
        }
        Person { name: n, age: a } => {
            println!("{} masih muda (umur {})", n, a)
        }
    }

    println!("\n=== 24. MATCH OPTION (WITHOUT GENERIC SYNTAX) ===");
    let some_value = Some(5);
    match some_value {
        Some(x) => println!("Ada nilai: {}", x),
        None => println!("Tidak ada nilai"),
    }

    println!("\n=== 25. EXHAUSTIVE MATCHING ===");
    // Rust memastikan semua kemungkinan tercakup
    enum Traffic {
        Red,
        Yellow,
        Green,
    }
    
    let light = Traffic::Red;
    let action = match light {
        Traffic::Red => "Berhenti",
        Traffic::Yellow => "Hati-hati",
        Traffic::Green => "Jalan",
        // Tidak perlu _ karena semua variant sudah tercakup
    };
    println!("Lampu merah: {}", action);
}