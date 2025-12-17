package main

import "fmt"

// ya representasi data untuk null (kalau di bahasa lain)
// Nil sendiri hanya bisa digunakan di beberapa tipe data, seperti interface, function, map, slice, pointer dan channel
func main() {
	var orang map[string]string

	if(orang == nil) {
		fmt.Println("orang : nilainya nil")
	} else {
		fmt.Println("Lah!?")
	}
}