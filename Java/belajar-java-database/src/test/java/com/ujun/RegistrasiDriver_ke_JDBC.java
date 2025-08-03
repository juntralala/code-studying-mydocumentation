package com.ujun;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Selesai setelah kita menambakan MySQL Driver ke project kita
 * Kita perlu melakukan registrasi Driver terlebih dahulu
 * Untuk melakukan registrasi Driver, kita bisa menggunakan static method registerDriver milik class java.sql.DriverManager
 */

public class RegistrasiDriver_ke_JDBC {

    @Test
    public void testRegister() {
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }

}
