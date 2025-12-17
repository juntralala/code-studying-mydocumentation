package main

import "fmt"

func main() {
	var number1 int8 = 127
	var number2 int16 = 32767
	var number3 int32 = 2147483647
	var number4 int64 = 9223372036854775807
	var number5 uint8 = 127
	var number6 uint16 = 32767
	var number7 uint32 = 2147483647
	var number8 uint64 = 9223372036854775807

	var number10 float32 = 0.2
	var number11 float64 = 0.2
	var number12 complex64 = complex(0.2, 0)
	var number13 complex128 = complex(0.2, 0)
	
	var ( // bikin variable secara sekaligus
		number14 int = 1 // minimal int32, tergantung platform
		number15 uint = 1 // minimal uint32, tergantung platform
		number16 byte = 1 // alias int8
		number17 rune = 1 // alias int32
	)

	// Print semua variabel
	fmt.Println("number1 (int8):", number1)
	fmt.Println("number2 (int16):", number2)
	fmt.Println("number3 (int32):", number3)
	fmt.Println("number4 (int64):", number4)
	fmt.Println("number5 (uint8):", number5)
	fmt.Println("number6 (uint16):", number6)
	fmt.Println("number7 (uint32):", number7)
	fmt.Println("number8 (uint64):", number8)
	
	fmt.Println("number10 (float32):", number10)
	fmt.Println("number11 (float64):", number11)
	fmt.Println("number12 (complex64):", number12)
	fmt.Println("number13 (complex128):", number13)
	
	fmt.Println("number14 (int):", number14)
	fmt.Println("number15 (uint):", number15)
	fmt.Println("number16 (byte):", number16)
	fmt.Println("number17 (rune):", number17)
}