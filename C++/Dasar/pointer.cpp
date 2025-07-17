#include <iostream>
using namespace std;

int main() {

    int a =5;

    // pointer
    int *aPtr = &a;

    // a memiki nilai dan alamat (adress)
    cout << "nilai  a : " << a << endl;
    cout << "alamat a : " << &a << endl;
    cout << "alamat a : " << aPtr << endl;

    // dereferencing
    cout << "mengambil nilai aPtr : " << *aPtr << endl;
    a = 10;
    cout << "mengambil nilai aPtr : " << *aPtr << endl;

    int b = 5;
    int &c = b;

    b = 10;
    cout << "mengambil nilai c : " << c << endl;

    return 0;
}