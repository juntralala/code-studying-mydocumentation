# Depend On
* Saat sebuah bean membutuhkan bean lain, secara otomatis bean tersebut akan dibuat setelah bean yang dibutuhkan dibuat
* Namun bagaimana jika bean tersebut tidak membutuhkan bean lain, namun kita ingin sebuah bean dibuat setelah bean lain dibuat?
* Jika ada kasus seperti itu, kita bisa menggunakan annotation @DependsOn(value={”namaBean”})
* Secara otomatis, Spring akan memprioritaskan pembuatan bean yang terdapat di DependsOn terlebih dahulu

> yang ini tidak dibuatkan contoh unittest nya hanya contoh kelasnya saja