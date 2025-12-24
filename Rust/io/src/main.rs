mod read_test;

use std::io::{self, Read};

fn main() { // cara apa adanya pakai srd::io::Read
    let file: Result<std::fs::File, io::Error>  = std::fs::File::open("test.txt");
    match file {
        Err(e) => panic!("{:?}", e),
        Ok(mut file) => {
            let mut buff: [u8; 1000] = [0u8;1000];
            match file.read(&mut buff) {
                Err(e) => panic!("{:?}", e.to_string()),
                Ok(bytes) => {
                    println!("data: {}", String::from_utf8_lossy(&buff[..bytes]));
                }
            }
        }
    }
}