/**
 * Saat membuat aplikasi menggunakan database, ada baiknya kita selalu melakukan backup data secara reguler
 * Untungnya MySQL mendukung proses backup database
 * Untuk melakukan backup database, kita tidak menggunakan perintah SQL, melainkan sebuah aplikasi yang disediakan MySQL khusus
   untuk melakukan backup database, namanya adalah mysqldump 
 * https://dev.mysql.com/doc/refman/8.0/en/mysqldump.html        <= lebih detailnya disini
*/

mysqldump pzn --user root --password --result-file="/UJUN/Latian ngoding/MySQL/backup_database/backup.sql"
mysqldump pzn -u root -p --result-file="/UJUN/Latian ngoding/MySQL/backup_database/backup.sql"

pzn = nama_database_nya