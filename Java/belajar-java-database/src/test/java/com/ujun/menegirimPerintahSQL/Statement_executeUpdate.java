package com.ujun.menegirimPerintahSQL;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/** Statement.createStatement()
 * Method pertama yang akan kita bahas adalah executeUpdate(sql)
 * Method ini digunakan untuk mengirim perintah SQL INSERT, UPDATE, DELETE atau apapun yang tidak membutuhkan result
 * Bahkan bisa untuk perintah DDL (CREATE TABLE, CREATE INDEX, ALTER, dll), akan tetapi best practice nya, perintah DDL
   lebih baik dilakukan langsung di database, atau menggunakan migration script, bukan dari aplikasi yang kita buat
 * execueUpdate(sql) me-return int, dimana ini biasanya mengembalikan berapa banyak record di database yang terkena
   impact perintah SQL kita, misal ketika mengirim perintah UPDATE, berapa banyak record yang ter-update misalnya
 */

public class Statement_executeUpdate {

    // nyoba bikin Connection Pool manual
    private static HikariDataSource dataSource;
    @BeforeAll
    public static void setUp() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/belajar_java_database");
        config.setUsername("root");
        config.setPassword("");
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000L);
        config.setMaxLifetime(10 * 60_000L);
        dataSource = new HikariDataSource(config);
    }

    // liat ininya aja
    @Test
    public void testExecuteUpdate() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("""
                INSERT INTO customers(id ,name, email)
                VALUES('2200', 'Junaidi', 'junaidi@gmail.com');""");

        // jangan lupa tutup semuanya
        statement.close();
        connection.close();
        dataSource.close();
    }

}
