#include <iostream>
#include <fstream>
using namespace std;

int main() {

	fstream myFile;
	int hasil;
	myFile.open("data.bin", ios::in | ios::binary);
	myFile.read(reinterpret_cast<char*>(&hasil), sizeof(hasil)) ;

	cout << hasil << endl;
	myFile.close();

	return 0;
}

/*fstream myFile;
int number = 125;
myFile.open("data.bin", ios::out | ios::binary);
myFile.write(reinterpret_cast<char*> (&number),sizeof(number));*/