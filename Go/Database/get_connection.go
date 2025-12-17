package main

import (
	"database/sql"
	_ "github.com/go-sql-driver/mysql"
	"time"
)

/*
DB itu sudah connection pool internalnya, jadi nggak usah mikir ngatur koneksi secara manual
*/

var database *sql.DB = nil
func GetConnection() *sql.DB {
	if(database == nil) {
		db, err := sql.Open("mysql", "super:super@tcp(127.0.0.1:3306)/golang?parseTime=true");
		if err != nil {
			panic(err)
		}
		err = db.Ping()
		if err != nil {
			panic("wrong password or username, error: " + err.Error())
		}
	
		db.SetMaxIdleConns(10)
		db.SetMaxOpenConns(100)
		db.SetConnMaxIdleTime(10 * time.Minute)
		db.SetConnMaxLifetime(60 * time.Minute)
		database = db;
	}
	return database;
}