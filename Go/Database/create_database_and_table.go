package main

import (
	// "fmt"
	"database/sql" 
	"context"
	_ "github.com/go-sql-driver/mysql"
)

func main() {
	db, err := sql.Open("mysql", "super:super@tcp(127.0.0.1:3306)/");
	if err != nil {
		panic(err)
	}
	defer db.Close()
	err = db.Ping()
	if err != nil {
		panic("wrong password or username, error: " + err.Error())
	}
	ctx := context.Background()
	db.ExecContext(ctx, "CREATE DATABASE IF NOT EXISTS golang")
	_, err = db.ExecContext(ctx, "CREATE TABLE IF NOT EXISTS golang.orang (id INT primary key auto_increment, name VARCHAR(100), age INT)")
	if err != nil {
		panic(err.Error())
	}
}