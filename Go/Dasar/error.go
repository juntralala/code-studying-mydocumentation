package main

/**
Go-Lang memiliki interface yang digunakan sebagai kontrak untuk membuat error, nama interface nya adalah error

// The error built-in interface type is the conventional interface for
// representing an error condition, with the nil value representing no error.
type error interface {
	Error() string
}
*/

// Untuk membuat error, kita tidak perlu manual.
// Go-Lang sudah menyediakan library untuk membuat helper secara mudah, yang terdapat di package errors (Package akan kita bahas secara detail di materi tersendiri)

import (
	"fmt"
	"errors"
)

func main() {
	result, err := devide(2, 0)
	if err != nil {
		fmt.Println("terjadi error: " + err.Error())
	}

	fmt.Println("Hasil pembagian : ", result)
}

func devide(num1 int, num2 int) (int, error) {
	if(num2 == 0) {
		return 0, errors.New("Pembagi tidak boleh nol")
	}
	return num1 / num2, nil
}