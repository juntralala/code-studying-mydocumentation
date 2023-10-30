#include <iostream>
using namespace std;

int main() {

	short a = 5;
	int b = (int) a;
	float c = 6.675f;

	cout << b * c << endl;
	cout << "(int)(b * c) = " << (int)(b * c) << endl;
	cout << " b * (int)c = " << b * (int) c << endl;

	int d = 23;
	float hasil1 = d / b;
	float hasil2 = (float)d / (float)b;
	cout << "hasil1 : " << hasil1 << endl;
	cout << "hasil2 : " << hasil2 << endl;

	return 0;
}