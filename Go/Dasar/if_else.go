package main

import "fmt"

func main() {
	age := 102

	if age < 18 {
		fmt.Println("Dibawah umur")
	} else if age > 100 {
		fmt.Println("Kamu sepuh")
	} else {
		fmt.Println("cukup umur")
		fmt.Println("cukup umur")
	}
	
	// short statement
	// short hand untuk melakukan sesuatu sebelum pengecekan
	name := "ujun"
	if length := len(name); length < 4 {
		fmt.Println("Terlalu pendek")
	} else {
		fmt.Println("nice")
	}
}