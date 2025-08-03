#include <iostream>

using namespace std;

int main() {

    const int a = 9;
    const int b = 4;

    /* 
    operator aritmatika 5:
    1. +
    2. -
    3. *
    4. /
    5. %
    */

   float hasil = a + b;
   cout << a << " + " << b << " = " << hasil << endl;
   hasil = a - b;
   cout << a << " - " << b << " = " << hasil << endl;
   hasil = a * b;
   cout << a << " * " << b << " = " << hasil << endl;
   hasil = a / b;
   cout << a << " / " << b << " = " << hasil << endl;
   hasil = a % b;
   cout << a << " % " << b << " = " << hasil << endl;

   return 0;
}