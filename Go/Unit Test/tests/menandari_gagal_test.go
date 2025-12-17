/** mengagalkan test
Menggagalkan unit test menggunakan panic bukanlah hal yang bagus
Go-Lang sendiri sudah menyediakan cara untuk menggagalkan unit test menggunakan testing.T
Terdapat function Fail(), FailNow(), Error() dan Fatal() jika kita ingin menggagalkan unit test
*
/*
Terdapat dua function untuk menggagalkan unit test, yaitu Fail() dan FailNow(). Lantas apa bedanya?
Fail() akan menggagalkan unit test, namun tetap melanjutkan eksekusi unit test. Namun diakhir ketika selesai, maka unit test tersebut dianggap gagal
FailNow() akan menggagalkan unit test saat ini juga, tanpa melanjutkan eksekusi unit test
*/
/*
Selain Fail() dan FailNow(), ada juga Error() dan Fatal()
Error() function lebih seperti melakukan log (print) error, namun setelah melakukan log error, dia akan secara otomatis memanggil function Fail(), sehingga mengakibatkan unit test dianggap gagal
Namun karena hanya memanggil Fail(), artinya eksekusi unit test akan tetap berjalan sampai selesai
Fatal() mirip dengan Error(), hanya saja, setelah melakukan log error, dia akan memanggil FailNow(), sehingga mengakibatkan eksekusi unit test berhenti
*/

package tests

import (
	"unittest/app"
	"testing"
 	"fmt"
)

func TestHelloWorldWithError(t *testing.T) {
	t.Skip("Karna memang dibikin slalu gagal")
	result := app.HelloWorld()
	if result != "gagal" {
		t.Error("Harusnya Hello World")
	}
	fmt.Println("tetap jalan walau gagal")
}

func TestHelloWorldWithFatal(t *testing.T) {
	t.Skip("Karna memang dibikin slalu gagal")
	result := app.HelloWorld()
	if result != "gagal" {
		t.Fatal("Harusnya Hello World")
	}
	fmt.Println("tidak dieksekusi saat gagal")
}
