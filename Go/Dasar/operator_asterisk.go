package main

import "fmt"

func main() {
	// 1. Deklarasi pointer
	var x int = 10
	var ptr := &x
	
	fmt.Println("Nilai x:", x)
	fmt.Println("Alamat x:", &x)
	fmt.Println("Nilai pointer:", ptr)
	fmt.Println("Dereferensi pointer:", *ptr)
	
	// 2. Mengubah nilai melalui pointer
	*ptr = 20
	fmt.Println("Nilai x setelah perubahan:", x)
	
}

func changeValue(ptr *int) {
	*ptr = 100
}