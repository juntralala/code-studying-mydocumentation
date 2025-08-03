#include <iostream>
#include <limits>
using namespace std;

int main(){

    // bilangan bulat
    short a = 127;     // <-- 2 byte
    int   b = 4;     // <-- 4 byte
    long  c = 8;     // <-- 8 byte

    // bilangan deciamal
    float f = 4.0;     // <-- 4 byte
    double d = 8.0;    // <-- 8 byte

    // character
    char karakter = 'a';    // <-- 2 byte

    // boolean
    bool boolean = true;    // <-- 1 bit

    cout << a << endl;
    cout << sizeof(a) << endl;
    cout << numeric_limits<int>::max() << endl;
    cout << numeric_limits<int>::min() << endl;

    return 0;
}