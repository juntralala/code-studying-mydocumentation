package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println(strings.Trim("   anu ", " "))
	fmt.Println(strings.Trim("0000anu000", "0"))
	fmt.Println(strings.ToLower("Junaidi"))
	fmt.Println(strings.ToUpper("Junaidi"))
	fmt.Println(strings.Split("Ujun Muhammad Junaidi", " "))
	fmt.Println(strings.Contains("Ujun Muhammad Junaidi", "Ujun"))
	fmt.Println(strings.Replace("Muhammad Zunaidi", "Zunaidi", "Junaidi", 1))
	fmt.Println(strings.ReplaceAll("Muhammad Zunaidi", "Zunaidi", "Junaidi"))
}