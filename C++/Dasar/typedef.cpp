#include <iostream>

using namespace std;

int main() {

	typedef int angka;
	typedef unsigned long ulong;
	typedef int iVector2D[2];
	typedef double vector[2];

	using number = double;

	angka angka1 = 10;
	ulong angka2 = 4000000;
	iVector2D vector1 = {5,5};
	vector vector2 = {2.5,3.14};

	number angkaDouble = 99.9999;

	cout << angka1 << endl;
	cout << angka2 << endl;
	cout << vector1[0] << " " << vector1[1] << endl;
	cout << vector2[0] << " " << vector2[1] << endl;
	cout << angkaDouble << endl;

	return 0;
}