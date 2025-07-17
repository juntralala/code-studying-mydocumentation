#include <iostream>
#include <array>
using namespace std;

const int baris = 3;
const int kolom = 3;

void printArrayMD(array<array<int, baris>, kolom> arrayStd) {
	const int satu = 1;
	for (array<int, baris> vectorBaris : arrayStd) {
		cout << "[";
		for (int i = 0; i < kolom;i++) {
			cout << vectorBaris[i];
			if ((i + 1) == kolom) {
				cout << "]" << endl;
			}
			else {
				cout << " ";
			}
		}
	}
}

int main() {

	array<array<int, baris>, kolom> arrayStdMD = { 1,2,3,4,5,6,7,8,9 };

	for (array <int, baris> nilai : arrayStdMD) {
		cout << nilai[1] << endl;
	}

	printArrayMD(arrayStdMD);

	return 0;
}

