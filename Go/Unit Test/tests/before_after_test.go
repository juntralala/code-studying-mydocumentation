/*
=> before and after (per package)
Biasanya dalam unit test, kadang kita ingin melakukan sesuatu sebelum dan setelah sebuah unit test dieksekusi
Jikalau kode yang kita lakukan sebelum dan setelah selalu sama antar unit test function, maka membuat manual di unit test function nya adalah hal yang membosankan dan terlalu banyak kode duplikat jadinya
Untungnya di Go-Lang terdapat fitur yang bernama testing.M
Fitur ini bernama Main, dimana digunakan untuk mengatur eksekusi unit test, namun hal ini juga bisa kita gunakan untuk melakukan Before dan After di unit test

=> testing.M
Untuk mengatur ekeskusi unit test, kita cukup membuat sebuah function bernama TestMain dengan parameter testing.M
Jika terdapat function TestMain tersebut, maka secara otomatis Go-Lang akan mengeksekusi function ini tiap kali akan menjalankan unit test di sebuah package
Dengan ini kita bisa mengatur Before dan After unit test sesuai dengan yang kita mau
Ingat, function TestMain itu dieksekusi hanya sekali per Go-Lang package, bukan per tiap function unit test
*/

package tests

import (
	"testing"
	"fmt"
)

func TestMain(m *testing.M) {
	fmt.Println("Sebelum test...")
	m.Run()
	fmt.Println("Sesudah test...")
}
