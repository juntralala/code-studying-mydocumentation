package main

/*
Kadang ada kasus dimana kita membuat beberapa channel, dan menjalankan beberapa goroutine
Lalu kita ingin mendapatkan data dari semua channel tersebut
Untuk melakukan hal tersebut, kita bisa menggunakan select channel di Go-Lang
Dengan select channel, kita bisa memilih data tercepat dari beberapa channel, jika data datang secara bersamaan di beberapa channel, maka akan dipilih secara random

default select:
Apa yang terjadi jika kita melakukan select terhadap channel yang ternyata tidak ada datanya?
Maka kita akan menunggu sampai data ada
Kadang mungkin kita ingin melakukan sesuatu jika misal semua channel tidak ada datanya ketika kita melakukan select channel
Dalam select, kita bisa menambahkan default, dimana ini akan dieksekusi jika memang di semua channel yang kita select tidak ada datanya
*/

// kode cuman contoh, nggak lengkap, jadi nggak bisa dijalankan
// func anu() {
// 	counter := 0
// 	for {
// 		select {
// 		case data := <-channel1:
// 			fmt.Println("Data dari Channel 1", data)
// 			counter++
// 		case data := <-channel2:
// 			fmt.Println("Data dari Channel 2", data)
// 			counter++
// 		}
// 		if counter == 2 {
// 			break
// 		}
// 	}
// }