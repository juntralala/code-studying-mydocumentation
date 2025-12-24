use std::io;
use std::error;
use std::fs;

fn read_data(mut reader: impl io::Read) -> String {
    let mut buffer: [u8;1000] = [0;1000];
    _ = reader.read(&mut buffer);
    String::from_utf8_lossy(&mut(buffer[..])).to_string()
}


/*
io rust punya Trait Read sebagai kontract (InputStream kalau di java)
*/
#[test]
fn test_read() -> Result<(), Box<dyn error::Error>> {
    let file: fs::File = fs::File::open("test.txt")?;
    let data: String = read_data(file);
    println!("{}", data);
    Ok(())
}