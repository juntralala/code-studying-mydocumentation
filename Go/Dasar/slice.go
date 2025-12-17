/**
Tipe data Slice adalah potongan dari data Array
Slice mirip dengan Array, yang membedakan adalah ukuran Slice bisa berubah
Slide dan Array selalu terkoneksi, dimana Slice adalah data yang mengakses sebagian atau seluruh data di Array

Tipe Data Slice memiliki 3 data, yaitu pointer, length dan capacity
Pointer adalah penunjuk data pertama di array para slice
Length adalah panjang dari slice, dan
Capacity adalah kapasitas dari slice, dimana length tidak boleh lebih dari capacity
*/

package main

import "fmt"

func main() {
    names := [...]string{"Eko", "Kumiawan", "Khannedy", "Joko", "Budi", "Nugraha"}
    slice := names[2:4]
    // slice := names[:6]
    // slice := names[4:]
    // slice := names[:]

    fmt.Println(slice[0])
    fmt.Println(slice[1])
    fmt.Println(len(slice)) // panjang slice
    fmt.Println(cap(slice)) // kapasistas
    fmt.Println(append(slice, "Ujun")) // Membuat slice baru dengan menambah data ke posisi terakhir slice, jika kapasitas sudah penuh, maka akan membuat array baru
	fmt.Println(names)
    // fmt.Println(make([10]string, 5, 10)) // bikin slice baru
	// copy(destination, source)
}