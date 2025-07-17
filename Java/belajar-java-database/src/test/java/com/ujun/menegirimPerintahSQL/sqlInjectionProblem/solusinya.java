package com.ujun.menegirimPerintahSQL.sqlInjectionProblem;

/**
 * class Statement tidak didesain untuk bisa mengangani SQL Injection
 * Oleh karena itu, jika SQL query yang kita gunakan berdasarkan input dari user, maka kita jangan menggunakan Statement
 * Untuk menghindari SQL Injection, terdapat interface PreparedStatement, ini adalah jenis Statement yang bisa menangani
   SQL Injection dengan baik
 */

public interface solusinya {
}
