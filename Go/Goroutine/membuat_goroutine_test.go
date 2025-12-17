package main

import (
	"fmt"
	"testing"
	"time"
)

func RunHelloWorld() {
	fmt.Println("Hello World")
}

func TestCreateGoroutine(t *testing.T) {
	go RunHelloWorld() // ini jalan secara async (didalam goroutine)
	fmt.Println("ups")
	
	time.Sleep(1 * time.Second)
}