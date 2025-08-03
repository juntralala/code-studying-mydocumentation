package com.ujun.mendapatkanGeneratedKeys;

import com.ujun.hikariCP.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.*;

/** cara mengambil auto generated keys
 * Secara default, Statement ataupun PreparedStatement tidk mengerti utuk mengambil auto generated key
 * Kita perlu memberitahunya agar Statement ataupun PreparedStatement mengambil auto generate id secara otomatis
 * Untuk Statement, kita perlu memberitahu ketika memanggil method executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)
 * Sedangkan untk PreparedStatement,kita perlu memberi tahu ketika membuat
   PreparedStatement(sql, Statement.RETURN_GENERATED_KEYS)
 * Setelah itu, untuk mendapatkan auto generate key, kita tinggal menggunakan method getGeneratedKeys(), method ini
   akan error jika kita lupa mengirim parameter generated keys
 */

public class MendapatkanGeneratedKeys {

    @Test
    public void testAutoIncretement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "INSERT INTO comments(email, comment) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, "ujun@gmail.com");
        preparedStatement.setString(2, "apa aja");

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testGetGeneratedKeys() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "INSERT INTO comments(email, comment) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, "ujun@gmail.com");
        preparedStatement.setString(2, "apa aja");

        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if(resultSet.next()) System.out.println("Id Comment : " + resultSet.getInt(1));

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
