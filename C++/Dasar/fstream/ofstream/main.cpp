#include <iostream>
#include <fstream> // ofstream, ifstream, fstream
using namespace std;
/*
ios::out digunakan untuk menulis pada file.Jika file tidak ada, maka file akan dibuat.
		Jika file sudah ada,maka file akan dibuka untuk ditulis,dan data sebelumnya akan ditimpa.
ios::trunc digunakan untuk memotong file menjadi ukuran nol.Jika file tidak ada,maka file akan dibuat.
		Jika file sudah ada, maka data di dalam file akan dihapus dan diubah menjadi ukuran nol sebelum
		ditulis ulang.
ios::app digunakan untuk menambahkan data pada akhir file.Jika file tidak ada, maka file akan dibuat.
		Jika file sudah ada, maka data baru akan ditambahkan pada akhir file, tanpa menghapus data yang sudah
		ada.
*/

int main() {

	ofstream myFile;

	// ios::out = default, operasi output
	// ios::app = menuliskan pada akhir baris
	// ios::trunc = default, membuat file jika...

	myFile.open("data1.txt", ios::trunc);
	myFile << "menuliskan baris baru pada pada data1\n";
	myFile.close();

	myFile.open("data2.txt", ios::out);
	myFile << "menuliskan baris baru pada pada data2\n";
	myFile.close();

	myFile.open("data3.txt", ios::app);
	myFile << "menuliskan baris baru pada pada data3\n";
	myFile.close();

	return 0;
}