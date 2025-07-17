#include <iostream>
#include <array>
#include <exception>

int main() {

	std::array<int, 5> angka1 = { 0,1,2,3,4 };

	try {
		std::cout << angka1.at(5) << std::endl;
	}
	catch (std::exception e) {
		std::cout << e.what() << std::endl;
	}

	std::cout << "Program selesai" << std::endl;

	return 0;
}