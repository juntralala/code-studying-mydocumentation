package main

import "fmt"

func tambah(num1 int, num2 int) int {
	return num1 + num2
}

// multi return values
func gabungNama(firstName string, lastName string) (string, string) {
	fullName := firstName + " " + lastName
	return fullName, "Nama lengkap: " + fullName
}

// named return values
func hitungLuas(panjang int, lebar int) (luas int, keliling int) {
	luas = panjang * lebar
	keliling = 2 * (panjang + lebar)
	return
}

func total(numbers ...int) int {
	total := 0
	for _, number := range numbers {
		total += number
	}
	return total;
}

func main() {
	fmt.Println("hasil: ", tambah(2, 4))
	
	nama, pesan := gabungNama("John", "Doe")
	nama2, _ := gabungNama("John", "Doe") // mengabaikan return ke 2
	fmt.Println(nama)
	fmt.Println(pesan)
	
	luas, keliling := hitungLuas(2, 4) // penangkapan returnnya harus pakai urutan, hak cukup dengan nama var yang sama
	fmt.Println(luas)
	fmt.Println(keliling)
	
	fmt.Println(nama2) // biar nggak error kompile aja
	
	fmt.Println(total(2, 3, 6))
	fmt.Println(total([]int{4, 7, 1}...)); // slice paramter/argument
	
	// di go, function adalah value
	var sum func(...int) int = total
	fmt.Println(sum(2, 3, 6))
}