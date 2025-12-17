package main

import "fmt"

// ukuran map dinamis
func main() {
	person := map[string]string {
		"name": "ujun",
		"age": "200",
	}

	person["address"] = "earth";

	fmt.Println(person)
	fmt.Println(person["name"])
	fmt.Println(person["age"])

	delete(person, "address");
	fmt.Println(person);
}