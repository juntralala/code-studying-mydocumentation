
<{===== Beberapa DATE FUNCTIONS =====}>
1. EXTRACT(YEAR/MONTH/DAY FROM DATE/_namaField_)
2. YEAR(DATE)
3. MONTH(DATE)
4. DAY(DATE)

contohnya :
SELECT no, nama, EXTRACT(YEAR FROM tanggal_dibuat) FROM test;
SELECT no, nama, EXTRACT(MONTH FROM tanggal_dibuat) FROM test;
SELECT no, nama, EXTRACT(DAY FROM tanggal_dibuat) FROM test;
SELECT no, nama, YEAR(tanggal_dibuat) FROM test;
SELECT no, nama, MONTH(tanggal_dibuat) FROM test;
SELECT no, nama, DAY(tanggal_dibuat) FROM test;