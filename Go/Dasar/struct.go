package main

import "fmt"

/*
Struct adalah sebuah template data yang digunakan untuk menggabungkan nol atau lebih tipe data lainnya dalam satu kesatuan
Struct biasanya representasi data dalam program aplikasi yang kita buat
Data di struct disimpan dalam field  
Sederhananya struct adalah kumpulan dari field
*/

type Orang struct {
	name string
	age int
}

func (orang Orang) sayHello() {
	fmt.Println("helo, i'm ", orang.name);
} 

func main() {
	var ujun Orang = Orang{
		name: "ujun",
		age: 18,
	}

	fmt.Println(ujun)

	ujun.sayHello();
}