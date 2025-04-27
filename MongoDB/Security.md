# Security
* Secara default, jika kita menjalankan MongoDB, mode yang dijalankan tidaklah aman
* Tidak ada Authentication dan tidak ada Authorization
* Agar aman, kita harus mengaktifkan fitur access control di MongoDB

## User Admin
* User admin harus ada terlebih dahulu sebelum kita mengaktifkan access control
* User admin adalah user yang memiliki role userAdminAnyDatabase dan readWriteAnyDatabase
* Setelah membuat user admin, kita bisa menjalankan ulang MongoDB dengan perintah --auth

```js
// JS admin.js
// switch to database admin
use admin;

// create admin user
db.createUser({
  user: 'mongo',
  pwd: 'mongo',
  roles: [
    'userAdminAnyDatabase',
    'readWriteAnyDatabase'
  ]
});
```

## Menjalankan Ulang Mongodb
* Gunakan perintah seperti berikut untuk mengaktifkan fitur Security
* `bin/mongod --auth --dbpath=lokasi/data/`

## MongoDB Client
* Sekarang, untuk terkoneksi ke MongoDB Server menggunakan MongoDB Client, kita wajib menggunakan username dan password yang sudah kita buat sebelumnya
* Gunakan koneksi URL seperti berikut :
   `bin/mongosh "mongodb://username:password@host:port/database?authSource=admin"`

## User Function
| Function                 | Keterangan                 |
| ------------------------ | -------------------------- |
| db.createUser()          | Membuat user               |
| db.getUsers()            | Mendapatkan semua user     |
| db.dropUser()            | Menghapus user             |
| db.updateUser()          | Mengupdate user            |
| db.changeUserPassword()  | Mengubah user password     |


## Database Roles
| Role       | Keterangan                                                                       |
|------------|----------------------------------------------------------------------------------|
| read       | Bisa membaca data di semua collection yang bukan sistem collection               |
| readWrite  | Bisa membaca dan mengubah data di semua collection yang bukan sistem collection  |
| dbAdmin    | Bisa melakukan kemampuan administrasi database                                   |
| userAdmin  | Mampu membuat user dan role                                                      |
| dbOwner    | Kombinasi readWrite, dbAdmin dan userAdmin                                       |
| root       | Bisa melakukan semuanya                                                          |
> untuk detailnya cek dokumentasi

```js
// JS user.js

use admin;

// Create user with access read only
db.createUser({
  user: "contoh",
  pwd: "contoh",
  roles: [
    { role: "read", db: "test" }
  ]
});

// Create user with access read write
db.createUser({
  user: "contoh2",
  pwd: "contoh2",
  roles: [
    { role: "readWrite", db: "test" }
  ]
});


// JS change-user.js
// Get all users
db.getUsers();

// Change password for user contoh
db.changeUserPassword("contoh", "rahasia");

// Drop user contoh
db.dropUser("contoh");

// Update user
db.updateUser("contoh2", {
  roles: [
    { role: "readWrite", db: "test" },
    { role: "readWrite", db: "belajar" }
  ]
});
```

## Role
> Di MongoDB kita juga bisa membuat role  
> Meski biasanya builtin role saja sudah cukup  
> Detailnya cek sendiri ke dokumentasi

## Role Function
| Role            | Keterangan          |
|-----------------|---------------------|
| db.createRole() | Membuat role baru   |
| db.getRoles()   | Mendapatkan role    |
| db.deleteRole() | Menghapus role      |
| db.updateRole() | Mengubah role       |