/**
 * UNION ALL adalah operasi yang sama dengan UNION, namun data duplikat tetap akan ditampilkan dihasil query nya
*/

SELECT DISTINCT email FROM customers 
UNION ALL
SELECT DISTINCT email FROM guestbooks;


SELECT emails.email FROM count(emails.email) (SELECT DISTINCT email FROM customers 
UNION ALL
SELECT DISTINCT email FROM guestbooks) as emails
GROUP BY emails.email;