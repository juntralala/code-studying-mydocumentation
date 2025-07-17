package com.ujun;

import com.ujun.hikariCP.ConnectionUtil;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * Seperti kita ketahui, tipe tanggal dan waktu di database biasanya banyak, ada Date, Time, ada juga Timestamp
 * Sedangkan di Java hanya terdapat tipe data java.util.Date
 * Agar bisa menghandel hal ini, terdapat class-class turunan java.util.Date do package java.sql yang bernama Date,
   Time dan Timestamp
 * Sesuai dengan namanya, class-class tersebut digunakan sebagai representasi di Java
 * Secara otomatis JDBC bisa melakukan konversi tipe data tersebut dari database menjadi object di Ja va
 */

public class Date_Time_Timestamp {

    // CONTOH INSERT
    @Test
    public void testDateInsert() throws SQLException {
        HikariDataSource dataSource = ConnectionUtil.getDataSource();
        String sql = """
                INSERT INTO sample_time(sample_date, sample_time, sample_timestamp)
                VALUES
                (?, ?, ?)""";

        Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setDate(1, new Date(System.currentTimeMillis()));
        ps.setTime(2, new Time(System.currentTimeMillis()));
        ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

        ps.executeUpdate();

        ps.close();
        connection.close();
    }

    // CONTOH QUERY
    @Test
    public void  testDateQuery() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = """
                SELECT * 
                FROM sample_time""";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println("ID \t\t: " + resultSet.getInt("id"));
            System.out.println("Date \t: " + resultSet.getDate("sample_date"));
            System.out.println("time \t: " + resultSet.getTime("sample_time"));
            System.out.println("timestamp\t: " + resultSet.getTimestamp("sample_timestamp"));
        }

    }

}

/* Sampel table di db

CREATE TABLE sample_time (
    id                  INT     NOT NULL AUTO_INCREMENT,
    sample_date         DATE,
    sample_time         TIME,
    sample_timestamp    TIMESTAMP,
    PRIMARY KEY (id)
);

*/