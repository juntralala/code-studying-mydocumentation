package tests

/*
package testing di go nggak ada assertion jadi perlu dependency

Testify menyediakan dua package untuk assertion, yaitu assert dan require
Saat kita menggunakan assert, jika pengecekan gagal, maka assert akan memanggil Fail(), artinya eksekusi unit test akan tetap dilanjutkan
Sedangkan jika kita menggunakan require, jika pengecekan gagal, maka require akan memanggil FailNow(), artinya eksekusi unit test tidak akan dilanjutkan
*/

import (
	"fmt"
	"testing"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
	"unittest/app"
)

func TestHelloWorldWithAssertion(t *testing.T) {
	result := app.HelloWorld()
	assert.Equal(t, "Hello World", result)

	fmt.Println("Sukses")
}
func TestHelloWorldWithReqire(t *testing.T) {
	result := app.HelloWorld()
	require.Equal(t, "Hello World", result)

	fmt.Println("Sukses")
}