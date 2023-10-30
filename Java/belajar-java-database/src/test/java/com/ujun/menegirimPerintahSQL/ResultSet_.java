package com.ujun.menegirimPerintahSQL;

import com.ujun.hikariCP.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Seperti yang sudah kita bahas sebelumnya di Statement, ketika kita melakukan query, maka akan menghasilkan :
   java.sql.ResultSet
 * ResultSet adalah representasi dari hasil query  dari database
 * ResultSet itu mirip seperti iterator, jadi kita bisa melakukan perulangan di RersultSet untuk mendapatkan data tiap
   record nya
 * https://docs.oracle.com/en/java/javase/15/docs/api/java.sql/java/sql/ResultSet.html
 */

/** cara menambil data kolom di ResultSet
 * Cara kerja ResultSet sama seperti cursor, dimana untuk maju kita menggunakan method next() dan previous() untuk mundur
 * Untuk mendapatkan data dari tiap kolom pada lokasi cursor saat ini, kita bisa menggunakan beda-beda method
   getXxx(column) di resultSet
 * Kita bisa sesuaikan dengan tipe data kolom tersebut, misal getString(column), getInt(column), dll
 */

public class ResultSet_ {

    @Test
    public void testExecuteQuery() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");

        while(resultSet.next()) {
            System.out.println( String.join(", ",
                    resultSet.getString("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"))
            );
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

}
