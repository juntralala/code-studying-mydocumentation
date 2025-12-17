package main

import "fmt"

/**
Sebelumnya untuk membuat pointer dengan menggunakan operator &
Go-Lang juga memiliki function new yang bisa digunakan untuk membuat pointer
Namun function new hanya mengembalikan pointer ke data kosong, artinya tidak ada data awal
*/

type Address struct {
	Country string
}

func main() {
	alamat1 := new(Address)
	alamat2 := alamat1

	alamat2.Country = "Indonesia"

	fmt.Println(alamat1) // alamat1 berubah
	fmt.Println(alamat2)
}