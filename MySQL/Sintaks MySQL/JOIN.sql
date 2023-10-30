<<============================================>> fitur JOIN <<============================================>>

SELECT *
FROM employees AS e
    JOIN departement AS d
        ON (e.dep_id = d.dep_id);

SELECT  e.emp_id AS 'ID Pegawai',
        e.dep_id AS 'ID Departemen'
        e.emp_name AS 'Nama Pegawai',
        e.job_name AS 'Profesi',
        d.dep_name AS 'Nama Departement'
FROM employees AS e 
    JOIN departement AS d
        ON (e.dep_id = d.dep_id);
