#include <iostream>
#include <string>
using namespace std;

int main() {

	int a, b;
	string hasil1, hasil2, output;

	hasil1 = "udin";
	hasil2 = "ipiul";

	a = 5;
	cout << "Masukan angka : ";
	cin >> b;
	output = (b < a) ? hasil1 : hasil2;

	cout << "hasil : " << output << endl;

	return 0;
}