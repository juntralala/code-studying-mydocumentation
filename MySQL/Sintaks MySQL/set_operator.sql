/**
 * MySQL mendukung opearator Set, dimana ini adalah opearsi antar hasil dua SELECT query. Ada beberapa  jenis operator Set, yaitu :
 * UNION
 * UNION ALL
 * INTERSECT
 * MINUS
*/

CREATE TABLE guestbooks (
    ID      INT             NOT NULL AUTO_INCREMENT,
    email   VARCHAR(100)    NOT NULL,
    title   VARCHAR(200)    NOT NULL,
    content TEXT,
    PRIMARY KEY (id)
);

INSERT INTO guestbooks( email, title, content) VALUES 
("guest1@gmail.com", "Hello", "Hello"),
("guest2@gmail.com", "Hello", "Hello"),
("guest3@gmail.com", "Hello", "Hello"),
("ujun@gmail.com", "Hello", "Hello"),
("ujun@gmail.com", "Hello", "Hello"),
("ujun@gmail.com", "Hello", "Hello");