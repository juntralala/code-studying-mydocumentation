package main

import "fmt"
import "time"

func main() {
	now := time.Now()
	fmt.Println(now)

	var waktu time.Time = time.Date(2024, time.December, 20, 10, 30, 0, 0, time.Local) 
	fmt.Println(waktu)
	fmt.Println(waktu.Add(2 * time.Hour))
	fmt.Println(waktu.Add(-2 * time.Hour))

	// parsing
	// layout := "30-01-2030"
	// dateString := "14-08-2025"
	// waktu, err := time.Parse(layout, dateString)
	// if err != nil {
	// 	fmt.Println("error : ", err.Error())
	// 	return
	// }
	// fmt.Println(waktu)
}