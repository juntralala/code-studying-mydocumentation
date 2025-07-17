#include <iostream>
#include <array>
using namespace std;

int main() {

	// looping untuk array pada C++ 11 keatas
	/*
	for (deklasrasi variable : array) {
		statement
	}
	*/
	array<int, 4> nilaiArray = {1,2,3,4};

	for (int nilai : nilaiArray) {
		cout << "Alamat : " << &nilai << " nilai : " << nilai << endl;
		nilai = 7;
	}

	// references
	cout << endl;
	for (int &nilai : nilaiArray) {
		cout << "Alamat : " << &nilai << " nilai : " << nilai << endl;
	}

	cout << endl;
	for (int &nilai : nilaiArray) {
		nilai *= 2;
	}

	cout << endl;
	for (int &nilai : nilaiArray) {
		cout << "Alamat : " << &nilai << " nilai : " << nilai << endl;
	}

	return 0;
}