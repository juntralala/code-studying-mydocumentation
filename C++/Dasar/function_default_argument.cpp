#include <iostream>

using namespace std;

int volume_kubus(int panjang, int lebar, int tinggi= 1);

int main() {

    cout << volume_kubus(8, 4, 6) << endl;

    return 0;
}


int volume_kubus(int panjang, int lebar, int tinggi) {
    return panjang * lebar * tinggi;
}