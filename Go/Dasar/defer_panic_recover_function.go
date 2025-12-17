package main

import "fmt"

/*
Defer function adalah function yang bisa kita jadwalkan untuk dieksekusi setelah sebuah function selesai di eksekusi
Defer function akan selalu dieksekusi walaupun terjadi error di function yang dieksekusi

Panic function adalah function yang bisa kita gunakan untuk menghentikan program
Panic function biasanya dipanggil ketika terjadi panic pada saat program kita berjalan
Saat panic function dipanggil, program akan terhenti, namun defer function tetap akan dieksekusi

Recover adalah function yang bisa kita gunakan untuk menangkap data panic
Dengan recover proses panic akan terhenti, sehingga program akan tetap berjalan
Recover harus dijalankan dalam defer function
*/
func main() {
	defer app(false)
}

func app(isError bool) {
	defer logging()
	defer handleError()
	
	if isError {
		panic("ERROR")
	}
	fmt.Println("Sukes")
}

func handleError() {
	message := recover()
	if message != nil {
		fmt.Println("Terjadi error: ", message)
	} 
}

func logging() {
	fmt.Println("Melakukan Logging")
}
