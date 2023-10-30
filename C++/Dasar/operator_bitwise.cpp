#include <iostream>
#include <string>
#include <bitset>
using namespace std;

void printBinary(string nama, unsigned short angka) {
	cout << nama << " = " << bitset<8>(angka) << endl;
}

int main() {

	unsigned short a = 6;
	unsigned short b = 10;
	unsigned short c;

	cout << "<===== & =====>" << endl;
	c = a & b;
	printBinary("a",a);
	printBinary("b",b);
	printBinary("c",c);

	cout << "<===== | =====>" << endl;
	c = a | b;
	printBinary("a",a);
	printBinary("b",b);
	printBinary("c",c);

	cout << "<===== ^ =====>" << endl;
	c = a ^ b;
	printBinary("a",a);
	printBinary("b",b);
	printBinary("c",c);

	cout << "<===== ~ =====>" << endl;
	printBinary("c",c);
	c = ~c;
	printBinary("c",c);

	cout << "<===== << =====>" << endl;
	c = 3; 
	cout << "c = " << c << endl;
	cout << "c = " << bitset<8>(c) << " << " << 2 << " = " << bitset<8>(c= c << 2) << endl;
	cout << "c = " << c << endl;
	
	cout << "<===== >> =====>" << endl;
	c = 24; 
	cout << "c = " << c << endl;
	cout << "c = " << bitset<8>(c) << " >> " << 2 << " = " << bitset<8>(c= c >> 2) << endl;
	cout << "c = " << c << endl;

	return 0;
}