package main
/*
Sebelumnya diawal kita sudah bahas bahwa goroutine itu sebenarnya dijalankan di dalam Thread
Pertanyaannya, seberapa banyak Thread yang ada di Go-Lang ketika aplikasi kita berjalan?
Untuk mengetahui berapa jumlah Thread, kita bisa menggunakan GOMAXPROCS, yaitu sebuah function di package runtime yang bisa kita gunakan untuk mengubah jumlah thread atau mengambil jumlah thread
Secara default, jumlah thread di Go-Lang itu sebanyak jumlah CPU di komputer kita. 
Kita juga bisa melihat berapa jumlah CPU kita dengan menggunakan function runtime.NumCpu()
*/

import (
	"fmt"
	"runtime"
)

func main() {
	totalCpu := runtime.NumCPU()
	fmt.Println("CPU", totalCpu)

	runtime.GOMAXPROCS(4) // mengubah jumlah thread
	totalThread := runtime.GOMAXPROCS(-1)
	fmt.Println("Thread", totalThread)

	totalGoroutine := runtime.NumGoroutine()
	fmt.Println("Goroutine", totalGoroutine)
}