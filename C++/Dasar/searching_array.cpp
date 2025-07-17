#include <iostream>
#include <array>
#include <algorithm>

const int sizeArray = 10;

void printArray(std::array<int, sizeArray> arrayParam) {
	for (int data : arrayParam) {
		std::cout << data << " ";
	}
	std::cout << std::endl;
}

int main() {

	std::array <int, sizeArray> arrayAngka = {2,4,3,7,1,5,9,8,5,6};
	printArray(arrayAngka);

	int angkacari;
	bool ketemu;
	// sort dulu
	// binary-search
	std::cout << "cari angka : ";
	std::cin >> angkacari;
	std::sort(arrayAngka.begin(),arrayAngka.end());
	ketemu = std::binary_search(arrayAngka.begin(),arrayAngka.end(),angkacari);

	if (ketemu) {
		std::cout << "Angka ditemukan" << std::endl;
	}
	else {
		std::cout << "Angka tidak ditemukan" << std::endl;
	}

	return 0;
}