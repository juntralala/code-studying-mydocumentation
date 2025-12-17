package main
// Pool adalah implementasi design pattern bernama object pool pattern. 
// Sederhananya, design pattern Pool ini digunakan untuk menyimpan data, selanjutnya untuk menggunakan datanya, kita bisa mengambil dari Pool, dan setelah selesai menggunakan datanya, kita bisa menyimpan kembali ke Pool nya
// Implementasi Pool di Go-Lang ini sudah aman dari problem race condition

import (
	"fmt"
	"testing"
	"sync"
	"time"
)

func TestPool(t *testing.T) {
	// var pool sync.Pool
	var pool = sync.Pool{New: func() interface{} {return "Baru"}} // versi bikin data otomatis

	// pool.Put("Eko")
	// pool.Put("Kurniawan")
	// pool.Put("Khannedy")

	for i := 0; i < 10; i++ {
		go func() {
			data := pool.Get()
			fmt.Println(data)
			pool.Put(data)
		}()
	}

	time.Sleep(3 * time.Second)
}
