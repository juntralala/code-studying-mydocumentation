package main

import "fmt"

func main() {
	for i := 0; i < 5; i++ {
		fmt.Println("Iteration:", i)
	}

	// => For Range
	// For bisa digunakan untuk melakukan iterasi terhadap semua data collection
 	// Data collection contohnya Array, Slice dan Map
	numbers := [...]string{"ujun", "adul", "urik"}
	for i, num := range numbers {
		fmt.Println("Index:", i, "Value:", num)
	}

	// ada keyword break dan continue, seperti di bahasa lainnya
}