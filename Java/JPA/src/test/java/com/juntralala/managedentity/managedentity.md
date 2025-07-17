# Managed Entity
* Salah satu fitur yang wajib dimengerti ketika menggunakan JPA adalah Managed Entity
* Saat kita membuat Object Entity secara manual, mana bisa dibilang itu adalah Unmanaged Entity (Entity yang tidak di managed oleh JPA)
* Saat Unmanaged Entity di simpan ke database menggunakan Entity Manager, secara otomatis objectnya berubah menjadi Managed Entity
* Setiap perubahan yang terjadi pada Managed Entity, secara otomatis akan di update ke database ketika kita melakukan commit, walaupun kita tidak melakukan update secara manual
