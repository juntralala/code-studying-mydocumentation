# Profile Properties File
* Saat kita menggunakan fitur profile, kita juga bisa membuat file properties sesuai dengan profile yang aktif
* Penamaan properties file adalah application-{profile}.properties
* Misal jika active profile adalah dev, maka application-dev.properties akan di load
* Jika active profile lebih dari satu, maka semua files properties tiap profile akan di load
* Jangan lupa application.properties akan tetap di load disemua profile
