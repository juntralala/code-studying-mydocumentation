package main

/*
embed file ke variable hanya dilakukan saat runtime
tidak bisa didalam function
target variable biasanya string, []byte atau embed.File untk multi file

(yang multi file malas meraktekin)
*/

import (
	"fmt"
	_ "embed"
	"encoding/json"
)

//go:embed properties.json
var properties []byte
var propertyMap map[string]interface{}

func main() {
	err := json.Unmarshal(properties, &propertyMap)
	if(err != nil) {
		panic(err)
	}
	fmt.Println(propertyMap)
}