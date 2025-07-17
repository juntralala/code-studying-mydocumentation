#include <iostream>
#include <array>
#include <algorithm>

const int arraySize = 10;

void printArray(std::array<int, arraySize> dataArray) {
	for (int &data : dataArray) {
		std::cout << data << " ";
	}
	std::cout << std::endl;
}

void printArray(std::array<char, arraySize> dataArray) {
	for (char &data : dataArray) {
		std::cout << data << " ";
	}
	std::cout << std::endl;
}

int main() {

	std::array<int, arraySize> arrayAngka = {4,3,8,9,6,0,1,2,8,5};
	std::array<char, arraySize> arrayChar = { 'd','r','f','g','l','q','v','a','s','r' };

	printArray(arrayAngka);
	printArray(arrayChar);

	std::cout << "<<======= sesudah disortir =======>>" << std::endl;

	std::sort(arrayAngka.begin(), arrayAngka.end());
	std::sort(arrayChar.begin(), arrayChar.end());
	printArray(arrayAngka);
	printArray(arrayChar);

	return 0;
}