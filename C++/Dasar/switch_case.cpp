#include <iostream>

using namespace std;

int main(int argc, char *argv[]) {

    int angka;

    printf("Masukkan angka : ");
    cin >> angka;

    switch (angka) {
    case 1 :
        cout << "ini case 1" << endl;
        break;
    case 2 :
        cout << "ini case 2" << endl;
        break;
    case 3 :
        cout << "ini case 3" << endl;
        break;
    case 4 :
        cout << "ini case 4" << endl;
        break;
    default:
        cout << "tidak ada case yang sesuai" << endl;
        if (argc>0) {
            cout << argv[argc-2] << argv[argc-1] << endl;  
        }
        break;
    }

    return 0;
}