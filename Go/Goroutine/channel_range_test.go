/*
Kadang-kadang ada kasus sebuah channel dikirim data secara terus menerus oleh pengirim
Dan kadang tidak jelas kapan channel tersebut akan berhenti menerima data
Salah satu yang bisa kita lakukan adalah dengan menggunakan perulangan range ketika menerima data dari channel
Ketika sebuah channel di close(), maka secara otomatis perulangan tersebut akan berhenti
Ini lebih sederhana dari pada kita melakukan pengecekan channel secara manual
*/

package main

import (
	"fmt"
	"testing"
)

func TestChannelRange(t *testing.T) {
	channel := make(chan string, 4)
	for i:=0; i<10; i++ {
		go func() {
			channel <- fmt.Sprintf("data-%d", i)
		}()
		if i == 9 {
			close(channel)
		}
	}
	for data := range channel {
		fmt.Println(data)
	}
	fmt.Println("Done")
}