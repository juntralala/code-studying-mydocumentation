#include <iostream>
#include <string>
using namespace std;

int main() {

    // cara pembuatan array1
    int nilai[5];
    nilai[0] = 1;
    nilai[1] = 2;
    nilai[2] = 3;
    nilai[3] = 4;
    nilai[4] = 5;

    // cara pembuatan array1
    string 

    cout << &nilai[0] << " nilainya : " << nilai[0] << endl;
    cout << &nilai[1] << " nilainya : " << nilai[1] << endl;
    cout << &nilai[2] << " nilainya : " << nilai[2] << endl;
    cout << &nilai[3] << " nilainya : " << nilai[3] << endl;
    cout << &nilai[4] << " nilainya : " << nilai[4] << endl;

    int *ptr = nilai;
    *(ptr + 2) = 10;

    nilai[3] = 20;

    cout << endl;
    cout << &nilai[0] << " nilainya : " << nilai[0] << endl;
    cout << &nilai[1] << " nilainya : " << nilai[1] << endl;
    cout << &nilai[2] << " nilainya : " << nilai[2] << endl;
    cout << &nilai[3] << " nilainya : " << nilai[3] << endl;
    cout << &nilai[4] << " nilainya : " << nilai[4] << endl;

    cout << endl;
    cout << "ukuran array adalah : " << sizeof(nilai) << endl;
    cout << "Jumlah member array : " << sizeof(nilai)/sizeof(int) << endl;

    return 0;
}