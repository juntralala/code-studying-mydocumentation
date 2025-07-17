#include <iostream>
#include <fstream>
#include <string>

using namespace std;

struct mahasiswa {
	string nim;
	string nama;
	string jurusan;
};

void outMahasiswa(mahasiswa dataMahasiswa, string mode = "trunc");
mahasiswa inMahasiswa(int posisi);

int main() {

	mahasiswa mahasiswa1, mahasiswa2, mahasiswa3,data;

	mahasiswa1.nim = "2210010097";
	mahasiswa1.nama = "Muhammad Junaidi";
	mahasiswa1.jurusan = "Tehnik Informatika";
	
	mahasiswa2.nim = "2210010098";
	mahasiswa2.nama = "Muhammad Abu Yazid";
	mahasiswa2.jurusan = "Pendidikan Agama Islam";
	
	mahasiswa3.nim = "2210010099";
	mahasiswa3.nama = "Ainorrahmi";
	mahasiswa3.jurusan = "Administrasi Rumah Sakit";

	outMahasiswa(mahasiswa1,"trunc");
	outMahasiswa(mahasiswa2,"app");
	outMahasiswa(mahasiswa3,"app");

	data = inMahasiswa(1);
	cout << data.nim << endl;
	cout << data.nama << endl;
	cout << data.jurusan << endl;

	return 0;
}


void outMahasiswa(mahasiswa dataMahasiswa, string mode) {
	fstream myFile;
	if (mode == "trunc") {
	myFile.open("data.bin", ios::trunc | ios::out | ios::binary);
	} else if (mode == "app") {
	myFile.open("data.bin", ios::app | ios::binary);
	}
	myFile.write(reinterpret_cast<char*> (&dataMahasiswa), sizeof(mahasiswa));
	myFile.close();
};

mahasiswa inMahasiswa(int posisi) {
	mahasiswa buffer;
	fstream myFile;
	myFile.open("data.bin", ios::in | ios::binary);
	myFile.seekp((posisi - 1) * sizeof(mahasiswa));
	myFile.read(reinterpret_cast<char*> (&buffer), sizeof(mahasiswa));
	myFile.close();
	return buffer;
}