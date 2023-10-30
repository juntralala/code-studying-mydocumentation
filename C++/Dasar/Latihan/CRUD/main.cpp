#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
#include <cstdlib>
using namespace std;

struct Mahasiswa {
	int pk;
	string nim;
	string nama;
	string jurusan;
};

void openDatabase(fstream& data);
void clearConsole();
int inputOpsi();
int getDataSize(fstream& data);
Mahasiswa readDataMahasiswa(fstream& data, int dataSize);
void writeDataMahasiswa(fstream& data, Mahasiswa& dataMahasiswa, int sizeData);
void addDataMahasiswa(fstream& data);
void showDataMahasiswa(fstream& data);
void updateDataMahasiswa(fstream& data);
void deleteDataMahasiswa(fstream& data) {
	Mahasiswa blankDataMahasiswa;
};
bool getDone();

int main() {

	enum opsi {create = 1, read, update, delete_data};
	fstream data;
	bool isDone = false;

	openDatabase(data);
	while (!isDone) {
		clearConsole();
		int opsiUser = inputOpsi();

		switch (opsiUser) {
		case create :
			addDataMahasiswa(data);
			break;
		case read :
			showDataMahasiswa(data);
			break;
		case update :
			showDataMahasiswa(data);
			updateDataMahasiswa(data);
			showDataMahasiswa(data);
			break;
		case delete_data :
			cout << "Menghapus Data Mahsiswa" << endl;
			/*
			showDataMahasiswa(data);
			deleteDataMahasiswa(data);
			showDataMahasiswa(data);
			*/
			break;
		default :
			cout << "Tidak ada opsi yang sesuai";
			break;
		};

		isDone = getDone();
	}
	data.close();
	return 0;
} // <=========================> AKHIR MAIN <=========================>

void clearConsole() {
	char *os = getenv("OS");
	if (string(os) == "Windows_NT") {
		system("cls");
	}
	else {
		system("clear");
	}
}

void openDatabase(fstream& data) {
	data.open("data.bin", ios::out | ios::in | ios::binary);
	if (data.is_open()) {
		cout << "database ditemukan" << endl;
	}
	else {
		data.close();
		data.open("data.bin", ios::trunc | ios::out | ios::in | ios::binary);
	} 
}

int inputOpsi() {
	int opsiDipilih;
	cout << " Program CRUD Data Mahasiswa" << endl;
	cout << "<==========================>" << endl;
	cout << "1. Tambah data mahasiswa" << endl;
	cout << "2. Lihat data mahasiswa" << endl;
	cout << "3. Rubah data mahasiswa" << endl;
	cout << "4. Hapus data mahasiswa" << endl;
	cout << "<==========================>" << endl;
	cout << "Pilih opsi : ";
	cin >> opsiDipilih;
	cin.ignore(numeric_limits<streamsize>::max(), '\n');
	return opsiDipilih;
}

int getDataSize(fstream& data) {
	int start, end;
	data.seekg( 0, ios::beg);
	start = data.tellg();
	data.seekg( 0, ios::end);
	end = data.tellg();
	return (end-start)/(int)sizeof(Mahasiswa);
};

void writeDataMahasiswa(fstream& data, Mahasiswa& dataMahasiswa, int sizeData) {
	int posisi = sizeData * sizeof(Mahasiswa);
	data.seekp(posisi);
	data.write(reinterpret_cast<char*>(&dataMahasiswa), sizeof(Mahasiswa));
}

Mahasiswa readDataMahasiswa(fstream& data, int indexposisi) {
	Mahasiswa lastMahasiswa;
	int posisi = (indexposisi - 1) * (int)sizeof(Mahasiswa);
	data.seekg(posisi, ios::beg);
	data.read(reinterpret_cast<char*> (&lastMahasiswa), sizeof(Mahasiswa));
	return lastMahasiswa;
}

void addDataMahasiswa(fstream& data) {
	Mahasiswa dataMahasiswa, lastDataMahasiswa;
	int dataSize = getDataSize(data);
	if (dataSize == 0) {
		dataMahasiswa.pk = 1;
	} else {
		lastDataMahasiswa = readDataMahasiswa(data, dataSize);
		dataMahasiswa.pk = lastDataMahasiswa.pk +1;
	}
	cout << endl << "<===== Menambahkan data mahasiswa =====>" << endl;
	cout << "NIM : ";
	getline(cin, dataMahasiswa.nim);
	cout << "Nama : ";
	getline(cin, dataMahasiswa.nama);
	cout << "Jurusan : ";
	getline(cin, dataMahasiswa.jurusan);
	writeDataMahasiswa( data, dataMahasiswa,dataSize);
}

void showDataMahasiswa(fstream& data) {
	Mahasiswa buffer;
	int dataSize = getDataSize(data);
	cout << "\n<===== Menampilkan Data Mahasiswa =====>" << endl << endl;
	cout << "+====+====+=========+==============+==============+" << endl;
	cout << "| N0 | PK | NIM     | Nama         | Jurusan      |" << endl;
	cout << "+----+----+---------+--------------+--------------+" << endl;
	for (int i = 1; i <= dataSize; i++) {
		buffer = readDataMahasiswa(data, i);
		cout <<"| "<< left << setw(2) << i << " | " << left << setw(2) << buffer.pk << " | "<< setw(7) << buffer.nim << " | "<< setw(12) << buffer.nama << " | "<< setw(12) << buffer.jurusan << " |" << endl;
	}
	cout << "+----+----+---------+--------------+--------------+" << endl;
}

void updateDataMahasiswa(fstream& data) {
	Mahasiswa dataUpdateMahasiswa;
	int nomorDataDipilih;
	cout << "<====== Pilih data yang mau dirubah ======>" << endl;
	cout << "Pilih : ";
	cin >> nomorDataDipilih;
	cin.ignore(numeric_limits<streamsize>::max(), '\n');

	dataUpdateMahasiswa = readDataMahasiswa(data, nomorDataDipilih);
	cout << "NIM\t: " << dataUpdateMahasiswa.nim << endl;
	cout << "Nama\t: " << dataUpdateMahasiswa.nama << endl;
	cout << "Jurusan\t: " << dataUpdateMahasiswa.jurusan << endl;

	cout << "\n<====== Rubah Data ======>" << endl;
	cout << "NIM\t: ";
	getline(cin,dataUpdateMahasiswa.nim);
	cout << "Nama\t: ";
	getline(cin,dataUpdateMahasiswa.nama);
	cout << "Jurusan\t: ";
	getline(cin,dataUpdateMahasiswa.jurusan);

	writeDataMahasiswa(data, dataUpdateMahasiswa, (nomorDataDipilih - 1));
}

bool getDone() {
	string answer;
	bool done = false;
	cout << "apakah selesai [y/t]? ";
	cin >> answer;
	if (answer == "y") {
		done = true;
	}
	return done;
}