package main

import "fmt"

// Type Assertions merupakan kemampuan merubah tipe data menjadi tipe data yang diinginkan
// Fitur ini sering sekali digunakan ketika kita bertemu dengan data interface kosong

// Saat salah menggunakan type assertions, maka bisa berakibat terjadi panic di aplikasi kita
// Jika panic dan tidak ter-recover, maka otomatis program kita akan mati
// Agar lebih aman, sebaiknya kita menggunakan switch expression untuk melakukan type assertions

func random() interface{} {
	return "OK";
}

func main() {
	result := random()

	// Type assertion examples (can cause panic if wrong type)
	// resultString := result.(string)
	// fmt.Println(resultString)

	// resultInt := result.(int) // panic
	// fmt.Println(resultInt)


	switch value := result.(type) {
	case string:
		fmt.Println("String", value)
	case int:
		fmt.Println("Int", value)
	default:
		fmt.Println("Unknown")
	}
}