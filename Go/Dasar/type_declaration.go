package main;

import "fmt";

/**
 * type declaration: fitur untuk membuat tipe data baru dari tipe data yang sudah ada
 */

func main() {
	type NoKTP string;

	var noKTP NoKTP = "12121";
	fmt.Println(noKTP);
	fmt.Println(NoKTP("97873"));
}