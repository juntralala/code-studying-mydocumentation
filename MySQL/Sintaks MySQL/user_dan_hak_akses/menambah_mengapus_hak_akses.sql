GRANT SELECT ON pzn.* TO 'ujun'@'localhost';
GRANT SELECT, INSERT, UPDATE, DELETE ON pzn.* TO 'junaidi'@'%';

SHOW GRANTS FOR 'ujun'@'localhost';
SHOW GRANTS FOR 'junaidi'@'%';

-- menghapus
REVOKE SELECT ON pzn.* FROM 'ujun'@'localhost';
REVOKE SELECT, INSERT, UPDATE, DELETE ON pzn.* FROM 'junaidi'@'%';