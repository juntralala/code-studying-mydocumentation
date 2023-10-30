#include <iostream>
#include <array>

using namespace std;

int main() {

    array<int,11> nilai;

    cout << "<======== program menampilkan grafik nilai ========>\n";
    for (int i=0 ; i < nilai.size(); i++) {
        cout << "banyak siswa yang mendapat nilai ";
        if (i == 10) {
            cout << "100\t: ";
        } else {
            cout << i*10 << "-" << i*10+9 << "\t: ";
        }
        cin  >> nilai[i];
    }

    cout << endl;
    cout << "Grafik nilai" << endl;
    for (int i=0 ; i<nilai.size() ; i++) {
        if (i == 10) {
            cout << "100\t: ";
        } else {
            cout << i*10 << "-" << i*10+9 << "\t: ";
        }
        for (int j=0; j<nilai[i] ;j++) {
            cout << "*";
        }
        cout << endl;
    }

    return 0;
}