## Non Null
* Sebelumnya, saat kita membuat constructor dengan @RequiredArgsConstructor, Lombok akan menjadi final field. Hal ini membuat field tersebut tidak bisa diubah lagi
* Lombok memiliki annotation @NonNull
* Jika @NonNull ditempatkan di field, maka secara otomatis juga akan di generate di @RequiredArgsConstructor, sekaligus dilakukan pengecekan tidak boleh null. Selain itu semua setter method nya juga akan dilakukan pengecekan null
* Jika @NonNull ditempatkan di parameter, maka parameter tersebut akan dilakukan pengecekan null
* Jika parameternya null, maka otomatis akan throw NullPointerException
