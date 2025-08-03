package com.juntralala;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SetUp {

    private Connection connection = null;

    @BeforeEach
    public void setUp() throws SQLException {
        String url = "jdbc:mysql://172.20.82.191:3306/spring_jpa";
        connection = DriverManager.getConnection(url, "super", "");
    }

    @AfterEach
    public void tearDown() throws SQLException {
        connection.close();
    }

    @Test
    public void createCategories() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("""
                CREATE TABLE IF NOT EXISTS categories (
                    id BIGINT         NOT NULL AUTO_INCREMENT,
                    name VARCHAR(100) NOT NULL,
                    PRIMARY KEY (id)
                )""");
        statement.close();
    }

    @Test
    public void createProducts() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("""
                CREATE TABLE IF NOT EXISTS products (
                    id BIGINT          NOT NULL AUTO_INCREMENT,
                    name VARCHAR(100)  NOT NULL,
                    price BIGINT       NOT NULL,
                    category_id BIGINT NOT NULL,
                    PRIMARY KEY (id),
                    FOREIGN KEY fk_products_categories (category_id) REFERENCES categories(id)
                )""");
        statement.close();
    }

    @Test
    public void alterCategoriesAuditing() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("ALTER TABLE categories ADD COLUMN created_at DATETIME");
        statement.execute("ALTER TABLE categories ADD COLUMN updated_at DATETIME");
        statement.close();
    }
}
