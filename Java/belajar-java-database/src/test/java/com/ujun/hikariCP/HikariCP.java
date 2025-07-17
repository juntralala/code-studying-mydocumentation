package com.ujun.hikariCP;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Membuat connecion pool secara manual bukankah hal yang bijak, lenih baik kita menggunakan liblary connection pool
   yang sudah terbukti berkerja dengan baik
 * HikariCP adalah salah satu connection poll liblary paling populer saat ini di Java
 * Kita bisa mneggunakan HikariCP ini untuk melakukan connection poll terhadap koneksi database di aplikasi kita
 * https://github.com/brettwooldridge/HikariCP
 */

public class HikariCP {

    @Test
    public void testHikariCP() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/belajar_java_database");
        config.setUsername("root");
        config.setPassword("");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(10 * 60_000);


        try {
            HikariDataSource dataSource = new HikariDataSource(config);
            Connection connection1 = dataSource.getConnection();
            Connection connection2 = dataSource.getConnection();

            connection1.close(); // mengemblikan connection ke connection pool
            connection2.close();
            dataSource.close();  // menutup semua connection didalam connection pool
        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }

    @Test
    public void testConnectionUtil() throws SQLException{
        Connection connection1 = ConnectionUtil.getDataSource().getConnection();
    }

}
