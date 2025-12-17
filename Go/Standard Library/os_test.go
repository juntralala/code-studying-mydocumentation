package main

import "fmt"
import "os"
import "io"
import "testing"

func TestOsOpen(t *testing.T) {
	var reader io.Reader
	reader, err := os.Open("go.mod") // mengembalikan implementasi interface io.Reader
	if err != nil {
		panic(err)
	}

	var content []byte
	var bytes []byte = make([]byte, 8)
	length, err := reader.Read(bytes)
	for err != io.EOF {
		content = append(content, bytes[:length]...)
		length, err = reader.Read(bytes)
	}
	fmt.Println(string(content))
}

func TestReadFile(t *testing.T) {
	var (
		bytes []byte
		err   error
	)
	bytes, err = os.ReadFile("go.mod")
	if err != nil {
		panic(err)
	}
	fmt.Println(string(bytes))
}

func TestWriteFile(t *testing.T) {
	var (
		bytes []byte = []byte("Hello World")
		err   error
	)
	err = os.WriteFile("hello.txt", bytes, os.FileMode(os.O_WRONLY))
	if err != nil {
		panic(err)
	}
}
