<<==================>> CONTROL FLOW FUNCTIONS <<==================>>

=================================> FLOW CONTROL OPERATOR 
1. CASE
2. IF()
3. IFNULL()
4. NULLIF()

contoh CASE :
SELECT
    emp_name as Nama,
    job_name as 'Perkerjaan',
    CASE  job_name
        WHEN 'PRESIDENT' THEN 'BOSNYA'
        WHEN 'MANAGER' THEN 'Tangan Kanan'
        WHEN 'SALESMAN' THEN 'Anak Buah'
        WHEN 'ANALYST' THEN 'Penganalisa'
        WHEN 'clerk' THEN 'Pegawai Toko'
        ELSE ''
        END AS p
from employees;

contoh IF() :
SELECT
    emp_name AS Nama,
    job_name AS Perkerjaan,
    salary AS Gaji,
        IF( salary >= 2000, 'Banyak',
            IF( salary < 2000 AND salary >= 1000, 'Sedang', 'Sedikit')
            ) AS Keterangan
FROM employees;

contoh IFNULL() :
SELECT
    emp_name AS Nama,
    IFNULL(commission, '') AS Gaji
from employees;