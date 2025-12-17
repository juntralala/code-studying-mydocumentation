package main

import "fmt"

/*
Interface adalah tipe data Abstract, dia tidak memiliki implementasi langsung
Sebuah interface berisikan definisi-definisi method
Biasanya interface digunakan sebagai kontrak

// pengemplementasian
Setiap tipe data yang sesuai dengan kontrak interface, secara otomatis dianggap sebagai interface tersebut
Sehingga kita tidak perlu mengimplementasikan interface secara manual
Hal ini agak berbeda dengan bahasa pemrograman lain yang ketika membuat interface, kita harus menyebutkan secara eksplisit akan menggunakan interface mana
*/

type HasName interface {
	GetName() string
}

func sayHello(hasName HasName) {
	fmt.Println("hello ", hasName.GetName());
}

type Orang struct {
	name string
}

func (orang Orang) GetName() string {
	return orang.name
}

func main() {
	ujun := Orang{
		name: "ujun",
	}

	sayHello(ujun)
}