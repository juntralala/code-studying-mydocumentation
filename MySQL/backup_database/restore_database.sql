/*Cara RESTORE yang ke 1*/
mysql -u root -p pzn_backup < "/UJUN/Latian ngoding/MySQL/backup_database/backup.sql"
mysql -user=root -password pzn_backup < "/UJUN/Latian ngoding/MySQL/backup_database/backup.sql"

-- pzn_backup = nama_database_nya 


/*Cara RESTORE yang ke 2*/
CREATE DATABASE pzn_import_source;
USE pzn_import_source;
SOURCE /UJUN/Latian ngoding/MySQL/backup_database/backup.sql;

-- yang ini harus meng-use database nya dulu
