#include <iostream>
#include <cstdlib>

using namespace std;

double hitung_luas(double panjang,double tinggi);
void sapa(string nama);

int main() {
    system("cls");

    double angka1 = 5; 
    double angka2 = 8; 
    cout << hitung_luas(angka1,angka2) << endl;

    return 0;
}

double hitung_luas(double panjang,double tinggi) {
    return panjang * tinggi;
}

void sapa(string nama){
    printf("%s",nama);
}