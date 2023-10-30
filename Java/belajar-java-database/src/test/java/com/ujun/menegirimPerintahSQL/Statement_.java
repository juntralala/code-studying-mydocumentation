package com.ujun.menegirimPerintahSQL;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * java.sql.Statement adalah interface yang bisa kita gunakan untuk mengirim SQL ke database sekaligus menerma response
   dari database
 * Ada banya method yang bisa kita gunakan di Statement untuk mengirim perintah SQl, kita akan bahas satu per satu
 * https://docs.oracle.com/en/java/javase/15/docs/api/java.sql/java/sql/Statement.html
 * Untuk membuat object Statement kita bisa menggunakan method createStatement() milik Connection
 */

public class Statement_ {

    // nyoba bikin koneksinya tanpa connection pool
    public static Connection connection;
    @BeforeAll
    public static void setUp() throws SQLException {
        Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(mysqlDriver);
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/belajar_java_database","root", "");
    }

    // membuat statement
    @Test
    public void testStatement() throws SQLException {
        Statement statement = connection.createStatement();
        statement.close();
        connection.close();
    }

}
