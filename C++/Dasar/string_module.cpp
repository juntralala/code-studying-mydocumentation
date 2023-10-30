#include <iostream>
#include <string>

int main() {

	char arrayChar[5] = {'M','o','b','i','l'};
	std::cout << "arrayChar : " << arrayChar;std::cout << std::endl;
	// arrayChar tidak cocok untuk dijadikan text karena
	// array tidak bisah ditambah, fiks karena array

	std::string kata1("pesawat");
	std::string kata2 = "motor";
	std::string kata3;
	std::cout << "kata1 : " << kata1 << std::endl;
	std::cout << "kata2 : " << kata2 << std::endl << std::endl;

	std::cout << "Masukan kata : ";
	std::cin >> kata3;
	std::cout << "kata dimasukan : " << kata3 << std::endl;

	return 0;
}