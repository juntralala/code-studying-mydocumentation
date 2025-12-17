package main

import (
	"fmt"
	"context"
)

func main() {
	db := GetConnection()
	ctx := context.Background()
	rows, err := db.QueryContext(ctx, "SELECT * FROM orang")
	if(err != nil) {
		panic(err)
	}
	var(
		id int
		name string
		age int
	)
	for rows.Next() {
		rows.Scan(&id, &name, &age)
		fmt.Printf("id=%d name=%s age=%d\n", id, name, age)
	}
	defer rows.Close();
}