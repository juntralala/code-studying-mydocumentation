// <============================== ChatGPT-3.5 ==============================>
/* 
Promise bekerja berdasarkan tiga status utama: `pending`, `fulfilled`, dan `rejected`. Berikut adalah
langkah-langkah cara kerja promise:

1. **Pembuatan Promise:**
   - Sebuah promise dibuat dengan membuat instance dari objek `Promise`. Pada saat pembuatan, promise berada dalam
     status `pending`.

    ```javascript
    const myPromise = new Promise((resolve, reject) => {
      // Code untuk operasi asinkron
    });
    ```

2. **Operasi Asinkron:**
   - Kode untuk operasi asinkron ditempatkan di dalam executor function yang diteruskan sebagai argumen ke
     konstruktor promise. Executor function menerima dua parameter: `resolve` (fungsi yang dipanggil ketika
     operasi berhasil) dan `reject` (fungsi yang dipanggil ketika operasi gagal).

    */
    const myPromise = new Promise((resolve, reject) => {
      setTimeout(() => {
        // Operasi asinkron selesai, panggil resolve
        resolve("Data berhasil diambil");
      }, 1000);
    });
    /*

3. **Transisi Status:**
   - Promise dapat bertransisi dari status `pending` ke status `fulfilled` (berhasil) atau dari status `pending` 
     ke status `rejected` (gagal). Transisi ini tergantung pada apakah operasi asinkron di dalam promise berhasil
     atau gagal.

4. **Penggunaan `.then()` dan `.catch()`:**
   - Untuk menangani hasil yang sukses (status `fulfilled`), kita menggunakan metode `.then()`. Untuk menangani
     kasus kegagalan (status `rejected`), kita menggunakan metode `.catch()`.

    ```javascript
    myPromise
      .then(result => {
        // Handle hasil yang sukses
        console.log(result);
      })
      .catch(error => {
        // Handle kasus kegagalan
        console.error(error);
      });
    ```

   Metode `.then()` akan dieksekusi ketika promise berada dalam status `fulfilled`, dan metode `.catch()` akan
   dieksekusi ketika promise berada dalam status `rejected`.

Cara kerja promise memungkinkan kita menangani operasi asinkron dengan lebih terstruktur dan membuat kode lebih
mudah dipelihara daripada menggunakan callback functions secara bersarang (callback hell). Selain itu, promise
memberikan kemampuan untuk menangani kasus kegagalan dengan lebih baik menggunakan `.catch()`.


*/