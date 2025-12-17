package main

import "fmt"
import "os"
import "io"

func main() {
	var reader io.Reader
	reader, _ = os.Open("go.mod")

	bytes, _ := io.ReadAll(reader)
	fmt.Println(string(bytes))
}