package main

import "fmt"

type Address struct {
	City    string
	Province string
	Country string
}

// Secara default di Go-Lang semua variable itu di passing by value, bukan by reference
// Artinya, jika kita mengirim sebuah variable ke dalam function, method atau variable lain, sebenarnya yang dikirim adalah duplikasi value nya
func tanpaPointer() {
	address1 := Address{"Subang", "Jawa Barat", "Indonesia"}
	address2 := address1

	address2.City = "Bandung"

	fmt.Println(address1) // address1 tidak berubah
	fmt.Println(address2)
}

// Pointer adalah kemampuan membuat reference ke lokasi data di memory yang sama, tanpa menduplikasi data yang sudah ada
// Sederhananya, dengan kemampuan pointer, kita bisa membuat pass by reference
func pakaiPointer() {
	address1 := Address{"Subang", "Jawa Barat", "Indonesia"}
	var address2 *Address = &address1  // * disini bukan operator asterisk btw, cuman buat definisi tipedata reference

	address2.City = "Bandung"

	fmt.Println(address1)
	fmt.Println(address2)
}

func main() {
	fmt.Println("============== pass by value ==============")
	tanpaPointer()
	fmt.Println("============== pass by referrence ==============")
	pakaiPointer()
}