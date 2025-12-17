package main

import (
	"bufio"
	"bytes"
	"compress/gzip"
	"fmt"
	"io"
	"os"
	"strings"
)

/*
package io di go hanya berisi 2 interface yang mendasari stream di golang dan beberapa helper function

// Interface
type Reader interface {
    Read(p []byte) (n int, err error)
}

type Writer interface {
    Write(p []byte) (n int, err error)
}

// Fungsi utility untuk read/write
func Copy(dst Writer, src Reader) (written int64, err error)
func CopyBuffer(dst Writer, src Reader, buf []byte) (written int64, err error)
func ReadAll(r Reader) ([]byte, error)
func ReadAtLeast(r Reader, buf []byte, min int) (n int, err error)
func WriteString(w Writer, s string) (n int, err error)
*/

/*
 */

func makeReaders() { // daftar file yang menghasilkan io.Reader dan io.Writer
	var reader io.Reader

	reader, _ = os.Open("go.mod")
	reader = bufio.NewReader(reader)
	reader = bufio.NewReaderSize(reader, 4096)
	reader, _ = gzip.NewReader(reader)
	reader = bytes.NewReader([]byte("Hello")) // <= untuk data yang sudah di ram
	reader = strings.NewReader("Hello World")

	var writer io.Writer
	writer, _ = os.Open("go.mod")
	writer = gzip.NewWriter(writer)
	writer = bufio.NewWriter(writer)
	writer = bufio.NewWriterSize(writer, 4096)

	// supaya nggak error waktu compile aja ini
	fmt.Printf("%T", reader)
	fmt.Printf("%T", writer)
}
