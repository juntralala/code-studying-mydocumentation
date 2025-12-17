package main

import (
	"fmt"
	"database/sql" 
	"context"
	_ "github.com/go-sql-driver/mysql"
)

func main() {
	var db *sql.DB = GetConnection()
	var ctx context.Context = context.Background()
	result, err := db.ExecContext(ctx, "INSERT INTO orang(name, age) VALUES (?, ?)", "ozon", 500);
	if(err != nil) {
		panic(err)
	}
	fmt.Printf("%T\n", result)
	fmt.Printf("%T\n", ctx)
}