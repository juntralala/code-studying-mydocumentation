CREATE DATABASE php_login_management;
CREATE DATABASE php_login_management_test;

CREATE TABLE users (
    id VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ENGINE InnoDB;

CREATE TABLE sessions (
    id VARCHAR(255) PRIMARY KEY,
    user_id VARCHAR(255) NOT NULL
) ENGINE InnoDB;

ALTER TABLE sessions ADD FOREIGN KEY (user_id) REFERENCES users (id);