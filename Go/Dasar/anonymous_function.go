package main;

import "fmt";

func main() {
	sayHello := func(name string) {
		fmt.Println("Hello ", name)
	}

	sayHello("badali")
}