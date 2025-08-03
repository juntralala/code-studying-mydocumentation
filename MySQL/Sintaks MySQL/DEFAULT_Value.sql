CREATE TABLE barang(
    id INT(4) NOT NULL,
    field2 tipedata(panjang),
    harga INT,
    jumlah INT,
    waktu_dibuat TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;
);