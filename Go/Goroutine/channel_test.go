package main

import "fmt"
import "testing"
import "time"
 
/*
Channel adalah tempat komunikasi secara synchronous yang bisa dilakukan oleh goroutine
Saat melakukan pengiriman data ke Channel, goroutine akan ter-block, sampai ada yang menerima data tersebut
Channel cocok sekali sebagai alternatif seperti mekanisme async await yang terdapat di beberapa bahasa pemrograman lain

channel hanya bisa menerima satu data satuwaktu,
menerima satu jenis data,
1 channel bisa diterima oleh banyak goroutine,
harus diclose agar tidak menyebabkan memory leak
*/
func TestChannel(t *testing.T) {
	var channel chan string = make(chan string)	
	go sender(channel)
	go reciever(channel)

	time.Sleep(3 * time.Second)
	close(channel)
}

// khusus untuk tipedata channel, bukan pass by value jadi tidak perlu pointer operator
// <- di parameter itu opsional, untuk mendai bahwa channel hanya bisa recieve/out
func reciever(channel <-chan string) {
	data := <-channel
	fmt.Println("diterima: ", data)
}

// <- di parameter itu opsional, untuk mendai bahwa channel hanya bisa send/in
func sender(channel chan<- string) {
	time.Sleep(1 * time.Second)
	channel <- "ujun";
}

