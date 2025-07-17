#include <iostream>
#include <string>
#include <fstream>
using namespace std;

int main() {

	ifstream myFile;
	myFile.open("data.txt");

	string data;
	myFile >> data;
	cout << data << endl;
	getline(myFile, data);
	cout << data << endl;
	myFile.close();

	myFile.open("data.txt");
	string output, buffer;
	bool isData = false;
	int counter = 0;
	while (!isData) {
		getline(myFile, buffer);
		output.append(buffer +"\n");
		if (buffer == "data") {
			isData = true;
		}
	}
	cout << output;

	string nomor, nama;
	int jumlah_data =0;
	while (!myFile.eof()) {
		myFile >> nomor;
		myFile >> nama;
		cout << nomor << "\t" << nama << endl;
		jumlah_data++;
	}
	cout << "jumlah data : " << jumlah_data << endl;

	return 0;
}