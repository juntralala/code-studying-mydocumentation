package com.juntralala;

import com.juntralala.entity.Student;
import com.juntralala.entity.User;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Setup {

    @Test
    public void createDB() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://172.20.82.191:3306", "super", "");
        connection.createStatement().execute("CREATE DATABASE jpa;");
    }

    @Test
    public void createTableCustomers() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://172.20.82.191:3306/jpa", "super", "");
        connection.createStatement().execute("""
                CREATE TABLE customers(
                    id VARCHAR(100) NOT NULL PRIMARY KEY,
                    name VARCHAR(100) NOT NULL
                )""");
    }

    @Test
    public void addColumnprimary_email() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://172.20.82.191:3306/jpa", "super", "");
        connection.createStatement().execute("ALTER TABLE customers ADD COLUMN primary_email VARCHAR(150)");
    }

    @Test
    public void createCategoriesTable() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://172.20.82.191:3306/jpa", "super", "");
        connection.createStatement().execute("""
                CREATE TABLE categories (
                    id      INT             NOT NULL AUTO_INCREMENT PRIMARY KEY,
                    name    VARCHAR(100)    NOT NULL,
                    description TEXT
                )""");
    }

    @Test
    public void addColumnTypeToCustomersTable() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://172.20.82.191:3306/jpa", "super", "");
        connection.createStatement().execute("ALTER TABLE customers ADD COLUMN type VARCHAR(50)");
    }

    @Test
    public void addColumnDateTimeOnCategoriesTable() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://172.20.82.191:3306/jpa", "super", "");
        connection.createStatement().execute("ALTER TABLE categories ADD COLUMN created_at TIMESTAMP");
        connection.createStatement().execute("ALTER TABLE categories ADD COLUMN updated_at TIMESTAMP");
    }

    @Test
    public void createTableMembers() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://172.20.82.191:3306/jpa", "super", "");
        connection.createStatement().execute("""
                CREATE TABLE members (
                    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                    email VARCHAR(150) NOT NULL,
                    title VARCHAR(100),
                    first_name VARCHAR(100) NOT NULL,
                    middle_name VARCHAR(100),
                    last_name VARCHAR(100)
                )""");
    }

    @Test
    public void createTableHobbies() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://172.20.82.191:3306/jpa", "super", "");
        connection.createStatement().execute("""
                CREATE TABLE hobbies (
                    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                    member_id INT NOT NULL,
                    name VARCHAR(255),
                    FOREIGN KEY fk_members_hobbies (member_id) REFERENCES members (id)
                )""");
    }

    @Test
    public void createTableUsersAndCredentials() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://172.20.82.191:3306/jpa", "super", "");
        connection.createStatement().execute("""
                CREATE TABLE users (
                    id   VARCHAR(100) NOT NULL PRIMARY KEY,
                    name VARCHAR(100) NOT NULL
                )""");
        connection.createStatement().execute("""
                CREATE TABLE credentials (
                    id       VARCHAR(100) NOT NULL PRIMARY KEY,
                    email    VARCHAR(100) NOT NULL,
                    password VARCHAR(100) NOT NULL,
                    FOREIGN KEY fk_credentials_users REFERENCES users(id)
                )""");
    }

    @Test
    public void createTableWallet() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://172.20.82.191:3306/jpa", "super", "");
        connection.createStatement().execute("""
                CREATE TABLE wallet (
                    id      INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
                    user_id VARCHAR(100) NOT NULL,
                    balance BIGINT       NOT NULL,
                    FOREIGN KEY fk_users_wallet (user_id) REFERENCES users (id)
                )""");
    }

    @Test
    public void createTableProducts() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://172.20.82.191:3306/jpa", "super", "");
        connection.createStatement().execute("""
                CREATE TABLE products (
                    id       INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                    brand_id INT NOT NULL,
                    name     VARCHAR(100) NOT NULL,
                    price    VARCHAR(100) NOT NULL,
                    FOREIGN KEY fk_products_brands REFERENCES brands(id)
                )""");
    }

    @Test
    public void createTableBrands() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://172.20.82.191:3306/jpa", "super", "");
        connection.createStatement().execute("""
                CREATE TABLE brands (
                    id   INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                    name VARCHAR(100) NOT NULL
                )""");
    }

    @Test
    public void createTableStudents() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://172.20.82.191:3306/jpa", "super", "");
        connection.createStatement().execute("""
                CREATE TABLE students (
                    id   VARCHAR(100) NOT NULL PRIMARY KEY,
                    name VARCHAR(100) NOT NULL,
                    version BIGINT    NOT NULL DEFAULT 0
                )""");
    }

    @Test
    public void createDbJpaTest() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://172.20.82.191:3306", "super", "");
        connection.createStatement().execute("CREATE DATABASE jpa_test");
    }

    @Test
    public void insertBatchUsers() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setId("U01" + i);
            student.setName("Murid NPC-" + i);
            entityManager.persist(student);
        }

        entityTransaction.commit();
        entityManager.close();
    }

}
