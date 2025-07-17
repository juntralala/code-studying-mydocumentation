# @RepostAsSingleViolation
* Secara default, semua Constraint di Constraint Composite akan dieksekusi, jadi jika misal  terdapat lebih dari satu error, maka semua error akan diberitahukan 
* Kadang ada baiknya, jika misal terdapat satu constraint yang error, kita tidak perlu lakukan pengecekan ke  constraint berikutnya 
* Untuk melakukan hal ini, kita bisa tambahkan annotation @ReportAsSingleViolation pada Composite Constraint Annotation