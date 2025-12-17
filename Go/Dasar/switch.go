package main

import "fmt"

func main() {
	day := 3
	switch day {
	case 1:
		fmt.Println("Senin")
	case 2:
		fmt.Println("Selasa")
	case 3:
		fmt.Println("Rabu")
	default:
		fmt.Println("Hari lainnya")
	}

	// pakai short statement seperti pada if else
	switch fruit := "apple"; fruit {
	case "apple":
		fmt.Println("Apel")
	case "banana":
		fmt.Println("Pisang")
	case "orange":
		fmt.Println("Jeruk")
	default:
		fmt.Println("Buah lainnya")
	}

	// kondisi di switch bisa dihilangkan dan ditaruh pada tiap case
	switch {
	case day == 1:
		fmt.Println("Senin")
	case day == 2:
		fmt.Println("Selasa")
	case day == 3:
		fmt.Println("Rabu")
	default:
		fmt.Println("Hari lainnya")
	}

}