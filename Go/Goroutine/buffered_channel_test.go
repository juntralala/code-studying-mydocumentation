package main

import "fmt"
import "testing"

/*
Seperti yang dijelaskan sebelumnya, bahwa secara default channel itu hanya bisa menerima 1 data
Artinya jika kita menambah data ke-2, maka kita akan diminta menunggu sampai data ke-1 ada yang mengambil
Kadang-kadang ada kasus dimana pengirim lebih cepat dibanding penerima, dalam hal ini jika kita menggunakan channel, maka otomatis pengirim akan ikut lambat juga
Untuknya ada Buffered Channel, yaitu buffer yang bisa digunakan untuk menampung data antrian di Channel

Kita bebas memasukkan berapa jumlah kapasitas antrian di dalam buffer
Jika kita set misal 5, artinya kita bisa menerima 5 data di buffer.
Jika kita mengirim data ke 6, maka kita diminta untuk menunggu sampai buffer ada yang kosong
Ini cocok sekali ketika memang goroutine yang menerima data lebih lambat dari yang mengirim data
*/
func TestBufferedChannel(t *testing.T) {
	channel := make(chan string, 4)

	fmt.Println(cap(channel))
	fmt.Println(len(channel)) // jumlah data didalam buffer
	close(channel)
}