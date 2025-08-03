package com.ujun.menegirimPerintahSQL.sqlInjectionProblem;

import com.ujun.hikariCP.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class SqlInjectionTest {

        @Test
        public void testSqlInjection() throws SQLException {
            Connection connection = ConnectionUtil.getDataSource().getConnection();
            Statement statement = connection.createStatement();

            String username = "admin'; #"; // sql Injection
            String password = "salah";

            String sql = "SELECT * FROM admin where username='" + username + "' AND password='" + password + "'";

            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                System.out.println("SUKSES LOG IN");
            } else {
                System.out.println("GAGAL LOG IN");
            }

        }
}
