<<============================================>> fitur FOREIGN KEY <<============================================>> 

contohnya :
CREATE TABLE wishlist (
    id          INT         NOT NULL AUTO_INCREMENT,
    id_produk   VARCHAR(10) NOT NULL,
    deskripsi   TEXT,
    PRIMARY KEY (id),
    CONSTRAINT fk_wishlist_produk FOREIGN KEY (id_produk) REFERENCES produk (id)
);
ALTER TABLE wishlist ADD CONSTRAINT fk_wishlist_produk FOREIGN KEY id_produk REFERENCES produk (id);
ALTER TABLE wishlist DROP CONSTRAINT fk_wishlist_produk;

<<============================================>> BEHAVIOR FOREIGN KEY <<============================================>>
secara default behavior FOREIGN KEY adalah TESTRICT

1. RESTRICT
2. CASCADE
3. NO ACTION
4. SET NULL
+===========+===================+=======================+
| Behavior  | ON DELETE         | ON UPDATE             |
+-----------+-------------------+-----------------------+
| RESTRICT  | ditolak           | ditolak               |
| CASCADE   | data akan dihapus | data akan ikut diubah |
| NO ACTION | data dibiarkan    | data dibiarkan        |
| SET FULL  | diubah jadi null  | diubah jadi null      |
+===========+===================+=======================+

contoh BEHAVIOR FOREIGN KEY :
CREATE TABLE wishlist (
    id          INT NOT NULL AUTO_INCREMENT,
    id_produk   VARCHAR(10) NOT NULL,
    deskripsi   TEXT,
    PRIMARY KEY (id),
    CONSTRAINT fk_wishlist_produk FOREIGN KEY id_produk REFERENCES produk (id) ON DELETE CASCADE ON UPDATE CASCADE 
);
