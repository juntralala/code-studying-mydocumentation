package main

import (
	"bufio"
	"fmt"
	"os"
	"testing"
)

/* ya untuk bikin buffer di io
import "bufio"

func NewWriter(io.Writer)                       // <- default buffer 4096
func NewWriterSize(io.Writer, bufferSize int)
func NewReader(io.Reader)
func NewReaderSize(io.Reader, bufferSize int)

// Buffered Writer
type Writer struct {
    // fields
}

func (b *Writer) Write(p []byte) (nn int, err error) // <- selalu baca sampai buffer penuh
func (b *Writer) WriteString(s string) (int, error)  // pakai delimiter, karna ya baca teks
func (b *Writer) WriteByte(c byte) error
func (b *Writer) WriteRune(r rune) (size int, err error)

// Buffered Reader
type Reader struct {
    // fields
}
func (b *Reader) Read(p []byte) (n int, err error)
func (b *Reader) ReadString(delim byte) (string, error)
func (b *Reader) ReadBytes(delim byte) ([]byte, error)
func (b *Reader) ReadLine() (line []byte, isPrefix bool, err error)
*/

// ada scanner juga sih btw, buat baca tulis buffered, cara yg lebih clean dibanding pakai bufio.Reader
func TestScanner(t *testing.T) {
    reader, _ := os.Open("go.mod")
    var scanner *bufio.Scanner = bufio.NewScanner(reader); // default buffer 4096
    // scanner.Buffer(make([]byte, 2048), 2048) // <= mengatur ukuran buffer
    for scanner.Scan() {
        // bytesSlice := scanner.Bytes();
        teks := scanner.Text();
        fmt.Println(teks);
    }

    if scanner != nil {
        // biar ada error pas compile aja
    }
}