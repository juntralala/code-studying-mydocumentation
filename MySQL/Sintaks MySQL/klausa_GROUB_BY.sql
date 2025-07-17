

Group by with rollup: mengelompokkan data dengan menambahkan baris subtotal dan total untuk setiap level group by. Contoh:
SELECT jurusan, tahun, SUM(nilai) FROM mahasiswa GROUP BY jurusan, tahun WITH ROLLUP;

Group by with cube: mengelompokkan data dengan menambahkan semua kombinasi kemungkinan dari group by. Contoh: 
SELECT jurusan, tahun, SUM(nilai) FROM mahasiswa GROUP BY CUBE(jurusan, tahun);