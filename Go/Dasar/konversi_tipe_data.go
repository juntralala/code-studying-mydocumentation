package main;

import "fmt";

func main() {
	var number1 int8 = 67;
	var number2 int16 = int16(number1); 
	var teks string = string(number1); 

	fmt.Println(number1);
	fmt.Println(number2);
	fmt.Println(teks);
}