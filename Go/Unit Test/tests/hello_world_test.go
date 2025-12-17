package tests

import "unittest/app"
import "testing"

func TestHelloWorld(t *testing.T) {
	result := app.HelloWorld()
	if result != "Hello World" {
		panic("Result is not Hello World")
	}
}