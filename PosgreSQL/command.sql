\l
\c db_name
\dt
\d nm_table
\ds              -- describe sequence
\d nm_sequence

CREATE TABLE (
    id SERIAL NOT NULL PRIMARY KEY,
    readable_id CHAR(10),
    name VARCHAR(100),
    description TEXT,
    create_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    TIMESTAMP,
    DATE,
    TIME,
    BOOLEAN,
    GENDER_ENUM
);

CREATE TABLE users (
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TYPE GENDER_ENUM AS ENUM('pria', 'wanita');

SELECT * FROM pg_tables WHERE schemaname = 'public';

TRUNCATE

ALTER TABLE tb_name ADD, DROP, MODIFY, CHANGE;

INSERT INTO tb_name VALUES ();

SELECT * FROM nm_table;

UPDATE table_name SET col_name="" WHERE true;
DELETE FROM table_name WHERE true;

SELECT col_name AS alia FROM tb_name;

expression LIKE "%pola%"; 
IS NULL;
BETWEEN;
IN (1, 2, 3);
ORDER BY col_name DESC;
LIMIT 0, 5;

SELECT currval('users_id_seq');
SELECT currval(pg_get_serial_sequence('users', 'id'));

INSERT INTO users(name) VALUES ('ozon'), ('ujun');

CREATE SEQUENCE contoh_sequence;
SELECT nextval('contoh_sequence'); -- menaikkan sequence
SELECT currval('contoh_sequence'); -- melihat poisi sequence terakhir saat ini

-- contoh dari year functions
SELECT id, EXTRACT(YEAR FROM created_at) AS created_year, EXTRACT(MONTH FROM created_at) AS created_month FROM users;

-- conditional expression
SELECT CASE WHEN condition THEN result
        [WHEN ...]
        [ELSE result]
    END;

SELECT CASE expression
        WHEN value THEN result
        [WHEN ...]
        [ELSE result]
    END;

COALESCE(value [, ...]) -- The COALESCE function returns the first of its arguments that is not null. Null is returned only if all arguments are null.

NULLIF(value1, value2) -- The NULLIF function returns a null value if value1 equals value2; otherwise it returns value1. This can be used to perform the inverse operation of the COALESCE

-- aggregate functions
COUNT()
MAX()
MIN()
AVG()

GROUP BY column_name;

HAVING

-- constaints
UNIQUE
CHECK
INDEX
CREATE INDEX users_id_name_index ON users(id, name); -- membuat index dari kombinasi yg sudah ada

-- fulltext search

--
JOIN
INNER JOIN
LEFT JOIN
RIGHT JOIN
CROSS JOIN

-- subquery

-- Set operator (operator himpunan)
INTERSECT
UNION
UNION all
EXCEPT

-- transaction

--

SELECT current_schema();
CREATE SCHEMA contoh;
DROP SCHEMA contoh;

SET search_path TO contoh; -- <- pindah schema

-- create role (kalau di mysql user namanya)
CREATE ROLE ujun;
ALTER ROLE ujun WITH LOGIN PASSWORD 'rahasia ';

GRANT INSERT, UPDATE, DELETE, SELECT ON ALL TABLE IN SCHEMA public TO ujun;
GRANT INSERT, UPDATE, DELETE, SELECT ON products TO ozon;

REVOKE DELETE ON products FROM ozon;

CREATE ROLE ujun [ WITH ] option ...;

-- backup
pg_dump --host=localhost --port=5432 --dbname=pzn --username=postgres --format=sql --file=./backup.pzn.sql