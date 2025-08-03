#include <iostream>
#include <string>
using namespace std;

struct santri {
	string nama;
	short umur;
	short kelas;
	string lokal;
};

struct ilmu {
	string nama;
	string pencetus;
};

int main() {

	santri santri1;
	santri1.nama = "cogan";
	santri1.umur = 18;
	santri1.kelas = 3;
	santri1.lokal = "i";

	cout << "Nama  : " << santri1.nama << endl;
	cout << "Umur  : " << santri1.umur << endl;
	cout << "Kelas : " << santri1.kelas << endl;
	cout << "Lokal : " << santri1.lokal << endl;

	ilmu mantiq;
	mantiq.nama = "mantiq";
	mantiq.pencetus = "Abdul Qodir Al Jurjani";

	cout << endl;
	cout << "Nama     : " << mantiq.nama << endl;
	cout << "pencetus : " << mantiq.pencetus << endl;

	ilmu nahwu;
	nahwu.nama = "nahwu";
	nahwu.pencetus = "Abul Aswad Ad-Dualiyyu";

	cout << endl;
	cout << "Nama     : " << nahwu.nama << endl;
	cout << "pencetus : " << nahwu.pencetus << endl;
	
	return 0;
}