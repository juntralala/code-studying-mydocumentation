package com.ujun.menegirimPerintahSQL;

import com.ujun.hikariCP.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Jika kita ingin mengirim perintah SQL yang mengembalikan data, maka kita bisa menggunakan method executeQuery(sql)
 * Method ini akan mengembalikan object java.sql.ResultSet, yaitu berisikan data-data hasil query SQL yang kita kirimkan
 * Pembahasan interface ResultSet akan kita bahas lebih detail lagi nanti di chapter tersendiri
 */

public class Statement_executeQuery {

    @Test
    public void testExecuteQuery() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");
        // disini tidak dijelaskan cara mengambil data dari resultSet

        resultSet.close();
        statement.close();
        connection.close();
    }

}
