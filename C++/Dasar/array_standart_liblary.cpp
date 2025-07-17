#include <iostream>
#include <array>

using namespace std;

int main() {

    // membuat array menggunakan standart liblay
    // array<tipedata, jumlahArray> namaVariable;
    array<int,5> nilai;

    for (int index=0; index<=4  ; index++) {
        nilai[index] = index+1;
        cout << "nilai " << index << " : " << nilai[index] << endl;
        cout << "address : "<< &nilai[index] << endl; 
    }

    cout << endl;
    // ukuran array
    cout << "ukuran : " << nilai.size() << endl;
    // address awal dari array 
    cout << "address awal : " << nilai.begin() << endl;
    // address akhir dari array
    cout << "address akhir: " << nilai.end() << endl;
    // nilai ke 2 dengan index
    cout << "nilai index ke 2 : " << nilai.at(2) << endl;

    for (int i=0; i<= nilai.size() +2; i++) {
        cout << nilai[i] << endl;
    }

    return 0;
}