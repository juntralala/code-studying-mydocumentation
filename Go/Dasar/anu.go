package main

import "fmt"

type Orang struct {
	name string
} 

func main() {
	var teks Orang = Orang {
		name: "ujun",
	}
	var orang *Orang = &teks

	fmt.Println(*orang)
}