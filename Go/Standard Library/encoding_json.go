package main

import (
	"fmt"
	"encoding/json"
)

// json juga bisa di decode dan encode langsung dari file btw, dengan cara json.NewEncoder(io.Writer) dan json.NewDecoder(io.Reader)
func main() {
	// map
	orang := map[string]interface{} {
		"name":"ujun",
		"age":200,
	}

	jsonBytes, _ := json.Marshal(orang) // endcode
	fmt.Printf("%T\n", jsonBytes)
	fmt.Println(string(jsonBytes))
	fmt.Println(string([]uint8{80, 66}))
	
	var encoded = make(map[string]interface{})
	json.Unmarshal(jsonBytes, &encoded) // decode
	fmt.Println(encoded)

	// struct
	ujun := Orang{FullName: "Muhammad Junaidi", Hobbies: []string{"Coding", "Gaming"}}
	bytes, _ := json.Marshal(ujun)
	fmt.Println(string(bytes))
}

type Orang struct {
	FullName string `json: full_name`
	Hobbies []string `json: hobbies`
}