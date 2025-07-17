package com.ujun.connection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Setelah melakukan register ke JDBC, kita sekarang bisa mulai melakukan koneksi ke database
 * Untuk melakukan koneksi ke database, kita harus memberi tahu jenis database, host, port, username password untuk
   terkoneksi ke database
 * Semua itu biasa digabungkan dalam sebuah string yang biasa disebut JDBC URL
 * Koneks database dipresentasikan oleh interface java.sql.Connection
 * https://docs.oracle.com/en/java/javase/15/docs/api/java.sql/java/sql/Connection.html
 */

/** Membuat Connection
 * Untuk membuat Connection ke database, kita bisa menggunakan static method getConnection() di class java.sql.DriverManager
 * Semua method JDBC rata-rata selalu akan menghasilkan SQLException
 */

public class Connection_ {

    @BeforeAll
    public static void regiter() {
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }

    @Test
    public void testConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database";
        String user = "root";
        String password = "";

        try(Connection connection = DriverManager.getConnection(jdbcUrl,user, password)) {
            System.out.println("Berhasil connect ke database");
//            connection.close();
        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }

}
