package main

import "fmt"

/**
 * di go, array punya adalah:
   1. panjangnya tetap
   2. semua item bertipe data sama
   3. saat pembuatan, wajib disebutkan panjangnya
 */
func main() {
	var names [3]string
	names[0] = "ujun"
	names[1] = "muhammad"
	names[2] = "junaidi"

	var numbers = [3]int{20, 40, 60}
	var numbers2 = [...]int{20, 40, 60}

	fmt.Println(names)
	fmt.Println(numbers)
	fmt.Println(numbers2)
	fmt.Println(len(numbers))
	fmt.Println(numbers[0])

	// hati-hati!
	iniArray = [...]int{1, 2, 3}
	iniSlice = []int{1, 2, 3}
}