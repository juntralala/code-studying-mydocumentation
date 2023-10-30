package com.ujun.databaseTransaction;

import com.ujun.hikariCP.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/** Database Transaction
 * Fitur paling bermanfaat di database salah satu nya adalah database transaction
 * FItur database transaction pun bisa kita jalankan menggunakan JDBC
 * Jika belum mnegerti apa itu database transaction, silahkan tonton course saya tentang database MySQL, di sana saya
   jelaskan secara rinci
 */

public class DatabaseTransaction {

    @Test
    public void testCommit() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO comments(email, comment) VALUES (?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "ujun@gmail.com");
        preparedStatement.setString(2, "test melakukan commit");
        preparedStatement.executeUpdate();

        connection.commit();

        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testRollback() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO comments(email, comment) VALUES (?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "ujun@gmail.com");
        preparedStatement.setString(2, "test melakukan Rollback");
        preparedStatement.executeUpdate();

        connection.rollback(); // data rollback tidak, berarti datanya tidak pernah disimpan secara permanen

        preparedStatement.close();
        connection.close();
    }

}

/*
CREATE TABLE comments (
    id INT NOT NULL AUTO_INCREMENT,
    email varchar(100) NOT NULL,
    comment TEXT NOT NULL,
    PRIMARY KEY (id)
);
*/