
<<------------------------------------<< contoh CHECK >>------------------------------------>>
CREATE TABLE siswa (
    id INT ZEROFILL PRIMARY KEY AUTO_INCREMENT,
    nama VARCHAR(20) NOT NULL,
    umur SMALLINT,
    email VARCHAR(25),
    UNIQUE KEY email_unique (email),
    CONSTRAINT umur_check CHECK (NOT umur > 25)
);
ALTER TABLE siswa ADD CONSTRAINT umur_check CHECK (NOT umur > 25 );
ALTER TABLE siswa DROP CONSTRAINT umur_check;