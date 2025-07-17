package com.ujun.batchProcess;

import com.ujun.hikariCP.ConnectionUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC mendukung proses exekusi perintah SQL secara batch pada Statement maupun PreparedSatement
 * Di Statement terdapat method addBatch(sql) untk menambahkan perintah ke proses batch
 * Sedangkan PreparedStatement terdapat method addBatch() untuk menambakan proses ke batch, lalu bisa menggunakan method
   clearParameter() untuk menghapus parameter input user sebelumnya
 * Setelah proses batch selesai, jika ingin mengeksekusinya, kita gunakan perintah executeBatch()
 */ // proses batch tidak bisa digunakan untuk mengambil data

public class BatchProcess {

    @Test
    @DisplayName("testBatch Statement")
    public void testBatch() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        for(int i = 0 ; i<1000 ; i++) {
            statement.addBatch("INSERT INTO comments(email, comment) VALUES ('ujun@gmail.com', 'hi "+ i +"')");
        }
        statement.executeBatch();

        statement.close();
        connection.close();
    }

    @Test
    @DisplayName("testBatch PreparedStatement")
    public void testBatch2() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "INSERT INTO comments(email, comment) VALUES (email=?, comment=?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        for(int i = 0 ; i<1000 ; i++) {
            statement.clearParameters();
            statement.setString(1, "ujun@gmail.com");
            statement.setString(2, "halo");
            statement.addBatch();
        }
        statement.executeBatch();

        statement.close();
        connection.close();
    }

}
