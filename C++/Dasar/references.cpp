#include <iostream>

using namespace std;

int main() {

    int a = 5;

    cout << "Alamat a : " << &a << endl;
    cout << "Nilai  a : " << a << endl << endl;

    int &b = a;

    cout << "Alamat b : " << &b << endl;
    cout << "Nilai  b : " << b << endl << endl;

    a = 10;
    cout << "Nilai  a : " << a << endl;
    cout << "Nilai  b : " << b << endl << endl;
    
    b = 20;
    cout << "Nilai  a : " << a << endl;
    cout << "Nilai  b : " << b << endl;

    return 0;
}