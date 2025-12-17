package main

import "fmt"

func main() {
	teks := "anu"
	number := 12
	decimal := 0.3

	formatted := fmt.Sprintf("%T", teks)
	fmt.Println(formatted)
	formatted = fmt.Sprintf("%d", number)
	fmt.Println(formatted)
	formatted = fmt.Sprintf("%0.2f | 1%e", decimal)
	fmt.Println(formatted)
	formatted = fmt.Sprintf("%%", decimal)
	fmt.Println(formatted)
}