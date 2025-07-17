#include <iostream>
#include <string>

using namespace std;

int main() {

    int n;
    cout << "Masukan besar segitiga : ";
    cin >> n;

    string buffer = "";
    for (int i = 0;i < n ; i++) {
        buffer += "*  ";
        cout << buffer << endl;
    }
    
    for (int i = 0; i < n ; i++) {
        buffer = "";
        for (int j = n-i; j>1 ; j--){
            buffer += "   ";
        }

        for (int j = 0; j <= i ; j++){
            buffer += "*  ";
        } 

        cout << buffer << endl;
    }

    for (int i = 0; i < n ; i++) {
        buffer = "";
        for (int j = n-i; j>1 ; j--){
            buffer += "   ";
        }

        for (int j = 0; j <= i ; j++){
            buffer += "*  ";
        } 

        for (int j = 0;j <= i ; j++) {
            buffer += "*  ";
        }

        cout << buffer << endl;
    }

    for (int i = 0; i < n ; i++) {
        buffer = "";
        for (int j = 0 ; j < i ; j++) {
            buffer += "   ";
        }

        for (int j = n-i ; j > 0 ; j--){
            buffer += "*  ";
        }
        
        for (int j = n-i ; j > 0 ; j--){
            buffer += "*  ";
        }

        cout << buffer << endl;
    }


    return 0;
}