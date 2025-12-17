package main

import (
	"fmt"
	"belajar-golang/helper"
)

// Secara standar, file Go-Lang hanya bisa mengakses file Go-Lang lainnya yang berada dalam package yang sama
// Jika kita ingin mengakses file Go-Lang yang berada diluar package, maka kita bisa menggunakan Import
func main() {
	fmt.Println(helper.Hello("ujun"))
	fmt.Println(Sapa("ujun"))
}