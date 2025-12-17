package main

/*
Ticker adalah representasi kejadian yang berulang
Ketika waktu ticker sudah expire, maka event akan dikirim ke dalam channel
Untuk membuat ticker, kita bisa menggunakan time.NewTicker(duration)
Untuk menghentikan ticker, kita bisa menggunakan Ticker.Stop()
*/

import (
	"fmt"
	"testing"
	"time"
)

func TestTicker(t *testing.T) {
	ticker := time.NewTicker(1 * time.Second)

	for tick := range ticker.C {
		fmt.Println(tick)
	}
}

/*
Kadang kita tidak butuh data Ticker nya, kita hanya butuh channel nya saja
Jika demikian, kita bisa menggunakan function timer.Tick(duration), function ini tidak akan mengembalikan Ticker, hanya mengembalikan channel timer nya saja
*/
func TestTick(t *testing.T) {
	var tickerChannel <-chan time.Time = time.Tick(1 * time.Second)

	for tick := range tickerChannel {
		fmt.Println(tick)
	}
}