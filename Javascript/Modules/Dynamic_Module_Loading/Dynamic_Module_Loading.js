/** Dynamic Module Loading
 * Saat kita menggunakan module dengan cara import, maka semua module akan di load
 * Pada kenyataanya, kadang kita tidak ingin meload semua module diawal, kita ingin meload module ketika
   dibutuhkan saja, ini juga akan menghemat bandwith jaringan juga, karena kita tidak perlu download semua 
   module di awal
 * JavaScript mendukung dynamic module loading, caranya kita bisa gunakan function import(), dimana hasinya
   adalah Promise<ModuleObject> (Promise adalah materi yang kompoleks, ini akan dibahas di class JavaScript
   Async )
*/