package com.ujun.menegirimPerintahSQL.preparedStatement;

import com.ujun.hikariCP.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * PreparedStatement adalah turunan dari Statement, jadi apapun yang bisa dilakukan Statement, PreparedStatement juga bisa
   melakukannya
 * Yang membedakan PreparedStatement dan Statement adalah kemampuan untuk mengamankan dari input user yang dimiliki
   oleh PreparedStatement sehingga iya lebih aman dari SQl Injection
 */

/** cara membuat PreparedStatement
 * Berbeda dengan Statement, pada PreparedStatement, ketika pembuatanya, sudah ditentukan SQL apa yang akan digunakan
 * Oleh karena itu, PreparedStetement biasanya digunakan sekali saja untuk mengirim perintah SQL, jika ingin mengirim
 lagi perintah SQL yang berbeda, harus membuat object PreparedStatement baru
 * Untuk membuat PreparedStatement, kita bisa mneggunakan method preparedStatement(sql) milik Connection
 */

/** cara menerima input user
 * Sekarang pertanyaanya, bagaimana cara menerima input user menggunakan PreparedStatement?
 * Untuk menerima inpu dari user, SQL yang kita buat harus diubah juga
 * Input dari user perlu kita ubah menjadi tanda tanya (?)
 * Nanti ketika pembuatan object, kita bisa substitusi datanya menggunakan seXxx(index, value) disesuaikan dengan
 tipe datanya , misal setString(), setInt(), dll
 */

public class PreparedStatement_ {

    @Test
    public void testPreparedStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String username = "admin' ;#";
        String password = "admin";
        String sql = "SELECT * FROM admin WHERE username=? AND password=?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);

        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()) {
            System.out.println("SUKSES LOG IN");
        } else {
            System.out.println("GAGAL LOG IN");
        }

        statement.close();
        connection.close();
    }

}
