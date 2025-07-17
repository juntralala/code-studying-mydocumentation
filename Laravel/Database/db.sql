CREATE TABLE categories (
    id          VARCHAR(100) NOT NULL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    description TEXT,
    created_at  TIMESTAMP
);

CREATE TABLE counters(
    id      VARCHAR(100) NOT NULL PRIMARY KEY,
    counter INT          NOT NULL DEFAULT 0
);

INSERT INTO counters (id, counter) VALUES ('sample', 0);

SELECT * FROM counters;

CREATE TABLE products (
    id          VARCHAR(100) NOT NULL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    description TEXT,
    price       int          NOT NULL,
    category_id VARCHAR(100) NOT NULL,
    created_at TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES categories (id)
);

-- mencoba insert yg salah ()
INSERT INTO products(id, name, description, price, category_id, created_at) VALUES ('A001', 'Buku', 'Buku tulis', 20000, 'tidak_ada', CURRENT_TIMESTAMP);

DROP TABLE products;
DROP TABLE categories;
DROP TABLE counters;