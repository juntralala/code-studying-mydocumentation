/* error handling
Error merupakan hal yang sudah biasa dalam pembuatan aplikasi
Hampir semua bahasa pemrograman memiliki fitur untuk Error Handling, termasuk Rust
Rust membagi error menjadi dua jenis recoverable (dapat dipulihkan) dan unrecoverable (tidak dapat dipulihkan)
Rust tidak punya tipe data Exception, seperti di Java, PHP, JavaScript
Rust menggunakan pendekatan lain untuk Error Handling
*/

/* Uncoverable Error
Jika terdapat jenis error yang menurut kita tidak bisa dipulihkan, maka kita bisa gunakan jenis Unrecoverable Error
Rust menggunakan macro panic! untuk melakukan ini
Misal saat aplikasi yang kita buat berjalan, ternyata tidak ada konfigurasi untuk terkoneksi ke database. Tidak ada gunanya mengecek ulang pada kasus ini misalnya, lebih baik matikan aplikasi dan sebutkan error bahwa konfigurasi tidak ada. Pada kasus ini, kita bisa gunakan Unrecoverable Error
Beberapa hal di Rust juga menggunakan Unrecoverable Error, contoh ketika mengakses index di array / vector diluar jangkauan index nya
*/
fn connect_database(host: Option<String>) {
    match host {
        Some(host) => {
            println!("Connecting to database at {}", host);
        }
        None => {
            panic!("No database host provided");
        }
    }
}
#[test]
fn test_unrecoverable_error() {
    connect_database(None);
}

/* Coverable Error
Seperti yang dijelaskan di awal, Rust tidak memiliki tipe data Exception. Lantas bagaimana untuk jenis Recoverable Error? Sama seperti Enum Option, Rust menyediakan Enum Result untuk ini
Jadi ketika misal kita membuat function yang bisa mengembalikan sukses atau gagal, kita bisa buat function dengan return value Enum Result
Enum Result hanya memiliki dua nilai, Ok(T) dan Err(E)
https://doc.rust-lang.org/std/result/index.html 
https://doc.rust-lang.org/std/result/enum.Result.html 
*/
fn connect_cache(host: Option<String>) -> Result<String, String> {
    match host {
        Some(host) => Ok(host),
        None => Err("No cache host provided".to_string()),
    }
}
#[test]
fn test_recoverable_error() {
    let cache = connect_cache(None);
    match cache {
        Ok(host) => {
            println!("Connected to cache at {}", host);
        }
        Err(err) => {
            println!("Error connecting to cache: {}", err);
        }
    }
}

/* Operator ?
Saat menggunakan Recoverable Error, kadang kita sering memanggil beberapa jenis function yang menghasilkan Result, lalu ingin mengecek, jika Err maka kita ingin langsung mengembalikan error itu secara langsung
Jika melakukan manual menggunakan Pattern Matching, kadang menyulitkan
Kita bisa menggunakan ? Operator, yang secara otomatis bisa mengembalikan Result jika memang Err
*/
fn connect_application_without(host: Option<String>) -> Result<String, String> { // tanpa operator ?
    let cache_result = connect_cache(host.clone());
    match cache_result {
        Ok(_) => {}
        Err(err) => {
            return Err(err);
        }
    }
    
    // let email_result = connect_email(host.clone());
    // match email_result {
    //     Ok(_) => {}
    //     Err(err) => {
    //         return Err(err);
    //     }
    // }
    
    Ok("Connected to application".to_string())
}

fn connect_application(host: Option<String>) -> Result<String, String> { // pakai operator ?
    connect_cache(host.clone())?;
    // connect_email(host.clone())?;
    Ok("Connected to application".to_string())
}

#[test]
fn test_connect_app() {
    let result = connect_application(Some("localhost".to_string()));
    match result {
        Ok(msg) => {
            println!("{}", msg);
        }
        Err(err) => {
            println!("Error connecting to application: {}", err);
        }
    }
}