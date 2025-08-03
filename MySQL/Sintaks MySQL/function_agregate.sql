<(================= Beberapa AGREEGATE FUNCTION =================)>
1. SUM(kolom)
2. COUNT(kolom)
3. AVG(kolom)                                                                     <== rata-rata     
4. MAX(kolom)
5. MIN(kolom)    


contohnya :
SELECT SUM(salary) FROM employees;
SELECT COUNT(emp_id) FROM employees;
SELECT AVG(emp_id) FROM employees;
contoh menggunakan GROUP BY :
SELECT job_name AS Profesi, COUNT(job_name) AS Jumlah FROM employees GROUP BY job_name;
SELECT job_name AS Profesi, AVG(salary) AS Jumlah FROM employees GROUP BY job_name;
SELECT job_name AS Profesi, AVG(salary) AS Jumlah FROM employees GROUP BY job_name ORDER BY FIELD(job_name,
                                                                                        'PRESIDENT',
                                                                                        'MANAGER',
                                                                                        'ANALYST',
                                                                                        'SALESMAN',
                                                                                        'CLERK');