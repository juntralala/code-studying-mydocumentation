#include <iostream>
using namespace std;

union nama_union {
	int int_value;
	char char_value[4];
};

int main() {

	nama_union ipul;
	ipul.int_value = 428945127;
	cout << "data int_value  : " << ipul.int_value << endl;
	cout << "data char_value : " << ipul.char_value << endl;

	ipul.char_value[0] = 'a';
	ipul.char_value[1] = 'b';
	ipul.char_value[2] = 'c';
	ipul.char_value[3] = 'd';
	cout << "data int_value  : " << ipul.int_value << endl;
	cout << "data char_value : " << ipul.char_value << endl;

	return 0;
}