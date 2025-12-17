package main

/*
Go-Lang memiliki sebuah struct beranama sync.Map
Map ini mirip Go-Lang map, namun yang membedakan, Map ini aman untuk menggunaan concurrent menggunakan goroutine
Ada beberapa function yang bisa kita gunakan di Map :
Store(key, value) untuk menyimpan data ke Map
Load(key) untuk mengambil data dari Map menggunakan key
Delete(key) untuk menghapus data di Map menggunakan key
Range(function(key, value)) digunakan untuk melakukan iterasi seluruh data di Map
*/

import (
	"fmt"
	"testing"
	"sync"
	"time"
)

func TestSyncMap(t *testing.T) {
	var data sync.Map

	addToMap := func(value int) {
		data.Store(value, value)
	}

	for i := 0; i < 100; i++ {
		go addToMap(i)
	}

	time.Sleep(1 * time.Second)

	data.Range(func(key, value interface{}) bool {
		fmt.Println(key, ":", value)
		return true
	})
}