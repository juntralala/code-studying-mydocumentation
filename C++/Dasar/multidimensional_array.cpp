#include <iostream>
using namespace std;

void printArrayMD(int *ptrArray, int baris, int kolom) {
	int index = 0;
	for (int i=0; i < baris; i++) {
		cout << "[";
		for (int j=0; j < kolom;j++) {
			cout << *(ptrArray + index++);
			if (j == kolom - 1) {
				cout << "]" << endl;
			}
			else {
				cout << " " ;
			}
		}
	}
}

int main() {

	const int baris = 2;
	const int kolom = 2;
	int arrayMD[baris][kolom] = { 1,2,3,4 };

	printArrayMD(*arrayMD, baris, kolom);

	return 0;
}