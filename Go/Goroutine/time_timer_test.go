package main

/*
Timer adalah representasi satu kejadian
Ketika waktu timer sudah expire, maka event akan dikirim ke dalam channel
Untuk membuat Timer kita bisa menggunakan time.NewTimer(duration)
*/

import (
	"fmt"
	"time"
	"sync"
	"testing"
)

func TestTimer(t *testing.T) {
	timer := time.NewTimer(3 * time.Second)
	fmt.Println(time.Now())
	wakt := <- timer.C
	fmt.Println(wakt)
}

/*
Kadang kita hanya butuh channel nya saja, tidak membutuhkan data Timer nya
Untuk melakukan hal itu kita bisa menggunakan function time.After(duration)
*/
func TestAfter(t *testing.T) {
	var timerChannel <-chan time.Time = time.After(1 * time.Second)

	tick := <-timerChannel
	fmt.Println(tick)
}

/*
Kadang ada kebutuhan kita ingin menjalankan sebuah function dengan delay waktu tertentu
Kita bisa memanfaatkan Timer dengan menggunakan function time.AfterFunc()
Kita tidak perlu lagi menggunakan channel nya, cukup kirim kan function yang akan dipanggil ketika Timer mengirim kejadiannya
*/
func TestAfterFunc(t *testing.T) {
	group := sync.WaitGroup{}
	group.Add(1)

	time.AfterFunc(1 * time.Second, func() {
		fmt.Println("executed after 1 second")
		group.Done()
	})
	
	group.Wait()
}