/**
 * Masalah dengan callback hell (contoh dari Programmer Zaman Now)
 */
// yang contoh dari Programmer Zaman Now tidak bisa di run karna function nya undeclared

doFirst(data, function(){
    doSecond(data, function(){
        doThird(data, function(){
            // Callback Hell
        })
    })
})



/** <========================= ChatGPT-3.5 =========================>
 * Callback hell (juga dikenal sebagai pyramid of doom) terjadi ketika terdapat banyak callback function
   bersarang secara dalam-dalam di dalam kode, menyebabkan kode menjadi sulit dibaca, sulit dipahami, dan
   sulit dipelihara. Hal ini terutama muncul dalam situasi di mana ada banyak operasi asinkron yang saling
   tergantung satu sama lain. Callback hell dapat terjadi karena callback function ditempatkan di dalam
   callback function lainnya, membentuk struktur seperti piramida.
 */

//=> Berikut adalah contoh sederhana callback hell dalam JavaScript:

function getData(callback) {
  setTimeout(function() {
    console.log("Data berhasil diambil");
    callback();
  }, 1000);
}

function processData(callback) {
  setTimeout(function() {
    console.log("Data diproses");
    callback();
  }, 1000);
}

function displayData() {
  console.log("Data ditampilkan");
}

// Callback hell
getData(function() {
  processData(function() {
    displayData();
  });
});

/**
Dalam contoh di atas, `getData`, `processData`, dan `displayData` masing-masing adalah operasi asinkron
yang membutuhkan waktu untuk mengeksekusi. Callback hell terjadi karena setiap callback function
ditempatkan di dalam callback function lainnya, membentuk struktur bertingkat yang sulit dibaca.

Untuk mengatasi callback hell, beberapa pendekatan dapat diambil:

1. **Gunakan Named Functions:**
  - Membuat fungsi-fungsi bernama dapat membantu mengurangi tingkat bersarang dan membuat kode lebih bersih.
 */
function getData(callback) {
  setTimeout(function() {
    console.log("Data berhasil diambil");
    callback();
  }, 1000);
}

function processData(callback) {
  setTimeout(function() {
    console.log("Data diproses");
    callback();
  }, 1000);
}

function displayData() {
  console.log("Data ditampilkan");
}

// Menggunakan Named Functions
function handleDataProcessing() {
  processData(displayData);
}

getData(handleDataProcessing);

/*
2. **Gunakan Promises:**
  - Promises adalah cara yang lebih modern dan terstruktur untuk menangani operasi asinkron. Mereka dapat
    membantu menghindari callback hell dan membuat kode lebih mudah dipelihara.
*/

function getData() {
  return new Promise(resolve => {
    setTimeout(function() {
      console.log("Data berhasil diambil");
      resolve();
    }, 1000);
  });
}

function processData() {
  return new Promise(resolve => {
    setTimeout(function() {
      console.log("Data diproses");
      resolve();
    }, 1000);
  });
}

function displayData() {
  console.log("Data ditampilkan");
}

// Menggunakan Promises
getData()
  .then(() => processData())
  .then(() => displayData());

/*
Penggunaan Promises atau async/await dapat membuat kode lebih terbaca dan mengurangi tingkat bersarang
yang berlebihan.
*/