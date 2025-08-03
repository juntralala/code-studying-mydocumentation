#include <iostream>
#include <cstdint>

using namespace std;

int main(int argc,char *argv[]) {

    int n;
    cout << ":<============>: deret fibbonaci :<============>:"<< endl;
    cout << "suku ke : ";
    cin >> n;

    int64_t a,b,c;
    b = 0;
    a = 1;
    cout << "b : " << b << endl;
    cout << "c : " << c << endl;
    cout << "a : " << a << endl;
    for (int i = 0; i < n ; i++) {
        a += b;
        b = c;
        c = a;

        cout << a << endl;
    }

    return 0;
}