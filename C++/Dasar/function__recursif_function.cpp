/*
stack overflow pada : 43157
*/

#include <iostream>
using namespace std;

int pangkat_rekursif(int angka, int pangkat);

int main() {
    int angka;
    int pangkat;
    cout << "Angka\t: ";
    cin  >> angka;
    cout << "Pangkat\t: ";
    cin >> pangkat;

    int hasil = pangkat_rekursif(angka,pangkat);
    cout << "\nHasil : " << hasil << endl; 

    return 0 ;
}

int pangkat_rekursif(int angka, int pangkat) {
    cout << pangkat << endl;

    if (pangkat <= 1) {
        return angka;
    }

    return angka * pangkat_rekursif(angka, pangkat-1);
}