#include <iostream>
using namespace std;

void fungsi(int val) {
	cout << val << endl;
}

int main() {

	int a, b, c;

	a = (b = 5, c = 3);

	cout << "nilai a : " << a << endl;
	cout << "nilai b : " << b << endl;
	cout << "nilai c : " << c << endl << endl;

	a = (b = 4, c = 4, (b + c));
	cout << "nilai a : " << a << endl;
	cout << "nilai b : " << b << endl;
	cout << "nilai c : " << c << endl << endl;

	a = (b = 4, cout << "nilai b : " << b << endl, c = 4, cout << "nilai c : " << c << endl, (b + c));
	cout << "nilai a : " << a << endl << endl;

	a = (b = 8, fungsi(b), c = 2, fungsi(c), (b + c));
	cout << "nilai a : " << a << endl;

	return 0;
}