# Non Query
* JPA QL juga bisa digunakan untuk membuat perintah Update atau Delete
* Kita cukup buat query nya seperti biasa, dan untuk melakukan execute nya, kita bisa gunakan method Query.executeUpdate()
* Ini bisa dilakukan baik itu menggunakan JPQ QL atau Native Query

# Peringatan!
* Hati-hati ketika melakukan update data secara langsung menggunakan JPA QL
* Hal ini bisa menyebabkan fitur seperti Optimistic Locking tidak berjalan, karena version tidak berubah ketika kita update

