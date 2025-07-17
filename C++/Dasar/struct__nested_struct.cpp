#include <iostream>
#include <string>
using namespace std;

struct aktor {
	string nama;
	int tahun_lahir;
};

struct film {
	string judul;
	string genre;
	int tahun;
	// struct aktor
	aktor pemain1;
	aktor pemain2;
};

int main() {

	aktor aktor1, aktor2;
	film film1;

	// buat aktor1
	aktor1.nama = "ipul";
	aktor1.tahun_lahir = 2005;

	// buat aktor2
	aktor2.nama = "udin";
	aktor2.tahun_lahir = 2002;

	// buat film
	film1.judul = "pemburu";
	film1.genre = "action";
	film1.tahun = 2026;
	film1.pemain1 = aktor1;
	film1.pemain2 = aktor2;

	cout << "Judul   : " << film1.judul << endl;
	cout << "genre   : " << film1.genre << endl;
	cout << "tahun   : " << film1.tahun << endl;
	cout << "pemain1 : " << film1.pemain1.nama << endl;
	cout << "pemain2 : " << film1.pemain2.nama << endl;

	return 0;
}