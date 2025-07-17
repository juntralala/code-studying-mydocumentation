#include <iostream>
#include <string>
using namespace std;

int main() {

	string namaTebakan;
	string namaRahasia = "udin";

	while (true) {
		cout << "Tebak nama rahasia : ";
		cin >> namaTebakan;
		if (namaTebakan == namaRahasia) {
			cout << "Tebakan kamu benar!" << endl;
			break;
		}
		cout << "tebakan kamu salah, coba lagi" << endl;
	}

	cout << "Program selesai" << endl;

	return 0;
}