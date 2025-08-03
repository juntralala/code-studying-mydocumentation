* Saat kita membuat table, sering sekali kita menambahkan informasi audit seperti createdAt dan updatedAt
* Spring Data JPA mendukung mengubahan data audit secara otomatis ketika proses save
* Kita cukup gunakan annotation @CreatedDate dan @LastModifiedDate, dan menggunakan EntityListener AuditingEntityListener
* Kita bisa menggunakan tipe data Date, Timestamp, Instance atau Long (milis) untuk field audit nya
* Secara default, fitur ini tidak aktif, untuk mengaktifkannya, kita harus menambahkan annotation @EnableJpaAuditing
