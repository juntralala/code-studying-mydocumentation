package main

import "fmt"

func main() {
	var (
		result int
		operand1 int
		operand2 int
		operator string
	)
	fmt.Println("<======== Kalkulator Terminal Sederhana ========>")
	fmt.Print("operand1 : ")
	fmt.Scan(&operand1)
	fmt.Print("operator : ")
	fmt.Scanln(&operator)
	fmt.Print("operand2 : ")
	fmt.Scan(&operand2)

	switch {
	case operator == "+": result = operand1 + operand2
	case operator == "-": result = operand1 - operand2
	case operator == "*": result = operand1 * operand2
	case operator == "/": result = operand1 / operand2
	default: fmt.Println("Operator yang kamu masukkan Invalid!")
	}

	fmt.Println("hasil : ", result);
}